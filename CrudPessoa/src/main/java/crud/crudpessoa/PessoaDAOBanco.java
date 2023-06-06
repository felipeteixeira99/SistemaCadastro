
package crud.crudpessoa;

import java.sql.DriverManager;
import interfaces.PessoaPersistencia;
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAOBanco implements PessoaPersistencia {
    
    private static PessoaDAOBanco instancia;
    
    public static PessoaDAOBanco getInstancia(){
        if(instancia == null){
            instancia = new PessoaDAOBanco();
            System.out.println("Teste");
        }
        return instancia;
    }
    
    private final String url = "jdbc:postgresql://localhost:5432/crud"; //Java DataBase Connection Procolo  que o java usa para se comunicar com banco
    private final String user = "postgres";
    private final String password = "postgres";
    
    private Connection connect(){ 
        Connection conn = null; 
        
        try {
           conn = DriverManager.getConnection(url,user,password);
            System.out.println("Conexao criada com sucesso!");
        }catch (Exception e){ //finally{codigo}
            System.out.println("Erro de conexao: " + e.getMessage());
        } 
        return conn;
    }
    
    public void testar(){
        try{
            Connection conn = connect();
            Statement statement = conn.createStatement();
            String sql = "select ID, NOME, IDADE, SEXO from pessoas";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int id = resultSet.getInt("ID");
                String nome = resultSet.getString("NOME");
                int idade = resultSet.getInt("IDADE");
                String sexo = resultSet.getString("SEXO");
                System.out.println("NOME: " + nome);
            }
            conn.close(); 
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

//    @Override
//    public void adicionarPessoa(Pessoa pessoa) {
//        try{
//           Connection conn = connect();
//           Statement statement = conn.createStatement(); 
//           String sql = "insert into pessoas(NOME, IDADE, SEXO) values ('" + pessoa.getNome()+"'," + pessoa.getIdade() + ",'" + pessoa.getSexo() + "')";
//            System.out.println(sql);
//           statement.execute(sql);
//           
//           conn.close();
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//    }
    
    @Override
    public void adicionarPessoa(Pessoa pessoa) {
        try{
           Connection conn = connect();
           //String sql = "insert into pessoas(NOME, IDADE, SEXO) values ('" + pessoa.getNome()+"'," + pessoa.getIdade() + ",'" + pessoa.getSexo() + "')";
           String sql = "insert into pessoas(NOME, IDADE, SEXO) values (?, ?, ?)";
           PreparedStatement ps = conn.prepareStatement(sql);
           //System.out.println(sql);
           ps.setString(1,pessoa.getNome());
           ps.setInt(2,pessoa.getIdade());
           ps.setString(3,pessoa.getSexo());
           ps.executeUpdate();
           //statement.execute(sql);
           ps.close();
           conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
        

    @Override
    public void alterarPessoa(Pessoa pessoa) {
        try{
           Connection conn = connect(); 
           String sql = "update PESSOAS set NOME = ? , IDADE = ?, SEXO = ? where ID = ?";
           System.out.println(sql);
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setString(1,pessoa.getNome());
           ps.setInt(2,pessoa.getIdade());
           ps.setString(3, pessoa.getSexo());
           ps.setInt(4,pessoa.getId());
           ps.executeUpdate();
           ps.close();
           conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

//    @Override
//    public List<Pessoa> buscarTodosold() {
//        
//        List<Pessoa> pessoas = new ArrayList();
//        
////        try{
//            Connection conn = connect();
//            Statement statement = conn.createStatement();
//            String sql = "select ID, NOME, IDADE, SEXO from pessoas";
//            ResultSet resultSet = statement.executeQuery(sql);
//            while(resultSet.next()){
//                int id = resultSet.getInt("ID");
//                String nome = resultSet.getString("NOME");
//                int idade = resultSet.getInt("IDADE");
//                String sexo = resultSet.getString("SEXO");
//                
//                Pessoa p = new Pessoa();
//                p.setId(id);
//                p.setNome(nome);
//                p.setIdade(idade);
//                p.setSexo(sexo);
//                pessoas.add(p);
//            }
//            conn.close();  
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//        return pessoas;
//    }
    
    
    @Override
    //Como não tem parametros para busca utiliza-se apenas o PreparedStatement
    public List<Pessoa> buscarTodos() {
        
        List<Pessoa> pessoas = new ArrayList();
        
        try{
            Connection conn = connect();
            String sql = "select ID, NOME, IDADE, SEXO from pessoas";
            //Statement statement = conn.createStatement();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            //ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int id = resultSet.getInt("ID");
                String nome = resultSet.getString("NOME");
                int idade = resultSet.getInt("IDADE");
                String sexo = resultSet.getString("SEXO");
                
                Pessoa p = new Pessoa();
                p.setId(id);
                p.setNome(nome);
                p.setIdade(idade);
                p.setSexo(sexo);
                pessoas.add(p);
            }
            resultSet.close();
            ps.close();
            conn.close();  
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return pessoas;
    }
    
    

//    @Override
//    public Pessoa buscarPorId(int id) {
//        
//        Pessoa p = null;
//       
//        try{
//            Connection conn = connect();
//            Statement statement = conn.createStatement();
//            String sql = "select ID, NOME, IDADE, SEXO from pessoas where ID = " + id;
//            ResultSet resultSet = statement.executeQuery(sql);
//            if(resultSet.next()){
//                int idBanco = resultSet.getInt("ID");
//                String nome = resultSet.getString("NOME");
//                int idade = resultSet.getInt("IDADE");
//                String sexo = resultSet.getString("SEXO");
//                
//                p = new Pessoa();
//                p.setId(idBanco);
//                p.setNome(nome);
//                p.setIdade(idade);
//                p.setSexo(sexo);
//            }
//            conn.close();  
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//        return p;
//    }
    
    
    @Override
    public Pessoa buscarPorId(int id) {
        
        Pessoa p = null;
       
        try{
            Connection conn = connect();
            //Statement statement = conn.createStatement();
            String sql = "select ID, NOME, IDADE, SEXO from pessoas where ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                int idBanco = resultSet.getInt("ID");
                String nome = resultSet.getString("NOME");
                int idade = resultSet.getInt("IDADE");
                String sexo = resultSet.getString("SEXO");
                
                p = new Pessoa();
                p.setId(idBanco);
                p.setNome(nome);
                p.setIdade(idade);
                p.setSexo(sexo);
            }
            resultSet.close();
            ps.close();
            conn.close();  
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return p;
    }

//    @Override
//    public Pessoa buscarPessoa(String nome) {
//        
//        Pessoa p = null;
//       
//        try{
//            Connection conn = connect();
//            Statement statement = conn.createStatement();
//            String sql = "SELECT ID, NOME, IDADE, SEXO FROM pessoas WHERE UPPER(NOME) LIKE '%" + nome.toUpperCase() + "%'";
//
//           // String sql = "select ID, NOME, IDADE, SEXO from pessoas where  upper(NOME) LIKE = '" + nome + "'";
//            ResultSet resultSet = statement.executeQuery(sql);
//            if(resultSet.next()){
//                int idBanco = resultSet.getInt("ID");
//                String nomeBanco = resultSet.getString("NOME");
//                int idade = resultSet.getInt("IDADE");
//                String sexo = resultSet.getString("SEXO");
//                
//                p = new Pessoa();
//                p.setId(idBanco);
//                p.setNome(nomeBanco);
//                p.setIdade(idade);
//                p.setSexo(sexo);
//            }
//            conn.close();  
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//        return p;     
//    }
    
    @Override
    public Pessoa buscarPessoa(String nome) {
        
        Pessoa p = null;
       
        try{
            Connection conn = connect();
            //Statement statement = conn.createStatement();
//          String sql = "SELECT ID, NOME, IDADE, SEXO FROM pessoas WHERE UPPER(NOME) LIKE '%" + nome.toUpperCase() + "%'";
            String sql = "SELECT ID, NOME, IDADE, SEXO FROM pessoas WHERE UPPER(NOME) LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,"%" + nome.toUpperCase() + "%");
           // String sql = "select ID, NOME, IDADE, SEXO from pessoas where  upper(NOME) LIKE = '" + nome + "'";
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                int idBanco = resultSet.getInt("ID");
                String nomeBanco = resultSet.getString("NOME");
                int idade = resultSet.getInt("IDADE");
                String sexo = resultSet.getString("SEXO");
                
                p = new Pessoa();
                p.setId(idBanco);
                p.setNome(nomeBanco);
                p.setIdade(idade);
                p.setSexo(sexo);
            }
            resultSet.close();
            ps.close();
            conn.close();  
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return p;     
    }
    
//    public List<Pessoa> buscarPessoas(String busca) {
//        
//        List<Pessoa> pessoas = new ArrayList();
//        
//        try{
//            Connection conn = connect();
//            Statement statement = conn.createStatement();
//            String sql = "SELECT ID, NOME, IDADE, SEXO FROM pessoas WHERE UPPER(NOME) LIKE '%" + busca.toUpperCase() + "%'";
//            ResultSet resultSet = statement.executeQuery(sql);
//            while(resultSet.next()){
//                int id = resultSet.getInt("ID");
//                String nome = resultSet.getString("NOME");
//                int idade = resultSet.getInt("IDADE");
//                String sexo = resultSet.getString("SEXO");
//                
//                Pessoa p = new Pessoa();
//                p.setId(id);
//                p.setNome(nome);
//                p.setIdade(idade);
//                p.setSexo(sexo);
//                pessoas.add(p);
//            }
//            conn.close();  
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//        return pessoas;
//    }
    
    
       public List<Pessoa> buscarPessoas(String busca) {
        
        List<Pessoa> pessoas = new ArrayList();
        
        try{
            Connection conn = connect();
            //Statement statement = conn.createStatement();
            String sql = "SELECT ID, NOME, IDADE, SEXO FROM pessoas WHERE UPPER(NOME) LIKE ?";
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1,"%" + busca.toUpperCase() + "%");
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("ID");
                String nome = resultSet.getString("NOME");
                int idade = resultSet.getInt("IDADE");
                String sexo = resultSet.getString("SEXO");
                
                Pessoa p = new Pessoa();
                p.setId(id);
                p.setNome(nome);
                p.setIdade(idade);
                p.setSexo(sexo);
                pessoas.add(p);
            }
            resultSet.close();
            ps.close();
            conn.close();  
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return pessoas;
    }
     
    @Override
    public void deletarPessoaPorId(int id) {
        try{
           Connection conn = connect();
           String sql = "delete from PESSOAS where ID = ?";
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setInt(1, id);
           //Statement statement = conn.createStatement(); 
//           String sql = "delete from PESSOAS where ID = " + id;
           ps.execute();
           ps.close();
           conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    } 
}

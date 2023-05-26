
package crud.crudpessoa;

import java.util.List;

public class CrudPessoa {

    public static void main(String[] args) {
        PessoaDAO pessoaDAO = PessoaDAO.getInstancia();
        
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setId(1);
        pessoa1.setNome("Felipe");
        pessoa1.setIdade(23);
        pessoa1.setSexo("Masculino");
        pessoaDAO.adicionarPessoa(pessoa1);
        
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setId(2);
        pessoa2.setNome("Sarah");
        pessoa2.setIdade(22);
        pessoa2.setSexo("Feminino");
        pessoaDAO.adicionarPessoa(pessoa2);
        
        List<Pessoa> lista = pessoaDAO.buscarTodos();
        lista.clear();
        
        
        /*
        List<Pessoa> listaPessoas = pessoaDAO.buscarTodos(); //armazena os objetos do tipo pessoa e armazena uma dentro de uma lista 
        */
        
        for(Pessoa pessoa : pessoaDAO.buscarTodos()){
            System.out.println("ID: " + pessoa.getId());
            System.out.println("NOME: " + pessoa.getNome());
            System.out.println("IDADE: " + pessoa.getIdade());
            System.out.println("SEXO: " + pessoa.getSexo());
            System.out.println("-----------------------------");
        }
        
        
        //Pessoa pessoaAlterada = new Pessoa();
        //pessoa2.setId(2);
        //pessoa2.setNome("Jonas");
        //pessoa2.setIdade(22);
        //pessoa2.setSexo("Feminino");
        //pessoaDAO.alterarPessoa(pessoa2);
        
        /*
        int idBusca = 2;
        Pessoa pessoaEncontrada = pessoaDAO.buscarPorId(idBusca);
        
        if(pessoaEncontrada != null){
            System.out.println("Pessoa Encontrada");
            System.out.println("ID: " + pessoaEncontrada.getId());
            System.out.println("Nome: " + pessoaEncontrada.getNome());
            System.out.println("Idade: " + pessoaEncontrada.getIdade());
            System.out.println("Sexo: " + pessoaEncontrada.getSexo());
            
        }
        
        else{
            System.out.println("Nenhuma Pessoa Encontrada");
        }
        
   
        
        pessoaDAO.deletarPessoaPorId(1);
        //pessoaDAO.deletarPessoaPorId(2);
        
        List<Pessoa> listaPessoas1 = pessoaDAO.buscarTodos(); //armazena os objetos do tipo pessoa e armazena uma dentro de uma lista 
        
        for(Pessoa pessoa : listaPessoas1){
            System.out.println("ID: " + pessoa.getId());
            System.out.println("NOME: " + pessoa.getNome());
            System.out.println("IDADE: " + pessoa.getIdade());
            System.out.println("SEXO: " + pessoa.getSexo());
            System.out.println("-----------------------------");
        }
        
       */ 
    }
    
    
}

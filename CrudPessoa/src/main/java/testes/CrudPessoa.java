
package testes;

import crud.crudpessoa.Pessoa;
import crud.crudpessoa.PessoaDAOLista;
import java.util.List;

public class CrudPessoa {

    public static void main(String[] args) {
        PessoaDAOLista pessoaDAO = PessoaDAOLista.getInstancia();
        
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
        
        for(Pessoa pessoa : pessoaDAO.buscarTodos()){
            System.out.println("ID: " + pessoa.getId());
            System.out.println("NOME: " + pessoa.getNome());
            System.out.println("IDADE: " + pessoa.getIdade());
            System.out.println("SEXO: " + pessoa.getSexo());
            System.out.println("-----------------------------");
        }
        
        pessoaDAO.buscarPessoa("Teste");
        
    }   
}

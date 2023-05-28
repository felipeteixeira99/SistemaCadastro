package interfaces;

import crud.crudpessoa.Pessoa;
import java.util.List;

public interface PessoaPersistencia {

    public void adicionarPessoa(Pessoa pessoa);

    public void alterarPessoa(Pessoa pessoa);

    public List<Pessoa> buscarTodos();

    public Pessoa buscarPorId(int id);
    
    public Pessoa buscarPessoa(String nome);
    
    public void deletarPessoaPorId(int id);
     
}

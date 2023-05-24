/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud.crudpessoa;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe
 */

//clase 
public class PessoaDAO {
    
    private static PessoaDAO instancia;
    
    public static PessoaDAO getInstancia(){
        if(instancia == null){
            instancia = new PessoaDAO();
        }
        return instancia;
    }
    private PessoaDAO(){
        
    }
    
    private List<Pessoa> lista = new ArrayList<>();
    
    public void adicionarPessoa(Pessoa pessoa){
        //Salva pessoa dentro da lista se nao tiver nenhuma pessoa com esse ID
        for(Pessoa p: lista){ //enhanced for ou for-each - percorre a lista de pessos onde a variavel p assume cada elemento da lista a cada iteração
            if(p.getId() == pessoa.getId()){ //verifica o id de cada elemento comparando se ele é o mesmo passado no parametro pessoa
                System.out.println("Erro: Já Existe uma pessoa com o mesmo ID.");
                return;
            }  
        }
        lista.add(pessoa); 
        System.err.println("Pessoa adicionada com sucesso");
        
    }
    
    //Retorna todas as pessoas na lista
    public List<Pessoa> buscarTodos(){
        return lista;  
    }
    
    public void alterarPessoa(Pessoa pessoa){
        //Substitui uma pessoa na lista que tem o mesmo id
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getId() == pessoa.getId()){
                lista.set(i, pessoa);
                break;
            }
        }
    }
    
    public Pessoa buscarPorId(int id){
        //Retorna uma pessoa da lista que tem o ID informado ou null se não tiver 
        for(Pessoa pessoa: lista){ //nesse bloco percorremos a lista de pesssoas verificando se a pessoa na iteracao atual possui o mesmo id que foi passado no parametro 
            if(pessoa.getId() == id){ //se esse id for igual o metodo vai retornar a pessoa dessa iteracao 
                return pessoa; 
            }
        }
        return null; //caso contrario retorna null se não for encontrada nenhuma pessoa
    }
    
    
    
    public void deletarPessoaPorId(int id){
        //Apaga da lista a pessoa que tem o id que foi passado
        Pessoa pessoaRemovida = null; //cria uma variavel do tipo pessoa para armazenar a pessoa que sera removida da lista 
        for(Pessoa pessoa : lista){ //percorre a lista comparando se a pessoa da iteracao atual possui o mesmo id do que foi passado dentro do parametro deste metodo
            if(pessoa.getId() == id){ 
                pessoaRemovida = pessoa; //armazena a pessoa encontrada dentro da variavel pessoaRemovida
                break; //sai do laco caso encontre o id que foi passado
            }
        }
        if(pessoaRemovida != null){  //serve para verificar se foi encontrado algum id, se encontrar ele remove a pessoa da lista
            lista.remove(pessoaRemovida); 
            System.out.println("Pessoa Removida da Lista! ");
        }
    }
}

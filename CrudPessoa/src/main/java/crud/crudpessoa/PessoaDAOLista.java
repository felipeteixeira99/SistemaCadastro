/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud.crudpessoa;

import interfaces.PessoaPersistencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe
 */

public class PessoaDAOLista implements PessoaPersistencia{
    
    private static PessoaDAOLista instancia;
    private int proximoID; // variavel que irá armazenar o proximo ID 
    
    public static PessoaDAOLista getInstancia(){
        if(instancia == null){
            instancia = new PessoaDAOLista();
        }
        return instancia;
    }

    private List<Pessoa> lista = new ArrayList<>(); //Lista principal
    
    private PessoaDAOLista(){
        proximoID = 1;
    }
    
    @Override
    public void adicionarPessoa(Pessoa pessoa){
        //int id = proximoID;,
        pessoa.setId(proximoID++);
        lista.add(pessoa); 
        System.out.println("Pessoa adicionada com sucesso: ID -  " + pessoa.getId());
    }
    
    @Override
    public void alterarPessoa(Pessoa pessoa){
        //Substitui uma pessoa na lista que tem o mesmo id
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getId() == pessoa.getId()){
                lista.set(i, pessoa);
                break;
            }
        }
    }
    
    //Retorna todas as pessoas na lista
    @Override
    public List<Pessoa> buscarTodos(){
        List<Pessoa> listaP = new ArrayList();
        listaP.addAll(this.lista); //adiciona todos os elementos da lista original dentro da lista que foi criada dentro dessa  funcao
        return listaP;  
    }
    
    @Override
    public Pessoa buscarPorId(int id){
        //Retorna uma pessoa da lista que tem o ID informado ou null se não tiver 
        for(Pessoa pessoa: lista){ //nesse bloco percorremos a lista de pesssoas verificando se a pessoa na iteracao atual possui o mesmo id que foi passado no parametro 
            if(pessoa.getId() == id){ //se esse id for igual o metodo vai retornar a pessoa dessa iteracao 
                return pessoa; 
            }
        }
        return null; //caso contrario retorna null se não for encontrada nenhuma pessoa
    }
     
    //Retornar pessoa - Especificamente o Nome da pessoa 
    @Override
    public Pessoa buscarPessoa(String nome){
        for(Pessoa pessoa : lista){
            if(pessoa.getNome().equals(nome)){
                return pessoa;
            }
        }
        return null;
    }
    
    @Override
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

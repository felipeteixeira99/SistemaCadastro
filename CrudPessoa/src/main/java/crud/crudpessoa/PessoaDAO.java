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
    }
    
    public List<Pessoa> buscarTodos(){
     return null;   
     //Retorna todas as pessoas na lista
    }
    
    public void alterarPessoa(Pessoa pessoa){
        //Substitui uma pessoa na lista que tem o emesmo id
    }
    
    public Pessoa buscarPorId(int id){
        return null;
        //Retorna uma pessoa da lista que tem o ID informado ou null se não tiver 
    }
    
    public void deletarPessoaPorId(int id){
        //Apaga da lista a pessoa que tem o id que foi passado
    }
    
    
    
}

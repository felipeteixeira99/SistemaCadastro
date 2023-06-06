/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testes;

import crud.crudpessoa.Pessoa;
import crud.crudpessoa.PessoaDAOBanco;

/**
 *
 * @author 78_TIC
 */
public class TestarBanco {
    
    public static void main(String[] args) {
        PessoaDAOBanco dao = new PessoaDAOBanco();
        Pessoa p = dao.buscarPorId(12);
        if(p  != null){
            System.out.println("Nome: " + p.getNome());
        }
        else{
            System.err.println("Pessoa Inexistente!");
        }
        
        //System.out.println(PessoaDAOBanco.getInstancia().buscarTodos().toString());
    }
    
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro;

/**
 *
 * @author 2830482411004
 */
public class aluno {
    public String nome;
    public String idade;
    public String curso;
    
    
    public aluno(String nome, String idade, String curso){
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
    }
    public Object[] ObterDados(){
        return new Object[]{nome, idade, curso};
    } 
    
}

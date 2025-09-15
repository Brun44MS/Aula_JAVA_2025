/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2830482411004
 */
public class Pessoa{
    public int id;
    public String nome;
    public String sexo;
    public String idioma;
 
    
    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public String getSexo(){
        return sexo;
    }
    public String getIdioma(){
        return idioma;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
    public void setIdioma(String idioma){
        this.idioma = idioma;
    }
}

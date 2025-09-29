/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2830482411004
 */
public class Fornecedores extends Cliente {
    public String nome_fantasia;
    public String CNPJ;
    
    public String getNome_fantasia(){
        return nome_fantasia;
    }
    public String getCNPJ(){
        return CNPJ;
    }
    public void setNome_fantasia(String nome_fantasia){
        this.nome_fantasia = nome_fantasia;
    }
    public void setCNPJ(String CNPJ){
        this.CNPJ = CNPJ;
    }
    
    
}

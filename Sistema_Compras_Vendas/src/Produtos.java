package com.comprasvendas.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2830482411004
 */
public class Produtos {
    private int id;
    private String nome;
    private String descricao;
    private double preco_venda;
    private int quantidade;

    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public String getDescricao(){
        return descricao;
    }
    public double getPreco_venda(){
        return preco_venda;
    }
    public int getQuantidade(){
        return quantidade;
     
    }
    public void setId(int id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setDescricao(String nome){
        this.descricao = descricao;
    }
    public void setPreco_venda(double preco_venda){
        this.preco_venda = preco_venda;
    }
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
     
    }    

    int getCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

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
public class ItemNota {
    private int notaCodigo; // FK para MovimentacaoNota
    private Produtos produtos; // Produto associado
    private int quantidade;
    private double precoUnitario; // Preço do produto no momento da transação

    public ItemNota(int notaCodigo, Produtos produtos, int quantidade, double precoUnitario) {
        this.notaCodigo = notaCodigo;
        this.produtos = produtos;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }
    public int getNotaCodigo() {
        return notaCodigo;
    }

    public void setNotaCodigo(int notaCodigo) {
        this.notaCodigo = notaCodigo;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    @Override
    public String toString() {
        return "ItemNota{" +
               ", notaCodigo=" + notaCodigo +
               ", produtos=" + produtos.getNome() +
               ", quantidade=" + quantidade +
               ", precoUnitario=" + precoUnitario +
               "}";
    }
}

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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovimentacaoNota {
    private int codigo;
    private String tipoMovimentacao; // "ENTRADA" ou "SAIDA"
    private int pessoaCodigo; // Código do Cliente ou Fornecedor
    private String pessoaNome; // Nome do Cliente ou Fornecedor para exibição
    private LocalDate dataMovimentacao;
    private List<ItemNota> itens = new ArrayList<>();

    public MovimentacaoNota(int codigo, String tipoMovimentacao, int pessoaCodigo, String pessoaNome, LocalDate dataMovimentacao) {
        this.codigo = codigo;
        this.tipoMovimentacao = tipoMovimentacao;
        this.pessoaCodigo = pessoaCodigo;
        this.pessoaNome = pessoaNome;
        this.dataMovimentacao = dataMovimentacao;
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public int getPessoaCodigo() {
        return pessoaCodigo;
    }

    public void setPessoaCodigo(int pessoaCodigo) {
        this.pessoaCodigo = pessoaCodigo;
    }

    public String getPessoaNome() {
        return pessoaNome;
    }

    public void setPessoaNome(String pessoaNome) {
        this.pessoaNome = pessoaNome;
    }

    public LocalDate getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(LocalDate dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public List<ItemNota> getItens() {
        return itens;
    }

    public void addItens(ItemNota item) {
        this.itens.add(item);
    }

    @Override
    public String toString() {
        return "Nota " + tipoMovimentacao + " [Código: " + codigo + ", Pessoa: " + pessoaNome + ", Data: " + dataMovimentacao + "]";
    }
}

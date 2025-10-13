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
public class Nota_Entrada {
    private Fornecedores fornecedores;
    private Produtos produtos;
    private int quantidadeComprada;
    private LocalDate dataCompra;

    public Nota_Entrada(Fornecedores fornecedores, Produtos produtos, int quantidadeComprada, LocalDate dataCompra) {
        this.fornecedores = fornecedores;
        this.produtos = produtos;
        this.quantidadeComprada = quantidadeComprada;
        this.dataCompra = dataCompra;
    }

    public Fornecedores getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(Fornecedores fornecedores) {
        this.fornecedores = fornecedores;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    public int getQuantidadeComprada() {
        return quantidadeComprada;
    }

    public void setQuantidadeComprada(int quantidadeComprada) {
        this.quantidadeComprada = quantidadeComprada;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }
}

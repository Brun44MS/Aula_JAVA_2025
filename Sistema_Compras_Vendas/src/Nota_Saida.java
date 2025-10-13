
import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2830482411004
 */
public class Nota_Saida {
    public Cliente cliente;
    public Produtos produtos;
    public int quantidadeVendida;
    public LocalDate dataVenda;

    public Nota_Saida(Cliente cliente, Produtos produtos, int quantidadeVendida, LocalDate dataVenda) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.quantidadeVendida = quantidadeVendida;
        this.dataVenda = dataVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    @Override
    public String toString() {
        return "NotaSaida{" +
               ", cliente=" + cliente.getNome() +
               ", produto=" + produtos.getNome() +
               ", quantidadeVendida=" + quantidadeVendida +
               ", dataVenda=" + dataVenda +
               "}";
    }
}


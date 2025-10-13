
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comprasvendas.dao;

/**
 *
 * @author 2830482411004
 */
public class ProdutosDAO {
    private Conexao conexao;
    private Connection conn;

    public ProdutosDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    public void Cadastrar_produto (Produtos produtos){
        String sql = "INSERT INTO Cliente(est_nome, est_desc, est_preco, est_quant) VALUES(?,?,?,?);";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, produtos.getNome());
            stmt.setString(2, produtos.getDescricao());
            stmt.setDouble(3, produtos.getPreco_venda());
            stmt.setInt(4, produtos.getQuantidade());
            
            
            stmt.execute();
        }catch(SQLException ex){
            System.out.println("Erro ao inserir pessoa "+ ex.getMessage());
            }
        }
}

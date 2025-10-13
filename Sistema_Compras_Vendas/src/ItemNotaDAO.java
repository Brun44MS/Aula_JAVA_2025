package com.comprasvendas.dao;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2830482411004
 */


public class ItemNotaDAO {

    private ProdutosDAO produtosDAO = new ProdutosDAO();

    public void save(ItemNota itemNota) {
        String sql = "INSERT INTO ItemNota (notaCodigo, produtoCodigo, quantidade, precoUnitario) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, itemNota.getNotaCodigo());
            stmt.setInt(2, itemNota.getProdutos().getCodigo());
            stmt.setInt(3, itemNota.getQuantidade());
            stmt.setDouble(4, itemNota.getPrecoUnitario());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    itemNota.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ItemNota> findByNotaCodigo(int notaCodigo) {
        List<ItemNota> itens = new ArrayList<>();
        String sql = "SELECT * FROM ItemNota WHERE notaCodigo = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, notaCodigo);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Produto produto = produtoDAO.findById(rs.getInt("produtoCodigo"));
                    ItemNota item = new ItemNota(
                        rs.getInt("id"),
                        rs.getInt("notaCodigo"),
                        produto,
                        rs.getInt("quantidade"),
                        rs.getDouble("precoUnitario")
                    );
                    itens.add(item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itens;
    }

    public void deleteByNotaCodigo(int notaCodigo) {
        String sql = "DELETE FROM ItemNota WHERE notaCodigo = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, notaCodigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

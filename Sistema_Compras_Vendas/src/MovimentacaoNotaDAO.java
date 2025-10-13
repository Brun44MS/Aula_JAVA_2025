package com.comprasvendas.dao;

import com.comprasvendas.model.MovimentacaoNota;
import com.comprasvendas.model.ItemNota;
import com.comprasvendas.model.Produtos;
import com.comprasvendas.dao.Conexao;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2830482411004
 */

public class MovimentacaoNotaDAO implements GenericDAO<MovimentacaoNota> {

    private ProdutosDAO produtosDAO = new ProdutosDAO();
    private ItemNotaDAO itemNotaDAO = new ItemNotaDAO();

    public void save(MovimentacaoNota nota) {
        String sql = "INSERT INTO MovimentacaoNota (tipoMovimentacao, pessoaCodigo, pessoaNome, dataMovimentacao) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, nota.getTipoMovimentacao());
            stmt.setInt(2, nota.getPessoaCodigo());
            stmt.setString(3, nota.getPessoaNome());
            stmt.setString(4, nota.getDataMovimentacao().toString());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    nota.setCodigo(generatedKeys.getInt(1));
                }
            }

            // Salvar os itens da nota
            for (ItemNota item : nota.getItens()) {
                item.setNotaCodigo(nota.getCodigo());
                itemNotaDAO.save(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<MovimentacaoNota> findAll() {
        List<MovimentacaoNota> notas = new ArrayList<>();
        String sql = "SELECT * FROM MovimentacaoNota";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                MovimentacaoNota nota = new MovimentacaoNota(
                    rs.getInt("codigo"),
                    rs.getString("tipoMovimentacao"),
                    rs.getInt("pessoaCodigo"),
                    rs.getString("pessoaNome"),
                    LocalDate.parse(rs.getString("dataMovimentacao"))
                );
                // Carregar itens da nota
                nota.getItens().addAll(itemNotaDAO.findByNotaCodigo(nota.getCodigo()));
                notas.add(nota);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notas;
    }

    @Override
    public MovimentacaoNota findById(int id) {
        String sql = "SELECT * FROM MovimentacaoNota WHERE codigo = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    MovimentacaoNota nota = new MovimentacaoNota(
                        rs.getInt("codigo"),
                        rs.getString("tipoMovimentacao"),
                        rs.getInt("pessoaCodigo"),
                        rs.getString("pessoaNome"),
                        LocalDate.parse(rs.getString("dataMovimentacao"))
                    );
                    // Carregar itens da nota
                    nota.getItens().addAll(itemNotaDAO.findByNotaCodigo(nota.getCodigo()));
                    return nota;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(MovimentacaoNota nota) {
        String sql = "UPDATE MovimentacaoNota SET tipoMovimentacao = ?, pessoaCodigo = ?, pessoaNome = ?, dataMovimentacao = ? WHERE codigo = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nota.getTipoMovimentacao());
            stmt.setInt(2, nota.getPessoaCodigo());
            stmt.setString(3, nota.getPessoaNome());
            stmt.setString(4, nota.getDataMovimentacao().toString());
            stmt.setInt(5, nota.getCodigo());
            stmt.executeUpdate();

            // Atualizar itens da nota (simplificado: deleta e reinsere)
            itemNotaDAO.deleteByNotaCodigo(nota.getCodigo());
            for (ItemNota item : nota.getItens()) {
                item.setNotaCodigo(nota.getCodigo());
                itemNotaDAO.save(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM MovimentacaoNota WHERE codigo = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            // Os itens da nota serão deletados em cascata pelo FOREIGN KEY ON DELETE CASCADE
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
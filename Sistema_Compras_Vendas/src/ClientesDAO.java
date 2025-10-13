package com.comprasvendas.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2830482411004
 */
public class ClientesDAO {
    private Conexao conexao;
    private Connection conn;

    public ClientesDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    public void Cadastrar_cliente (Cliente cliente){
        String sql = "INSERT INTO Cliente(cli_nome, cli_end, cli_email, cli_tel) VALUES(?,?,?,?);";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            
            
            stmt.execute();
        }catch(SQLException ex){
            System.out.println("Erro ao inserir pessoa "+ ex.getMessage());
        }
    }
}


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
public class FornecedoresDAO {
   private Conexao conexao;
    private Connection conn;

    public FornecedoresDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    public void Cadastrar_fornecedor (Fornecedores fornecedores){
            String sql = "INSERT INTO Cliente(for_nome, for_nomeFan, for_cnpj, for_end, for_email, for_tel) VALUES(?,?,?,?,?,?);";

            try{
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setString(1, fornecedores.getNome());
                stmt.setString(2, fornecedores.getNomeFantasia());
                stmt.setString(3, fornecedores.getCnpj());
                stmt.setString(4, fornecedores.getEndereco());
                stmt.setString(5, fornecedores.getEmail());
                stmt.setString(3, fornecedores.getTelefone());


                stmt.execute();
            }catch(SQLException ex){
                System.out.println("Erro ao inserir pessoa "+ ex.getMessage());
                }
            }
        }


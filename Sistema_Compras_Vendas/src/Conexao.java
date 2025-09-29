
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2830482411004
 */
public class Conexao {
        public Connection getConexao(){
        try{
            Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/aulajava1?userTimezone=true&serverTimezone=UTC",
                "root", "root");
            System.out.println("Conexao registrada com sucesso ");
            return conn;
        }
        catch(Exception e){
            System.out.println("Erro ao conectar ao Banco " + e.getMessage());
            return null;
        }
        }
}

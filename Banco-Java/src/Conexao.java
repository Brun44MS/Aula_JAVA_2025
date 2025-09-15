
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * Classe criada para conectar-se ao banco de dados
 * @author Bruno Ferreira
 * @since Classe criada em 15/09/2025  
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

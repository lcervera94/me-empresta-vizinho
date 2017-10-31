package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private Connection conexao;

    public Conexao() {
        conecta();
    }

    public void conecta() {
        if (conexao == null) {
            String url = "jdbc:postgresql://localhost:5432/me_empresta_vizinho";
            String usuario = "postgres";
            String senha = "290994";
            String driver = "org.postgresql.Driver";

            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                conexao = (Connection) DriverManager.getConnection(url, usuario, senha);
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public Connection getConexao() {
        return conexao;
    }
}

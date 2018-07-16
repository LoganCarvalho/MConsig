package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class ConnectionFactory {
	
	// O drive do banco deve ser anexado as bibliotecas do projeto
	 private static final String url = "jdbc:oracle:thin:rm@//172.17.107.3:1521/rmpr";
	 private static final String usuario = "rm";
	 private static final String senha = "rm";
	 private static Connection conn = null;

	    //Método que será chamado em outras classes para obter conexão
	    public static Connection getConnection() {

	        try {
	           //Criar uma conexão com o banco
	            conn = DriverManager.getConnection(url, usuario, senha);
	        } catch (SQLException e) {
	            System.out.println("erro, verifique se o driver foi incluido como biblioteca do projeto ou procure o administrador do sistema.");
	            throw new RuntimeException(e);
	        }
	        return conn;
	    }
	    
	    // Métodos para fechar as conexões
	    public static void FecharConexao(Connection conn, PreparedStatement pstm, ResultSet rs) throws Exception {
	        Fechar(conn, pstm, rs);
	    }
	    
	    public static void FecharConexao(Connection conn, PreparedStatement pstm) throws Exception {
	        Fechar(conn, pstm, null);
	    }

	    public static void FecharConexao(Connection conn) throws Exception {
	        Fechar(conn, null, null);
	    }

	    private static void Fechar(Connection conn, PreparedStatement pstm, ResultSet rs) throws Exception {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (pstm != null) {
	                pstm.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (Exception e) {
	            throw new Exception(e.getMessage());
	        }
	    }
}

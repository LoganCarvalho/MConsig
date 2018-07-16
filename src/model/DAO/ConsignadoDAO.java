package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Bean.Consignado;

public class ConsignadoDAO {
	
	 public boolean consultar(Consignado consig) throws Exception {

	        Connection conexao = ConnectionFactory.getConnection();
	        ResultSet resposta = null;
	        boolean ok = false;
	        StringBuilder sql = new StringBuilder();

	        try {
	            sql.append("select margem from v_consignado");
	            sql.append(" where CPF = ?");                    //verificar se o cpf pode ser passado sem aspas 
	            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
	            stmt.setString(1, consig.getCpf());
	           
	            
	            resposta = stmt.executeQuery(); //o resultado da query fica armazenado nessa variável
	            while (resposta.next()) { 
	                
	                consig.setMargem(Double.parseDouble(resposta.getString("margem"))); //o campo em azul dever ser o nome do campo que está na tebala do banco
	                   
	                ok = true;
	            }
	        } catch (SQLException error) {
	            System.out.println(error.getMessage());
	        } finally {
	            if (conexao != null) {
	                ConnectionFactory.FecharConexao(conexao, null, resposta);
	            }
	        }
	        return ok;
	    }

}

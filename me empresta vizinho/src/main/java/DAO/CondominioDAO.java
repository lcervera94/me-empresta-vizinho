package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Objetos.Condominio;

public class CondominioDAO {

	private ArrayList<Condominio> conds = new ArrayList<Condominio>();

	public CondominioDAO() {

		Condominio c1 = new Condominio();
		c1.setId(1);
		c1.setNomeCondominio("Edifício São Pedro");

		conds.add(c1);

		Condominio c2 = new Condominio();
		c2.setId(2);
		c2.setNomeCondominio("Belladock Paulista");

		conds.add(c2);
	}

	public void insert(Condominio condominio) {
		conds.add(condominio);
			/*String sql = "INSERT INTO condominio(nome_condominio) VALUES (?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, condominio.getNomeCondominio());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}

	public void delete(int id) {
		/*String sql = "DELETE FROM condominio WHERE id_condominio = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}

	public List selectAll(){
		return conds;
		/*String sql = "SELECT * FROM condominio";
		ArrayList<Condominio> resultado = new ArrayList<>();

		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet resultSet = stmt.executeQuery();

			 while(resultSet.next()){
				 Condominio condominio = new Condominio();
				 condominio.setId(resultSet.getInt("id_condominio"));
				 condominio.setNomeCondominio(resultSet.getString("nome_condominio"));
				 resultado.add(condominio);
			 }
		}catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;*/
	}
}

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Objetos.Usuario;

public class UsuarioDAO {
	private Connection connection;

	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(Usuario usuario){
		String sql = "INSERT INTO usuario(nome_usuario, id_condominio, nr_apartamento) VALUES (?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNomeUsuario());
			stmt.setInt(2, usuario.getId_condominio());
			stmt.setString(3, usuario.getNr_apartamento());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id){
		String sql = "DELETE FROM usuario WHERE id_usuario = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List selectAll(){
		String sql = "SELECT * FROM usuario";
		ArrayList<Usuario> resultado = new ArrayList<>();
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet resultSet = stmt.executeQuery();
			
			 while(resultSet.next()){
				 Usuario usuario = new Usuario();
				 usuario.setIdUsuario(resultSet.getInt("id_usuario"));
				 usuario.setNomeUsuario(resultSet.getString("nome_usuario"));
				 usuario.setId_condominio(resultSet.getInt("id_condominio"));
				 usuario.setNr_apartamento(resultSet.getString("nr_apartamento"));
				 resultado.add(usuario);
			 }
		}catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public Usuario findUserById(int userId){
		String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
		Usuario usuario = null;
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, userId);
			ResultSet resultSet = stmt.executeQuery();
			
			 if(resultSet.next()){
				 usuario = new Usuario();
				 usuario.setIdUsuario(resultSet.getInt("id_usuario"));
				 usuario.setNomeUsuario(resultSet.getString("nome_usuario"));
				 usuario.setId_condominio(resultSet.getInt("id_condominio"));
				 usuario.setNr_apartamento(resultSet.getString("nr_apartamento"));
			 }
		}catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
}
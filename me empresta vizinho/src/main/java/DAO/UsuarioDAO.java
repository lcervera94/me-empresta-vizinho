package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Objetos.Usuario;

public class UsuarioDAO {

	private ArrayList<Usuario> usus = new ArrayList<Usuario>();

	public UsuarioDAO() {
		Usuario u1 = new Usuario();
		u1.setIdUsuario(1);
		u1.setNomeUsuario("Lucas Pipa Cervera");
		u1.setId_condominio(1);
		u1.setNr_apartamento("42");
		usus.add(u1);

		Usuario u2 = new Usuario();
		u2.setIdUsuario(2);
		u2.setNomeUsuario("Redher Wetzl");
		u2.setId_condominio(1);
		u2.setNr_apartamento("63");
		usus.add(u2);
	}

	public void insert(Usuario usuario){
		usuario.setIdUsuario(usus.size());
		usus.add(usuario);
//		String sql = "INSERT INTO usuario(nome_usuario, id_condominio, nr_apartamento) VALUES (?, ?, ?)";
//		try {
//			PreparedStatement stmt = connection.prepareStatement(sql);
//			stmt.setString(1, usuario.getNomeUsuario());
//			stmt.setInt(2, usuario.getId_condominio());
//			stmt.setString(3, usuario.getNr_apartamento());
//			stmt.execute();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

	public void delete(int id){
		for(Usuario u : usus){
			if(u.getIdUsuario() == id){
				usus.remove(u);
				break;
			}
		}
//		String sql = "DELETE FROM usuario WHERE id_usuario = ?";
//		try {
//			PreparedStatement stmt = connection.prepareStatement(sql);
//			stmt.setInt(1, id);
//			stmt.execute();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

	public List selectAll(){
		return usus;
//		String sql = "SELECT * FROM usuario";
//		ArrayList<Usuario> resultado = new ArrayList<>();
//
//		try{
//			PreparedStatement stmt = connection.prepareStatement(sql);
//			ResultSet resultSet = stmt.executeQuery();
//
//			while(resultSet.next()){
//				Usuario usuario = new Usuario();
//				usuario.setIdUsuario(resultSet.getInt("id_usuario"));
//				usuario.setNomeUsuario(resultSet.getString("nome_usuario"));
//				usuario.setId_condominio(resultSet.getInt("id_condominio"));
//				usuario.setNr_apartamento(resultSet.getString("nr_apartamento"));
//				resultado.add(usuario);
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return resultado;
	}

	public Usuario findUserById(int userId){
		for(Usuario u : usus){
			if(u.getIdUsuario() == userId){
				return u;
			}
		}
		return null;
//		String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
//		Usuario usuario = null;
//
//		try{
//			PreparedStatement stmt = connection.prepareStatement(sql);
//			stmt.setInt(1, userId);
//			ResultSet resultSet = stmt.executeQuery();
//
//			if(resultSet.next()){
//				usuario = new Usuario();
//				usuario.setIdUsuario(resultSet.getInt("id_usuario"));
//				usuario.setNomeUsuario(resultSet.getString("nome_usuario"));
//				usuario.setId_condominio(resultSet.getInt("id_condominio"));
//				usuario.setNr_apartamento(resultSet.getString("nr_apartamento"));
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return usuario;
	}
}
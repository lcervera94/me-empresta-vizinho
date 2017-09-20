package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Objetos.Produto;
import Objetos.Usuario;

public class ProdutoDAO {
	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void insert(Produto produto) {
		String sql = "INSERT INTO produto(nome_produto, descricao_produto, id_categoria, id_usuario, vl_preco, data_inicio, data_fim, link_imagem) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, produto.getNomeProduto());
			stmt.setString(2, produto.getDescProduto());
			stmt.setInt(3, produto.getIdCategoria());
			stmt.setInt(4, produto.getIdUsuario());
			stmt.setDouble(5, produto.getVl_preco());
			stmt.setObject(6, produto.getData_inicio());
			stmt.setObject(7, produto.getData_fim());
			stmt.setString(8, produto.getLink_imagem());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		String sql = "DELETE FROM produto WHERE id_produto = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List selectAll(){
		String sql = "SELECT * FROM produto";
		ArrayList<Produto> resultado = new ArrayList<>();
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet resultSet = stmt.executeQuery();
			
			 while(resultSet.next()){
				 Produto produto = new Produto();
				 produto.setIdProduto(resultSet.getInt("id_produto"));
				 produto.setNomeProduto(resultSet.getString("nome_produto"));
				 produto.setDescProduto(resultSet.getString("descricao_produto"));
				 produto.setIdCategoria(resultSet.getInt("id_categoria"));
				 produto.setIdUsuario(resultSet.getInt("id_usuario"));
				 produto.setVl_preco(resultSet.getDouble("vl_preco"));
				 produto.setData_inicio(resultSet.getObject("data_inicio", LocalDate.class));
				 produto.setData_fim(resultSet.getObject("data_fim", LocalDate.class));
				 produto.setLink_imagem(resultSet.getString("link_imagem"));
				 
				 resultado.add(produto);
			 }
		}catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public List findProductsByUserId(int userId){
		String sql = "SELECT * FROM produto WHERE id_usuario = ?";
		ArrayList<Produto> resultado = new ArrayList<>();
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, userId);
			ResultSet resultSet = stmt.executeQuery();
			
			 while(resultSet.next()){
				 Produto produto = new Produto();
				 produto.setIdProduto(resultSet.getInt("id_produto"));
				 produto.setNomeProduto(resultSet.getString("nome_produto"));
				 produto.setDescProduto(resultSet.getString("descricao_produto"));
				 produto.setIdCategoria(resultSet.getInt("id_categoria"));
				 produto.setIdUsuario(resultSet.getInt("id_usuario"));
				 produto.setVl_preco(resultSet.getDouble("vl_preco"));
				 produto.setData_inicio(resultSet.getObject("data_inicio", LocalDate.class));
				 produto.setData_fim(resultSet.getObject("data_fim", LocalDate.class));
				 produto.setLink_imagem(resultSet.getString("link_imagem"));
				 resultado.add(produto);
			 }
		}catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public List findProductsByCategoryId(int categoryId){
		String sql = "SELECT * FROM produto WHERE id_categoria = ?";
		ArrayList<Produto> resultado = new ArrayList<>();
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, categoryId);
			ResultSet resultSet = stmt.executeQuery();
			
			 while(resultSet.next()){
				 Produto produto = new Produto();
				 produto.setIdProduto(resultSet.getInt("id_produto"));
				 produto.setNomeProduto(resultSet.getString("nome_produto"));
				 produto.setDescProduto(resultSet.getString("descricao_produto"));
				 produto.setIdCategoria(resultSet.getInt("id_categoria"));
				 produto.setIdUsuario(resultSet.getInt("id_usuario"));
				 produto.setVl_preco(resultSet.getDouble("vl_preco"));
				 produto.setData_inicio(resultSet.getObject("data_inicio", LocalDate.class));
				 produto.setData_fim(resultSet.getObject("data_fim", LocalDate.class));
				 produto.setLink_imagem(resultSet.getString("link_imagem"));
				 resultado.add(produto);
			 }
		}catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
}
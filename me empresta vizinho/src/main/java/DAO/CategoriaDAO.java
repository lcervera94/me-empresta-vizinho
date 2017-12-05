package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Objetos.Categoria;

public class CategoriaDAO {

    private ArrayList<Categoria> categorias = new ArrayList<Categoria>();

    public CategoriaDAO() {
        categorias.add(null);
    }

    public void insert(Categoria categoria) {
        categoria.setId(categorias.size());
        categorias.add(categoria);
//		String sql = "INSERT INTO categoria(nome_categoria) VALUES (?)";
//		try {
//			PreparedStatement stmt = connection.prepareStatement(sql);
//			stmt.setString(1, categoria.getNomeCategoria());
//			stmt.execute();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
    }

    public void delete(int id) {
        for (Categoria c : categorias) {
            if (c.getId() == id) {
                categorias.remove(c);
                break;
            }
        }
//		String sql = "DELETE FROM categoria WHERE id_categoria = ?";
//		try {
//			PreparedStatement stmt = connection.prepareStatement(sql);
//			stmt.setInt(1, id);
//			stmt.execute();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
    }

    public List selectAll() {
        return categorias;
//		String sql = "SELECT * FROM categoria";
//		ArrayList<Categoria> resultado = new ArrayList<>();
//
//		try {
//			PreparedStatement stmt = connection.prepareStatement(sql);
//			ResultSet resultSet = stmt.executeQuery();
//
//			while (resultSet.next()) {
//				Categoria categoria = new Categoria();
//				categoria.setId(resultSet.getInt("id_categoria"));
//				categoria.setNomeCategoria(resultSet.getString("nome_categoria"));
//				resultado.add(categoria);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return resultado;
    }
}

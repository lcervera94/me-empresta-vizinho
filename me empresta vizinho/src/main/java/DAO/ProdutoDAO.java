package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Objetos.Produto;
import Objetos.Usuario;

public class ProdutoDAO {
    private ArrayList<Produto> produtos = new ArrayList<Produto>();

    public ProdutoDAO() {

        Produto livro = new Produto();
        livro.setIdProduto(1);
        livro.setNomeProduto("TOEFL IBT");
        livro.setDescProduto("Livro para ajudar no preparatório do exame TOEFL. Acompanha CD com áudio.");
        livro.setIdCategoria(88);
        livro.setLink_imagem("../../../assets/toefl.jpg");
        livro.setVl_preco(0);
        livro.setIdUsuario(1);
        livro.setEmprestado(true);
        livro.setIdTomador(2);
        livro.setNomeTomador("Redher Wetzl");
        livro.setAprovado(true);
        produtos.add(livro);

        Produto escada = new Produto();
        escada.setIdProduto(2);
        escada.setNomeProduto("ESCADA");
        escada.setDescProduto("Escada de alumínio 1,5m");
        escada.setIdCategoria(99);
        escada.setLink_imagem("../../../assets/escada.jpg");
        escada.setVl_preco(0);
        escada.setIdUsuario(1);
        escada.setIdTomador(0);
        escada.setEmprestado(false);
        escada.setAprovado(false);
        produtos.add(escada);

        Produto martelo = new Produto();
        martelo.setIdProduto(3);
        martelo.setNomeProduto("MARTELO");
        martelo.setDescProduto("");
        martelo.setIdCategoria(99);
        martelo.setLink_imagem("../../../assets/martelo.jpg");
        martelo.setVl_preco(0);
        martelo.setIdUsuario(1);
        martelo.setIdTomador(2);
        martelo.setEmprestado(true);
        martelo.setAprovado(false);
        produtos.add(martelo);

        Produto ferro = new Produto();
        ferro.setIdProduto(4);
        ferro.setNomeProduto("FERRO DE PASSAR");
        ferro.setDescProduto("Ferro de passar black and decker");
        ferro.setIdCategoria(99);
        ferro.setLink_imagem("../../../assets/ferro.jpg");
        ferro.setVl_preco(0);
        ferro.setIdUsuario(2);
        ferro.setEmprestado(true);
        ferro.setIdTomador(1);
        ferro.setNomeTomador("Lucas Pipa Cervera");
        ferro.setAprovado(true);
        produtos.add(ferro);

        Produto aspirador = new Produto();
        aspirador.setIdProduto(3);
        aspirador.setNomeProduto("ASPIRADOR DE PÓ");
        aspirador.setDescProduto("Bico de 2m");
        aspirador.setIdCategoria(99);
        aspirador.setLink_imagem("../../../assets/aspirador.jpg");
        aspirador.setVl_preco(0);
        aspirador.setIdUsuario(2);
        aspirador.setNomeTomador("Lucas Pipa Cervera");
        aspirador.setIdTomador(1);
        aspirador.setEmprestado(true);
        aspirador.setAprovado(true);
        produtos.add(aspirador);

    }

    public void insert(Produto produto) {
        produto.setIdProduto(produtos.size());
        produtos.add(produto);
        /*String sql = "INSERT INTO produto(nome_produto, descricao_produto, id_categoria, id_usuario, vl_preco, data_inicio, data_fim, link_imagem) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProduto());
            stmt.setString(2, produto.getDescProduto());
            stmt.setInt(3, produto.getIdCategoria());
            stmt.setInt(4, produto.getIdUsuario());
            stmt.setDouble(5, produto.getVl_preco());
            stmt.setObject(6, LocalDate.ofEpochDay(produto.getData_inicio()));
            stmt.setObject(7, LocalDate.ofEpochDay((produto.getData_fim())));
            stmt.setString(8, produto.getLink_imagem());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    public void delete(int id) {
        Produto selecionado = null;
        for (Produto p :
                produtos) {
            if (p.getIdProduto() == id) {
                selecionado = p;
            }
        }
        produtos.remove(selecionado);
        /*String sql = "DELETE FROM produto WHERE id_produto = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    public List<Produto> selectAll() {
        return produtos;
        /*String sql = "SELECT * FROM produto";
        ArrayList<Produto> resultado = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(resultSet.getInt("id_produto"));
                produto.setNomeProduto(resultSet.getString("nome_produto"));
                produto.setDescProduto(resultSet.getString("descricao_produto"));
                produto.setIdCategoria(resultSet.getInt("id_categoria"));
                produto.setIdUsuario(resultSet.getInt("id_usuario"));
                produto.setVl_preco(resultSet.getDouble("vl_preco"));
                produto.setData_inicio(((Date) resultSet.getObject("data_inicio")).getTime());
                produto.setData_fim(((Date) resultSet.getObject("data_fim")).getTime());
                produto.setLink_imagem(resultSet.getString("link_imagem"));

                resultado.add(produto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;*/
    }

    public Produto findProductById(int id) {
        for (Produto p :
                produtos) {
            if (p.getIdProduto() == id) {
                return p;
            }
        }
        return null;
    }

    public List findProductsByUserId(int userId) {
        //String sql = "SELECT * FROM produto WHERE id_usuario = ?";
        ArrayList<Produto> resultado = new ArrayList<>();

        for (Produto p :
                produtos) {
            if(p.getIdUsuario() == userId && (p.isAprovado() || !p.isEmprestado())){
                resultado.add(p);
            }
        }
/*
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, userId);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(resultSet.getInt("id_produto"));
                produto.setNomeProduto(resultSet.getString("nome_produto"));
                produto.setDescProduto(resultSet.getString("descricao_produto"));
                produto.setIdCategoria(resultSet.getInt("id_categoria"));
                produto.setIdUsuario(resultSet.getInt("id_usuario"));
                produto.setVl_preco(resultSet.getDouble("vl_preco"));
                produto.setData_inicio(((Date) resultSet.getObject("data_inicio")).getTime());
                produto.setData_fim(((Date) resultSet.getObject("data_fim")).getTime());
                produto.setLink_imagem(resultSet.getString("link_imagem"));
                resultado.add(produto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return resultado;
}

    public List findProductsByCategoryId(int categoryId) {
        //String sql = "SELECT * FROM produto WHERE id_categoria = ?";
        ArrayList<Produto> resultado = new ArrayList<>();

        for (Produto p :
                produtos) {
            if (p.getIdCategoria() == categoryId) {
                resultado.add(p);
            }
        }
        /*
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, categoryId);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(resultSet.getInt("id_produto"));
                produto.setNomeProduto(resultSet.getString("nome_produto"));
                produto.setDescProduto(resultSet.getString("descricao_produto"));
                produto.setIdCategoria(resultSet.getInt("id_categoria"));
                produto.setIdUsuario(resultSet.getInt("id_usuario"));
                produto.setVl_preco(resultSet.getDouble("vl_preco"));
                produto.setData_inicio(((Date) resultSet.getObject("data_inicio")).getTime());
                produto.setData_fim(((Date) resultSet.getObject("data_fim")).getTime());
                produto.setLink_imagem(resultSet.getString("link_imagem"));
                resultado.add(produto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return resultado;
    }
}
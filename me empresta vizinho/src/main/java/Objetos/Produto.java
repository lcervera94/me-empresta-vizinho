package Objetos;

import java.time.LocalDate;

public class Produto {
	private int idProduto;
	private String nomeProduto;
	private String descProduto;
	private int idCategoria; 
	private int idUsuario;
	private double vl_preco;
	private LocalDate data_inicio;
	private LocalDate data_fim;
	private String link_imagem;
	
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getDescProduto() {
		return descProduto;
	}
	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public double getVl_preco() {
		return vl_preco;
	}
	public void setVl_preco(double vl_preco) {
		this.vl_preco = vl_preco;
	}
	public LocalDate getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(LocalDate data_inicio) {
		this.data_inicio = data_inicio;
	}
	public LocalDate getData_fim() {
		return data_fim;
	}
	public void setData_fim(LocalDate data_fim) {
		this.data_fim = data_fim;
	}
	public String getLink_imagem() {
		return link_imagem;
	}
	public void setLink_imagem(String link_imagem) {
		this.link_imagem = link_imagem;
	}
}

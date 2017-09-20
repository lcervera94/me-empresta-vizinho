package Objetos;

public class Usuario {
	private int idUsuario;
	private String nomeUsuario;
	private int id_condominio;
	private String nr_apartamento;
		
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public int getId_condominio() {
		return id_condominio;
	}
	public void setId_condominio(int id_condominio) {
		this.id_condominio = id_condominio;
	}
	public String getNr_apartamento() {
		return nr_apartamento;
	}
	public void setNr_apartamento(String nr_apartamento) {
		this.nr_apartamento = nr_apartamento;
	}
}

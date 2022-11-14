package model;

public class Aluno {

	private int id;
	private String nome;
	private int idProfessor;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdProfessor() {
		return idProfessor;
	}
	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}
	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", idProfessor=" + idProfessor + "]";
	}
	
}

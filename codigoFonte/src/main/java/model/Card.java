package model;

public class Card {

	private int id;
	private String nome;
	private String imgCard;
	
	
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
	public String getImgCard() {
		return imgCard;
	}
	public void setImgCard(String imgCard) {
		this.imgCard = imgCard;
	}
	@Override
	public String toString() {
		return "Card [id=" + id + ", nome=" + nome + ", imgCard=" + imgCard + "]";
	}
	
	
	
}

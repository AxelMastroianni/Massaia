package la.massaia;

public class Ingrediente {
	
	private String nome="";
	private int calorie;
	private int quantita=0;
	
	public Ingrediente(String nome, int calorie) {
		this.nome=nome.toLowerCase();
		this.calorie=calorie;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toLowerCase();
	}

	public int getCalorie() {
		return calorie;
	}

	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}
	
	public int getQuantita() {
		return quantita;
	}
	
	public void setQuantita(int quantita) {
		this.quantita=quantita;
	}
	
	public int calcolaCalorie() {
		return calorie*quantita;
	}
	
	public String toString() {
		return nome+" calorie contenute in 1g: "+calorie;
	}

}

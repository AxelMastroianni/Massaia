package la.massaia;

import java.util.ArrayList;

public class Ricetta {
	
	private String nome="";
	private ArrayList<Ingrediente> necessari=new ArrayList<Ingrediente>();
	private String descrizione="";
	private String cardinalita="";//indica se è un primo oppure un secondo
	private int calorieTotali=0;
	
	public Ricetta(String nome, String cardinalita) {
		this.nome=nome.toLowerCase();
		this.cardinalita=cardinalita.toLowerCase();
	}

	public int getCalorieTotali() {
		return calorieTotali;
	}

	public void setCalorieTotali(int calorieTotali) {
		this.calorieTotali = calorieTotali;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toLowerCase();
	}

	public ArrayList<Ingrediente> getNecessari() {
		return necessari;
	}

	public void setNecessari(ArrayList<Ingrediente> necessari) {
		this.necessari = necessari;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCardinalita() {
		return cardinalita;
	}

	public void setCardinalita(String cardinalita) {
		this.cardinalita = cardinalita.toLowerCase();
	}
	
	public void visualizzaRicetta() {
		System.out.println(nome+": "+calorieTotali+" calorie");
	}
	
	public int calorieTotali() {
		int totali=0;
		for(Ingrediente necessario: necessari) {
			totali+=necessario.calcolaCalorie();
		}
		return totali;
	}
	
	
	public void aggiungiIngrediente(Ingrediente ingrediente) {
		necessari.add(ingrediente);
	}

}

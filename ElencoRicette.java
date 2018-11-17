package la.massaia;
import java.util.ArrayList;

public class ElencoRicette {
	
	private ArrayList<Ricetta> elencoPrimi=new ArrayList<Ricetta>();
	private ArrayList<Ricetta> elencoSecondi=new ArrayList<Ricetta>();
	
	public ElencoRicette() {
		
	}
	
	public void aggiungiRicetta(Ricetta nuova) {
		if(nuova.getCardinalita().equals("primo"))
			elencoPrimi.add(nuova);
		else if(nuova.getCardinalita().equals("secondo"))
			elencoSecondi.add(nuova);
	}
	
	public void visualizzaRicette() {
		if(!elencoPrimi.isEmpty()) {
			System.out.println("----------------------");
			System.out.println("Elenco primi: ");
			for(Ricetta primo: elencoPrimi)
				primo.visualizzaRicetta();
		}
		else 
			System.out.println("Non hai inserito nessun primo piatto");
		if(!elencoSecondi.isEmpty()) {
			System.out.println("----------------------");
			System.out.println("Elenco secondi: ");
			for(Ricetta secondo: elencoSecondi)
				secondo.visualizzaRicetta();
			System.out.println("----------------------");
		}
		else
			System.out.println("Non hai inserito nessun secondo piatto");
	}
	
	private int cercaPrimo(String nome) {
		for(int i=0;i<elencoPrimi.size();i++) {
			Ricetta primo=elencoPrimi.get(i);
			if(primo.getNome().equals(nome))
				return i;
		}
		return -1;
	}
	
	private int cercaSecondo(String nome) {
		for(int i=0;i<elencoSecondi.size();i++) {
			Ricetta secondo=elencoSecondi.get(i);
			if(secondo.getNome().equals(nome))
				return i;
		}
		return -1;
	}
	
	public Ricetta ritornaPrimo(String nome) {
		int indirizzoPrimo=cercaPrimo(nome);
		if(indirizzoPrimo!=-1)
			return elencoPrimi.get(indirizzoPrimo);
		throw new IllegalArgumentException();
	}
	
	public Ricetta ritornaSecondo(String nome) {
		int inidirizzoSecondo=cercaSecondo(nome);
		if(inidirizzoSecondo!=-1)
			return elencoSecondi.get(inidirizzoSecondo);
		throw new IllegalArgumentException();
	}

	public ArrayList<Ricetta> getElencoPrimi() {
		return elencoPrimi;
	}

	public void setElencoPrimi(ArrayList<Ricetta> elencoPrimi) {
		this.elencoPrimi = elencoPrimi;
	}

	public ArrayList<Ricetta> getElencoSecondi() {
		return elencoSecondi;
	}

	public void setElencoSecondi(ArrayList<Ricetta> elencoSecondi) {
		this.elencoSecondi = elencoSecondi;
	}
	
	
	
}

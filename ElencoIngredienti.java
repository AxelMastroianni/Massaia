package la.massaia;
import java.util.ArrayList;

public class ElencoIngredienti {
	
	private ArrayList<Ingrediente> elencoIngredienti=new ArrayList<Ingrediente>();
	
	public ElencoIngredienti() {
		
	}
	
	public void aggiungiIngrediente(Ingrediente nuovo) {
		elencoIngredienti.add(nuovo);
	}
	
	public void visualizzaIngredienti() {
		if(!elencoIngredienti.isEmpty()) {
			for(Ingrediente ingrediente : elencoIngredienti)
				System.out.println(ingrediente.toString());
		}
		else
			System.out.println("Non hai aggiunto nessun ingrediente");
	}
	
	public int ingredientePresente(String nome) {
		for(int i=0;i<elencoIngredienti.size();i++) {
			if(elencoIngredienti.get(i).getNome().equals(nome.toLowerCase()))
				return i; //trovato
		}
		return -1;
	}
	
	public Ingrediente ritornaIngrediente(int indirizzo) {
		return elencoIngredienti.get(indirizzo);
	}
	
	public Ingrediente ritornaIngrediente(String nome) {
		int indirizzo=ingredientePresente(nome);
		if(indirizzo!=-1) {
			return elencoIngredienti.get(indirizzo);
		}
		throw new IllegalArgumentException();
	}

	public ArrayList<Ingrediente> getElencoIngredienti() {
		return elencoIngredienti;
	}

	public void setElencoIngredienti(ArrayList<Ingrediente> elencoIngredienti) {
		this.elencoIngredienti = elencoIngredienti;
	}
	
	

}

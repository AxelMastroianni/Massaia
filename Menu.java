package la.massaia;

public class Menu {
	
	private Ricetta primo;
	private Ricetta secondo;
	
	public Menu(Ricetta primo, Ricetta secondo) {
		this.primo=primo;
		this.secondo=secondo;
	}

	public Ricetta getPrimo() {
		return primo;
	}

	public void setPrimo(Ricetta primo) {
		this.primo = primo;
	}

	public Ricetta getSecondo() {
		return secondo;
	}

	public void setSecondo(Ricetta secondo) {
		this.secondo = secondo;
	}
	
	public int calorieMenu() {
		return primo.calorieTotali()+secondo.calorieTotali();
	}
	
	public void stampaMenu() {
		primo.visualizzaRicetta();
		secondo.visualizzaRicetta();
		System.out.println("Totale calorie: "+calorieMenu()+" calorie");
	}

}

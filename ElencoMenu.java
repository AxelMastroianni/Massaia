package la.massaia;
import java.util.ArrayList;

public class ElencoMenu {
	
	private static final int MASSIMA_PERCENTUALE = 100;
	private ArrayList<Menu> elencoMenu=new ArrayList<Menu>();
	private ArrayList<Menu> menuAccettabili=new ArrayList<Menu>();
	public static final int PERCENTUALE_TOLLERANZA=20;
	public ElencoMenu() {
		
	}
	
	public void aggiungiMenu(Menu nuovo) {
		elencoMenu.add(nuovo);
	}


	public ArrayList<Menu> getElencoMenu() {
		return elencoMenu;
	}
	public void setElencoMenu(ArrayList<Menu> elencoMenu) {
		this.elencoMenu = elencoMenu;
	}
	public ArrayList<Menu> getMenuAccettabili() {
		return menuAccettabili;
	}
	public void setMenuAccettabili(ArrayList<Menu> menuAccettabili) {
		this.menuAccettabili = menuAccettabili;
	}
	
	public void selezionaMenu(int massimeCalorie) {
		double estremoSuperiore=(double)massimeCalorie*(PERCENTUALE_TOLLERANZA/(double)MASSIMA_PERCENTUALE)+massimeCalorie;
		double estremoInferiore=(double)massimeCalorie-massimeCalorie*(PERCENTUALE_TOLLERANZA/(double)MASSIMA_PERCENTUALE);
		for(int i=0;i<elencoMenu.size();i++) {
			Menu selezionato=elencoMenu.get(i);
			if(selezionato.calorieMenu()>=estremoInferiore && selezionato.calorieMenu()<=estremoSuperiore)
				menuAccettabili.add(selezionato);
		}
	}
	
	public void visualizzaAccettabili() {
		if(!menuAccettabili.isEmpty()) {
		for(Menu accettabile : menuAccettabili)
			accettabile.stampaMenu();
		}
		else
			System.out.println("Non ho trovato un menu che corrisponda alle tue esigenze");
	}
	
	public void visualizzaLista() {
		if(!elencoMenu.isEmpty()) {
			for(int i=0;i<elencoMenu.size();i++) {
				Menu menu=elencoMenu.get(i);
				menu.stampaMenu();
			}
		}
		else
			System.out.println("La lista è vuota, inserisci qualche menu");
	}
	
	/**
	 * svuoto i menu accettabili in modo da poter ricostruire una nuova lista sulla base di un nuovo
	 * valore di calorie tollerabili
	 */
	public void svuotaAccettabili() {
		while(!menuAccettabili.isEmpty())
			menuAccettabili.remove(0);
	}
	
	
	

}

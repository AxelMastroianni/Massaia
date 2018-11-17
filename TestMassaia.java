package la.massaia;


import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class TestMassaia {
	public static Ingrediente creaIngrediente() {	
		String nome=InputDati.leggiStringaNonVuota("Inserisci il nome dell'ingrediente: ");
		int calorie=InputDati.leggiIntero("Quante calorie contiene un grammo: ");
		return new Ingrediente(nome,calorie);
	}
	
	public static Ricetta creaRicetta() {
		String nome=InputDati.leggiStringaNonVuota("Inserisci il nome della ricetta: ");
		String cardinalita=InputDati.leggiStringaNonVuota("Primo o un secondo? ");
		return new Ricetta(nome,cardinalita);
	}
	public static void main(String[] args) {
		final String[] menuScelte=new String[] {"Aggiungi Ingrediente","Visualizza Ingredienti",
				"Crea Ricetta","Visualizza Ricette","Crea Menu","Visualizza Lista Menu","Ricette per calorie"};
		int scelta=0;
		MyMenu menu=new MyMenu("Piovra",menuScelte);
		ElencoIngredienti elencoIngredienti=new ElencoIngredienti();
		ElencoRicette elencoRicette=new ElencoRicette();
		ElencoMenu elencoMenu=new ElencoMenu();
		String risposta="";
		while(!risposta.equals("no")) {
			scelta=menu.scegli();
			switch(scelta) {
			case 1:{
				Ingrediente ingrediente=creaIngrediente();
				elencoIngredienti.aggiungiIngrediente(ingrediente);
				break;
			}
			case 2:{
				elencoIngredienti.visualizzaIngredienti();
				break;
			}
			case 3:{
				Ricetta ricetta=creaRicetta();
				int numeroIngredienti=InputDati.leggiIntero("Da quanti ingredienti è composta? ");
				try {
				for(int i=0;i<numeroIngredienti;i++) {
					String nomeIngrediente=InputDati.leggiStringaNonVuota("Inserisci un ingrediente: ");
					Ingrediente ingrediente=elencoIngredienti.ritornaIngrediente(nomeIngrediente);
					int quantita=InputDati.leggiIntero("Quanti grammi? ");
					ingrediente.setQuantita(quantita);
					ricetta.aggiungiIngrediente(ingrediente);
				}
				int calorieTotali=ricetta.calorieTotali();
				ricetta.setCalorieTotali(calorieTotali);
				}catch(IllegalArgumentException e) {
					System.out.println("Ingrediente inesistente, aggiungilo");
					break;
				}
				elencoRicette.aggiungiRicetta(ricetta);
				break;
			}
			case 4:{
				elencoRicette.visualizzaRicette();
				break;
			}
			case 5:{
				System.out.println("Hai a disposizione i seguenti piatti: ");
				elencoRicette.visualizzaRicette();
				try {
				String nomePrimo=InputDati.leggiStringaNonVuota("Inserisci il nome di un primo: ");
				Ricetta primo=elencoRicette.ritornaPrimo(nomePrimo);
				String nomeSecondo=InputDati.leggiStringaNonVuota("Inserisci il nome di un secondo: ");
				Ricetta secondo=elencoRicette.ritornaSecondo(nomeSecondo);
				Menu pietanza=new Menu(primo,secondo);//se arriva fin qui non ha incontrato nessun eccezione
				elencoMenu.aggiungiMenu(pietanza);
				}catch(IllegalArgumentException e) {
					System.out.println("Primo o secondo non esistente, selezionare nuovamente l'opzione");
					break;
				}
				break;
			}
			case 6:{
				elencoMenu.visualizzaLista();
				break;
			}
			case 7:{
				int massimeTollerabili=InputDati.leggiIntero("Inserisci le massime calorie che vuoi assumere: ");
				elencoMenu.selezionaMenu(massimeTollerabili);
				elencoMenu.visualizzaAccettabili();
				elencoMenu.svuotaAccettabili();//svuoto le pietanze accettabili in modo da riceverne di nuove
				break;
			}
			default:{
				System.out.println("Scelta non corretta, riprova");
				break;
			}
			}
			risposta=InputDati.leggiStringaNonVuota("Continui ad interagire con il sistema?(no, per terminare) ");
		}
	}

}

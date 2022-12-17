import java.util.ArrayList;

public class AdressBuch {
	private	ArrayList<Adresse> adressListe = new ArrayList<Adresse>();
	
	public void addAdresse(String vorname, String nachname, String telefon, String email) {
		Adresse a = new Adresse(vorname, nachname, telefon, email);
		adressListe.add(a);
	}
	public void printAll() {
		for (Adresse adresse : adressListe) {
			System.out.println(adresse.toString());
		}
	}
	
}

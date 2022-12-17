
public class Adresse {
	private String vorname;
	private String nachname;
	private String telefon;
	private String email;
	
	public Adresse() {
		vorname = "";
		nachname = "";
		telefon = "";
		email = "";
	}
	
	public Adresse(String vorname, String nachname, String telefon, String email) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.telefon = telefon;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Adresse [vorname = " + vorname + ", nachname = " + nachname + ", telefon = " + telefon + ", email = " + email + "]";
	}
	
	/*@Override
	public String toString() {
		return vorname + nachname + telefon + email;
	}*/
}

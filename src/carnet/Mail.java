package carnet;

public class Mail {
	/**
	 * Mail de la personne
	 */
	private String mail ;

	/**
	 * Constructeur du mail
	 * @param mail = mail du contact
	 */
	public Mail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return le mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Permet de changer le mail
	 * @param mail = nouveau mail ;
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}

package carnet;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Mail {
	/**
	 * Mail de la personne
	 */
	private StringProperty mail ;

	/**
	 * Constructeur du mail
	 * @param mail = mail du contact
	 */
	public Mail(String mail) {
		this.mail = new SimpleStringProperty(mail);
	}

	/**
	 * @return le mail en string
	 */
	public String getMail() {
		return mail.get();
	}
	
	/**
	 * @return le mail
	 */
	public StringProperty getMailProperty() {
		return this.mail ;
	}

	/**
	 * Permet de changer le mail
	 * @param mail = nouveau mail ;
	 */
	public void setMail(String mail) {
		this.mail = new SimpleStringProperty(mail);
	}
	
	
}

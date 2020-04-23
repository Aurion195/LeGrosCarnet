package carnet;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sun.net.NetworkServer;

public class Contact {
	/**
	 * Nom de famille
	 */
	private StringProperty firstName ;
	
	/**
	 * Prénom
	 */
	private StringProperty lastName ;
	
	
	/**
	 * Age
	 */
	private Integer age ;
	
	/**
	 * Homme ou femme
	 * 1 = homme
	 * 0 = femme
	 */
	private boolean genre ;

	
	/**
	 * Constructeur de contact
	 * @param firstName = nom de famille ;
	 * @param lastName = prenom ;
	 * @param age = age ;
	 * @param genre = homme ou femme ;
	 */
	public Contact(String firstName, String lastName, Integer age, boolean genre) {
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.age = age;
		this.genre = genre;
	}
	
	/**
	 * @return le firstName ;
	 */
	public StringProperty getFirstNameProperty() {
		return this.firstName ;
	}
	
	/**
	 * @return le lastName ;
	 */
	public StringProperty getLastNameProperty() {
		return this.lastName ;
	}
	
	/**
	 * @return le firstName en string ;
	 */
	public String getFirstName() {
		return firstName.get() ;
	}

	/**
	 * @return le lastName en string;
	 */
	public String getLastName() {
		return lastName.get() ;
	}

	/**
	 * @return l'age ;
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @return le genre ;
	 */
	public boolean isGenre() {
		return genre;
	}

	/**
	 * Permet de changer le nom
	 * @param firstName = nouveau firstName ;
	 */
	public void setFirstName(String firstName) {
		this.firstName = new SimpleStringProperty(firstName) ;
	}

	/**
	 * Permet de changer le prénom
	 * @param lastName = nouveau lastName ;
	 */
	public void setLastName(String lastName) {
		this.lastName = new SimpleStringProperty(lastName);
	}

	/**
	 * Permet de changer l'age
	 * @param age = nouveau age ;
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * Permet de changer le genre
	 * @param genre = nouveau genre ;
	 */
	public void setGenre(boolean genre) {
		this.genre = genre;
	}
	
	
}

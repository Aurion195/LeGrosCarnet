package carnet;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	 * Mail du contact
	 */
	private Mail mail ;
	
	/**
	 * Adresse du contact
	 */
	private Address adress ;
	
	/**
	 * Téléphone du contact
	 */
	private ObservableList<Telephone> telephone = FXCollections.observableArrayList() ;

	
	/**
	 * Constructeur de contact
	 * @param firstName = nom de famille ;
	 * @param lastName = prenom ;
	 * @param age = age ;
	 * @param genre = homme ou femme ;
	 */
	public Contact(String firstName, String lastName, Integer age, boolean genre, Mail mail, Address adress, Telephone telephone) {
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.age = age;
		this.genre = genre;
		this.mail = mail ;
		this.adress = adress ;
		this.telephone.add(telephone) ;
	}
	
	/**
	 * Permet d'ajouter un téléphone au contact
	 * @param telephone = nouveau numéro de téléphone ;
	 */
	public void ajouterTelephone(Telephone telephone) {
		this.telephone.add(telephone) ;
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
		return this.firstName.get() ;
	}

	/**
	 * @return le lastName en string;
	 */
	public String getLastName() {
		return this.lastName.get() ;
	}

	/**
	 * @return l'age ;
	 */
	public Integer getAge() {
		return this.age;
	}

	/**
	 * @return le genre ;
	 */
	public boolean isGenre() {
		return this.genre;
	}

	/**
	 * @return le mail
	 */
	public Mail getMail() {
		return this.mail ;
	}
	
	/**
	 * @return l'adresse du contact
	 */
	public Address getAddress() {
		return this.adress ;
	}
	
	/**
	 * @return le téléphone
	 */
	public ObservableList<Telephone> getTelephone() {
		return this.telephone ;
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
	
	/**
	 * Permet de changer l'addresse
	 * @param address = nouvelle adresse
	 */
	public void setAdress(Address address) {
		this.adress = address ;
	}
}

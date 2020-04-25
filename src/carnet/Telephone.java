package carnet;

import enumeration.EnumTelephone;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Telephone {
	/**
	 * Prefix 
	 */
	public StringProperty prefix ;
	
	/**
	 * Numéro de téléphone
	 */
	public StringProperty numero ;
	
	/**
	 * Type de téléphone
	 */
	public StringProperty type ;
	
	/**
	 * Constructeur du téléphone
	 * @param prefix = prefix ;
	 * @param numero = numéro de téléphone ;
	 */
	public Telephone(String prefix, String numero, String type) {
		this.prefix = new SimpleStringProperty(prefix);
		this.numero = new SimpleStringProperty(numero);
		this.type = new SimpleStringProperty(type) ;
	}

	/**
	 * @return le prefix
	 */
	public StringProperty getPrefix() {
		return prefix;
	}

	/**
	 * @return le numero
	 */
	public StringProperty getNumero() {
		return numero;
	}
	
	/**
	 * @return le type de telephone
	 */
	public StringProperty getType() {
		return type ;
	}

	/**
	 * Permet de changer le prefix
	 * @param prefix = nouveau prefix ;
	 */
	public void setPrefix(String prefix) {
		this.prefix = new SimpleStringProperty(prefix);;
	}

	/**
	 * Permet de changer le numéro
	 * @param numero = nouveau numéro ;
	 */
	public void setNumero(String numero) {
		this.numero = new SimpleStringProperty(numero);
	}
	
	/**
	 * Permet de changer le type de téléphone
	 * @param type = nouveau type ;
	 */
	public void setType(String type) {
		this.type = new SimpleStringProperty(type) ;
	}
}

package carnet;

public class Telephone {
	/**
	 * Prefix 
	 */
	public String prefix ;
	
	/**
	 * Numéro de téléphone
	 */
	public Integer numero ;
	
	/**
	 * Constructeur du téléphone
	 * @param prefix = prefix ;
	 * @param numero = numéro de téléphone ;
	 */
	public Telephone(String prefix, Integer numero) {
		this.prefix = prefix;
		this.numero = numero;
	}

	/**
	 * @return le prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * @return le numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * Permet de changer le prefix
	 * @param prefix = nouveau prefix ;
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * Permet de changer le numéro
	 * @param numero = nouveau numéro ;
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	
}

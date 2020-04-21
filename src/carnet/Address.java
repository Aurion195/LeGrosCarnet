package carnet;

public class Address {
	private String rue ;
	private String ville ;
	private Integer codePostale ;
	
	public Address(String rue, String ville, Integer codePostale) {
		this.rue = rue;
		this.ville = ville;
		this.codePostale = codePostale;
	}

	/**
	 * @return la rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * @return la ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @return la codePostale
	 */
	public Integer getCodePostale() {
		return codePostale;
	}

	/**
	 * Permet de changer la rue
	 * @param rue = nouvelle rue ;
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * Permet de changer la ville
	 * @param ville = nouvelle ville ;
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Permet de changer le code postale
	 * @param codePostale = nouveau code postale ;
	 */
	public void setCodePostale(Integer codePostale) {
		this.codePostale = codePostale;
	}
	
	
}

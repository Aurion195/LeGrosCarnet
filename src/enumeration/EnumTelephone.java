package enumeration;

public enum EnumTelephone {
	OFFICE("Office"),
	HOME("Home"),
	FAX("Fax"),
	PAGER("Pager"),
	MOBILE("Mobile") ;
	
	/**
	 * Type de téléphone
	 */
	private String type ;
	
	/**
	 * 
	 * @param type
	 */
	EnumTelephone(String type) {
		this.type = type ;
	}
	
	/**
	 * @return le type d'énumeration
	 */
	public String getType() {
		return this.type ;
	}
}

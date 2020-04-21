package carnet;

public class Contact {
	/**
	 * Nom de famille
	 */
	private String firstName ;
	
	/**
	 * Prénom
	 */
	private String lastName ;
	
	
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
	 * @return le firstName ;
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return le lastName ;
	 */
	public String getLastName() {
		return lastName;
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
		this.firstName = firstName;
	}

	/**
	 * Permet de changer le prénom
	 * @param lastName = nouveau lastName ;
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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

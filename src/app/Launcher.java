package app;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import carnet.Address;
import carnet.Contact;
import carnet.Mail;
import carnet.Telephone;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * Hello world!
 */
public class Launcher extends Application
{
	/**
	 * 1er scene
	 */
	private Stage primaryStage;

	/**
	 * Scene que l'on va changer 
	 */
	private AnchorPane rootLayout;

	/**
	 * Instance unique
	 */
	private static volatile Launcher instance = null;
	
	/**
	 * Object qui va contenir tous les contacts du carnet
	 */
	private Map<String, ObservableList<Contact>> mapContact = new HashMap<>();
	
	/**
	 * Constructeur de la classe
	 */
	public Launcher()
	{
		super();

		synchronized(Launcher.class)
		{
			if(instance != null) throw new UnsupportedOperationException(
					getClass()+" is singleton but constructor called more than once");
			instance = this;
		}
	}

	/**
	 * @return le singleton de Launcher
	 */
	public final static Launcher getInstance()
	{
		if(Launcher.instance == null)
		{
			synchronized(Launcher.class)
			{ 
				if(Launcher.instance == null)
				{
					Launcher.instance = new Launcher();
				}
			}
		}
		return Launcher.instance;
	}
	
	/**
	 * Lance l'application
	 */
	@Override
	public void start(Stage primaryStage)  
	{
		this.initMap();
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("LeGrosCarnet");

		initRootLayout();
	}

	/**
	 * Initialize le root layout
	 */
	public void initRootLayout() 
	{
		try {
			//Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Launcher.class.getClassLoader().getResource("vue\\HomeView.fxml"));
			rootLayout = (AnchorPane) loader.load();

			//Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();


		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}
	
	/**
	 * Main du jeu 
	 * @param args = obligatoire ;
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * On va remplir les ObservableList afin de pouvoir voir l'affichage
	 */
	public void initMap() {
		ObservableList<Contact> myVectorContactAll = FXCollections.observableArrayList();
		ObservableList<Contact> myVectorContactStudents = FXCollections.observableArrayList();
		ObservableList<Contact> myVectorContactPrivate = FXCollections.observableArrayList();
		ObservableList<Contact> myVectorContactHome = FXCollections.observableArrayList();
		
		myVectorContactAll.add(new Contact("Mathieu", "Thomas", 25, true, new Mail("test@hotmail.fr"), 
				       new Address("Impasse des chevriers", "Cavaillon", 84300), new Telephone("33", "0490761555", "Home"))) ;
		myVectorContactPrivate.add(new Contact("Mathieu", "Thomas", 25, true, new Mail("legrosGarcia@hotmail.fr"), 
					   new Address("Rue des martyrs", "Cavaillon", 84300), new Telephone("33", "0490761520", "Fax"))) ;
		this.mapContact.put("Private", myVectorContactPrivate) ;
		
		
		myVectorContactHome.add(new Contact("Mathieu", "Thomas", 25, true, new Mail("legarcia@hotmail.fr"), 
					new Address("Impasse des test", "Cavaillon", 84300), new Telephone("33", "0490761520", "Fax"))) ;
		myVectorContactAll.add(new Contact("Rezaigui", "Nizar", 25, true, new Mail("jesaispasquoiEcrire@hotmail.fr"), 
				       new Address("Quartier des fous", "Cavaillon", 84300), new Telephone("33", "0490761520", "Fax"))) ;
		myVectorContactHome.add(new Contact("Rezaigui", "Nizar", 25, true, new Mail("Lucien@hotmail.fr"),
					new Address("Chez charly la famille", "Cavaillon", 84300), new Telephone("33", "0490761520", "Fax"))) ;
		this.mapContact.put("Home", myVectorContactHome) ;
		this.mapContact.put("All", myVectorContactAll) ;
		this.mapContact.put("Student", myVectorContactStudents) ;
		
	}
	
	/**
	 * @return l'ObservableList des contact private
	 */
	public ObservableList<Contact> getContactPrivate() {
		return this.mapContact.get("Private") ;
	}
	
	/**
	 * @return l'ObservableList des contact home
	 */
	public ObservableList<Contact> getContactHome() {
		return this.mapContact.get("Home") ;
	}
	
	/**
	 * @return l'ObservableList des contact students
	 */
	public ObservableList<Contact> getContactStudent() {
		return this.mapContact.get("Student") ;
	}
	
	/**
	 * @return l'ObservableList de tous les contact
	 */
	public ObservableList<Contact> getContactAll() {
		return this.mapContact.get("All") ;
	}
	
	/**
	 * @param rootLayout the rootLayout to set
	 */
	public void setRootLayout(AnchorPane rootLayout) 
	{
		this.rootLayout = rootLayout;
	}
	
	/**
	 * @param instance the instance to set
	 */
	public static void setInstance(Launcher instance) 
	{
		Launcher.instance = instance;
	}

	/**
	 * @return return le stage principal
	 */
	public Stage getPrimaryStage() 
	{
		return primaryStage;
	}
	
	/**
	 * @return the rootLayout
	 */
	public AnchorPane getRootLayout() 
	{
		return rootLayout;
	}
}

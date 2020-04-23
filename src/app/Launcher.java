package app;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import carnet.Contact;
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
	 * Fonction pour tester l'affichage
	 */
	public void initMap() {
		ObservableList<Contact> myVectorContactStudents = FXCollections.observableArrayList();
		ObservableList<Contact> myVectorContactPrivate = FXCollections.observableArrayList();
		ObservableList<Contact> myVectorContactHome = FXCollections.observableArrayList();
		myVectorContactPrivate.add(new Contact("Mathieu", "Thomas", 25, true)) ;
		this.mapContact.put("Private", myVectorContactPrivate) ;
		
		myVectorContactHome.add(new Contact("Mathieu", "Thomas", 25, true)) ;
		myVectorContactHome.add(new Contact("Rezaigui", "Nizar", 25, true)) ;
		this.mapContact.put("Home", myVectorContactHome) ;
		
	}
	
	public ObservableList<Contact> getContactPrivate() {
		return this.mapContact.get("Private") ;
	}
	
	public ObservableList<Contact> getContactHome() {
		return this.mapContact.get("Home") ;
	}
	
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
	public static void main(String[] args) 
	{
		System.out.println("coucou");
		launch(args);
	}
}

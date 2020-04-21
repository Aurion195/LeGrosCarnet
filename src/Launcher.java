import java.io.IOException;

import javafx.application.Application;
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
			loader.setLocation(Launcher.class.getClassLoader().getResource("vue\\AjouterContactView.fxml"));
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

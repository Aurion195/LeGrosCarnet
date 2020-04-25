package vue;

import java.awt.Image;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import app.Launcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class NewContactViewController  implements Initializable {
	
	@FXML
	/**
	 * Button pour revenir en arrière
	 */
	private Button buttonCancel ;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Fonction qui va permettre de changer de vue en fonction d'ou on veut aller
	 * Avancer ou revenir en arrières
	 * @param vueFxml = nom de la vue a charger ;
	 */
	private void changeStage(String vueFxml) {
		Launcher main = Launcher.getInstance();
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(getClass().getResource(vueFxml));
			main.setRootLayout(loader.load());

			Scene scene = new Scene(main.getRootLayout());
			main.getPrimaryStage().setScene(scene);
			main.getPrimaryStage().show();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
	@FXML
	/**
	 * Quand on va cliquer dessus on va changer de vue pour ajouter un téléphone
	 * On fait appel à la fonction private changeStage(String nom) ;
	 */
	public void onClickImageButtonPhone() {
		this.changeStage("AjouterPhoneContactView.fxml");
		
	}
	
	@FXML
	/**
	 * Quand on va cliquer dessus on va changer de vue pour revenir en arrière
	 * On fait appel à la fonction private changeStage(String nom) ;
	 */
	public void onClickButtonCancel() {
		this.changeStage("HomeView.fxml");
	}
}

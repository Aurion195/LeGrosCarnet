package vue;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import app.Launcher;
import enumeration.EnumTelephone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class AjouterPhoneViewController implements Initializable {
	
	@FXML
	/**
	 * Saisie du préfixe
	 */
	private JFXTextField textPrefixe ;
	
	@FXML
	/**
	 * Saisie du numéro
	 */
	private JFXTextField textNumero ;
	
	@FXML
	/**
	 * Permet de revenir en arrière
	 */
	private JFXButton buttonCancel ;
	
	@FXML
	/**
	 * Permet d'enregistrer le nouveau numéro
	 */
	private JFXButton buttonOk ;
	
	@FXML
	/**
	 * Permet de choisir les différents type
	 */
	private MenuButton buttonMenu ;
	
	@FXML 
	/**
	 * Type de numero
	 */
	private MenuItem menuItemOffice ;
	
	@FXML
	/**
	 * Type de numero
	 */
	private MenuItem menuItemHome ;
	
	@FXML
	/**
	 * Type de numero
	 */
	private MenuItem menuItemFax ;
	
	@FXML
	/**
	 * Type de numero
	 */
	private MenuItem menuItemPager ;
	
	@FXML
	/**
	 * Type de numero
	 */
	private MenuItem menuItemMobile ;
	
	
	/**
	 * Quand on arrive sur la vue, ou alors dés qu'on clique sur la vue
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	/**
	 * Permet de notifier l'utilisateur d'une alerte
	 * @param type = type d'alerte ;
	 * @param message = message de l'alerte ;
	 */
	private void showAlert(String type, String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle(type);
	 
	        alert.setHeaderText(null);
	        alert.setContentText(message);
	 
	        alert.showAndWait();
	}
	
	/**
	 * Permet de vérifier la saisie du prefixe afin qu'elle corresponde au 
	 * caractéristiques attendu
	 * @return true s'il est OK / false sinon ;
	 */
	private boolean verifSaisiePrefixe() {
		String verifPrefixe = this.textPrefixe.getText() ;
		
		if(verifPrefixe.length() == 2) {
			try {
				int test = Integer.parseInt(verifPrefixe) ;
				return true ;
			}
			catch(NumberFormatException n) {
				this.showAlert("Erreur", "Rentrer uniquement des chiffres dans le prefixe");
				return false ;
			}
		}
		
		this.showAlert("Erreur", "Le prefixe est uniquement composé de deux chiffres");
		return false ;
	}
	
	/**
	 * Permet de vérifier la saisie du numéro afin qu'elle corresponde au 
	 * caractéristiques attendu
	 * @return true s'il est OK / false sinon ;
	 */
	private boolean verifSaisieNumero() {
		String verifNumero = this.textNumero.getText() ;
		
		if(verifNumero.length() == 10) {
			try {
				int test = Integer.parseInt(verifNumero) ;
				return true ;
			}
			catch(NumberFormatException n) {
				this.showAlert("Erreur", "Rentrer uniquement des chiffres dans le numéro");
				return false ;
			}
		}
		
		this.showAlert("Erreur", "Le numéro est uniquement composé de 6 chiffres");
		return false ;
	}
	
	/**
	 * Permet de vérifier que l'utilisateur à bien choisit un type de numéro
	 * @return true s'il a choisit / false sinon ;
	 */
	private boolean verifChoixType() {
		String verifType = this.buttonMenu.getText() ;
		
		if(verifType.equals("Selection type")) {
			this.showAlert("Alert", "Veuillez selectionner un type de numéro");
			return false ;
		}
		
		return true ;
	}
	
	@FXML
	/**
	 * Quand l'utilisateur va cliquer sur le button OK afin de créer le nouveau téléphone
	 * @param event = action de l'utilisateur ;
	 */
	public void onClickButtonOk(ActionEvent event) {
		if(this.verifSaisiePrefixe() && this.verifSaisieNumero() && this.verifChoixType()) {
			this.showAlert("Information", "Vous avez rentrer un nouveau numéro de téléphone, il va être pris en compte");
		}
	}
	
	@FXML
	/**
	 * Quand on va choisir le type de téléphone pour OFFICE
	 * @param event = action de l'utilisateur
	 */
	public void onClickMenuItemOffice(ActionEvent event) {
		this.buttonMenu.setText(EnumTelephone.OFFICE.getType());
	}
	
	@FXML
	/**
	 * Quand on va choisir le type de téléphone pour HOME
	 * @param event = action de l'utilisateur
	 */
	public void onClickMenuitemHome(ActionEvent event) {
		this.buttonMenu.setText(EnumTelephone.HOME.getType());
	}
	
	@FXML
	/**
	 * Quand on va choisir le type de téléphone pour FAX
	 * @param event = action de l'utilisateur
	 */
	public void onClickMenuItemFax(ActionEvent event) {
		this.buttonMenu.setText(EnumTelephone.FAX.getType());
	}
	
	@FXML
	/**
	 * Quand on va choisir le type de téléphone pour PAGER
	 * @param event = action de l'utilisateur
	 */
	public void onClickMenuItemPager(ActionEvent event) {
		this.buttonMenu.setText(EnumTelephone.PAGER.getType());
	}
	
	@FXML
	/**
	 * Quand on va choisir le type de téléphone pour MOBILE
	 * @param event = action de l'utilisateur
	 */
	public void onClickMenuItemMobile(ActionEvent event) {
		this.buttonMenu.setText(EnumTelephone.MOBILE.getType());
	}
	
	@FXML
	public void onClickButtonCancel() {
		Launcher main = Launcher.getInstance();
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(getClass().getResource("TelephoneView.fxml"));
			main.setRootLayout(loader.load());

			Scene scene = new Scene(main.getRootLayout());
			main.getPrimaryStage().setScene(scene);
			main.getPrimaryStage().show();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

package vue;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Vector;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import app.Launcher;
import carnet.Contact;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class HomeViewController  implements Initializable {
	
	@FXML
	/**
	 * Ajouter un contact
	 */
	private Button buttonNewContact ;
	
	@FXML
	/**
	 * Editer un contact
	 */
	private Button buttonEditContact ;
	
	@FXML
	/**
	 * Remove un contact
	 */
	private Button buttonRemoveContact ;
	
	@FXML 
	/**
	 * Voir l'adresse du contact
	 */
	private Button buttonSeeOnMap ;
	
	@FXML
	/**
	 * Permet de choisir les contacts à afficher
	 */
	private MenuButton menuButton ;
	
	@FXML
	/**
	 * Permet de choisir les contact Home
	 */
	private MenuItem menuItemHome ;
	
	@FXML
	/**
	 * Permet de choisir les contact Private
	 */
	private MenuItem menuItemPrivate ;
	
	@FXML
	/**
	 * Permet de choisir les contact Student
	 */
	private MenuItem menuItemStudent ;
	
	@FXML
	private JFXTextField textContact ;
	
	@FXML
	private JFXTextArea textName ;
	
	@FXML
	private JFXTextArea textAge ;
	
	@FXML
	private JFXTextArea textmail ;
	
	@FXML
	private JFXTextField textAdresseHaut ;
	
	@FXML
	private JFXTextField textAdresseBas ;
	
	@FXML
	private TableView<Contact> tableContact ;
	
	@FXML
	private TableColumn<Contact, String> columnFirstName ;
	
	@FXML
	private TableColumn<Contact, String> columnLastName ;
	
	@FXML
	private TableColumn<Contact, String> columnMail ;
	
	
	/**
	 * Permet de montrer le détail du profil sélectionner
	 * @param selectedProfil = profil selectionner ;
	 */
	public void showProfilDetail(Contact selectedContact) {
	
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Launcher launcher = Launcher.getInstance() ;
		this.columnFirstName.setCellValueFactory(cellData -> cellData.getValue().getFirstNameProperty());
		this.columnLastName.setCellValueFactory(cellData -> cellData.getValue().getLastNameProperty());
		
		if(this.menuButton.getText().equals("Private")) {
			System.out.println(launcher.getContactHome().size());
			this.tableContact.setItems(launcher.getContactPrivate());
		}
		else if(this.menuButton.getText().equals("Home")) {
			System.out.println(launcher.getContactHome().size());
			this.tableContact.setItems(launcher.getContactHome());
		}

		showProfilDetail(null);

		this.tableContact.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showProfilDetail(newValue));
	}
	
	@FXML
	public void onClickMenuItemPrivate() {
		this.menuButton.setText(this.menuItemPrivate.getText());
		initialize(null, null);
	}
	
	@FXML
	public void onClickMenuItemHome() {
		this.menuButton.setText(this.menuItemHome.getText());
		initialize(null, null);
	}
	
	@FXML
	public void onClickMenuItemStudent() {
		this.menuButton.setText(this.menuItemStudent.getText());
		initialize(null, null);
	}
}

package vue;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Vector;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.sun.corba.se.impl.ior.GenericTaggedComponent;

import app.Launcher;
import carnet.Contact;
import carnet.Telephone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.Label;
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
	 * Permet de choisir tous les contacts
	 */
	private MenuItem menuItemAll ;
	
	@FXML
	/**
	 * Permet de choisir les contact Student
	 */
	private MenuItem menuItemStudent ;
	
	@FXML
	/**
	 * Permet d'afficher le nom du contact
	 */
	private Label textContact ;
	
	@FXML
	/**
	 * Permet d'afficher le prénom du contact
	 */
	private Label textName ;
	
	@FXML
	/**
	 * Permet d'afficher l'age
	 */
	private Label textAge ;
	
	@FXML
	/**
	 * Permet d'afficher le mail
	 */
	private Label textmail ;
	
	@FXML
	/**
	 * Permet d'afficher l'adresse
	 */
	private Label textAdresseHaut ;
	
	@FXML
	/**
	 * Permet d'afficher le code postale est la ville
	 */
	private Label textAdresseBas ;
	
	@FXML
	/**
	 * TableView contact
	 */
	private TableView<Contact> tableContact ;
	
	@FXML
	/**
	 * Column du nom de famille
	 */
	private TableColumn<Contact, String> columnFirstName ;
	
	@FXML
	/**
	 * Colum du prénom
	 */
	private TableColumn<Contact, String> columnLastName ;
	
	@FXML
	/**
	 * Colum du mail
	 */
	private TableColumn<Contact, String> columnMail ;
	
	@FXML
	/**
	 * TableView téléphone
	 */
	private TableView<Telephone> tableTelephone ;
	
	@FXML
	/**
	 * Column du type de téléphone 
	 */
	private TableColumn<Telephone, String> columnType ;
	
	@FXML
	/**
	 * Colum du numéro de téléphone
	 */
	private TableColumn<Telephone, String> columnMobile ;
	
	/**
	 * Permet de montrer le détail du profil sélectionner
	 * @param selectedProfil = profil selectionner ;
	 */
	public void showProfilDetail(Contact selectedContact) {
		if(selectedContact != null) {
			this.textContact.setText(selectedContact.getFirstName() + " " + selectedContact.getLastName());
			this.textName.setText(selectedContact.getLastName()) ;
			this.textAge.setText(String.valueOf(selectedContact.getAge())) ;
			this.textmail.setText(selectedContact.getMail().getMail()) ;
			this.textAdresseHaut.setText(selectedContact.getAddress().getRue());
			this.textAdresseBas.setText(selectedContact.getAddress().getCodePostale() + " " + selectedContact.getAddress().getVille());
			
			this.tableTelephone.setItems(selectedContact.getTelephone());
			this.columnType.setCellValueFactory(cellData -> cellData.getValue().getType());
			this.columnMobile.setCellValueFactory(cellData -> cellData.getValue().getNumero());
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Launcher launcher = Launcher.getInstance() ;
		this.columnFirstName.setCellValueFactory(cellData -> cellData.getValue().getFirstNameProperty());
		this.columnLastName.setCellValueFactory(cellData -> cellData.getValue().getLastNameProperty());
		this.columnMail.setCellValueFactory(cellData -> cellData.getValue().getMail().getMailProperty());
		
		if(this.menuButton.getText().equals("All contacts")) {
			this.tableContact.setItems(launcher.getContactAll());
		}
		else if(this.menuButton.getText().equals("Private")) {
			this.tableContact.setItems(launcher.getContactPrivate());
		}
		else if(this.menuButton.getText().equals("Home")) {
			this.tableContact.setItems(launcher.getContactHome());
		}
		else if(this.menuButton.getText().equals("Students")) {
			this.tableContact.setItems(launcher.getContactStudent());
		}

		showProfilDetail(null);

		this.tableContact.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showProfilDetail(newValue));
	}
	
	@FXML
	/**
	 * Quand on va choisir dans le menu déroulant, ça va placer le terme "Private"
	 * dans la bare de menu déroulant
	 */
	public void onClickMenuItemPrivate() {
		this.menuButton.setText(this.menuItemPrivate.getText());
		initialize(null, null);
	}
	
	@FXML
	/**
	 * Quand on va choisir dans le menu déroulant, ça va placer le terme "Home"
	 * dans la bare de menu déroulant
	 */
	public void onClickMenuItemHome() {
		this.menuButton.setText(this.menuItemHome.getText());
		initialize(null, null);
	}
	
	@FXML
	/**
	 * Quand on va choisir dans le menu déroulant, ça va placer le terme "Student"
	 * dans la bare de menu déroulant
	 */
	public void onClickMenuItemStudent() {
		this.menuButton.setText(this.menuItemStudent.getText());
		initialize(null, null);
	}
	
	@FXML
	/**
	 * Quand on va choisir dans le menu déroulant, ça va placer le terme "All"
	 * dans la bare de menu déroulant
	 */
	public void onClickMenuItemAll() {
		this.menuButton.setText(this.menuItemAll.getText());
		initialize(null, null);
	}
	
	@FXML
	/**
	 * Permet de changer de vue pour aller créer un nouveau contact
	 * @param event = action de l'utilisateur ;
	 */
	public void onClickButtonNewContact(ActionEvent event) {
		Launcher main = Launcher.getInstance();
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(getClass().getResource("NewContactView.fxml"));
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
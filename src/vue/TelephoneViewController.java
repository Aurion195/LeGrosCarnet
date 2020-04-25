package vue;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

import com.jfoenix.controls.JFXButton;

import app.Launcher;
import carnet.Telephone;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TelephoneViewController implements Initializable {

	@FXML
	private JFXButton buttonAdd ;
	
	@FXML
	private JFXButton buttonEdit ;
	
	@FXML
	private JFXButton buttonRemove ;
	
	@FXML
	private JFXButton buttonOk ;
	
	@FXML 
	private JFXButton buttonCancel ;
	
	@FXML
	private TableView<Telephone> tableTelephone ;
	
	@FXML
	private TableColumn<Telephone, String> columnPrefix ;
	
	@FXML
	private TableColumn<Telephone, String> columnNumero ; 
	
	@FXML
	private TableColumn<Telephone, String> columnType ;
	
	private Vector<Telephone> vectorTelephone = new Vector<>() ;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
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
	public void onClickButtonOk() {
		this.changeStage("NewContactView.fxml") ;
	}
	
	@FXML
	public void onClickButtonAdd() {
		this.changeStage("AjouterPhoneContactView.fxml");
	}
	@FXML
	public void onClickButtonCancel() {
		this.changeStage("NewContactView.fxml") ;
	}
}

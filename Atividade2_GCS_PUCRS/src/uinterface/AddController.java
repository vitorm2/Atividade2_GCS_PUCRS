package uinterface;

import app.MainApp;
import business.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


public class AddController {

	@FXML
	private TextField nomeAddCliente;
	@FXML
	private TextField cpfAddCliente;
    @FXML
    private RadioButton radioMasculino;
    @FXML
    private RadioButton radioFeminino;
	@FXML
	private TextField idadeAddCliente;
	@FXML
	private Button adicionarClienteFinal;
	@FXML
	private ToggleGroup group;

	private char sexo;



    private Stage dialogStage;
	private MainApp mainApp;

	public AddController(){

	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	public void buttonAdicionarClienteFinal(){
		if(group.selectedToggleProperty().equals(radioMasculino)){
    		sexo = "m".charAt(0);
    	}else{
    		sexo = "f".charAt(0);
    	}

		Cliente cliente =  new Cliente(nomeAddCliente.getText(),
										cpfAddCliente.getText(),
										sexo,
										Integer.valueOf(idadeAddCliente.getText()));
		cliente.setStatus(true);

		mainApp.adicionarCliente(cliente);
		dialogStage.close();
	}

}

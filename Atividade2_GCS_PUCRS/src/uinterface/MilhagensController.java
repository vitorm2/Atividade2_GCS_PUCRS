package uinterface;

import app.MainApp;
import business.ClienteSocio;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MilhagensController {

	@FXML
	private TextField qtdMilhagens;
	@FXML
	private Button adicionarButton;

    private Stage dialogStage;
	private MainApp mainApp;

	private ClienteSocio cliente;

	public MilhagensController() {
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void setCliente(ClienteSocio cliente){
		this.cliente = cliente;
	}

	@FXML
	private void buttonAdicionarFinal(){
		cliente.adicionarMilhagens(Double.valueOf(qtdMilhagens.getText()));
		dialogStage.close();
	}

}

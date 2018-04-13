package uinterface;

import app.MainApp;
import business.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ResgitroSaidaController {

	@FXML
	private TextField cpfSaida;
	@FXML
	private Button confirmaSaida;

    private Stage dialogStage;
	private MainApp mainApp;


	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	@FXML
	public void buttonConfirmaSaida(){
		Cliente c = mainApp.procurarPorCpf(cpfSaida.getText());
		c.setStatus(false);
		mainApp.removerCliente(c);
		dialogStage.close();
	}
}

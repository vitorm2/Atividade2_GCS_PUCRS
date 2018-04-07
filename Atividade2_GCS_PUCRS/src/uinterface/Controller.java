package uinterface;

import business.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import app.MainApp;



public class Controller {


	@FXML
	private TableView<Cliente> clienteTable;
	@FXML
	private TableColumn<Cliente, String> nomeCliente;


	private MainApp mainApp;

	public Controller() {
	}


	@FXML
	private void initialize() {
		// Inicializa a tabela de camas com duas colunas.
		nomeCliente.setCellValueFactory(cellData -> cellData.getValue().identificadorProperty());
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		// Adiciona os dados da observable list na tabela
		clienteTable.setItems(mainApp.getClienteData());
	}

}

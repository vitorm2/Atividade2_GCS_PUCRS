package uinterface;

import java.util.ArrayList;

import app.MainApp;
import business.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class dadosClientesController {

	@FXML
	private TableView<Cliente> historicoTable;
	@FXML
	private TableColumn<Cliente, String> nomeClienteColumn;
	@FXML
	private TableColumn<Cliente, String> cpfClienteColumn;
	@FXML
	private Button botaoPesquisar;

	@FXML
	private TextField searchText;

	private ObservableList<Cliente> l1 = null;

    private Stage dialogStage;
	private MainApp mainApp;

	public dadosClientesController(){
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		ObservableList<Cliente> l1 = mainApp.getHistoricoData();
		historicoTable.setItems(l1);
	}

	@FXML
	private void initialize() {
		nomeClienteColumn.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		cpfClienteColumn.setCellValueFactory(cellData -> cellData.getValue().cpfProperty());

	}

	@FXML
	public void pesquisa(){
		if(searchText.getText() != null){
			ArrayList<Cliente>al = new ArrayList<>();
			ObservableList<Cliente>l2 = FXCollections.observableArrayList(al);
			ObservableList<Cliente>l1 = mainApp.getHistoricoData();
			for (Cliente c: l1){
				if(c.getNome().contains(searchText.getText().toString().toLowerCase()) ||
						c.getNome().contains(searchText.getText().toString().toUpperCase()) ||
						c.getNome().toLowerCase().contains(searchText.getText().toString()) ||
						c.getCpf().contains(searchText.getText().toString())){
					l2.add(c);
				}
			}
			historicoTable.setItems(l2);
		}else{historicoTable.setItems(l1);}
		historicoTable.refresh();
	}


}

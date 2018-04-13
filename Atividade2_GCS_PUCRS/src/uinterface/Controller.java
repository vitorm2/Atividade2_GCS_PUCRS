package uinterface;

import business.Cliente;
import business.ClienteSocio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.util.ArrayList;

import app.MainApp;



public class Controller {


	@FXML
	private TableView<Cliente> clienteTable;
	@FXML
	private TableColumn<Cliente, String> nomeCliente;
	@FXML
	private TableColumn<Cliente, String> cpfCliente;
	@FXML
	private Label numPessoasLabel;
	@FXML
	private Label porcMLabel;
	@FXML
	private Label porcFLabel;
	@FXML
	private Label qtdSociosLabel;
	@FXML
	private Label qtdNaoSociosLabel;
	@FXML
	private Label nomeClienteLabel;
	@FXML
	private Label cpfClienteLabel;
	@FXML
	private Label generoClienteLabel;
	@FXML
	private Label idadeClienteLabel;
	@FXML
	private Label infoSocioLabel;
	@FXML
	private Label campoNumSocioLabel;
	@FXML
	private Label numSocioLabel;
	@FXML
	private Label campoMilhagensLabel;
	@FXML
	private Label milhagensLabel;

	@FXML
	private Button adicionarClienteButton;
	@FXML
	private Button registrarSaidaClienteButton;
	@FXML
	private Button pesquisarButton;
	@FXML
	private Button promoverSocioButton;
	@FXML
	private Button adicionarMilhagensButton;
	@FXML
	private Button mostrarDadosClienteButton;

	@FXML
	private TextField searchTexto;

	private ObservableList<Cliente> l1 = null;

	private MainApp mainApp;

	public Controller() {
	}


	@FXML
	private void initialize() {
		// Inicializa a tabela de camas com duas colunas.
		nomeCliente.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		cpfCliente.setCellValueFactory(cellData -> cellData.getValue().cpfProperty());



		clienteTable.getSelectionModel().selectedItemProperty().addListener(
		          (observable, oldValue, newValue) -> showClienteDetalhes(newValue));
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		ObservableList<Cliente>l1 = mainApp.getClienteData();

		// Adiciona os dados da observable list na tabela
		clienteTable.setItems(mainApp.getClienteData());
		atualizaNumeros();
	}

	public void atualizaNumeros(){
		numPessoasLabel.setText(String.valueOf(mainApp.quantasPessoasAtivas()));
		mainApp.porcentagemGenero();
		porcMLabel.setText(String.valueOf(mainApp.getPorcentagemM()).substring(0, 4)+"%");
		porcFLabel.setText(String.valueOf(mainApp.getPorcentagemF()).substring(0, 4)+"%");
		qtdNaoSociosLabel.setText(String.valueOf(mainApp.quantidadeNaoSocios()));
		qtdSociosLabel.setText(String.valueOf(mainApp.quantidadeSocios()));
	}

	public void showClienteDetalhes(Cliente c1){

		nomeCliente.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		cpfCliente.setCellValueFactory(cellData -> cellData.getValue().cpfProperty());

		if(c1 != null){
			nomeClienteLabel.setText(c1.getNome());
			cpfClienteLabel.setText(c1.getCpf());
			generoClienteLabel.setText(String.valueOf(c1.getGenero()));
			idadeClienteLabel.setText(String.valueOf(c1.getIdade()));
			infoSocioLabel.setVisible(true);
			numSocioLabel.setVisible(true);
			campoNumSocioLabel.setVisible(true);
			milhagensLabel.setVisible(true);
			campoMilhagensLabel.setVisible(true);
			adicionarMilhagensButton.setVisible(true);
		}else{
			nomeClienteLabel.setText("");
			cpfClienteLabel.setText("");
			generoClienteLabel.setText("");
			idadeClienteLabel.setText("");
		}

		if(c1 instanceof  ClienteSocio){
			numSocioLabel.setText(String.valueOf(((ClienteSocio) c1).getNumero()));
			milhagensLabel.setText(String.valueOf(((ClienteSocio) c1).getMilhagens()));
		}else{
			infoSocioLabel.setVisible(false);
			numSocioLabel.setVisible(false);
			campoNumSocioLabel.setVisible(false);
			milhagensLabel.setVisible(false);
			campoMilhagensLabel.setVisible(false);
			adicionarMilhagensButton.setVisible(false);
		}

	}


	// USAR A VIEW
	@FXML
	private void buttonAdicionarCliente(){
		mainApp.showAddCliente();
		clienteTable.setItems(mainApp.getClienteData());

		nomeCliente.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		cpfCliente.setCellValueFactory(cellData -> cellData.getValue().cpfProperty());
		clienteTable.refresh();
		atualizaNumeros();
	}

	// USAR A VIEW
	@FXML
	private void buttonRegistrarSaida(){
		mainApp.showRegistrarSaida();
		clienteTable.setItems(mainApp.getClienteData());

		nomeCliente.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		cpfCliente.setCellValueFactory(cellData -> cellData.getValue().cpfProperty());
		clienteTable.refresh();
		atualizaNumeros();

	}

	//FILTRAR POR NOME, CPF, IDADE, GENERO (OLHAR HIST�RICO PROJETO SUMMERHOSTEL)
	@FXML
	private void buttonPesquisar(){
		if(searchTexto.getText() != null){
			ArrayList<Cliente>al = new ArrayList<>();
			ObservableList<Cliente>l2 = FXCollections.observableArrayList(al);
			ObservableList<Cliente>l1 = mainApp.getClienteData();

				for(Cliente c1: l1){
					if(c1.getNome().contains(searchTexto.getText().toString().toLowerCase()) ||
							c1.getNome().contains(searchTexto.getText().toString().toUpperCase()) ||
							c1.getNome().toLowerCase().contains(searchTexto.getText().toString()) ||
							c1.getCpf().contains(searchTexto.getText().toString())){
						l2.add(c1);
					}
				}
			clienteTable.setItems(l2);
		}else{
			clienteTable.setItems(l1);
			}

	clienteTable.refresh();
}

	@FXML
	private void buttonDadosClientes(){
		mainApp.showDadosClientes();
	}

	//Funciona mais tem um bugzinho
	@FXML
	private void buttonPromoverSocio(){

		Cliente clienteSelecionado = clienteTable.getSelectionModel().getSelectedItem();

		if (clienteSelecionado != null) {
			mainApp.removerCliente(clienteSelecionado);
			clienteSelecionado = new ClienteSocio(clienteSelecionado.getNome(), clienteSelecionado.getCpf(), clienteSelecionado.getGenero(),
					clienteSelecionado.getIdade(), mainApp.getContadorSocios()+1, 0);
			clienteSelecionado.setStatus(true);
			mainApp.adicionarCliente(clienteSelecionado);
			showClienteDetalhes(clienteSelecionado);
			clienteTable.setItems(mainApp.getClienteData());
			clienteTable.refresh();
			atualizaNumeros();
	    } else {
	        // Nada seleciondo.
	        Alert alert = new Alert(AlertType.WARNING);
	            alert.setTitle("Nenhuma sele��o");
	            alert.setHeaderText("Nenhuma Pessoa Selecionada");
	            alert.setContentText("Por favor, selecione uma pessoa na tabela.");
	            alert.showAndWait();
	    }



	}

	//UTILIZAR O CLIENTE SELECIONADO
	@FXML
	private void buttonAdicionarMilhagens(){
		ClienteSocio clienteSelecionado = (ClienteSocio) clienteTable.getSelectionModel().getSelectedItem();
		mainApp.showAdicionarMilhagens(clienteSelecionado);
		showClienteDetalhes(clienteSelecionado);
		clienteTable.setItems(mainApp.getClienteData());
		clienteTable.refresh();
	}


}

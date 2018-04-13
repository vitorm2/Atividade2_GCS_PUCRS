package app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import business.Cliente;
import business.ClienteSocio;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import uinterface.AddController;
import uinterface.Controller;
import uinterface.MilhagensController;
import uinterface.ResgitroSaidaController;
import uinterface.dadosClientesController;


public class MainApp extends Application {

    private Stage primaryStage;
	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	private ObservableList<Cliente> lista2 = FXCollections.observableArrayList(listaClientes);
	private ArrayList<Cliente> historicoClientes = new ArrayList<Cliente>();
	private ObservableList<Cliente> listaOBhistorico = FXCollections.observableArrayList(historicoClientes);
	private double porcentoM;
	private double porcentoF;
	private int qtd_sociosAtivos;
	private int qtd_naoSocios;

	private int contadorSocios;

	public MainApp() {
		ClienteSocio c1 = new ClienteSocio("Joao", "11", "m".charAt(0), 15, 1, 2000);
		Cliente c2 =  new Cliente("Pedro", "22", "m".charAt(0), 67);
		ClienteSocio c3 = new ClienteSocio("Fabio", "33", "m".charAt(0), 15, 1, 2000);
		Cliente c4 =  new Cliente("Mauro", "44", "m".charAt(0), 67);
		ClienteSocio c5 = new ClienteSocio("Mariana", "55", "f".charAt(0), 15, 1, 2000);
		Cliente c6 =  new Cliente("Tiago", "66", "m".charAt(0), 67);
		ClienteSocio c7 = new ClienteSocio("Ana", "77", "f".charAt(0), 15, 1, 2000);
		Cliente c8 =  new Cliente("Bianca", "88", "f".charAt(0), 67);
		ClienteSocio c9 = new ClienteSocio("Leandro", "99", "m".charAt(0), 15, 1, 2000);
		Cliente c10 =  new Cliente("Gustavo", "12", "m".charAt(0), 67);
		ClienteSocio c11 = new ClienteSocio("Lucas", "24", "m".charAt(0), 15, 1, 2000);
		Cliente c12 =  new Cliente("Guilherme", "35", "m".charAt(0), 67);

		listaClientes.add(c1);
		listaClientes.add(c2);
		listaClientes.add(c3);
		listaClientes.add(c4);
		listaClientes.add(c5);
		listaClientes.add(c6);
		listaClientes.add(c7);
		listaClientes.add(c8);
		listaClientes.add(c9);
		listaClientes.add(c10);
		listaClientes.add(c11);
		listaClientes.add(c12);

		lista2 = FXCollections.observableArrayList(listaClientes);

//		historicoClientes.add(c12);
//		saveData();

	}


	 @Override
	 public void start(Stage primaryStage) {
		 this.primaryStage = primaryStage;

		 this.primaryStage.setTitle("Atividade- Bar");


		 loadData();
		 showTable();

		 primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	            @Override
	            public void handle(WindowEvent t) {
	                t.consume();

	               saveData();

	                primaryStage.close();
	                Platform.exit();
	                System.exit(0);
	            }
	        });

	 }

	 public Stage getPrimaryStage() {
		 return primaryStage;
	 }

	 public static void main(String[] args) {
		 launch(args);
	 }

    public void showTable() {
        try {
            // Carrega a person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/uinterface/MainScreen.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
//            // Define a person overview no centro do root layout.
//            rootLayout.setCenter(personOverview);

            Scene scene = new Scene(personOverview);
            primaryStage.setScene(scene);


            primaryStage.show();


            // D� ao controlador acesso � the main app.
            Controller controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAdicionarMilhagens(ClienteSocio cliente){

    	try {
    	FXMLLoader loader = new FXMLLoader();
         loader.setLocation(MainApp.class.getResource("/uinterface/AdicionarMilhagensScreen.fxml"));
         AnchorPane page = (AnchorPane) loader.load();
         Stage dialogStage = new Stage();
         dialogStage.setTitle("Adicionar Milhagens");
         dialogStage.initModality(Modality.WINDOW_MODAL);
         dialogStage.initOwner(primaryStage);
         Scene scene = new Scene(page);
         dialogStage.setScene(scene);

         // Define a Cama no controller.
         MilhagensController controller = loader.getController();
         controller.setDialogStage(dialogStage);
         controller.setCliente(cliente);
         controller.setMainApp(this);

         dialogStage.showAndWait();

    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void showAddCliente(){
    	try {
        	FXMLLoader loader = new FXMLLoader();
             loader.setLocation(MainApp.class.getResource("/uinterface/AddScreen.fxml"));
             AnchorPane page = (AnchorPane) loader.load();
             Stage dialogStage = new Stage();
             dialogStage.setTitle("Adicionar Cliente");
             dialogStage.initModality(Modality.WINDOW_MODAL);
             dialogStage.initOwner(primaryStage);
             Scene scene = new Scene(page);
             dialogStage.setScene(scene);

             // Define a Cama no controller.
             AddController controller = loader.getController();
             controller.setDialogStage(dialogStage);
             controller.setMainApp(this);

             dialogStage.showAndWait();

        	} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    }

    public void showRegistrarSaida(){
    	try {
        	FXMLLoader loader = new FXMLLoader();
             loader.setLocation(MainApp.class.getResource("/uinterface/RegistroSaidaScreen.fxml"));
             AnchorPane page = (AnchorPane) loader.load();
             Stage dialogStage = new Stage();
             dialogStage.setTitle("Registrar Saida");
             dialogStage.initModality(Modality.WINDOW_MODAL);
             dialogStage.initOwner(primaryStage);
             Scene scene = new Scene(page);
             dialogStage.setScene(scene);

             // Define a Cama no controller.
             ResgitroSaidaController controller = loader.getController();
             controller.setDialogStage(dialogStage);
             controller.setMainApp(this);

             dialogStage.showAndWait();
        	} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    }

    public void showDadosClientes(){
    	try {
        	FXMLLoader loader = new FXMLLoader();
             loader.setLocation(MainApp.class.getResource("/uinterface/dadosClientesScreen.fxml"));
             AnchorPane page = (AnchorPane) loader.load();
             Stage dialogStage = new Stage();
             dialogStage.setTitle("Clientes que estiveram no Bar");
             dialogStage.initModality(Modality.WINDOW_MODAL);
             dialogStage.initOwner(primaryStage);
             Scene scene = new Scene(page);
             dialogStage.setScene(scene);

             // Define a Cama no controller.
             dadosClientesController controller = loader.getController();
             controller.setDialogStage(dialogStage);
             controller.setMainApp(this);

             dialogStage.showAndWait();
        	} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    }


	public void saveData(){

		Path arq1 = Paths.get("src/persistence/dadosClientes.dat");

		try (ObjectOutputStream oarq = new ObjectOutputStream(Files.newOutputStream(arq1))) {
			  oarq.writeObject(historicoClientes);
			}
			catch(IOException e) {
			  System.out.println(e.getMessage());
			  System.exit(1);
			}
	}

	public void loadData(){

		Path arq1 = Paths.get("src/persistence/dadosClientes.dat");

		try (ObjectInputStream iarq = new ObjectInputStream(Files.newInputStream(arq1))) {
		  historicoClientes = (ArrayList<Cliente>) iarq.readObject();
		  listaOBhistorico =  FXCollections.observableArrayList(historicoClientes);

		}
		catch(ClassNotFoundException e) {
		  System.out.println("Classe Cliente n�o encontrada!");
		  System.exit(1);
		}
		catch(IOException e) {
		  System.out.println(e.getMessage());
		  System.out.println("CAIU AQUI");
		  System.exit(1);
		}
	}

	public ObservableList<Cliente> getClienteData(){
		return this.lista2;
	}

	public ObservableList<Cliente> getHistoricoData(){
		return this.listaOBhistorico;
	}

	public  void adicionarCliente(Cliente a) {
		if(a instanceof ClienteSocio){
			listaClientes.add(a);
			lista2 =  FXCollections.observableArrayList(listaClientes);
			contadorSocios++;
		}
		else{
			listaClientes.add(a);
			lista2 =  FXCollections.observableArrayList(listaClientes);
		}
	}

	public void removerCliente(Cliente a){
		historicoClientes.add(a);
		listaOBhistorico =  FXCollections.observableArrayList(historicoClientes);

		listaClientes.remove(a);
		lista2 =  FXCollections.observableArrayList(listaClientes);
	}

	public int getContadorSocios(){
		return contadorSocios;
	}

	public void porcentagemGenero() {
		double m=0;
		double f=0;


		for (int i=0; i<listaClientes.size();i++) {
			if (listaClientes.get(i).getGenero()=='m' && listaClientes.get(i).getStatus()==true){
				m=m+1;
			}

		}
		m=(m/quantasPessoasAtivas());



		for (int i=0; i<listaClientes.size();i++) {
			if (listaClientes.get(i).getGenero()=='f' && listaClientes.get(i).getStatus()==true){
				f=f+1;
			}

		}
		f=(f/quantasPessoasAtivas());

		porcentoM = m*100;
		porcentoF = f*100;
	}

	public Cliente procurarPorCpf(String cpf) {
		for(int i=0;i<listaClientes.size();i++) {
	          if(cpf.equals(listaClientes.get(i).getCpf())) {
	          return listaClientes.get(i);
	          }

	      }
		return null;
	}

	public int quantasPessoasAtivas() {
		int qtd = 0;
		for(Cliente c1: listaClientes){
			if(c1.getStatus()){
				qtd++;
			}
		}

		return qtd;
	}

	public int quantidadeSocios(){
		int qtd = 0;

		for(Cliente c1: listaClientes){
			if(c1 instanceof ClienteSocio && c1.getStatus()==true){
				qtd++;
			}
		}

		return qtd;
	}

	public int quantidadeNaoSocios(){
		int qtdSocios = quantidadeSocios();
		int qtdTotal = quantasPessoasAtivas();
		return qtdTotal - qtdSocios;
	}

	public double getPorcentagemM(){
		return porcentoM;
	}

	public double getPorcentagemF(){
		return porcentoF;
	}

}

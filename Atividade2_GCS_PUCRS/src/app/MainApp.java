package app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import business.Cliente;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import uinterface.Controller;

public class MainApp extends Application {

    private Stage primaryStage;
	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	private ObservableList<Cliente> lista2 = FXCollections.observableArrayList(listaClientes);
	private double porcentoM;
	private double porcentoF;
	private int qtd_sociosAtivos;
	private int qtd_naoSocios;

	public MainApp() {
//		Cliente c1 = new Cliente("Pedro");
//		listaClientes.add(c1);
//		saveData();
	}


	 @Override
	 public void start(Stage primaryStage) {
		 this.primaryStage = primaryStage;

		 this.primaryStage.setTitle("Atividade- Bar");

		 loadData();
		 showTable();
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



	public void saveData(){

		Path arq1 = Paths.get("teste.dat");

		try (ObjectOutputStream oarq = new ObjectOutputStream(Files.newOutputStream(arq1))) {
			  oarq.writeObject(listaClientes);
			}
			catch(IOException e) {
			  System.out.println(e.getMessage());
			  System.exit(1);
			}
	}

	public void loadData(){

		Path arq1 = Paths.get("teste.dat");

		try (ObjectInputStream iarq = new ObjectInputStream(Files.newInputStream(arq1))) {
		  listaClientes = (ArrayList<Cliente>) iarq.readObject();
		  lista2 =  FXCollections.observableArrayList(listaClientes);

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
	
	public  void adicionarCliente(Cliente a) {
		listaClientes.add(a);
	}
	
	public void porcentagemGenero() {
		double m=0;
		double f=0;
		
		
		for (int i=0; i<listaClientes.size();i++) {
			if (listaClientes.get(i).getGenero()=='m'){
				m=m+1;
			}
			
		}
		m=(m/listaClientes.size());

		
		
		for (int i=0; i<listaClientes.size();i++) {
			if (listaClientes.get(i).getGenero()=='f'){
				f=f+1;
			}
			
		}
		f=(f/listaClientes.size());
		System.out.println("Porcentagem de homens: "+(m*100)+"%");
		System.out.println("Porcentagem de mulheres: "+(f*100)+"%");		
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
		int c=0;
		for (int i=0; i<listaClientes.size();i++) {
			if (listaClientes.get(i).getStatus()==true) {
				c=c+1;
			}
		}
		
		return c;
	}
	
}

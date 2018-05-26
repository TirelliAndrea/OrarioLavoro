package application;
	
import it.andrea.orariolavoro.dao.OrarioLavoroDAO;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("OrarioLavoro.fxml")) ;
			//(BorderPane)FXMLLoader.load(getClass().getResource("OrarioLavoro.fxml"));
			
			BorderPane root = (BorderPane)loader.load();
			OrarioLavoroController orarioLavoroController = loader.getController();
			OrarioLavoroDAO orarioDAO = new OrarioLavoroDAO();
			orarioLavoroController.setOrarioLavoroDAO(orarioDAO);
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

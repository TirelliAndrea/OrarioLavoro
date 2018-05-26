package application;

import java.time.LocalDate;
import java.time.LocalTime;


import it.andrea.orariolavoro.dao.OrarioLavoroDAO;
import it.andrea.orariolavoro.model.OrarioLavoro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class OrarioLavoroController {

    @FXML
    private TableView<OrarioLavoro> tblOrario;
    
    @FXML
    private DatePicker txtData;

    @FXML
    private TextField txtOraArrico;

    @FXML
    private Button btnSalva;

    @FXML
    private TextField txtOraUscita;
    
    @FXML
    private TableColumn<OrarioLavoro, LocalDate> colData;
    
    @FXML
    private TableColumn<OrarioLavoro, LocalTime> colOraArrivo;
    
    private OrarioLavoroDAO orarioLavoroDAO;
    
    
    
 
    public void setOrarioLavoroDAO(OrarioLavoroDAO orarioLavoroDAO) {
		this.orarioLavoroDAO = orarioLavoroDAO;
	}


	//METODI PRIVATI
	private void caricaTabella(){
    	
    	
    	
    	ObservableList<OrarioLavoro> lst = FXCollections.observableArrayList(orarioLavoroDAO.getLista());
    	System.out.println(lst.size());
    	tblOrario.getColumns().clear();
    	
    	colData = new TableColumn<>("Data");
    	colOraArrivo = new TableColumn<>("Ora Arrivo");
    	
    	colData.setCellValueFactory(new PropertyValueFactory<>("dataGiorno"));
    	colOraArrivo.setCellValueFactory(new PropertyValueFactory<>("oraArrivo"));
    	
    	tblOrario.getColumns().addAll(colData,colOraArrivo);
    	
    	tblOrario.setItems(lst);
    	
    }

}
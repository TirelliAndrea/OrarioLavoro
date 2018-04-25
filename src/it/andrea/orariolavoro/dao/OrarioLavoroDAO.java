package it.andrea.orariolavoro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import it.andrea.orariolavoro.model.OrarioLavoro;

public class OrarioLavoroDAO {
	
	private Connection connection=null;
	private ResultSet rsListaGiorni = null;
	private Statement stantement = null;
	private String dbURL = "jdbc:ucanaccess://OrarioLavoroDB.accdb";
	private String sqlOrarioLavoro = "SELECT * FROM Orario";
	private String sqlAggiungiOrario = "INSERT INTO Orario (Data,OraArrivo) VALUES (?,?) ";
	private List<OrarioLavoro> lstOrario = null;
	private PreparedStatement pstOrarioLavoro = null;
	private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	
	
	public OrarioLavoroDAO (){
		
		this.creaConnessione();
		
	}
	
	public List<OrarioLavoro> getLista (){
		
		lstOrario = new ArrayList<OrarioLavoro>();
		
		try {
		
			stantement = connection.createStatement();
			rsListaGiorni = stantement.executeQuery(sqlOrarioLavoro);
			while (rsListaGiorni.next()){
				LocalDate date = LocalDate.parse(rsListaGiorni.getString("Data"),dateFormatter);
				LocalTime ora = LocalTime.parse(rsListaGiorni.getString("OraArrivo"),timeFormatter);
				OrarioLavoro orario = new OrarioLavoro(date,ora);
				
				lstOrario.add(orario);
				}
			
			
			return  lstOrario;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public void setOrarioLavoro (OrarioLavoro nuovoOrario){
		
		try {
			pstOrarioLavoro = connection.prepareStatement(sqlAggiungiOrario);
			pstOrarioLavoro.setString(1, dateFormatter.format(nuovoOrario.getDataGiorno()));
			pstOrarioLavoro.setString(2, timeFormatter.format(nuovoOrario.getOraArrivo()));
			pstOrarioLavoro.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* METODI PRIVATI */
	private void creaConnessione() {
		
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			connection = DriverManager.getConnection(dbURL);
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (ClassNotFoundException e){
				e.printStackTrace();
			}
		
	}


	

}

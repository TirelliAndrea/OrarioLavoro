package it.andrea.orariolavoro.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import it.andrea.orariolavoro.model.OrarioLavoro;

public class OrarioLavoroDAO {
	
	private Connection connection=null;
	private ResultSet rsListaGiorni = null;
	private Statement statement = null;
	private String dbURL = "jdbc:ucanaccess://OrarioLavoroDB.accdb";
	private String sqlOrarioLavoro = "SELECT * FROM Orario";
	private String sqlAggiungiOrario = "INSERT INTO Orario (Data,OraArrivo) VALUES (?,?) ";
	private List<OrarioLavoro> lstOrario = null;
	private PreparedStatement pstOrarioLavoro = null;
	//private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	//private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	private OrarioLavoro orarioLavoro = null;
	
	public OrarioLavoroDAO (){
		
		this.creaConnessione();
		
	}
	
	public List<OrarioLavoro> getLista (){
		
		lstOrario = new ArrayList<OrarioLavoro>();
		
		try {
		
			statement = connection.createStatement();
			rsListaGiorni = statement.executeQuery(sqlOrarioLavoro);
			while (rsListaGiorni.next()){
			
				LocalDate data = rsListaGiorni.getDate("Data").toLocalDate();
				LocalTime time = rsListaGiorni.getTime("OraArrivo").toLocalTime();
				
				orarioLavoro = new OrarioLavoro(data,time);
				
				lstOrario.add(orarioLavoro);
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
			Date data = Date.valueOf(orarioLavoro.getDataGiorno());
			Time time = Time.valueOf(orarioLavoro.getOraArrivo());
			pstOrarioLavoro.setDate(1, data);
			pstOrarioLavoro.setTime(2, time);
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

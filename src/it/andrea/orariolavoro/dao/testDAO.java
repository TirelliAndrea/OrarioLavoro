package it.andrea.orariolavoro.dao;

import java.time.LocalDate;
import java.time.LocalTime;

import it.andrea.orariolavoro.model.OrarioLavoro;

public class testDAO {

	public static void main(String[] args) {

	 OrarioLavoroDAO dao = new OrarioLavoroDAO();
	 
	 dao.setOrarioLavoro(new OrarioLavoro(LocalDate.of(2019, 12, 31),LocalTime.of(8, 45)));
	 
	 for (int i = 0 ; i <dao.getLista().size() ; i++){
		 System.out.println(dao.getLista().get(i).getDataGiorno() + " " + dao.getLista().get(i).getOraArrivo() );
	 }
	}

}

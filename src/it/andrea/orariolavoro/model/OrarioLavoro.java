package it.andrea.orariolavoro.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class OrarioLavoro {

	private LocalDate dataGiorno;
	private LocalTime oraArrivo;
	
	public OrarioLavoro(LocalDate dataGiorno, LocalTime oraArrivo) {
		super();
		this.dataGiorno = dataGiorno;
		this.oraArrivo = oraArrivo;
	}

	public LocalDate getDataGiorno() {
		return dataGiorno;
	}

	public void setDataGiorno(LocalDate dataGiorno) {
		this.dataGiorno = dataGiorno;
	}

	public LocalTime getOraArrivo() {
		return oraArrivo;
	}

	public void setOraArrivo(LocalTime oraArrivo) {
		this.oraArrivo = oraArrivo;
	}
	
	
}

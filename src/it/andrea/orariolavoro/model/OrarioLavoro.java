package it.andrea.orariolavoro.model;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class OrarioLavoro {

	private LocalDate dataGiorno;
	private LocalTime oraArrivo;
	

	
	public OrarioLavoro(LocalDate dataGiorno, LocalTime oraArrivo) {
		super();
		this.dataGiorno = dataGiorno;
		this.oraArrivo = oraArrivo;
	}
	

	public OrarioLavoro() {
		super();
	
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

	public DayOfWeek getGiornoSettimana(){
		return dataGiorno.getDayOfWeek();
	}
	
	@Override
	public String toString() {
		return "OrarioLavoro [dataGiorno=" + dataGiorno + ", oraArrivo=" + oraArrivo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataGiorno == null) ? 0 : dataGiorno.hashCode());
		result = prime * result + ((oraArrivo == null) ? 0 : oraArrivo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrarioLavoro other = (OrarioLavoro) obj;
		if (dataGiorno == null) {
			if (other.dataGiorno != null)
				return false;
		} else if (!dataGiorno.equals(other.dataGiorno))
			return false;
		if (oraArrivo == null) {
			if (other.oraArrivo != null)
				return false;
		} else if (!oraArrivo.equals(other.oraArrivo))
			return false;
		return true;
	}
	
	
	
}

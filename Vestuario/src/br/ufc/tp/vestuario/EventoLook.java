package br.ufc.tp.vestuario;

import java.util.GregorianCalendar;

public class EventoLook {
	 private GregorianCalendar data;
	 private String evento;
	
	 public EventoLook(String evento, GregorianCalendar data) {
		this.data = data;
		this.evento = evento;
	}
	
	
	
	public String getEvento() {
		return this.evento;
	}
	public GregorianCalendar getData() {
		return this.data;
	}

}

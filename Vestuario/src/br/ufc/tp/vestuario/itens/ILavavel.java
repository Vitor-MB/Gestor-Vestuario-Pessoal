package br.ufc.tp.vestuario.itens;

import java.util.GregorianCalendar;

public interface ILavavel {
		//Salva a data do computador e varia de acordo com o tipo
		public void lavar();
		
		//Informa a ultima lavagem
		public GregorianCalendar getUltimaLavagem();
}

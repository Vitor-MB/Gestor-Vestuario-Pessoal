package br.ufc.tp.vestuario.itens.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MeuOuvinte implements ActionListener {
	 public void actionPerformed(ActionEvent event) {
		 Object fonte = event.getSource();
		 System.out.println(event + "em" + fonte);
	 }
}

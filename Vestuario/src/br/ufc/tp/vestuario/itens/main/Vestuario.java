package br.ufc.tp.vestuario.itens.main;

import javax.swing.*;


public class Vestuario {

	public static void main(String[] args) {
		
		
		
		try{
			 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println("Não foi possével usar esse Look and Feel:" + e);
		}
			
		SwingUtilities.invokeLater(() -> {
		        JanelaPrincipal janela = new JanelaPrincipal();
		        
		});	

		
	
	}

}

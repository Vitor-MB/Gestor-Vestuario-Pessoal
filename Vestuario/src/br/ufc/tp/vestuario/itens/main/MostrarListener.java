package br.ufc.tp.vestuario.itens.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MostrarListener implements ActionListener {
	private JFrame janela;

    // Construtor que recebe a janela principal
    public MostrarListener(JFrame janelaPrincipal) {
        this.janela = janelaPrincipal;
    }
	
	public void actionPerformed(ActionEvent e) {	
		new JanelaMostrar();
		
		this.janela.dispose();
	}
}

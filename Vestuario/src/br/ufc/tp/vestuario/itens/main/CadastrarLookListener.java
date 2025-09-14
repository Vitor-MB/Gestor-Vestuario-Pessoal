package br.ufc.tp.vestuario.itens.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class CadastrarLookListener implements ActionListener {
	private JFrame janela;

    // Construtor que recebe a janela principal
    public CadastrarLookListener(JFrame janela) {
        this.janela = janela;
    }
	
	public void actionPerformed(ActionEvent e) {
		Object fonte = e.getSource();
		
		JanelaCadastrarLook Cadastro = new JanelaCadastrarLook();
		
		this.janela.dispose();
		
	}

}

package br.ufc.tp.vestuario.itens.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFrame;

public class CadastrarItemListener implements ActionListener{
	private JFrame janela;

    // Construtor que recebe a janela principal
    public CadastrarItemListener(JFrame janela) {
        this.janela = janela;
    }
	
	public void actionPerformed(ActionEvent e) {
		Object fonte = e.getSource();
		
		try {
			JanelaCadastroItem Cadastro = new JanelaCadastroItem();
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		
		this.janela.dispose();
		
	}
	
}

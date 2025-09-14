package br.ufc.tp.vestuario.itens.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CadastrarListener implements ActionListener{
	
	private JFrame janelaPrincipal;

    // Construtor que recebe a janela principal
    public CadastrarListener(JFrame janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
    }
	
	public void actionPerformed(ActionEvent e) {
		Object fonte = e.getSource();
		
		JanelaCadastrar Cadastro = new JanelaCadastrar();
		
		this.janelaPrincipal.dispose();
	}
	

}

package br.ufc.tp.vestuario.itens.main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.JButton;

public class MouseEmCimaListener extends MouseAdapter{

	public void mouseEntered(MouseEvent e) {
		 if (e.getSource() instanceof JButton) {
	            JButton botao = (JButton) e.getSource();
	            Dimension original = botao.getSize();
	            botao.setSize(original.width+15, original.height+15);
	            botao.setBackground(Color.decode("#384159"));
	            botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
	            
	         
	        }
	}
	
	public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton botao = (JButton) e.getSource();
            Dimension original = botao.getSize();
            botao.setSize(original.width-15, original.height-15);
            botao.setBackground(Color.decode("#071230"));
            botao.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            
        }
    }

}

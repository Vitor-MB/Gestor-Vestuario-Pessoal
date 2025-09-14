package br.ufc.tp.vestuario.itens.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JanelaCadastrar extends JFrame{

	public JanelaCadastrar() {
        super("Cadastro");
       
        //DEFINIÇÕES DA TELA
        setLayout(null);
        setSize(1200, 700);
        Image icone = new ImageIcon(getClass().getResource("/ufc.png")).getImage(); //icone da ufc
        setIconImage(icone);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#1c2130"));
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            //Aqui vai voltar pra tela principal
            public void windowClosing(WindowEvent e) {
                JanelaPrincipal Principal = new JanelaPrincipal();
            }
        });
        
        JPanel pane = new JPanel();
        JLabel titulo = new JLabel("CADASTRO");
        
        titulo.setBounds(80, 40, 300, 100);
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        titulo.setForeground(Color.WHITE);
        
        pane.setLayout(null);
        pane.setBounds(80, 100, 1000, 500);
        pane.setBackground(Color.decode("#20273b"));
        
        JButton Item = new JButton("ITEM");
        JButton Look = new JButton("LOOK");
        
        Item.setBounds(160, 170, 300, 150);
        Item.setBackground(Color.decode("#071230"));  // Cor de fundo
        Item.setForeground(Color.WHITE);              
        Item.setFocusPainted(false);                  // Remove o contorno de foco
        Item.setBorderPainted(false);                 // Remove a borda
        Item.setContentAreaFilled(true);
        Item.setFont(new Font("Arial", Font.BOLD, 16));
        
        Look.setBounds(490, 170, 300, 150);
        Look.setBackground(Color.decode("#071230"));  // Cor de fundo
        Look.setForeground(Color.WHITE);              
        Look.setFocusPainted(false);                  // Remove o contorno de foco
        Look.setBorderPainted(false);                 // Remove a borda
        Look.setContentAreaFilled(true);
        Look.setFont(new Font("Arial", Font.BOLD, 16));
        
        Item.addMouseListener(new MouseEmCimaListener());
        Look.addMouseListener(new MouseEmCimaListener());
        
        Item.addActionListener(new CadastrarItemListener(this));
        Look.addActionListener(new CadastrarLookListener(this));
        
        pane.add(Item);
        pane.add(Look);
        
        
        add(titulo);
        add(pane);

        setVisible(true);
    }

    


}

package br.ufc.tp.vestuario.itens.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JanelaPrincipal extends JFrame{

	
	private static final long serialVersionUID = 1L;

	public JanelaPrincipal() {
        super("Vestuario");
      
        
        //DEFINIÇÕES DA TELA
        setLayout(null);
        setSize(1200, 700);
        //Image icone = new ImageIcon(getClass().getResource("/ufc.png")).getImage(); //icone da ufc
        //setIconImage(icone);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#1c2130"));
        
        JPanel pane = new JPanel();
        JButton cadastrar = new JButton("CADASTRAR");
        JButton estatisticas = new JButton("ESTATISTICAS");
        JButton procurar = new JButton("INVENTÁRIO");
        JButton emprestados = new JButton("EMPRESTADOS");
        
        //Animação de passar o mouse em cima nos botões
        cadastrar.addMouseListener(new MouseEmCimaListener());
        estatisticas.addMouseListener(new MouseEmCimaListener());
        procurar.addMouseListener(new MouseEmCimaListener());
        emprestados.addMouseListener(new MouseEmCimaListener());
        
        //Mudar a tela
        cadastrar.addActionListener(new CadastrarListener(this));
        procurar.addActionListener(new MostrarListener(this));
        
        //Image camisa = new ImageIcon(this.getClass().getResource("/camisaB.png")).getImage();
        //Image camisaR = camisa.getScaledInstance(300, 300, Image.SCALE_SMOOTH); // tamanho da imagem
        
       // JLabel ImagemCamisa = new JLabel(new ImageIcon(camisaR));
        

        
        //Image camisaredimensionada = ImagemCamisa.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        //ImagemCamisa.setBounds(840, 160, 350, 300);
        
        //Image adicionar = new ImageIcon(this.getClass().getResource("/b_adicionar.png")).getImage();
        //Image redimensionada = adicionar.getScaledInstance(75, 75, Image.SCALE_SMOOTH); // tamanho da imagem
        //cadastrar.setIcon(new ImageIcon(redimensionada));
        
        pane.setLayout(null);
        
        cadastrar.setBounds(30, 40, 300, 150);
        cadastrar.setBackground(Color.decode("#071230"));  // Cor de fundo
        cadastrar.setForeground(Color.WHITE);              
        cadastrar.setFocusPainted(false);                  // Remove o contorno de foco
        cadastrar.setBorderPainted(false);                 // Remove a borda
        cadastrar.setContentAreaFilled(true);
        cadastrar.setFont(new Font("Arial", Font.BOLD, 16));
        
        estatisticas.setBounds(30, 210, 300, 150);
        estatisticas.setBackground(Color.decode("#071230"));  // Cor de fundo
        estatisticas.setForeground(Color.WHITE);              
        estatisticas.setFocusPainted(false);                  // Remove o contorno de foco
        estatisticas.setBorderPainted(false);                 // Remove a borda
        estatisticas.setContentAreaFilled(true);
        estatisticas.setFont(new Font("Arial", Font.BOLD, 16));
        
        procurar.setBounds(370, 40, 300, 150);
        procurar.setBackground(Color.decode("#071230"));  // Cor de fundo
        procurar.setForeground(Color.WHITE);              
        procurar.setFocusPainted(false);                  // Remove o contorno de foco
        procurar.setBorderPainted(false);                 // Remove a borda
        procurar.setContentAreaFilled(true);
        procurar.setFont(new Font("Arial", Font.BOLD, 16));
        
        
        emprestados.setBounds(370, 210, 300, 150);
        emprestados.setBackground(Color.decode("#071230"));  // Cor de fundo
        emprestados.setForeground(Color.WHITE);              
        emprestados.setFocusPainted(false);                  // Remove o contorno de foco
        emprestados.setBorderPainted(false);                 // Remove a borda
        emprestados.setContentAreaFilled(true);
        emprestados.setFont(new Font("Arial", Font.BOLD, 16));
        
        pane.add(cadastrar);     
        pane.add(procurar);
       
        
        pane.setBounds(30, 140, 800, 400);
        pane.setBackground(Color.decode("#20273b"));
        
        //add(ImagemCamisa);
        add(pane);
        /*
        Image photo = new ImageIcon(this.getClass().getResource("/adicionar.png")).getImage();
        botao.setIcon(new ImageIcon(photo));
        botao.addActionListener(ouvinte);
        pane.add(botao);
        */

        //Confirmação de fechar a janela principal
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            //Se tentar fechar a janela
            public void windowClosing(WindowEvent e) {
                int opcao = JOptionPane.showConfirmDialog(
                    JanelaPrincipal.this,
                    "Deseja Fechar o Vestuário?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.DEFAULT_OPTION
                );
                if (opcao == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

        setVisible(true);
    }

    


}

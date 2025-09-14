package br.ufc.tp.vestuario.itens.main;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.*;

import br.ufc.tp.vestuario.*;
import br.ufc.tp.vestuario.excecoes.PreenchimentoInvalidoExcption;
import br.ufc.tp.vestuario.itens.*;


public class JanelaCadastrarLook extends JFrame{
	public JanelaCadastrarLook() {
		super("Cadastre seu Look");
		
		BancoItens Itens = BancoItens.getInstancia();
		BancoLooks Looks = BancoLooks.getInstancia();
		
		setLayout(null);
        setSize(1200, 700);
        Image icone = new ImageIcon(getClass().getResource("/ufc.png")).getImage(); //icone da ufc
        setIconImage(icone);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#1c2130"));
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            //Se tentar fechar a janela
            public void windowClosing(WindowEvent e) {
                int opcao = JOptionPane.showConfirmDialog(
                    JanelaCadastrarLook.this,
                    "Deseja fechar a janela de Cadastrar Look",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.DEFAULT_OPTION
                );
                if (opcao == JOptionPane.YES_OPTION) {
                    dispose();
                    JanelaCadastrar Cadastro = new JanelaCadastrar();
                }
            }
        });
        
        JPanel pane = new JPanel();
        pane.setBounds(50, 30, 1100,620);
        pane.setBackground(Color.decode("#20273b"));
        pane.setLayout(null);
        
        
        
        
        JLabel labelInterno= new JLabel("SupInterno:");
        labelInterno.setForeground(Color.WHITE);
        labelInterno.setBounds(400, 100, 200, 20);
        JComboBox<Item> SupInterno = new JComboBox<Item>(Itens.getSupInternos().toArray(new SupInterno[0]));
        SupInterno.setBounds(400, 120, 150, 30);
        
        JLabel labelExterno= new JLabel("SupExterno:");
        labelExterno.setForeground(Color.WHITE);
        labelExterno.setBounds(560, 100, 200, 20);
        JComboBox<Item> SupExterno = new JComboBox<Item>();
        SupExterno.addItem(null);
        for (Item item : Itens.getSupExternos()) {
            SupExterno.addItem(item);
        }
        SupExterno.setBounds(560, 120, 150, 30);
        
        JLabel labelInferior= new JLabel("Inferior:");
        labelInferior.setForeground(Color.WHITE);
        labelInferior.setBounds(400, 170, 200, 20);
        JComboBox<Item> Inferior = new JComboBox<Item>(Itens.getInferiores().toArray(new Inferior[0]));
        Inferior.setBounds(400, 190, 150, 30);
        
        JLabel labelCalcado= new JLabel("Calçado:");
        labelCalcado.setForeground(Color.WHITE);
        labelCalcado.setBounds(400, 240, 200, 20);
        JComboBox<Item> Calcados = new JComboBox<Item>(Itens.getCalcados().toArray(new Calcado[0]));
        Calcados.setBounds(400, 260, 150, 30);
        
        
        JLabel labelAcessorio= new JLabel("Acessorio:");
        labelAcessorio.setForeground(Color.WHITE);
        labelAcessorio.setBounds(200, 80, 200, 20);
        JPanel AcessoriosCheck = new JPanel();
        AcessoriosCheck.setLayout(new BoxLayout(AcessoriosCheck, BoxLayout.Y_AXIS));
        List<JCheckBox> ItensAcessorio = new ArrayList<JCheckBox>();
        
        for(Item i : Itens.getAcessorios()) {
        	JCheckBox c = new JCheckBox(i.getID() + "-" + i.getLoja());
        	ItensAcessorio.add(c);
        	AcessoriosCheck.add(c);
        }
        
        JScrollPane PainelAcessorios = new JScrollPane(AcessoriosCheck);
        PainelAcessorios.setBounds(200, 100, 150, 200);
        
        
        JTextField Id = new JTextField();
        Id.setBounds(200, 400, 250, 30);
        JLabel labelId= new JLabel("Nome do look:");
        labelId.setForeground(Color.WHITE);
        labelId.setBounds(200, 380, 190, 20);
        
        
        JButton Salvar = new JButton("Salvar");
        Salvar.setBounds(10, 500, 80, 30);
        Salvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					String tId = Id.getText();
					Item seSupInterno = (Item) SupInterno.getSelectedItem();
					Item seSupExterno = (Item) SupExterno.getSelectedItem();
					Item seInferior = (Item) Inferior.getSelectedItem();
					Item seCalcado = (Item) Calcados.getSelectedItem();
					
					validarPreenchimento(tId, seSupInterno, seInferior, seCalcado);
					
					Look l =new Look(tId, seSupInterno, seInferior, seCalcado);
					
					if(seSupExterno != null) {
						l.adicionar(seSupExterno);
					}
					
					for(int i =0 ; i < ItensAcessorio.size() ; i++) {
					    if (ItensAcessorio.get(i).isSelected()) {
					        l.adicionar(Itens.getAcessorios().get(i));
					    }
					}
					
					l.salvar(Looks);
					
					JOptionPane.showMessageDialog(null, "LOOK SALVO!");
		        
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro de Preenchimento", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
        
        JButton Cancelar = new JButton("Cancelar");
        Cancelar.setBounds(100, 500, 100, 30);
        Cancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				new JanelaCadastrar();
				
			}
		});
        
        JButton LimparTudo = new JButton("LimparTudo");
        LimparTudo.setBounds(210, 500, 150, 30);
        LimparTudo.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				 	
				
			}
		});
        
        
        pane.add(Salvar);
        pane.add(Cancelar);
        
        pane.add(Id);
        pane.add(labelId);
       
        pane.add(PainelAcessorios);
        pane.add(SupInterno);
        pane.add(SupExterno);
        pane.add(Inferior);
        pane.add(Calcados);
        pane.add(labelAcessorio);
        pane.add(labelInterno);
        pane.add(labelExterno);
        pane.add(labelInferior);
        pane.add(labelCalcado);
        add(pane);
        setVisible(true);
	}
	
	public void validarPreenchimento(String Id, Item SupI, Item Inf, Item Calc) throws PreenchimentoInvalidoExcption {
    	if(Id.isBlank()) 
    		throw new PreenchimentoInvalidoExcption("Nome do Look");
    	
    	if(SupI == null) 
    		throw new PreenchimentoInvalidoExcption("SuperiorInterno");
    	
    	if(Inf == null)
    		throw new PreenchimentoInvalidoExcption("Inferior");
    	
    	if(Calc == null)
    		throw new PreenchimentoInvalidoExcption("Calçado");
    }
}


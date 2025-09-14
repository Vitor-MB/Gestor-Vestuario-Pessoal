package br.ufc.tp.vestuario.itens.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import br.ufc.tp.vestuario.*;
import br.ufc.tp.vestuario.excecoes.PreenchimentoInvalidoExcption;
import br.ufc.tp.vestuario.itens.*;




public class JanelaCadastroItem extends JFrame{
	public JanelaCadastroItem() throws ParseException {
		super("Cadastre seu Item");
		
		BancoItens Itens = BancoItens.getInstancia();
		
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
                    JanelaCadastroItem.this,
                    "Deseja fechar a janela de Cadastrar Item",
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
        
		String[] opcoes = {"Superior Interno","Intimo", "Superior Externo", "Inferior", "Calçado", "Acessório"};
        JComboBox<String> Classe = new JComboBox<>(opcoes);
        Classe.setBounds(10, 0, 140, 30);
        Classe.setFont(new Font("Arial", Font.PLAIN, 12));
        
        
        
        JComboBox<MaterialEnum> Material = new JComboBox<MaterialEnum>(MaterialEnum.values());
        Material.setBounds(12, 210, 190, 30);
        JLabel labelMaterial= new JLabel("Material:");
        labelMaterial.setForeground(Color.WHITE);
        labelMaterial.setBounds(10, 190, 200, 20);
        Material.setVisible(false);
        labelMaterial.setVisible(false);
        
        JComboBox<TamanhoEnum> Tamanho = new JComboBox<>(TamanhoEnum.values());
        Tamanho.setBounds(12, 210, 50, 30);
        Tamanho.setFont(new Font("Arial", Font.PLAIN, 12));
        JLabel labelTamanho= new JLabel("Tamanho:");
        labelTamanho.setForeground(Color.WHITE);
        labelTamanho.setBounds(10, 190, 190, 20);
        
        JComboBox<EstilosEnum> Estilo = new JComboBox<>(EstilosEnum.values());
        Estilo.setBounds(10, 370, 300, 30);
        Estilo.setFont(new Font("Arial", Font.PLAIN, 12));
        JLabel labelEstilo= new JLabel("Estilo:");
        labelEstilo.setForeground(Color.WHITE);
        labelEstilo.setBounds(10, 340, 350, 30);
        
        JTextField Id = new JTextField();
        Id.setBounds(10, 70, 190, 30);
        JLabel labelId = new JLabel("ID:");
        labelId.setForeground(Color.WHITE);
        labelId.setBounds(10, 50, 190, 20);
        
        
        JTextField Cor = new JTextField();
        Cor.setBounds(240,140, 120, 30);
        JLabel labelCor= new JLabel("Cor:");
        labelCor.setForeground(Color.WHITE);
        labelCor.setBounds(240, 120, 190, 20);
        
        JTextField Loja = new JTextField();
        Loja.setBounds(10, 140, 190, 30);
        JLabel labelLoja= new JLabel("Loja:");
        labelLoja.setForeground(Color.WHITE);
        labelLoja.setBounds(10, 120, 190, 20);
        
        MaskFormatter mascara = new MaskFormatter("##");
		JFormattedTextField TamanhoCalcado = new JFormattedTextField(mascara);
		TamanhoCalcado.setBounds(12, 210, 50, 30);
        TamanhoCalcado.setFont(new Font("Arial", Font.PLAIN, 12));
        TamanhoCalcado.setVisible(false);
		
        
       
        JLabel labelConservacao= new JLabel("Conservação:");
        labelConservacao.setForeground(Color.WHITE);
        labelConservacao.setBounds(10, 270, 200, 20);
        
        ButtonGroup Conservacao = new ButtonGroup();
        
        JRadioButton radioRuim = new JRadioButton(ConservacaoEnum.RUIM.getString());
        radioRuim.setActionCommand(ConservacaoEnum.RUIM.name());
        radioRuim.setBounds(10, 300, 60, 20);
        radioRuim.setForeground(Color.WHITE);
        radioRuim.setBackground(Color.decode("#20273b")); 
        
        JRadioButton radioRegular= new JRadioButton(ConservacaoEnum.REGULAR.getString());
        radioRegular.setActionCommand(ConservacaoEnum.REGULAR.name());
        radioRegular.setBounds(70, 300, 75, 20);
        radioRegular.setForeground(Color.WHITE);
        radioRegular.setBackground(Color.decode("#20273b")); 
        
        JRadioButton radioBoa= new JRadioButton(ConservacaoEnum.BOA.getString());
        radioBoa.setActionCommand(ConservacaoEnum.BOA.name());
        radioBoa.setBounds(150, 300, 50, 20);
        radioBoa.setForeground(Color.WHITE);
        radioBoa.setBackground(Color.decode("#20273b")); 
        
        JRadioButton radioExcelente= new JRadioButton(ConservacaoEnum.EXCELENTE.getString());
        radioExcelente.setActionCommand(ConservacaoEnum.EXCELENTE.name());
        radioExcelente.setBounds(200, 300, 80, 20);
        radioExcelente.setForeground(Color.WHITE);
        radioExcelente.setBackground(Color.decode("#20273b")); 
        
       
        
        Classe.addActionListener(e -> {
            String selecionado = (String) Classe.getSelectedItem();
            if (selecionado.equals("Acessório")) {
                Tamanho.setVisible(false);
                labelTamanho.setVisible(false);
                Estilo.setVisible(false);
                labelEstilo.setVisible(false);
                
                Material.setVisible(true);
                labelMaterial.setVisible(true);
            }else if(selecionado.equals("Calçado")) {
            	Tamanho.setVisible(false);
            	
            	labelTamanho.setVisible(true);
            	TamanhoCalcado.setVisible(true);
            	
            	Estilo.setVisible(true);
                labelEstilo.setVisible(true);
                
                Material.setVisible(false);
                labelMaterial.setVisible(false);
            }else if(selecionado.equals("Intimo")) {
            	Tamanho.setVisible(false);
            	labelTamanho.setVisible(true);
            	TamanhoCalcado.setVisible(false);
            	
            	Estilo.setVisible(false);
                labelEstilo.setVisible(false);
                
                Material.setVisible(false);
                labelMaterial.setVisible(false);
            }
            
            else {
            	Tamanho.setVisible(true);
                labelTamanho.setVisible(true);
                TamanhoCalcado.setVisible(false);
                Estilo.setVisible(true);
                labelEstilo.setVisible(true);
                
                Material.setVisible(false);
                labelMaterial.setVisible(false);
               
            }
        });
        
        
        JButton Salvar = new JButton("Salvar");
        Salvar.setBounds(10, 500, 80, 30);
        Salvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
				String tID = Id.getText();
				String tcor = Cor.getText();         
		        String tloja = Loja.getText();       
		        String TamCalcado = TamanhoCalcado.getText();
		        TamanhoEnum tamanhoSelecionado = (TamanhoEnum) Tamanho.getSelectedItem(); 
		        EstilosEnum estiloSelecionado = (EstilosEnum) Estilo.getSelectedItem();
		        MaterialEnum materialSelecionado = (MaterialEnum) Material.getSelectedItem();
		        String conservacaoSelecionada = Conservacao.getSelection() != null ? Conservacao.getSelection().getActionCommand() : "Nenhuma";
		        String selecionado = (String) Classe.getSelectedItem();
		        
		        validarPreenchimento(tID, tcor, tloja, Conservacao);
		        
			        if (selecionado.equals("Superior Interno")) {
			        	Item i = new SupInterno(tID,tloja, tcor, ConservacaoEnum.valueOf(conservacaoSelecionada), tamanhoSelecionado,  estiloSelecionado.getEstilo() );
			        	Itens.CadastrarItem(i);
			           
			        } else if (selecionado.equals("Intimo")) {
			        	Itens.CadastrarItem(new Intimo(tID,tloja, tcor, ConservacaoEnum.valueOf(conservacaoSelecionada), tamanhoSelecionado));
			           
			        } else if (selecionado.equals("Superior Externo")) {
			        	Itens.CadastrarItem(new SupExterno(tID,tloja, tcor, ConservacaoEnum.valueOf(conservacaoSelecionada), tamanhoSelecionado, estiloSelecionado.getEstilo()));
			            
			        } else if (selecionado.equals("Inferior")) {
			        	Itens.CadastrarItem(new Inferior(tID,tloja, tcor, ConservacaoEnum.valueOf(conservacaoSelecionada), tamanhoSelecionado, estiloSelecionado.getEstilo()));
			            
			        } else if (selecionado.equals("Calçado")) {
			        	validarTamCalcado(TamCalcado);
			        	Itens.CadastrarItem(new Calcado(tID,tloja, tcor, ConservacaoEnum.valueOf(conservacaoSelecionada), TamCalcado, estiloSelecionado.getEstilo()));
			            
			        } else if (selecionado.equals("Acessório")) {
			        	Itens.CadastrarItem(new Acessorio(tID,tloja, tcor, ConservacaoEnum.valueOf(conservacaoSelecionada), materialSelecionado));
			        }
		        
			    JOptionPane.showMessageDialog(null, "ITEM SALVO!");
		        Id.setText("");
	            Cor.setText("");
	            Loja.setText("");
	            Conservacao.clearSelection();
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
				 	Id.setText("");
		            Cor.setText("");
		            Loja.setText("");
		            Conservacao.clearSelection();
				
			}
		});
        
        
        Conservacao.add(radioRuim);
        Conservacao.add(radioRegular);
        Conservacao.add(radioBoa);
        Conservacao.add(radioExcelente);
        
        pane.add(TamanhoCalcado);
        pane.add(radioRuim);
        pane.add(radioRegular);
        pane.add(radioBoa);
        pane.add(radioExcelente);
        pane.add(Material);
        pane.add(labelMaterial);
        pane.add(Tamanho);
        pane.add(labelTamanho);
        pane.add(Estilo);
        pane.add(labelEstilo);
        pane.add(Salvar);
        pane.add(Cancelar);
        pane.add(LimparTudo);
               
        pane.add(labelEstilo);
        pane.add(Estilo);
        pane.add(labelConservacao);
        
        pane.add(labelLoja);
        pane.add(labelCor);
        pane.add(labelId);
   
        pane.add(Id);
        pane.add(Cor);
        pane.add(Loja);
        pane.add(Classe);
        add(pane);
        setVisible(true);
        
        
	}
	
	public void validarPreenchimento(String Id, String cor, String loja, ButtonGroup Conservacao) throws PreenchimentoInvalidoExcption {
    	if(Id.isBlank()) 
    		throw new PreenchimentoInvalidoExcption("ID");
    	
    	if(cor.isBlank()) 
    		throw new PreenchimentoInvalidoExcption("Cor");
    	
    	if(loja.isBlank())
    		throw new PreenchimentoInvalidoExcption("Loja");
    	
    	if(Conservacao.getSelection() == null)
    		throw new PreenchimentoInvalidoExcption("Conservacao");
    }
	
	public void validarTamCalcado(String tamanho) throws PreenchimentoInvalidoExcption {
		if (tamanho.isBlank()) {
			throw new PreenchimentoInvalidoExcption("Tamanho");
		}
	}
}


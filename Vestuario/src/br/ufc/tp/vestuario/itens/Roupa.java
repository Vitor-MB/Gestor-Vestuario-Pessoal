package br.ufc.tp.vestuario.itens;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public abstract class Roupa extends Item implements ILavavel {
	
	protected GregorianCalendar ultima_lavagem;
	protected TamanhoEnum tamanho;
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Roupa(String id, String Loja_Origem, String Cor, ConservacaoEnum Conservacao, TamanhoEnum tamanho) {
		super(id, Loja_Origem, Cor, Conservacao);
		ultima_lavagem = null;
		this.tamanho = tamanho;
	}
	
	
	//GETs
	public String getTamanho() {
		return tamanho.getTamanho();
	}

	
	//METODOS ILAVAVEL
	public void lavar() {
		ultima_lavagem = new GregorianCalendar();
		System.out.println("Lavagem registrada " + formato.format(ultima_lavagem.getTime()));
	}
	//O usuário registra a lavagem
	public void registrarLavagem(GregorianCalendar ultima) {
		ultima_lavagem = ultima;
		System.out.println("Lavagem registrada " + formato.format(ultima_lavagem.getTime()));
	}
	
	//Informa a ultima lavagem
	public GregorianCalendar getUltimaLavagem() {
		return ultima_lavagem;
	}
	
	
}
package br.ufc.tp.vestuario.itens;

import java.util.GregorianCalendar;

import br.ufc.tp.vestuario.BancoEmprestados;
import br.ufc.tp.vestuario.excecoes.JaEmprestadoException;
import br.ufc.tp.vestuario.excecoes.NaoEmprestadoException;

public class Acessorio extends Item implements IEmprestavel {

	protected MaterialEnum material;
	protected Boolean emprestado;
	protected GregorianCalendar dataEmprestimo;
	protected GregorianCalendar dataDevolucao;
	
	public Acessorio(String id, String Loja_Origem, String Cor, ConservacaoEnum Conservacao, MaterialEnum Material) {
		super(id, Loja_Origem,Cor, Conservacao);
		this.material = Material;
		emprestado = false;
	}
	
	
	public String getMaterial() {
		return material.getCode();
	}
	
	// ------------------------ METODOS EMPRESTIMO ------------------------------
	
	public boolean registrarEmprestimo(BancoEmprestados Emprestados, GregorianCalendar Deadline) throws JaEmprestadoException {
		if(emprestado) {
			System.out.println("Item já emprestado");
			return false;
			
		}else {
			emprestado = true;
			dataEmprestimo = new GregorianCalendar();
			dataDevolucao = Deadline;
			Emprestados.adicionar(this);
			System.out.println("Item emprestado com sucesso!");
			return true;
		}
	}
	
	public boolean registrarEmprestimo(BancoEmprestados Emprestados, int qtdDiad) throws JaEmprestadoException {
		if(emprestado) {
			System.out.println("Item já emprestado");
			return false;
		}else {
			emprestado = true;
			dataDevolucao = new GregorianCalendar();
			dataEmprestimo = new GregorianCalendar();
			dataDevolucao.add(GregorianCalendar.DATE, qtdDiad);
			Emprestados.adicionar(this);
			System.out.println("Item emprestado com sucesso!");
			return true;
		}
	}
	
	public GregorianCalendar getDataEmprestimo() {
		return dataEmprestimo;
	}
	
	public GregorianCalendar getDataDevolucao() {
		return dataDevolucao;
	}
	
	public int qtdDiasEmprestado() {
		if(emprestado) {
			long millis1 = dataEmprestimo.getTimeInMillis();
			long millis2 = new GregorianCalendar().getTimeInMillis();
			
			int Dias = (int)Math.ceil((millis2-millis1)/(1000.0*60*60*24));
			
			return Dias;
		}
		else {
			return 0;
		}
	}
	
	public int diasParadevolucao() {
		if(emprestado) {
			long Total = dataDevolucao.getTimeInMillis();
			long millis1 = new GregorianCalendar().getTimeInMillis();
			
			int Dias = (int)Math.ceil((Total-millis1)/(1000.0*60*60*24));
			
			return Dias;
		}
		else {
			return 0;
		}
	}
	
	public boolean registrarDevolucao(BancoEmprestados Emprestados) throws NaoEmprestadoException {
		if(emprestado) {
			emprestado = false;
			Emprestados.remover(this);
			return true;
		}else {
			System.out.println("Item não está Emprestado");
			return false;
		}
	}
	
	public Boolean isEmprestado() {
		return emprestado;
	}
	
}

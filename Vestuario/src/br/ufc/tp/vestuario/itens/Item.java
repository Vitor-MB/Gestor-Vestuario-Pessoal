package br.ufc.tp.vestuario.itens;

import java.util.GregorianCalendar;

import br.ufc.tp.vestuario.*;
import br.ufc.tp.vestuario.excecoes.ItemJaExistenteException;
import br.ufc.tp.vestuario.excecoes.ItemNaoExistenteException;
import br.ufc.tp.vestuario.excecoes.JaEmprestadoException;
import br.ufc.tp.vestuario.excecoes.NaoEmprestadoException;
import br.ufc.tp.vestuario.excecoes.NaoEmprestavelException;
import br.ufc.tp.vestuario.excecoes.NaoLavavelException;
import br.ufc.tp.vestuario.excecoes.NaoPossuiEstiloException;
import br.ufc.tp.vestuario.excecoes.NaoRoupaException;

public abstract class Item {

	protected String id; //Nome
	protected String Loja_Origem;
	protected String Cor;
	protected ConservacaoEnum Conservacao;
	
	protected int qtdUsos;
	
	public Item(String id, String Loja_Origem, String Cor, ConservacaoEnum Conservacao) {
		this.id = id;
		this.Loja_Origem = Loja_Origem;
		this.Cor = Cor;
		this.Conservacao = Conservacao;
		qtdUsos = 0;
	}
	
	//Gets
	public String getID() {
		return id;
	}
	public int getQtdUsos() {
		return qtdUsos;
	}
	public String getCor() {
		return Cor;
	}
	public String getLoja() {
		return Loja_Origem;
	}
	public ConservacaoEnum getConservacao() {
		return Conservacao;
	}
	public String getTamanhoRoupa() throws NaoRoupaException {
		if(this instanceof Roupa) {
			return ((Roupa)this).getTamanho();
		}else {
			throw new NaoRoupaException();
		}
	}
	
	public String getTamanhoCalcado() throws NaoRoupaException {
		if(this instanceof Calcado) {
			return ((Calcado)this).gettamanho();
		}else {
			throw new NaoRoupaException();
		}
	}
	
	public String getEstilo() throws NaoPossuiEstiloException {
		if(this instanceof Normal) {
			return ((Normal) this).getEstilo();
		}
		else {
			throw new NaoPossuiEstiloException();
		}
	}
	
	public boolean isEmprestavel() {
		return this instanceof IEmprestavel;
	}
	public boolean isLavavel() {
		return this instanceof ILavavel;
	}
	
	public void registrarUso() {
		this.qtdUsos += 1;
	}
	
	//LAVAR
	public void Lavar() throws NaoLavavelException {
		if(isLavavel()) {
			ILavavel l = ((ILavavel) this);
			l.lavar();
		}else 
			throw new NaoLavavelException(this.id);
		
	}
	
	
	public GregorianCalendar getUltimaLavagem() throws NaoLavavelException{
		if(isLavavel()) {
			ILavavel l = ((ILavavel) this);
			return l.getUltimaLavagem();
		}else {
			throw new NaoLavavelException(this.id);
		}
	}
	
	//EMPRESTAR
	public void Emprestar(BancoEmprestados Emprestados, int qtdDias) throws NaoEmprestavelException, JaEmprestadoException{
		if(isEmprestavel()) {
			IEmprestavel e = ((IEmprestavel) this);
			e.registrarEmprestimo(Emprestados, qtdDias);
		}
		else {
			throw new NaoEmprestavelException();
		}
	}
	public void Emprestar(BancoEmprestados Emprestados, GregorianCalendar Deadline) throws NaoEmprestavelException, JaEmprestadoException {
		if(isEmprestavel()) {
			IEmprestavel e = ((IEmprestavel) this);
			e.registrarEmprestimo(Emprestados, Deadline);
		}
		else {
			throw new NaoEmprestavelException();
		}
	}
	
	public void Devolucao(BancoEmprestados Emprestados) throws NaoEmprestavelException, NaoEmprestadoException {
		if(isEmprestavel()) {
			IEmprestavel e = ((IEmprestavel) this);
			if(!e.isEmprestado()) {
				throw new NaoEmprestadoException(this.id);
			}
			if(e.registrarDevolucao(Emprestados)) 
				System.out.println(this.getID() + " Devolvido");
		}
		else {
			throw new NaoEmprestavelException();
		}
	}
	
	public Boolean isEmprestado() {
		if(isEmprestavel()) {
			IEmprestavel e = ((IEmprestavel) this);
			return e.isEmprestado();
		}
		else {
			return false;
		}
	}
		
		
	//EDITAR ITEM
	public void Editar(BancoItens Itens, Item editado) throws ItemNaoExistenteException, ItemJaExistenteException {
		//Verifica se sao da mesma classe
		if (!this.getClass().equals(editado.getClass())) {
	        throw new IllegalArgumentException("Item de Classes diferentes");
	    }
		
		if(this instanceof Calcado) {
			Calcado modificado = ((Calcado) editado);
			Calcado i = ((Calcado) this);
			
			if(this.id != editado.id) {
				Itens.RemoverItem(this);
				this.id = editado.id;
				Itens.CadastrarItem(this);	
			}
			this.Cor = editado.Cor;
			this.Conservacao = editado.Conservacao;
			this.Loja_Origem = editado.Loja_Origem;
			i.tamanho = modificado.tamanho;
			System.out.println("Item editado!\n");
			
		}
		if(this instanceof Roupa) {
			Roupa modificado = ((Roupa) editado);
			Roupa i = ((Roupa) this);
			
			//Caso mude o ID, cadastrar novamente no HashMap com outro ID
			if(this.id != editado.id) {
				Itens.RemoverItem(this);
				this.id = editado.id;
				Itens.CadastrarItem(this);	
			}
			this.Cor = editado.Cor;
			this.Conservacao = editado.Conservacao;
			this.Loja_Origem = editado.Loja_Origem;
			i.tamanho = modificado.tamanho;
			System.out.println("Item editado!\n");
			
		}
		else if(this instanceof Acessorio) {
			Acessorio modificado = ((Acessorio) editado);
			Acessorio i = ((Acessorio) this);
			
			if(!this.id.equals(editado.id)) {
				Itens.RemoverItem(this);
				this.id = editado.id;
				Itens.CadastrarItem(this);	
			}
			this.Cor = editado.Cor;
			this.Conservacao = editado.Conservacao;
			this.Loja_Origem = editado.Loja_Origem;
			i.material = modificado.material;
			System.out.println("Item editado!\n");
		}
		
	}
	
	public String toString() {
	    return this.getID() + " - " + this.getLoja();
	}
	
	
}

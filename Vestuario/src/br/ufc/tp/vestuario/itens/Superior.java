package br.ufc.tp.vestuario.itens;


public abstract class Superior extends Normal{
	public Superior(String id, String Loja_Origem, String Cor, ConservacaoEnum Conservacao, TamanhoEnum tamanho, String Estilo) {
		super(id, Loja_Origem, Cor, Conservacao, tamanho, Estilo);
	}
}

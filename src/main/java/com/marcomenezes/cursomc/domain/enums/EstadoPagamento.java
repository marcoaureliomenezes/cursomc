package com.marcomenezes.cursomc.domain.enums;

public enum EstadoPagamento {

	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int cod;
	private String descricao;
	
//	Constructor
	private EstadoPagamento (int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;		
	}
//	Getters and setters for cod, descricao
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
//	Method that receives a cod as Integer and returns an payment status.
	public static EstadoPagamento toEnum(Integer cod) {
		if(cod == null)  return null;
		for (EstadoPagamento x : EstadoPagamento.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}

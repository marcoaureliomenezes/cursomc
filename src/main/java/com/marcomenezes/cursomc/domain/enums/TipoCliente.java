package com.marcomenezes.cursomc.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
//	Constructor
	private TipoCliente (int cod, String descricao) {
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
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) return null;
		for (TipoCliente x : TipoCliente.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}	
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}

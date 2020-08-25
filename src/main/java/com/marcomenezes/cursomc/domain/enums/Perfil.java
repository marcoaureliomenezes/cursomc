package com.marcomenezes.cursomc.domain.enums;

public enum Perfil {

	ADMIN(1, "ROLE_ADMIN"),
	CLIENTE(2, "ROLE_CLIENTE"),
	LOJA(3, "ROLE_LOJA");
	
	private int cod;
	private String descricao;
	
//	Constructor
	private Perfil (int cod, String descricao) {
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
	public static Perfil toEnum(Integer cod) {
		if(cod == null)  return null;
		for (Perfil x : Perfil.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}

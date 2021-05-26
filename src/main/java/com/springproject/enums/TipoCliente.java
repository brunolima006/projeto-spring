package com.springproject.enums;

public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int codigo;
	private String tipo;
	
	private TipoCliente(int codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public static TipoCliente toEnum(Integer codigo) {
		if(codigo == null) {
			return null;
		}
		
		for(TipoCliente cliente : TipoCliente.values()) {
			if(codigo.equals(cliente.getCodigo())) {
				return cliente;
			}
		}
		
		throw new IllegalArgumentException("Id inválido" + codigo);
	}

}

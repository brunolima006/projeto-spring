package com.springproject.enums;

public enum EstadoPagamento {
	
	PENDENTE(1, "Pagamento Pendente"),
	QUITADO(2, "Pagamento Quitado"),
	CANCELADO(3, "Pagamento Cancelado");
	
	private int codigo;
	private String informacao;
	
	private EstadoPagamento(int codigo, String informacao) {
		this.codigo = codigo;
		this.informacao = informacao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getInformacao() {
		return informacao;
	}
	
	public EstadoPagamento toEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}
		
		for(EstadoPagamento pagamento : EstadoPagamento.values()) {
			if (codigo.equals(pagamento.getCodigo())) {
				return pagamento;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}

}

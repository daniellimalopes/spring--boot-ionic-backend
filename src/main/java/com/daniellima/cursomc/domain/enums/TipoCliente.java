package com.daniellima.cursomc.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Física"), PESSOAJURIDICA(2, "Pessoa Jurídica");

	private int cod;
	private String descricao;

	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	// So usa o get porque o tipo enum uma vez istanciado nao pode mudar o nome
	// dele.
	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	// Metodo de busca, retorna um objeto do TipoCliente de acordo ao cod
	// pesquisado.
	public static TipoCliente toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}
		// O cod
		for (TipoCliente x : TipoCliente.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("id Inválido" + cod);
	}

	
	}


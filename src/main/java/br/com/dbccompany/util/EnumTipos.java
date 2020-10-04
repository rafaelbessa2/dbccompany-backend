package br.com.dbccompany.util;

public enum EnumTipos {
	VENDEDOR("001"),
	CLIENTE("002"),
	VENDA("003");
	
	private String codigo;
	
	private EnumTipos(String codigo) {
		this.codigo= codigo;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}	
}

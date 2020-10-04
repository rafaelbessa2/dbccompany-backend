package br.com.dbccompany.util;

public enum EnumDiretorio {
	ENTRADA("data/in/"),
	SAIDA("data/out/");
	
	private String caminho;
	
	private EnumDiretorio(String caminho) {
		this.caminho= caminho;
	}

	/**
	 * @return the caminho
	 */
	public String getCaminho() {
		return caminho;
	}

	/**
	 * @param caminho the caminho to set
	 */
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	
	
}

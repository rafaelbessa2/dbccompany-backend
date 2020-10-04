package br.com.dbccompany.model;

public class Cliente {

	
	private String cnpj;
	private String name;
	private String businessArea;
	
	public Cliente() {
		
	}
	public Cliente(String cnpj, String name,String businessArea) {
		this.cnpj= cnpj;
		this.name= name;
		this.businessArea= businessArea;
	}
	/**
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}
	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the businessArea
	 */
	public String getBusinessArea() {
		return businessArea;
	}
	/**
	 * @param businessArea the businessArea to set
	 */
	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}
}

package br.com.dbccompany.model;

import java.util.List;

public class Venda {

	
	private Integer saleId;
	private String salesmanName;
	private List<ItemVenda> itens;
	
	public Venda() {
	}
	
	public Venda(Integer saleId,String salesmanName) {
		this.saleId = saleId;
		this.salesmanName = salesmanName;
	}

	/**
	 * @return the saleId
	 */
	public Integer getSaleId() {
		return saleId;
	}

	/**
	 * @param saleId the saleId to set
	 */
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}

	/**
	 * @return the salesmanName
	 */
	public String getSalesmanName() {
		return salesmanName;
	}

	/**
	 * @param salesmanName the salesmanName to set
	 */
	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}

	/**
	 * @return the itens
	 */
	public List<ItemVenda> getItens() {
		return itens;
	}

	/**
	 * @param itens the itens to set
	 */
	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}

}

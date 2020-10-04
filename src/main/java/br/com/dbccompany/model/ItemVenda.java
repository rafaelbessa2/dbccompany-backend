package br.com.dbccompany.model;

public class ItemVenda {

	
	private Integer itemId;
	private Integer itemQuantity;
	private Double itemPrice;
	
	public ItemVenda() {
	}
	
	public ItemVenda(Integer itemId,Integer itemQuantity,Double itemPrice) {
		this.itemId = itemId;
		this.itemQuantity = itemQuantity;
		this.itemPrice = itemPrice;
	}
	/**
	 * @return the itemId
	 */
	public Integer getItemId() {
		return itemId;
	}
	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	/**
	 * @return the itemQuantity
	 */
	public Integer getItemQuantity() {
		return itemQuantity;
	}
	/**
	 * @param itemQuantity the itemQuantity to set
	 */
	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	/**
	 * @return the itemPrice
	 */
	public Double getItemPrice() {
		return itemPrice;
	}
	/**
	 * @param itemPrice the itemPrice to set
	 */
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
}

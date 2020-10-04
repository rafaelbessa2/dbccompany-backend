package br.com.dbccompany.model;

public class Vendedor {

	
	private String cpf;
	private String name;
	private Double salary;
	
	public Vendedor() {
		
	}
	public Vendedor(String cpf, String name,Double salary) {
		this.cpf= cpf;
		this.name= name;
		this.salary= salary;
	}
	
	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	 * @return the salary
	 */
	public Double getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	

}

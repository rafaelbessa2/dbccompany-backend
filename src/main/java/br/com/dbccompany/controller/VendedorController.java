package br.com.dbccompany.controller;

import java.util.List;

import br.com.dbccompany.exception.ExceptionVendedor;
import br.com.dbccompany.model.ItemVenda;
import br.com.dbccompany.model.Venda;
import br.com.dbccompany.model.Vendedor;

public class VendedorController {

	public Vendedor identificarPiorVendedor(List<Vendedor> pVendedor, List<Venda> pVendas) throws ExceptionVendedor {
		Vendedor retorno = new Vendedor();

		try {
			Double vPioresVenda = 0.00;
			
			for (Vendedor vVendedor : pVendedor) {
				Double vValorTotalDeVendas = 0.00;
				for (Venda vVenda : pVendas) {
					if(vVendedor.getName().equals(vVenda.getSalesmanName())){
						for (ItemVenda vItemVenda : vVenda.getItens()) {
							vValorTotalDeVendas += vItemVenda.getItemQuantity() * vItemVenda.getItemPrice();
						}
					}
				}
				if(vPioresVenda.equals(0.00)){
					vPioresVenda = vValorTotalDeVendas;
					retorno = vVendedor;
				}else if (vValorTotalDeVendas < vPioresVenda) {
					vPioresVenda = vValorTotalDeVendas;
					retorno = vVendedor;
				}
			}
			return retorno;

		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionVendedor("Ocorreu um erro inesperado");
		}
	}

}

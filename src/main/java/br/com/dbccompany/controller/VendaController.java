package br.com.dbccompany.controller;

import java.util.List;

import br.com.dbccompany.exception.ExceptionVenda;
import br.com.dbccompany.model.ItemVenda;
import br.com.dbccompany.model.Venda;

public class VendaController {

	public Venda identificarMaiorVenda(List<Venda> pVendas) throws ExceptionVenda {
		Venda retorno = new Venda();
		
		try{
			Double vMaiorVenda = 0.00;
			for (Venda vVenda : pVendas) {
			
				Double vValorTotalVenda = 0.00;
				for (ItemVenda vItemVenda : vVenda.getItens()) {
					vValorTotalVenda +=  vItemVenda.getItemQuantity() * vItemVenda.getItemPrice();
				}
				
				if(vValorTotalVenda>vMaiorVenda){
					vMaiorVenda = vValorTotalVenda;
					retorno = vVenda;
				}
			}
			
		return retorno;
		
		}catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionVenda("Ocorreu um erro inesperado");
		}
	}  
	
	
}

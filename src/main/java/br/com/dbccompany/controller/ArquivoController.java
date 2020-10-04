package br.com.dbccompany.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import br.com.dbccompany.dto.DocumentoDTO;
import br.com.dbccompany.exception.ExceptionVenda;
import br.com.dbccompany.exception.ExceptionVendedor;
import br.com.dbccompany.model.Cliente;
import br.com.dbccompany.model.ItemVenda;
import br.com.dbccompany.model.Venda;
import br.com.dbccompany.model.Vendedor;
import br.com.dbccompany.util.EnumTipos;
import br.com.dbccompany.util.FileUtis;

public class ArquivoController {


	private static final String CARACTER_SPLIT_BASE_LINHA = "ç";
	private static final String CARACTER_SPLIT_ITENS_VENDA = ",";
	private static final String CARACTER_SPLIT_ITEM_VENDA = "-";
	
	private List<Vendedor> vListVendedor;
	private List<Cliente> vListCliente;
	private List<Venda> vListVenda;
	
	static VendaController vVendaCotroller = new VendaController();
	static VendedorController vVendedorCotroller = new VendedorController(); 
	
	public void processarArquivos(File[] pArquivos) throws NumberFormatException, IOException, ExceptionVenda, ExceptionVendedor{
	
		vListVendedor = new ArrayList<>();
		vListCliente = new ArrayList<>();
		vListVenda = new ArrayList<>();
		
	for(File vArquivo : pArquivos){
		BufferedReader vBufferedReader = new BufferedReader(new FileReader(vArquivo));

	     while(vBufferedReader.ready()){
	        String vLinha[] = vBufferedReader.readLine().split(CARACTER_SPLIT_BASE_LINHA);
	        
	        if(vLinha[0].equals(EnumTipos.VENDEDOR.getCodigo())){
	        	vListVendedor.add(new Vendedor(vLinha[1],vLinha[2],Double.valueOf(vLinha[3])));
	        }else if(vLinha[0].equals(EnumTipos.CLIENTE.getCodigo())){
	        	vListCliente.add(new Cliente(vLinha[1],vLinha[2],vLinha[3]));
	        }else if(vLinha[0].equals(EnumTipos.VENDA.getCodigo())){
	        	Venda venda = new Venda(Integer.valueOf(vLinha[1]),vLinha[3]);
	        	venda.setItens(new ArrayList<ItemVenda>());
	        	vListVenda.add(venda);		        
	        	String vLinhaItensVenda[] = vLinha[2].substring(1, vLinha[2].length()-1).split(CARACTER_SPLIT_ITENS_VENDA);
	        	 
	        	 for (int i = 0; i < vLinhaItensVenda.length; i++) {
	        		 String vItensVenda[] = vLinhaItensVenda[i].split(CARACTER_SPLIT_ITEM_VENDA);
	        		 venda.getItens().add(new ItemVenda(Integer.valueOf(vItensVenda[0]),Integer.valueOf(vItensVenda[1]),Double.valueOf(vItensVenda[2])));
	        	 }
	        }		        
	     }
	     
	     vBufferedReader.close();
	}
	
	FileUtis.gerarArquivo(vListCliente.size(),vListVendedor.size(),vVendaCotroller.identificarMaiorVenda(vListVenda).getSaleId(),vVendedorCotroller.identificarPiorVendedor(vListVendedor,vListVenda).getName());
	}
	
	
	
	
	public List<DocumentoDTO> listarArquivos(String diretorio) {
		
		File vDiretorio = new File(diretorio);  
        
        File[] vArquivos = vDiretorio.listFiles(FileUtis.filter);
        List<DocumentoDTO> vListaDocumentoDTO =  new ArrayList<DocumentoDTO>();
        
        for (File vArquivo : vArquivos) {
        	vListaDocumentoDTO.add(new DocumentoDTO(vArquivo.getName(),vArquivo.length()));
		}
        
		return vListaDocumentoDTO;
		
	} 
	
	public DocumentoDTO buscarArquivo(String diretorio,String nomeArquivo) throws Exception {
		
		File vDiretorio = new File(diretorio);  
        
        File[] vArquivos = vDiretorio.listFiles(FileUtis.filter);
        DocumentoDTO vDocumentoDTO = null;
        
        for (File vArquivo : vArquivos) {
        	if(vArquivo.getName().equals(nomeArquivo)) {
        		vDocumentoDTO = new DocumentoDTO(vArquivo.getName(),vArquivo.length(),FileUtis.fileToByte(vArquivo));
        	}
		}
        
		return vDocumentoDTO;
	} 
	
	public void inserirArquivo(String pCaminhoArquivo,String pArquivoBase64) throws Exception {
		
        File vFile = new File(pCaminhoArquivo);
		FileOutputStream fos = new FileOutputStream(vFile);
		      		      
	    byte[] decoder = Base64.getDecoder().decode(pArquivoBase64);

	    fos.write(decoder);
	    fos.close();
	    
	} 
	
	
	
	/**
	 * @return the vListVendedor
	 */
	public List<Vendedor> getvListVendedor() {
		return vListVendedor;
	}
	/**
	 * @return the vListCliente
	 */
	public List<Cliente> getvListCliente() {
		return vListCliente;
	}
	/**
	 * @return the vListVenda
	 */
	public List<Venda> getvListVenda() {
		return vListVenda;
	}
	
	
}

package br.com.dbccompany.web.rest.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbccompany.controller.ArquivoController;
import br.com.dbccompany.dto.DocumentoDTO;
import br.com.dbccompany.util.EnumDiretorio;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ApiResource {
	
	ArquivoController  vArquivoController = new ArquivoController();
	
	@GetMapping(value = "/lista/documento/lote/v1")
	 public ResponseEntity<List<DocumentoDTO>> getListaDocumentoLote() {
		
		ResponseEntity<List<DocumentoDTO>> vResponseEntity = null;
		List<DocumentoDTO> vListaDocumentos = new ArrayList<>();
		try {
			vListaDocumentos = vArquivoController.listarArquivos(EnumDiretorio.ENTRADA.getCaminho());
			vResponseEntity = new ResponseEntity<>(vListaDocumentos, HttpStatus.OK);
		} catch (Exception e) {
			vResponseEntity = new ResponseEntity<>(vListaDocumentos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return vResponseEntity;
	 }
	
	@GetMapping(value = "/lista/documento/processado/v1")
	 public ResponseEntity<List<DocumentoDTO>> getListaDocumentoProcessado() {
		
		ResponseEntity<List<DocumentoDTO>> vResponseEntity = null;
		List<DocumentoDTO> vListaDocumentos = new ArrayList<>();
		try {
			vListaDocumentos = vArquivoController.listarArquivos(EnumDiretorio.SAIDA.getCaminho());
			vResponseEntity = new ResponseEntity<>(vListaDocumentos, HttpStatus.OK);
		} catch (Exception e) {
			vResponseEntity = new ResponseEntity<>(vListaDocumentos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return vResponseEntity;
	 }
	
	
	@GetMapping(value = "/download/documento/lote/v1")
	 public ResponseEntity<DocumentoDTO> getDownloadDocumentoLote(@RequestParam(required = true,name =  "nomeArquivo")String pNomeArquivo) {
		
		ResponseEntity<DocumentoDTO> vResponseEntity = null;
		DocumentoDTO vDocumentos = new DocumentoDTO();
		try {
			vDocumentos = vArquivoController.buscarArquivo(EnumDiretorio.ENTRADA.getCaminho(),pNomeArquivo);
					vResponseEntity = new ResponseEntity<>(vDocumentos, HttpStatus.OK);
		} catch (Exception e) {
			vResponseEntity = new ResponseEntity<>(vDocumentos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return vResponseEntity;
	 }
	
	@GetMapping(value = "/download/documento/processado/v1")
	 public ResponseEntity<DocumentoDTO> getDownloadDocumentoProcessado(@RequestParam(required = true,name =  "nomeArquivo")String pNomeArquivo) {
		
		ResponseEntity<DocumentoDTO> vResponseEntity = null;
		DocumentoDTO vDocumentos = new DocumentoDTO();
		try {
			vDocumentos = vArquivoController.buscarArquivo(EnumDiretorio.SAIDA.getCaminho(),pNomeArquivo);
					vResponseEntity = new ResponseEntity<>(vDocumentos, HttpStatus.OK);
		} catch (Exception e) {
			vResponseEntity = new ResponseEntity<>(vDocumentos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return vResponseEntity;
	 }
	
	@PostMapping(value = "/inseri/documento/lote/v1")
	 public ResponseEntity<DocumentoDTO> getInserirDocumentoLote(@RequestBody DocumentoDTO documento) {
		
		ResponseEntity<DocumentoDTO> vResponseEntity = null;
		
		try {
			 vArquivoController.inserirArquivo(EnumDiretorio.ENTRADA.getCaminho()+ documento.getNomeArquivo(),documento.getArquivoBase64());
			 vResponseEntity = new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			vResponseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return vResponseEntity;
	 }

}

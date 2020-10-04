package br.com.dbccompany.dto;


public class DocumentoDTO {
	
	private String nomeArquivo;
	private String arquivoBase64;
	private Long tamanhoArquivo;
	private byte[] arquivo; 
	
	public DocumentoDTO() {
	}

	public DocumentoDTO(String nomeArquivo,Long tamanhoArquivo) {
		this.nomeArquivo = nomeArquivo;
		this.tamanhoArquivo= tamanhoArquivo;
	}
	public DocumentoDTO(String nomeArquivo,Long tamanhoArquivo,byte[] arquivo) {
		this.nomeArquivo = nomeArquivo;
		this.tamanhoArquivo= tamanhoArquivo;
		this.arquivo = arquivo;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public Long getTamanhoArquivo() {
		return tamanhoArquivo;
	}

	public void setTamanhoArquivo(Long tamanhoArquivo) {
		this.tamanhoArquivo = tamanhoArquivo;
	}

	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}

	public String getArquivoBase64() {
		return arquivoBase64;
	}

	public void setArquivoBase64(String arquivoBase64) {
		this.arquivoBase64 = arquivoBase64;
	}
	
}

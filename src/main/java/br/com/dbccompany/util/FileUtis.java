package br.com.dbccompany.util;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtis {
	

	private static final String FORMATO_ENTRADA_PERMITIDO = ".dat";
	
	private static final String FORMATO_SAIDA = ".done.dat";
	
	public static FileFilter filter = new FileFilter() {
	    public boolean accept(File pFile) {
	        return pFile.getName().endsWith(FORMATO_ENTRADA_PERMITIDO);
	    }
	};
	
	public static void gerarArquivo(Object... pParans) throws IOException{
		
		Date vDataAtual = new Date();
	    SimpleDateFormat sdf = new  SimpleDateFormat("yyyyMMddhhmmss");
	    String vDataFormatada = sdf.format(vDataAtual);

		
		FileWriter vFileWriter = new FileWriter(EnumDiretorio.SAIDA.getCaminho() + vDataFormatada+ FORMATO_SAIDA);
	    PrintWriter vPrintWriter = new PrintWriter(vFileWriter);
	    for (Object vParam : pParans) {
	    	vPrintWriter.println(vParam);	
		}
	    vFileWriter.close();
	}
	
	public static byte[] fileToByte(File pArquivo) throws Exception {
		
		try (DataInputStream vDataInputStream = new DataInputStream(new FileInputStream(pArquivo))) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			    byte[] buffer = new byte[8192];
			    int bytesRead;
			    while ((bytesRead = vDataInputStream.read(buffer)) > 0) {
			        baos.write(buffer, 0, bytesRead);
			    }
			    
			    baos.close();
			    return baos.toByteArray();
		}
			
	}
	
}

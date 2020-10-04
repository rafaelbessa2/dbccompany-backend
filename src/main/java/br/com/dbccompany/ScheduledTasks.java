package br.com.dbccompany;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.dbccompany.controller.ArquivoController;
import br.com.dbccompany.exception.ExceptionVenda;
import br.com.dbccompany.exception.ExceptionVendedor;
import br.com.dbccompany.util.EnumDiretorio;
import br.com.dbccompany.util.FileUtis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class ScheduledTasks {
	
    private Integer vQtdFiles=0;

    ArquivoController vProcessamentoArquivosController = new ArquivoController();
    
	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() throws NumberFormatException, IOException, ExceptionVenda, ExceptionVendedor {
		log.info("Scanneando arquivos {}", dateFormat.format(new Date()));
		verificarPasta(EnumDiretorio.ENTRADA.getCaminho());   
	    }
	
	
	
	private void verificarPasta(String dir) throws NumberFormatException, IOException, ExceptionVenda, ExceptionVendedor {  
        File vDiretorio = new File(dir);  
          
        File[] vArquivos = vDiretorio.listFiles(FileUtis.filter);  
        if(vArquivos.length != vQtdFiles){
        
        this.vQtdFiles = vArquivos.length;
        vProcessamentoArquivosController.processarArquivos(vArquivos);
        }
          
    }  
	
}

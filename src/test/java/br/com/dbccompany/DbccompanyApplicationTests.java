package br.com.dbccompany;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
class DbccompanyApplicationTests {
	
	@Autowired
    private MockMvc vMockMvc;

	@Test
	void listaDocumentosLote() throws Exception {
		vMockMvc.perform(get("/api/lista/documento/lote/v1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
	}
	
	@Test
	void listaDocumentosProcessados() throws Exception {
		vMockMvc.perform(get("/api/lista/documento/processado/v1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
	}
	
	@Test
	void inserirDocumentoLote() throws Exception {
		Random vNumeroRandomico = new Random();
		vMockMvc.perform(post("/api/inseri/documento/lote/v1").content("{\"nomeArquivo\": \"venda_mes_"+ vNumeroRandomico.nextInt()+ ".dat\",\n"
				+ "\"arquivoBase64\": \"MDAxw6cxMjM0NTY3ODkxMjM0w6dQZWRyb8OnNTAwMDANCjAwMcOnMzI0NTY3ODg2NTQzNMOnUGF1bG/DpzQwMDAwLjk5DQowMDLDpzIzNDU2NzU0MzQ1NDQzNDXDp0pvc2UgZGEgU2lsdmHDp1J1cmFsDQowMDLDpzIzNDU2NzU0MzM0NDQzNDXDp0VkdWFyZG8gUGVyZWlyYcOnUnVyYWwNCjAwM8OnMTDDp1sxLTEwLTEwMCwyLTMwLTIuNTAsMy00MC0zLjEwXcOnUGVkcm8NCjAwM8OnMDjDp1sxLTM0LTEwLDItMzMtMS41MCwzLTQwLTAuMTBdw6dQYXVsbw==\"}")
                .accept(MediaType.ALL).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
	}
	
	@Test
	void inserirDocumentoLoteNotContent() throws Exception {
		vMockMvc.perform(post("/api/inseri/documento/lote/v1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
	}
	
	@Test
	void listaDocumentosProcessadosViaPost() throws Exception {
		vMockMvc.perform(post("/api/lista/documento/processado/v1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isMethodNotAllowed());
	}
	
	@Test
	void inserirDocumentoLoteViaGet() throws Exception {
		vMockMvc.perform(get("/api/inseri/documento/lote/v1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isMethodNotAllowed());
	}

}

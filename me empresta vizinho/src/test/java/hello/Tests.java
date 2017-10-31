/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hello;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import Objetos.Produto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Tests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void salvarUsuario() throws Exception {
        this.mockMvc.perform(get("/usuario/insere")
                .param("tipoLocal", "1")
                .param("numero", "507"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void buscarCategorias() throws Exception {
        this.mockMvc.perform(get("/categoria/selectAll"))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void buscarCondominios() throws Exception {
        this.mockMvc.perform(get("/condominio/selectAll"))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void inserirProduto() throws Exception {
        String produto = "{\"idProduto\": null,\"nomeProduto\": \"Teste\", \"descProduto\": \"Teste automatizado\",\"idCategoria\": 49,\"idUsuario\": 1, \"vl_preco\": 10, \"data_inicio\": 0, \"data_fim \": 0, \"link_imagem\": null}";
        this.mockMvc.perform(post("/produto/insere").contentType(MediaType.APPLICATION_JSON).content(produto)).andExpect(status().isOk());
    }


}

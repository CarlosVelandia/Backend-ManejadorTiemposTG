package com.ceiba.tiquete.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.tiquete.comando.ComandoTiquete;
import com.ceiba.tiquete.testdatabuilder.ComandoTiqueteTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorTiquete.class)
public class ComandoControladorTiqueteTest {

    private static final Long ID_USUARIO_CREAR = 1l;
    private static final Long ID_PARQUE_CREAR = 1l;
    private static final String FECHA_COMPRA_CREAR = "2021-03-20";
    private static final double VALOR_CRAR = 30000;

    private static final Long ID_USUARIO_ACTUALIZAR = 1l;
    private static final Long ID_PARQUE_ACTUALIZAR = 1l;
    private static final String FECHA_COMPRA_ACTUALIZAR = "2021-03-20";
    private static final double VALOR_ACTUALIZAR = 30000;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoTiquete tiquete = new ComandoTiqueteTestDataBuilder().conIdUsuario(ID_USUARIO_CREAR).conIdParque(ID_PARQUE_CREAR).conFechaCompra(FECHA_COMPRA_CREAR).conValor(VALOR_CRAR).build();

        // act - assert
        mocMvc.perform(post("/tiquetes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(tiquete)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 4 }"));
    }

    @Test
    public void actualizar() throws Exception {
        // arrange
        Long id = 2L;
        ComandoTiquete tiquete = new ComandoTiqueteTestDataBuilder().conIdUsuario(ID_USUARIO_ACTUALIZAR).conIdParque(ID_PARQUE_ACTUALIZAR).conFechaCompra(FECHA_COMPRA_ACTUALIZAR).conValor(VALOR_ACTUALIZAR).build();

        // act - assert
        mocMvc.perform(put("/tiquetes/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(tiquete)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 3L;

        // act - assert
        mocMvc.perform(delete("/tiquetes/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}

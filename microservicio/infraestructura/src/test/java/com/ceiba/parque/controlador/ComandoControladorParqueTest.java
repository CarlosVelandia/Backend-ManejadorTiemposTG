package com.ceiba.parque.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.parque.comando.ComandoParque;
import com.ceiba.parque.testdatabuilder.ComandoParqueTestDataBuilder;
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
@WebMvcTest(ComandoControladorParque.class)
public class ComandoControladorParqueTest {

    private static final String NOMBRE_PARQUE_NUEVO="Nuevo Parque";
    private static final String CODIGO_PARQUE_NUEVO="654321";
    private static final String DIRECCION_PARQUE_NUEVO="Cra test # 4-56";
    private static final String TELEFONO_PARQUE_NUEVO="654321";

    private static final String NOMBRE_PARQUE_ACTUALIZAR="Actualizar Parque";
    private static final String CODIGO_PARQUE_ACTUALIZAR="000000";
    private static final String DIRECCION_PARQUE_ACTUALIZAR="Cra actualizar # 12-34";
    private static final String TELEFONO_PARQUE_ACTUALIZAR="9999999";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoParque parque = new ComandoParqueTestDataBuilder().conNombre(NOMBRE_PARQUE_NUEVO).conCodigo(CODIGO_PARQUE_NUEVO).conDireccion(DIRECCION_PARQUE_NUEVO).conTelefono(TELEFONO_PARQUE_NUEVO).build();

        // act - assert
        mocMvc.perform(post("/parques")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(parque)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 4 }"));
    }

    @Test
    public void actualizar() throws Exception {
        // arrange
        Long id = 2L;
        ComandoParque parque = new ComandoParqueTestDataBuilder().conNombre(NOMBRE_PARQUE_ACTUALIZAR).conCodigo(CODIGO_PARQUE_ACTUALIZAR).conDireccion(DIRECCION_PARQUE_ACTUALIZAR).conTelefono(TELEFONO_PARQUE_ACTUALIZAR).build();

        // act - assert
        mocMvc.perform(put("/parques/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(parque)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 3L;

        // act - assert
        mocMvc.perform(delete("/parques/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}

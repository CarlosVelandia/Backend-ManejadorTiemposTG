package com.ceiba.etapa.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.etapa.comando.ComandoEtapa;
import com.ceiba.etapa.testdatabuilder.ComandoEtapaTestDataBuilder;
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
@WebMvcTest(ComandoControladorEtapa.class)
public class ComandoControladorEtapaTest {

    private static final String NOMBRE_ETAPA_NUEVO="Nuevo Etapa";
    private static final String CODIGO_ETAPA_NUEVO="654321";
    private static final String DIRECCION_ETAPA_NUEVO="Cra test # 4-56";
    private static final String TELEFONO_ETAPA_NUEVO="654321";

    private static final String NOMBRE_ETAPA_ACTUALIZAR="Actualizar Etapa";
    private static final String CODIGO_ETAPA_ACTUALIZAR="000000";
    private static final String DIRECCION_ETAPA_ACTUALIZAR="Cra actualizar # 12-34";
    private static final String TELEFONO_ETAPA_ACTUALIZAR="9999999";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoEtapa etapa = new ComandoEtapaTestDataBuilder().conNombre(NOMBRE_ETAPA_NUEVO).conCodigo(CODIGO_ETAPA_NUEVO).conDireccion(DIRECCION_ETAPA_NUEVO).conTelefono(TELEFONO_ETAPA_NUEVO).build();

        // act - assert
        mocMvc.perform(post("/etapas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(etapa)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 4 }"));
    }

    @Test
    public void actualizar() throws Exception {
        // arrange
        Long id = 2L;
        ComandoEtapa etapa = new ComandoEtapaTestDataBuilder().conNombre(NOMBRE_ETAPA_ACTUALIZAR).conCodigo(CODIGO_ETAPA_ACTUALIZAR).conDireccion(DIRECCION_ETAPA_ACTUALIZAR).conTelefono(TELEFONO_ETAPA_ACTUALIZAR).build();

        // act - assert
        mocMvc.perform(put("/etapas/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(etapa)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 3L;

        // act - assert
        mocMvc.perform(delete("/etapas/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}

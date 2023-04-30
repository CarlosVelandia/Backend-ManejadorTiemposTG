package com.ceiba.usuario.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.testdatabuilder.ComandoUsuarioTestDataBuilder;
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
@WebMvcTest(ComandoControladorUsuario.class)
public class ComandoControladorUsuarioTest {

    private static final String CEDULA_USUARIO_NUEVO = "123456789";
    private static final String NOMBRE_USUARIO_NUEVO = "Nuevo Pensonaje";
    private static final String CEDULA_USUARIO_ACTUALIZAR = "987654321";
    private static final String NOMBRE_USUARIO_ACTUALIZAR = "Actualizar Pensonaje";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception {
        // arrange
        ComandoUsuario usuario = new ComandoUsuarioTestDataBuilder().conNombre(NOMBRE_USUARIO_NUEVO).conCedula(CEDULA_USUARIO_NUEVO).build();

        // act - assert
        mocMvc.perform(post("/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuario)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 4 }"));
    }

    @Test
    public void actualizar() throws Exception {
        // arrange
        Long id = 3L;
        ComandoUsuario usuario = new ComandoUsuarioTestDataBuilder()
                .conNombre(NOMBRE_USUARIO_ACTUALIZAR)
                .conCedula(CEDULA_USUARIO_ACTUALIZAR)
                .build();

        // act - assert
        mocMvc.perform(put("/usuarios/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 2L;

        // act - assert
        mocMvc.perform(delete("/usuarios/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}

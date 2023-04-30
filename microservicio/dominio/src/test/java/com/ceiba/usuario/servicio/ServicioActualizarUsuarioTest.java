package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.usuario.excepcion.ExcepcionUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ServicioActualizarUsuarioTest {

    private static final String EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA = "El usuario no existe en el sistema";

    @Mock
    private RepositorioUsuario repositorioUsuario;

    @InjectMocks
    private ServicioActualizarUsuario servicioActualizarUsuario;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarExistenciaPreviaUsuario() {
        //arrange
        Usuario usuario = new UsuarioTestDataBuilder().build();
        Mockito.when(repositorioUsuario.existeId(usuario.getId())).thenReturn(false);
        //act - assert
        BasePrueba.assertThrows(() -> servicioActualizarUsuario.ejecutar(usuario), ExcepcionUsuario.class, EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarActualizarUsuarioTest() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().conId(1l).build();
        Mockito.when(repositorioUsuario.existeId(usuario.getId())).thenReturn(true);
        // act - assert
        servicioActualizarUsuario.ejecutar(usuario);
        // assert
        Mockito.verify(repositorioUsuario).actualizar(usuario);
    }
}
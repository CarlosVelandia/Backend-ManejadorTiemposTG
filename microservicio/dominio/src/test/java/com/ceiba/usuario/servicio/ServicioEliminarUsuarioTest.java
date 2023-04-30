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

public class ServicioEliminarUsuarioTest {

    private static final String El_USUARIO_NO_EXISTE = "El usuario no existe en el sistema";

    @Mock
    private RepositorioUsuario repositorioUsuario;

    @InjectMocks
    private ServicioEliminarUsuario servicioEliminarUsuario;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarExistenciaPreviaUsuario() {
        //arrange
        Usuario usuario = new UsuarioTestDataBuilder().build();
        Mockito.when(repositorioUsuario.existeExcluyendoId(usuario.getId(), usuario.getCedula())).thenReturn(false);
        //act - assert
        BasePrueba.assertThrows(() -> servicioEliminarUsuario.ejecutar(usuario.getId()), ExcepcionUsuario.class, El_USUARIO_NO_EXISTE);
    }

    @Test
    public void validarEliminarUsuarioTest() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().build();
        Mockito.when(repositorioUsuario.existeId(usuario.getId())).thenReturn(true);
        // act - assert
        servicioEliminarUsuario.ejecutar(usuario.getId());
        // assert
        Mockito.verify(repositorioUsuario).eliminar(usuario.getId());
    }
}

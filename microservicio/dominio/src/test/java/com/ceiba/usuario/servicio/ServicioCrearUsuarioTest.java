package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
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

public class ServicioCrearUsuarioTest {

    private static final String SE_DEBE_INGRESAR_LA_CEDULA = "Se debe ingresar la cedula";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";
    private static final String LA_CEDULA_DEBE_SER_NUMERICA = "La Cedula debe ser numerica, no debe contener simbolos, ni espacios";
    private static final String LA_CEDULA_DEBE_SER_POSITIVA = "La Cedula debe ser numerica positiva";
    private static final String EL_USUARIO_YA_EXISTE = "EL usuario ya existe en el sistema";
    private static final String LA_CEDULA_YA_EXISTE = "El usuario ya existe en el sistema con la cedula";
    private static final String EL_NOMBRE_DEBE_SER_TEXTO = "El nombre solo puede contener letas, sin numeros ni simbolos";


    @Mock
    private RepositorioUsuario repositorioUsuario;

    @InjectMocks
    private ServicioCrearUsuario servicioCrearUsuario;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarNombreObligatorioTest() {
        // arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conNombre(null);
        // act - assert
        BasePrueba.assertThrows(() -> usuarioTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
    }

    @Test
    public void validarCedulaObligatorioTest() {
        // arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conCedula(null);
        // act - assert
        BasePrueba.assertThrows(() -> usuarioTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_CEDULA);
    }

    @Test
    public void validarCedulaNumericaTest() {
        // arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conCedula("numerous");
        // act - assert
        BasePrueba.assertThrows(() -> usuarioTestDataBuilder.build(), ExcepcionValorInvalido.class, LA_CEDULA_DEBE_SER_NUMERICA);
    }

    @Test
    public void validarCedulaNumericaPositivaTest() {
        // arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conCedula("-123456");
        // act - assert
        BasePrueba.assertThrows(() -> usuarioTestDataBuilder.build(), ExcepcionValorInvalido.class, LA_CEDULA_DEBE_SER_POSITIVA);
    }

    @Test
    public void validarValidarTextoNombre() {
        // arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conNombre("Test 123");
        // act - assert
        BasePrueba.assertThrows(() -> usuarioTestDataBuilder.build(), ExcepcionValorInvalido.class, EL_NOMBRE_DEBE_SER_TEXTO);
    }

    @Test
    public void validarExistenciaPreviaExcluyendoId() {
        //arrange
        Usuario usuario = new UsuarioTestDataBuilder().build();
        Mockito.when(repositorioUsuario.existeCedula(usuario.getCedula())).thenReturn(true);
        //act - assert
        BasePrueba.assertThrows(() -> servicioCrearUsuario.ejecutar(usuario), ExcepcionUsuario.class, LA_CEDULA_YA_EXISTE);
    }

    @Test
    public void validarExistenciaPreviaId() {
        //arrange
        Usuario usuario = new UsuarioTestDataBuilder().build();
        Mockito.when(repositorioUsuario.existeId(usuario.getId())).thenReturn(true);
        //act - assert
        BasePrueba.assertThrows(() -> servicioCrearUsuario.ejecutar(usuario), ExcepcionUsuario.class, EL_USUARIO_YA_EXISTE);
    }

    @Test
    public void validarCreacionUsuarioTest() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().conId(1l).build();
        Mockito.when(repositorioUsuario.existeId(usuario.getId())).thenReturn(false);
        Mockito.when(repositorioUsuario.crear(usuario)).thenReturn(1l);
        // act - assert
        Long idUsuario = servicioCrearUsuario.ejecutar(usuario);
        // assert
        BasePrueba.assertEqualsObject(usuario.getId(), idUsuario);
    }
}

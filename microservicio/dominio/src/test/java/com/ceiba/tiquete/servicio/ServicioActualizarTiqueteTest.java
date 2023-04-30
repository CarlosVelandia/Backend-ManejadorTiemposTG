package com.ceiba.tiquete.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.parque.puerto.respositorio.RepositorioParque;
import com.ceiba.tiquete.excepcion.ExcepcionTiquete;
import com.ceiba.tiquete.modelo.entidad.Tiquete;
import com.ceiba.tiquete.puerto.repositorio.RepositorioTiquete;
import com.ceiba.tiquete.servicio.testdatabuilder.TiqueteTestDataBuilder;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ServicioActualizarTiqueteTest {

    private static final String EL_PARQUE_NO_EXISTE = "El parque no existe";
    private static final String EL_TIQUETE_NO_EXISTE = "El tiquete no existe";
    private static final String EL_USUARIO_NO_EXISTE = "El suario no existe";
    private static final String LUNES_NO_SE_VENDEN_TIQUETES = "Los Lunes no se pueden vender tiquetes por mantenimiento del parque";
    private static final String FECHA_LUNES = "2021-03-08";
    private static final int TIQUETES_PERMITIDOS_POR_PARQUE = 14;
    private static final int TIQUETES_PERMITIDOS_POR_PERSONA = 4;
    private static final int MAXIMO_TIQUETES_POR_PERSONA = 5;
    private static final int MAXIMO_TIQUETES_POR_PARQUE = 15;
    private static final String LIMITE_TIQUETES_POR_PARQUE_ALCANZADO = "Solo se dispone de un maximo de 50 tiquetes por dia";
    private static final String LIMITE_TIQUETES_POR_PERSONA_ALCANZADO = "Solo se permite un maximo de 5 tiquetes por persona";
    private static final String FECHA_FIN_DE_SEMANA = "2021-03-13";
    private static final String FECHA_DIA_NORMAL = "2021-03-10";


    @Mock
    private RepositorioTiquete repositorioTiquete;

    @Mock
    private RepositorioUsuario repositorioUsuario;

    @Mock
    private RepositorioParque repositorioParque;


    @InjectMocks
    private ServicioActualizarTiquete servicioActualizarTiquete;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarExistenciaPreviaTiquete() {
        //arrange
        Tiquete tiquete = new TiqueteTestDataBuilder().build();
        Mockito.when(repositorioTiquete.existeId(tiquete.getId())).thenReturn(false);
        //act - assert
        BasePrueba.assertThrows(() -> servicioActualizarTiquete.ejecutar(tiquete), ExcepcionTiquete.class, EL_TIQUETE_NO_EXISTE);
    }

    @Test
    public void validarExistenciaPreviaUsuario() {
        //arrange
        Tiquete tiquete = new TiqueteTestDataBuilder().build();
        Mockito.when(repositorioTiquete.existeId(tiquete.getId())).thenReturn(true);
        Mockito.when(repositorioUsuario.existeId(tiquete.getIdUsuario())).thenReturn(false);
        //act - assert
        BasePrueba.assertThrows(() -> servicioActualizarTiquete.ejecutar(tiquete), ExcepcionTiquete.class, EL_USUARIO_NO_EXISTE);
    }

    @Test
    public void validarExistenciaPreviaParque() {
        //arrange
        Tiquete tiquete = new TiqueteTestDataBuilder().build();
        Mockito.when(repositorioTiquete.existeId(tiquete.getId())).thenReturn(true);
        Mockito.when(repositorioUsuario.existeId(tiquete.getIdUsuario())).thenReturn(true);
        Mockito.when(repositorioParque.existeId(tiquete.getIdParque())).thenReturn(false);
        //act - assert
        BasePrueba.assertThrows(() -> servicioActualizarTiquete.ejecutar(tiquete), ExcepcionTiquete.class, EL_PARQUE_NO_EXISTE);
    }

    @Test
    public void validarActualizacionTiqueteDiaLunes() {
        // arrange
        TiqueteTestDataBuilder tiqueteTestDataBuilder = new TiqueteTestDataBuilder().conFechaCompra(FECHA_LUNES);
        // act - assert
        BasePrueba.assertThrows(() -> tiqueteTestDataBuilder.build(), ExcepcionTiquete.class, LUNES_NO_SE_VENDEN_TIQUETES);
    }


/*    @Test
    public void validarActualizacionTiqueteDiaLunes() {
        // arrange
        Tiquete tiquete = new TiqueteTestDataBuilder().conFechaCompra(FECHA_LUNES).build();
        Mockito.when(repositorioTiquete.existeId(tiquete.getId())).thenReturn(true);
        Mockito.when(repositorioUsuario.existeId(tiquete.getIdUsuario())).thenReturn(true);
        Mockito.when(repositorioParque.existeId(tiquete.getIdParque())).thenReturn(true);
        Mockito.when(repositorioTiquete.existeTiqueteFechaYCedula(tiquete.getFechaCompra(), tiquete.getIdUsuario())).thenReturn(TIQUETES_PERMITIDOS_POR_PERSONA);
        Mockito.when(repositorioTiquete.maximoTiquetesVendidos(tiquete.getFechaCompra(), tiquete.getIdParque())).thenReturn(TIQUETES_PERMITIDOS_POR_PARQUE);

        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarTiquete.ejecutar(tiquete), ExcepcionTiquete.class, LUNES_NO_SE_VENDEN_TIQUETES);
    }*/

    @Test
    public void validarMaximoTiquetesPersonaTest() {
        // arrange
        Tiquete tiquete = new TiqueteTestDataBuilder().build();
        Mockito.when(repositorioTiquete.existeId(tiquete.getId())).thenReturn(true);
        Mockito.when(repositorioUsuario.existeId(tiquete.getIdUsuario())).thenReturn(true);
        Mockito.when(repositorioParque.existeId(tiquete.getIdParque())).thenReturn(true);
        Mockito.when(repositorioTiquete.existeTiqueteFechaYCedula(tiquete.getFechaCompra(), tiquete.getIdUsuario())).thenReturn(MAXIMO_TIQUETES_POR_PERSONA);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarTiquete.ejecutar(tiquete), ExcepcionTiquete.class, LIMITE_TIQUETES_POR_PERSONA_ALCANZADO);
    }

    @Test
    public void validarMaximoTiquetesParqueTest() {
        // arrange
        Tiquete tiquete = new TiqueteTestDataBuilder().build();
        Mockito.when(repositorioTiquete.existeId(tiquete.getId())).thenReturn(true);
        Mockito.when(repositorioUsuario.existeId(tiquete.getIdUsuario())).thenReturn(true);
        Mockito.when(repositorioParque.existeId(tiquete.getIdParque())).thenReturn(true);
        Mockito.when(repositorioTiquete.existeTiqueteFechaYCedula(tiquete.getFechaCompra(), tiquete.getIdUsuario())).thenReturn(TIQUETES_PERMITIDOS_POR_PERSONA);
        Mockito.when(repositorioTiquete.maximoTiquetesVendidos(tiquete.getFechaCompra(), tiquete.getIdParque())).thenReturn(MAXIMO_TIQUETES_POR_PARQUE);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarTiquete.ejecutar(tiquete), ExcepcionTiquete.class, LIMITE_TIQUETES_POR_PARQUE_ALCANZADO);
    }

    @Test
    public void validarCreacionTiqueteFinDeSemanaTest() {
        // arrange
        Tiquete tiquete = new TiqueteTestDataBuilder().conFechaCompra(FECHA_FIN_DE_SEMANA).build();
        Mockito.when(repositorioTiquete.existeId(tiquete.getId())).thenReturn(true);
        Mockito.when(repositorioUsuario.existeId(tiquete.getIdUsuario())).thenReturn(true);
        Mockito.when(repositorioParque.existeId(tiquete.getIdParque())).thenReturn(true);
        Mockito.when(repositorioTiquete.existeTiqueteFechaYCedula(tiquete.getFechaCompra(), tiquete.getIdUsuario())).thenReturn(TIQUETES_PERMITIDOS_POR_PERSONA);
        Mockito.when(repositorioTiquete.maximoTiquetesVendidos(tiquete.getFechaCompra(), tiquete.getIdParque())).thenReturn(TIQUETES_PERMITIDOS_POR_PARQUE);
        // act - assert
        servicioActualizarTiquete.ejecutar(tiquete);
        // assert
        Mockito.verify(repositorioTiquete).actualizar(tiquete);
    }

    @Test
    public void validarCreacionTiqueteDiaNormalTest() {
        // arrange
        Tiquete tiquete = new TiqueteTestDataBuilder().conFechaCompra(FECHA_DIA_NORMAL).build();
        Mockito.when(repositorioTiquete.existeId(tiquete.getId())).thenReturn(true);
        Mockito.when(repositorioUsuario.existeId(tiquete.getIdUsuario())).thenReturn(true);
        Mockito.when(repositorioParque.existeId(tiquete.getIdParque())).thenReturn(true);
        Mockito.when(repositorioTiquete.existeTiqueteFechaYCedula(tiquete.getFechaCompra(), tiquete.getIdUsuario())).thenReturn(TIQUETES_PERMITIDOS_POR_PERSONA);
        Mockito.when(repositorioTiquete.maximoTiquetesVendidos(tiquete.getFechaCompra(), tiquete.getIdParque())).thenReturn(TIQUETES_PERMITIDOS_POR_PARQUE);
        // act - assert
        servicioActualizarTiquete.ejecutar(tiquete);
        // assert
        Mockito.verify(repositorioTiquete).actualizar(tiquete);
    }

}
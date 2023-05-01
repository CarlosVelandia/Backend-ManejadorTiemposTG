package com.ceiba.proceso.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.parque.puerto.respositorio.RepositorioParque;
import com.ceiba.proceso.excepcion.ExcepcionProceso;
import com.ceiba.proceso.modelo.entidad.Proceso;
import com.ceiba.proceso.puerto.repositorio.RepositorioProceso;
import com.ceiba.proceso.servicio.testdatabuilder.ProcesoTestDataBuilder;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ServicioCrearProcesoTest {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_COMPRA = "Se debe ingresar la fecha de la compra";
    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_USUARIO = "Se debe ingresar el id del usuario";
    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_PARQUE = "Se debe ingresar el id del parque";
    private static final String EL_USUARIO_NO_EXISTE = "El suario no existe";
    private static final String EL_PARQUE_NO_EXISTE = "El parque no existe";
    private static final String LUNES_NO_SE_VENDEN_PROCESOS = "Los Lunes no se pueden vender procesos por mantenimiento del parque";
    private static final String LIMITE_PROCESOS_POR_PERSONA_ALCANZADO = "Solo se permite un maximo de 5 procesos por persona";
    private static final String LIMITE_PROCESOS_POR_PARQUE_ALCANZADO = "Solo se dispone de un maximo de 50 procesos por dia";
    private static final String FECHA_LUNES = "2021-03-08";
    private static final String FECHA_FIN_DE_SEMANA = "2021-03-13";
    private static final String FECHA_DIA_NORMAL = "2021-03-10";
    private static final int MAXIMO_PROCESOS_POR_PERSONA = 5;
    private static final int PROCESOS_PERMITIDOS_POR_PERSONA = 4;
    private static final int MAXIMO_PROCESOS_POR_PARQUE = 15;
    private static final int PROCESOS_PERMITIDOS_POR_PARQUE = 14;


    @Mock
    private RepositorioProceso repositorioProceso;

    @Mock
    private RepositorioUsuario repositorioUsuario;

    @Mock
    private RepositorioParque repositorioParque;

    @InjectMocks
    private ServicioCrearProceso servicioCrearProceso;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarIdUsuarioObligatorioTest() {
        // arrange
        ProcesoTestDataBuilder procesoTestDataBuilder = new ProcesoTestDataBuilder().conIdUsuario(null);
        // act - assert
        BasePrueba.assertThrows(() -> procesoTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_ID_DEL_USUARIO);
    }

    @Test
    public void validarIdParqueObligatorioTest() {
        // arrange
        ProcesoTestDataBuilder procesoTestDataBuilder = new ProcesoTestDataBuilder().conIdParque(null);
        // act - assert
        BasePrueba.assertThrows(() -> procesoTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_ID_DEL_PARQUE);
    }

    @Test
    public void validarFechaCompraObligatorioTest() {
        // arrange
        ProcesoTestDataBuilder procesoTestDataBuilder = new ProcesoTestDataBuilder().conFechaCompra(null);
        // act - assert
        BasePrueba.assertThrows(() -> procesoTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_FECHA_DE_COMPRA);
    }

    @Test
    public void validarDiaLunesTest() {
        // arrange
        ProcesoTestDataBuilder procesoTestDataBuilder = new ProcesoTestDataBuilder().conFechaCompra(FECHA_LUNES);
        // act - assert
        BasePrueba.assertThrows(() -> procesoTestDataBuilder.build(), ExcepcionProceso.class, LUNES_NO_SE_VENDEN_PROCESOS);
    }

    @Test
    public void validarExcepcionExistenciaUsuarioTest() {
        // arrange
        Proceso proceso = new ProcesoTestDataBuilder().build();
        Mockito.when(repositorioUsuario.existeId(proceso.getIdUsuario())).thenReturn(false);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearProceso.ejecutar(proceso), ExcepcionProceso.class, EL_USUARIO_NO_EXISTE);
    }

    @Test
    public void validarExcepcionExistenciaParqueTest() {
        // arrange
        Proceso proceso = new ProcesoTestDataBuilder().build();
        Mockito.when(repositorioUsuario.existeId(proceso.getIdUsuario())).thenReturn(true);
        Mockito.when(repositorioParque.existeId(proceso.getIdParque())).thenReturn(false);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearProceso.ejecutar(proceso), ExcepcionProceso.class, EL_PARQUE_NO_EXISTE);
    }

    @Test
    public void validarMaximoProcesosPersonaTest() {
        // arrange
        Proceso proceso = new ProcesoTestDataBuilder().build();
        Mockito.when(repositorioUsuario.existeId(proceso.getIdUsuario())).thenReturn(true);
        Mockito.when(repositorioParque.existeId(proceso.getIdParque())).thenReturn(true);
        Mockito.when(repositorioProceso.existeProcesoFechaYCedula(proceso.getFechaCompra(), proceso.getIdUsuario())).thenReturn(MAXIMO_PROCESOS_POR_PERSONA);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearProceso.ejecutar(proceso), ExcepcionProceso.class, LIMITE_PROCESOS_POR_PERSONA_ALCANZADO);
    }

    @Test
    public void validarMaximoProcesosParqueTest() {
        // arrange
        Proceso proceso = new ProcesoTestDataBuilder().build();
        Mockito.when(repositorioUsuario.existeId(proceso.getIdUsuario())).thenReturn(true);
        Mockito.when(repositorioParque.existeId(proceso.getIdParque())).thenReturn(true);
        Mockito.when(repositorioProceso.existeProcesoFechaYCedula(proceso.getFechaCompra(), proceso.getIdUsuario())).thenReturn(PROCESOS_PERMITIDOS_POR_PERSONA);
        Mockito.when(repositorioProceso.maximoProcesosVendidos(proceso.getFechaCompra(), proceso.getIdParque())).thenReturn(MAXIMO_PROCESOS_POR_PARQUE);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearProceso.ejecutar(proceso), ExcepcionProceso.class, LIMITE_PROCESOS_POR_PARQUE_ALCANZADO);
    }


    @Test
    public void validarCreacionProcesoFinDeSemanaTest() {
        // arrange
        Proceso proceso = new ProcesoTestDataBuilder().conFechaCompra(FECHA_FIN_DE_SEMANA).build();
        Mockito.when(repositorioUsuario.existeId(proceso.getIdUsuario())).thenReturn(true);
        Mockito.when(repositorioParque.existeId(proceso.getIdParque())).thenReturn(true);
        Mockito.when(repositorioProceso.existeProcesoFechaYCedula(proceso.getFechaCompra(), proceso.getIdUsuario())).thenReturn(PROCESOS_PERMITIDOS_POR_PERSONA);
        Mockito.when(repositorioProceso.maximoProcesosVendidos(proceso.getFechaCompra(), proceso.getIdParque())).thenReturn(PROCESOS_PERMITIDOS_POR_PARQUE);

        // act - assert
        Long idProceso = servicioCrearProceso.ejecutar(proceso);
        // assert
        BasePrueba.assertEqualsObject(proceso.getId(), idProceso);
    }

    @Test
    public void validarCreacionProcesoDiaNormalTest() {
        // arrange
        Proceso proceso = new ProcesoTestDataBuilder().conFechaCompra(FECHA_DIA_NORMAL).build();
        Mockito.when(repositorioUsuario.existeId(proceso.getIdUsuario())).thenReturn(true);
        Mockito.when(repositorioParque.existeId(proceso.getIdParque())).thenReturn(true);
        Mockito.when(repositorioProceso.existeProcesoFechaYCedula(proceso.getFechaCompra(), proceso.getIdUsuario())).thenReturn(PROCESOS_PERMITIDOS_POR_PERSONA);
        Mockito.when(repositorioProceso.maximoProcesosVendidos(proceso.getFechaCompra(), proceso.getIdParque())).thenReturn(PROCESOS_PERMITIDOS_POR_PARQUE);

        // act - assert
        Long idProceso = servicioCrearProceso.ejecutar(proceso);
        // assert
        BasePrueba.assertEqualsObject(proceso.getId(), idProceso);
    }
}

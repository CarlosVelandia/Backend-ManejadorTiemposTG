package com.ceiba.etapa.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.etapa.excepcion.ExcepcionEtapa;
import com.ceiba.etapa.modelo.entidad.Etapa;
import com.ceiba.etapa.puerto.respositorio.RepositorioEtapa;
import com.ceiba.etapa.servicio.testdatabuilder.EtapaTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ServicioCrearEtapaTest {

    private static final String SE_DEBE_INGRESAR_EL_TELEFONO = "Se debe ingresar el telefono del etapa";
    private static final String SE_DEBE_INGRESAR_LA_DIRECCION = "Se debe ingresar la direccion";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_ETAPA = "Se debe ingresar el nombre de usuario";
    private static final String SE_DEBE_INGRESAR_EL_CODIGO_DEL_ETAPA = "Se debe ingresar el codigo del etapa";
    private static final String EL_TELEFONO_DEBE_SER_NUMERICO = "La Telefono debe ser numerica, no debe contener simbolos, ni espacios";
    private static final String EL_TELEFONO_DEBE_SER_POSITIVO = "La Telefono debe ser numerica positiva";
    private static final String CODIGO_DEBE_SER_ALFANUMERICO = "El codigo debe ser Alfanumerico, no debe contener simbolos, ni espacios";
    private static final String EL_NOMBRE_DEBE_SER_TEXTO = "El nombre solo puede contener letas, sin numeros ni simbolos";


    private static final String EL_ETAPA_YA_EXISTE_EN_EL_SISTEMA = "El etapa ya existe en el sistema";
    private static final String EL_NOMBRE_DEL_ETAPA_YA_EXISTE_EN_EL_SISTEMA = "El nombre del etapa ya existe en el sistema";
    private static final String EL_CODIGO_DEL_ETAPA_YA_EXISTE_EN_EL_SISTEMA = "El codigo del etapa ya existe en el sistema";

    @Mock
    private RepositorioEtapa repositorioEtapa;

    @InjectMocks
    private ServicioCrearEtapa servicioCrearEtapa;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarCodigoObligatorioTest() {
        // arrange
        EtapaTestDataBuilder etapaTestDataBuilder = new EtapaTestDataBuilder().conCodigo(null);
        // act - assert
        BasePrueba.assertThrows(() -> etapaTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_CODIGO_DEL_ETAPA);
    }

    @Test
    public void validarNombreObligatorioTest() {
        // arrange
        EtapaTestDataBuilder etapaTestDataBuilder = new EtapaTestDataBuilder().conNombre(null);
        // act - assert
        BasePrueba.assertThrows(() -> etapaTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_ETAPA);
    }

    @Test
    public void validarDireccionObligatorioTest() {
        // arrange
        EtapaTestDataBuilder etapaTestDataBuilder = new EtapaTestDataBuilder().conDireccion(null);
        // act - assert
        BasePrueba.assertThrows(() -> etapaTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_DIRECCION);
    }

    @Test
    public void validarTelefonoObligatorioTest() {
        // arrange
        EtapaTestDataBuilder etapaTestDataBuilder = new EtapaTestDataBuilder().conTelefono(null);
        // act - assert
        BasePrueba.assertThrows(() -> etapaTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_TELEFONO);
    }

    @Test
    public void validarValidarTextoNombre() {
        // arrange
        EtapaTestDataBuilder etapaTestDataBuilder = new EtapaTestDataBuilder().conNombre("Test 123");
        // act - assert
        BasePrueba.assertThrows(() -> etapaTestDataBuilder.build(), ExcepcionValorInvalido.class, EL_NOMBRE_DEBE_SER_TEXTO);
    }

    @Test
    public void validarTelefonoNumericaTest() {
        // arrange
        EtapaTestDataBuilder etapaTestDataBuilder = new EtapaTestDataBuilder().conTelefono("numerous");
        // act - assert
        BasePrueba.assertThrows(() -> etapaTestDataBuilder.build(), ExcepcionValorInvalido.class, EL_TELEFONO_DEBE_SER_NUMERICO);
    }

    @Test
    public void validarTelefonoNumericoPositivoTest() {
        // arrange
        EtapaTestDataBuilder etapaTestDataBuilder = new EtapaTestDataBuilder().conTelefono("-123456");
        // act - assert
        BasePrueba.assertThrows(() -> etapaTestDataBuilder.build(), ExcepcionValorInvalido.class, EL_TELEFONO_DEBE_SER_POSITIVO);
    }

    @Test
    public void validarCodigoAlfanumericoTest() {
        // arrange
        EtapaTestDataBuilder etapaTestDataBuilder = new EtapaTestDataBuilder().conCodigo("codigo123456@");
        // act - assert
        BasePrueba.assertThrows(() -> etapaTestDataBuilder.build(), ExcepcionValorInvalido.class, CODIGO_DEBE_SER_ALFANUMERICO);
    }

    @Test
    public void validarExistenciaPreviaNombre() {
        //arrange
        Etapa etapa = new EtapaTestDataBuilder().build();
        Mockito.when(repositorioEtapa.existe(etapa.getNombre())).thenReturn(true);
        //act - assert
        BasePrueba.assertThrows(() -> servicioCrearEtapa.ejecutar(etapa), ExcepcionEtapa.class, EL_NOMBRE_DEL_ETAPA_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarExistenciaPreviaCodigo() {
        //arrange
        Etapa etapa = new EtapaTestDataBuilder().build();
        Mockito.when(repositorioEtapa.existeCodigo(etapa.getCodigo())).thenReturn(true);
        //act - assert
        BasePrueba.assertThrows(() -> servicioCrearEtapa.ejecutar(etapa), ExcepcionEtapa.class, EL_CODIGO_DEL_ETAPA_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarExistenciaPreviaId() {
        //arrange
        Etapa etapa = new EtapaTestDataBuilder().build();
        Mockito.when(repositorioEtapa.existeId(etapa.getId())).thenReturn(true);
        //act - assert
        BasePrueba.assertThrows(() -> servicioCrearEtapa.ejecutar(etapa), ExcepcionEtapa.class, EL_ETAPA_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarCreacionEtapaTest() {
        // arrange
        Etapa etapa = new EtapaTestDataBuilder().conId(1l).build();
        Mockito.when(repositorioEtapa.existe(etapa.getNombre())).thenReturn(false);
        Mockito.when(repositorioEtapa.existeCodigo(etapa.getCodigo())).thenReturn(false);
        Mockito.when(repositorioEtapa.existeId(etapa.getId())).thenReturn(false);
        Mockito.when(repositorioEtapa.crear(etapa)).thenReturn(1l);
        // act - assert
        Long idEtapa = servicioCrearEtapa.ejecutar(etapa);
        // assert
        BasePrueba.assertEqualsObject(etapa.getId(), idEtapa);
    }
}

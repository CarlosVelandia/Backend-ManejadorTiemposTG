package com.ceiba.parque.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.parque.excepcion.ExcepcionParque;
import com.ceiba.parque.modelo.entidad.Parque;
import com.ceiba.parque.puerto.respositorio.RepositorioParque;
import com.ceiba.parque.servicio.testdatabuilder.ParqueTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ServicioCrearParqueTest {

    private static final String SE_DEBE_INGRESAR_EL_TELEFONO = "Se debe ingresar el telefono del parque";
    private static final String SE_DEBE_INGRESAR_LA_DIRECCION = "Se debe ingresar la direccion";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PARQUE = "Se debe ingresar el nombre de usuario";
    private static final String SE_DEBE_INGRESAR_EL_CODIGO_DEL_PARQUE = "Se debe ingresar el codigo del parque";
    private static final String EL_TELEFONO_DEBE_SER_NUMERICO = "La Telefono debe ser numerica, no debe contener simbolos, ni espacios";
    private static final String EL_TELEFONO_DEBE_SER_POSITIVO = "La Telefono debe ser numerica positiva";
    private static final String CODIGO_DEBE_SER_ALFANUMERICO = "El codigo debe ser Alfanumerico, no debe contener simbolos, ni espacios";
    private static final String EL_NOMBRE_DEBE_SER_TEXTO = "El nombre solo puede contener letas, sin numeros ni simbolos";


    private static final String EL_PARQUE_YA_EXISTE_EN_EL_SISTEMA = "El parque ya existe en el sistema";
    private static final String EL_NOMBRE_DEL_PARQUE_YA_EXISTE_EN_EL_SISTEMA = "El nombre del parque ya existe en el sistema";
    private static final String EL_CODIGO_DEL_PARQUE_YA_EXISTE_EN_EL_SISTEMA = "El codigo del parque ya existe en el sistema";

    @Mock
    private RepositorioParque repositorioParque;

    @InjectMocks
    private ServicioCrearParque servicioCrearParque;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarCodigoObligatorioTest() {
        // arrange
        ParqueTestDataBuilder parqueTestDataBuilder = new ParqueTestDataBuilder().conCodigo(null);
        // act - assert
        BasePrueba.assertThrows(() -> parqueTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_CODIGO_DEL_PARQUE);
    }

    @Test
    public void validarNombreObligatorioTest() {
        // arrange
        ParqueTestDataBuilder parqueTestDataBuilder = new ParqueTestDataBuilder().conNombre(null);
        // act - assert
        BasePrueba.assertThrows(() -> parqueTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PARQUE);
    }

    @Test
    public void validarDireccionObligatorioTest() {
        // arrange
        ParqueTestDataBuilder parqueTestDataBuilder = new ParqueTestDataBuilder().conDireccion(null);
        // act - assert
        BasePrueba.assertThrows(() -> parqueTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_DIRECCION);
    }

    @Test
    public void validarTelefonoObligatorioTest() {
        // arrange
        ParqueTestDataBuilder parqueTestDataBuilder = new ParqueTestDataBuilder().conTelefono(null);
        // act - assert
        BasePrueba.assertThrows(() -> parqueTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_TELEFONO);
    }

    @Test
    public void validarValidarTextoNombre() {
        // arrange
        ParqueTestDataBuilder parqueTestDataBuilder = new ParqueTestDataBuilder().conNombre("Test 123");
        // act - assert
        BasePrueba.assertThrows(() -> parqueTestDataBuilder.build(), ExcepcionValorInvalido.class, EL_NOMBRE_DEBE_SER_TEXTO);
    }

    @Test
    public void validarTelefonoNumericaTest() {
        // arrange
        ParqueTestDataBuilder parqueTestDataBuilder = new ParqueTestDataBuilder().conTelefono("numerous");
        // act - assert
        BasePrueba.assertThrows(() -> parqueTestDataBuilder.build(), ExcepcionValorInvalido.class, EL_TELEFONO_DEBE_SER_NUMERICO);
    }

    @Test
    public void validarTelefonoNumericoPositivoTest() {
        // arrange
        ParqueTestDataBuilder parqueTestDataBuilder = new ParqueTestDataBuilder().conTelefono("-123456");
        // act - assert
        BasePrueba.assertThrows(() -> parqueTestDataBuilder.build(), ExcepcionValorInvalido.class, EL_TELEFONO_DEBE_SER_POSITIVO);
    }

    @Test
    public void validarCodigoAlfanumericoTest() {
        // arrange
        ParqueTestDataBuilder parqueTestDataBuilder = new ParqueTestDataBuilder().conCodigo("codigo123456@");
        // act - assert
        BasePrueba.assertThrows(() -> parqueTestDataBuilder.build(), ExcepcionValorInvalido.class, CODIGO_DEBE_SER_ALFANUMERICO);
    }

    @Test
    public void validarExistenciaPreviaNombre() {
        //arrange
        Parque parque = new ParqueTestDataBuilder().build();
        Mockito.when(repositorioParque.existe(parque.getNombre())).thenReturn(true);
        //act - assert
        BasePrueba.assertThrows(() -> servicioCrearParque.ejecutar(parque), ExcepcionParque.class, EL_NOMBRE_DEL_PARQUE_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarExistenciaPreviaCodigo() {
        //arrange
        Parque parque = new ParqueTestDataBuilder().build();
        Mockito.when(repositorioParque.existeCodigo(parque.getCodigo())).thenReturn(true);
        //act - assert
        BasePrueba.assertThrows(() -> servicioCrearParque.ejecutar(parque), ExcepcionParque.class, EL_CODIGO_DEL_PARQUE_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarExistenciaPreviaId() {
        //arrange
        Parque parque = new ParqueTestDataBuilder().build();
        Mockito.when(repositorioParque.existeId(parque.getId())).thenReturn(true);
        //act - assert
        BasePrueba.assertThrows(() -> servicioCrearParque.ejecutar(parque), ExcepcionParque.class, EL_PARQUE_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarCreacionParqueTest() {
        // arrange
        Parque parque = new ParqueTestDataBuilder().conId(1l).build();
        Mockito.when(repositorioParque.existe(parque.getNombre())).thenReturn(false);
        Mockito.when(repositorioParque.existeCodigo(parque.getCodigo())).thenReturn(false);
        Mockito.when(repositorioParque.existeId(parque.getId())).thenReturn(false);
        Mockito.when(repositorioParque.crear(parque)).thenReturn(1l);
        // act - assert
        Long idParque = servicioCrearParque.ejecutar(parque);
        // assert
        BasePrueba.assertEqualsObject(parque.getId(), idParque);
    }
}

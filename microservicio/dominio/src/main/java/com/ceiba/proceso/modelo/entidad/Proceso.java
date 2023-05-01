package com.ceiba.proceso.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.proceso.excepcion.ExcepcionProceso;
import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.ceiba.dominio.ValidadorArgumento.validarNumerico;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Proceso {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_COMPRA = "Se debe ingresar la fecha de la compra";
    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_USUARIO = "Se debe ingresar el id del usuario";
    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_PARQUE = "Se debe ingresar el id del parque";
    private static final String EL_ID_USUARIO_DEBE_SER_NUMERICO = "La Cedula debe ser numerica, no debe contener simbolos, ni espacios";
    private static final String EL_ID_PARQUE_DEBE_SER_NUMERICO = "La Cedula debe ser numerica, no debe contener simbolos, ni espacios";

    private static final String LUNES_NO_SE_VENDEN_PROCESOS = "Los Lunes no se pueden vender procesos por mantenimiento del parque";
    private static final String LIMITE_PROCESOS_POR_PERSONA_ALCANZADO = "Solo se permite un maximo de 5 procesos por persona";
    private static final String LIMITE_PROCESOS_POR_PARQUE_ALCANZADO = "Solo se dispone de un maximo de 50 procesos por dia";
    private static final double VALOR_PROCESO_SEMANA = 15000;
    private static final double VALOR_PROCESO_FIN_DE_SEMANA = 30000;

    private static final String FORMATO_FECHA = "yyyy-MM-dd";
    private static final String FORMATO_DE_FECHA_DE_COMPRA_INCORRECTA = "Formato de fecha de compra es incorrecta";
    private static final String LA_FECHA_DE_COMPRA_INVALIDA = "La fecha de compra es invalida";


    private Long id;
    private Long idUsuario;
    private Long idParque;
    private LocalDate fechaCompra;
    private double valor;

    public Proceso(Long id, Long idUsuario, Long idParque, String fechaCompra, Double valor) {

        this.valor=valor;

        validarObligatorio(idUsuario, SE_DEBE_INGRESAR_EL_ID_DEL_USUARIO);
        validarObligatorio(idParque, SE_DEBE_INGRESAR_EL_ID_DEL_PARQUE);
        validarObligatorio(fechaCompra, SE_DEBE_INGRESAR_LA_FECHA_DE_COMPRA);
        validarNumerico(Long.toString(idUsuario), EL_ID_USUARIO_DEBE_SER_NUMERICO);
        validarNumerico(Long.toString(idParque), EL_ID_PARQUE_DEBE_SER_NUMERICO);
        validarFormatoFecha(darFormatoFecha(fechaCompra), FORMATO_DE_FECHA_DE_COMPRA_INCORRECTA);
        validarFechaCorrecta(darFormatoFecha(fechaCompra), LA_FECHA_DE_COMPRA_INVALIDA);
        LocalDate fechaCompraFinal = obtenerLocalDateDesdeUnString(fechaCompra);
        validarFinDeSemana(fechaCompraFinal);
        validarDiaLunes(fechaCompraFinal);

        this.id = id;
        this.idUsuario = idUsuario;
        this.idParque = idParque;
        this.fechaCompra = fechaCompraFinal;

    }

    private static void validarDiaLunes(LocalDate fechaCompra) {
        if (fechaCompra.getDayOfWeek() == DayOfWeek.MONDAY) {
            throw new ExcepcionProceso(LUNES_NO_SE_VENDEN_PROCESOS);
        }
    }

    private void validarFinDeSemana(LocalDate fechaCompra) {
        if (fechaCompra.getDayOfWeek() == DayOfWeek.FRIDAY
                || fechaCompra.getDayOfWeek() == DayOfWeek.SATURDAY
                || fechaCompra.getDayOfWeek() == DayOfWeek.SUNDAY) {
            setValor(VALOR_PROCESO_FIN_DE_SEMANA);
        } else {
            setValor(VALOR_PROCESO_SEMANA);
        }
    }

    private static void validarFechaCorrecta(String valor, String mensaje){
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat(FORMATO_FECHA);
            formatoFecha.setLenient(false);
            formatoFecha.parse(valor);
        } catch (ParseException parseException) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }
    private static void validarFormatoFecha(String valor, String mensaje) {

        Pattern patronFecha = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
        Matcher comparadorFormatoFecha = patronFecha.matcher(valor);
        if (!comparadorFormatoFecha.matches()) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    private LocalDate obtenerLocalDateDesdeUnString(String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATO_FECHA);
        return LocalDate.parse(fecha, formatter);
    }

    private String darFormatoFecha(String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATO_FECHA);
        return formatter.format(LocalDate.parse(fecha, formatter));
    }
}

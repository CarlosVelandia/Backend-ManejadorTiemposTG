package com.ceiba.etapa.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Etapa {

    private static final String SE_DEBE_INGRESAR_EL_TELEFONO = "Se debe ingresar el telefono del etapa";
    private static final String SE_DEBE_INGRESAR_LA_DIRECCION = "Se debe ingresar la direccion";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_ETAPA = "Se debe ingresar el nombre de usuario";
    private static final String SE_DEBE_INGRESAR_EL_CODIGO_DEL_ETAPA = "Se debe ingresar el codigo del etapa";
    private static final String EL_TELEFONO_DEBE_SER_NUMERICO = "La Telefono debe ser numerica, no debe contener simbolos, ni espacios";
    private static final String EL_TELEFONO_DEBE_SER_POSITIVO = "La Telefono debe ser numerica positiva";
    private static final String CODIGO_DEBE_SER_ALFANUMERICO = "El codigo debe ser Alfanumerico, no debe contener simbolos, ni espacios";
    private static final String EL_NOMBRE_DEBE_SER_TEXTO = "El nombre solo puede contener letas, sin numeros ni simbolos";


    private Long id;
    private String nombre;
    private String codigo;
    private String direccion;
    private String telefono;

    public Etapa(Long id, String nombre, String codigo, String direccion, String telefono) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_ETAPA);
        validarObligatorio(codigo, SE_DEBE_INGRESAR_EL_CODIGO_DEL_ETAPA);
        validarObligatorio(direccion, SE_DEBE_INGRESAR_LA_DIRECCION);
        validarObligatorio(telefono, SE_DEBE_INGRESAR_EL_TELEFONO);

        validarSoloLetras(nombre, EL_NOMBRE_DEBE_SER_TEXTO);
        validarNumerico(telefono, EL_TELEFONO_DEBE_SER_NUMERICO);
        validarPositivo(Double.parseDouble(telefono), EL_TELEFONO_DEBE_SER_POSITIVO);
        validarAlfanumerico(codigo, CODIGO_DEBE_SER_ALFANUMERICO);

        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.direccion = direccion;
        this.telefono = telefono;
    }
}

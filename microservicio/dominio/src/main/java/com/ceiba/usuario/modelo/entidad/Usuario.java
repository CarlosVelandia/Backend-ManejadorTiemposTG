package com.ceiba.usuario.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Usuario {

    private static final String SE_DEBE_INGRESAR_LA_CEDULA = "Se debe ingresar la cedula";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";
    private static final String LA_CEDULA_DEBE_SER_NUMERICO = "La Cedula debe ser numerica, no debe contener simbolos, ni espacios";
    private static final String LA_CEDULA_DEBE_SER_POSITIVA = "La Cedula debe ser numerica positiva";
    private static final String EL_NOMBRE_DEBE_SER_TEXTO = "El nombre solo puede contener letas, sin numeros ni simbolos";

    private Long id;
    private String nombre;
    private String cedula;

    public Usuario(Long id, String nombre, String cedula) {

        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(cedula, SE_DEBE_INGRESAR_LA_CEDULA);
        validarNumerico(cedula, LA_CEDULA_DEBE_SER_NUMERICO);
        validarPositivo(Double.parseDouble(cedula), LA_CEDULA_DEBE_SER_POSITIVA);
        validarSoloLetras(nombre, EL_NOMBRE_DEBE_SER_TEXTO);

        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
    }
}

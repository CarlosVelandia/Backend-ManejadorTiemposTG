package com.ceiba.proceso.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.etapa.modelo.dto.DtoEtapa;
import com.ceiba.proceso.modelo.dto.DtoProceso;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoProceso implements RowMapper<DtoProceso>, MapperResult {
    @Override
    public DtoProceso mapRow(ResultSet resultSet, int rowNum) throws SQLException {


        Long id = resultSet.getLong("id");
        LocalDate fechaCompra = extraerLocalDate(resultSet, "fecha_compra");
        double valor = resultSet.getDouble("valor");

        Long idUsuario = resultSet.getLong("id_usuario");
        String nombreUsuario = resultSet.getString("nombre_usuario");
        String cedula = resultSet.getString("cedula");

        Long idEtapa = resultSet.getLong("id_etapa");
        String nombreEtapa = resultSet.getString("nombre_etapa");
        String codigo = resultSet.getString("codigo");
        String direccion = resultSet.getString("direccion");
        String telefono = resultSet.getString("telefono");

        DtoUsuario usuario = new DtoUsuario(idUsuario, nombreUsuario, cedula);
        DtoEtapa etapa = new DtoEtapa(idEtapa, nombreEtapa, codigo, direccion, telefono);

        return new DtoProceso(id, usuario, etapa, fechaCompra, valor);
    }
}

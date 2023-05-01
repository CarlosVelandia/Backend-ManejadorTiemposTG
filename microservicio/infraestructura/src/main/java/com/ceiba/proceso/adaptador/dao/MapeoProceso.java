package com.ceiba.proceso.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.parque.modelo.dto.DtoParque;
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

        Long idParque = resultSet.getLong("id_parque");
        String nombreParque = resultSet.getString("nombre_parque");
        String codigo = resultSet.getString("codigo");
        String direccion = resultSet.getString("direccion");
        String telefono = resultSet.getString("telefono");

        DtoUsuario usuario = new DtoUsuario(idUsuario, nombreUsuario, cedula);
        DtoParque parque = new DtoParque(idParque, nombreParque, codigo, direccion, telefono);

        return new DtoProceso(id, usuario, parque, fechaCompra, valor);
    }
}

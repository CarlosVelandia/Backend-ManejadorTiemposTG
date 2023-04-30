package com.ceiba.parque.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.parque.modelo.dto.DtoParque;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoParque implements RowMapper<DtoParque>, MapperResult {

    @Override
    public DtoParque mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre_parque");
        String codigo = resultSet.getString("codigo");
        String direccion = resultSet.getString("direccion");
        String telefono = resultSet.getString("telefono");

        return new DtoParque(id, nombre, codigo, direccion, telefono);
    }
}

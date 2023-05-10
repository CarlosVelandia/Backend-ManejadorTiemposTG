package com.ceiba.etapa.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.etapa.modelo.dto.DtoEtapa;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoEtapa implements RowMapper<DtoEtapa>, MapperResult {

    @Override
    public DtoEtapa mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre_etapa");
        String codigo = resultSet.getString("codigo");
        String direccion = resultSet.getString("direccion");
        String telefono = resultSet.getString("telefono");

        return new DtoEtapa(id, nombre, codigo, direccion, telefono);
    }
}

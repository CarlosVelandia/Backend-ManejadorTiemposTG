package com.ceiba.tiquete.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.tiquete.modelo.dto.DtoTiquete;
import com.ceiba.tiquete.puerto.dao.DaoTiquete;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoTiqueteMysql implements DaoTiquete {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "tiquete", value = "listar")
    private static String sqlListar;

    public DaoTiqueteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoTiquete> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoTiquete());
    }
}

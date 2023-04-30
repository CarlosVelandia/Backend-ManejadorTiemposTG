package com.ceiba.parque.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.parque.modelo.dto.DtoParque;
import com.ceiba.parque.puerto.dao.DaoParque;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoParqueMysql implements DaoParque {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "parque", value = "listar")
    private static String sqlListar;

    public DaoParqueMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoParque> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoParque());
    }
}

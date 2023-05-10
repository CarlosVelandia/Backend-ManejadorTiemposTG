package com.ceiba.etapa.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.etapa.modelo.dto.DtoEtapa;
import com.ceiba.etapa.puerto.dao.DaoEtapa;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoEtapaMysql implements DaoEtapa {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "etapa", value = "listar")
    private static String sqlListar;

    public DaoEtapaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoEtapa> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoEtapa());
    }
}

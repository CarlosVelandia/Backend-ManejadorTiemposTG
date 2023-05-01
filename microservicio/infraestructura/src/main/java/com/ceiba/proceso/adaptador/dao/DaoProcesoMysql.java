package com.ceiba.proceso.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.proceso.modelo.dto.DtoProceso;
import com.ceiba.proceso.puerto.dao.DaoProceso;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoProcesoMysql implements DaoProceso {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "proceso", value = "listar")
    private static String sqlListar;

    public DaoProcesoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoProceso> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoProceso());
    }
}

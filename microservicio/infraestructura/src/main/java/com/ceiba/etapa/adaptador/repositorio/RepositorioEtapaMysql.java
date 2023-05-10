package com.ceiba.etapa.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.etapa.modelo.entidad.Etapa;
import com.ceiba.etapa.puerto.respositorio.RepositorioEtapa;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioEtapaMysql implements RepositorioEtapa {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "etapa", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "etapa", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "etapa", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "etapa", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "etapa", value = "existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    @SqlStatement(namespace = "etapa", value = "existeId")
    private static String sqlExisteId;

    @SqlStatement(namespace = "etapa", value = "existeCodigo")
    private static String sqlExisteCodigo;

    public RepositorioEtapaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Etapa etapa) {
        return this.customNamedParameterJdbcTemplate.crear(etapa, sqlCrear);
    }

    @Override
    public void actualizar(Etapa etapa) {
        this.customNamedParameterJdbcTemplate.actualizar(etapa, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String codigo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("codigo", codigo);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId, paramSource, Boolean.class);
    }

    @Override
    public boolean existeId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteId,
                paramSource, Boolean.class);
    }

    @Override
    public boolean existeCodigo(String codigo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("codigo", codigo);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteCodigo, paramSource, Boolean.class);
    }
}

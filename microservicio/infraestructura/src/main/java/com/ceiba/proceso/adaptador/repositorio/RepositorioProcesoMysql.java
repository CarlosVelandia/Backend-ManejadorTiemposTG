package com.ceiba.proceso.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.proceso.modelo.entidad.Proceso;
import com.ceiba.proceso.puerto.repositorio.RepositorioProceso;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class RepositorioProcesoMysql implements RepositorioProceso {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "proceso", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "proceso", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "proceso", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "proceso", value = "existeProcesoFechaYCedula")
    private static String sqlExisteProcesoFechaYCedula;

    @SqlStatement(namespace = "proceso", value = "maximoProcesosVendidos")
    private static String sqlMaximoProcesosVendidos;

    @SqlStatement(namespace = "proceso", value = "existeId")
    private static String sqlExisteId;


    public RepositorioProcesoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Proceso proceso) {
        return this.customNamedParameterJdbcTemplate.crear(proceso, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public void actualizar(Proceso proceso) {
        this.customNamedParameterJdbcTemplate.actualizar(proceso, sqlActualizar);
    }

    @Override
    public int existeProcesoFechaYCedula(LocalDate fechaCompra, Long idUsuario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("fechaCompra", fechaCompra);
        paramSource.addValue("idUsuario", idUsuario);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteProcesoFechaYCedula, paramSource, Integer.class);
    }

    @Override
    public int maximoProcesosVendidos(LocalDate fechaCompra, Long idParque) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("fechaCompra", fechaCompra);
        paramSource.addValue("idParque", idParque);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlMaximoProcesosVendidos, paramSource, Integer.class);
    }

    @Override
    public boolean existeId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteId, paramSource, Boolean.class);
    }

}

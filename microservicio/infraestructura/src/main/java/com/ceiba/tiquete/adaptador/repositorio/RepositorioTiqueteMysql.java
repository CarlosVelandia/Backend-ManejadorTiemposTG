package com.ceiba.tiquete.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.tiquete.modelo.entidad.Tiquete;
import com.ceiba.tiquete.puerto.repositorio.RepositorioTiquete;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class RepositorioTiqueteMysql implements RepositorioTiquete {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "tiquete", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "tiquete", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "tiquete", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "tiquete", value = "existeTiqueteFechaYCedula")
    private static String sqlExisteTiqueteFechaYCedula;

    @SqlStatement(namespace = "tiquete", value = "maximoTiquetesVendidos")
    private static String sqlMaximoTiquetesVendidos;

    @SqlStatement(namespace = "tiquete", value = "existeId")
    private static String sqlExisteId;


    public RepositorioTiqueteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Tiquete tiquete) {
        return this.customNamedParameterJdbcTemplate.crear(tiquete, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public void actualizar(Tiquete tiquete) {
        this.customNamedParameterJdbcTemplate.actualizar(tiquete, sqlActualizar);
    }

    @Override
    public int existeTiqueteFechaYCedula(LocalDate fechaCompra, Long idUsuario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("fechaCompra", fechaCompra);
        paramSource.addValue("idUsuario", idUsuario);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteTiqueteFechaYCedula, paramSource, Integer.class);
    }

    @Override
    public int maximoTiquetesVendidos(LocalDate fechaCompra, Long idParque) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("fechaCompra", fechaCompra);
        paramSource.addValue("idParque", idParque);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlMaximoTiquetesVendidos, paramSource, Integer.class);
    }

    @Override
    public boolean existeId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteId, paramSource, Boolean.class);
    }

}

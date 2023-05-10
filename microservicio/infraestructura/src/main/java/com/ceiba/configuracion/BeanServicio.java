package com.ceiba.configuracion;

import com.ceiba.etapa.puerto.respositorio.RepositorioEtapa;
import com.ceiba.etapa.servicio.ServicioActualizarEtapa;
import com.ceiba.etapa.servicio.ServicioCrearEtapa;
import com.ceiba.etapa.servicio.ServicioEliminarEtapa;
import com.ceiba.proceso.puerto.repositorio.RepositorioProceso;
import com.ceiba.proceso.servicio.ServicioActualizarProceso;
import com.ceiba.proceso.servicio.ServicioCrearProceso;
import com.ceiba.proceso.servicio.ServicioEliminarProceso;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    //BeanServiciosUsuario
    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    //BeanServiciosEtapa
    @Bean
    public ServicioCrearEtapa servicioCrearEtapa(RepositorioEtapa repositorioEtapa) {
        return new ServicioCrearEtapa(repositorioEtapa);
    }

    @Bean
    public ServicioEliminarEtapa servicioEliminarEtapa(RepositorioEtapa repositorioEtapa) {
        return new ServicioEliminarEtapa(repositorioEtapa);
    }

    @Bean
    public ServicioActualizarEtapa servicioActualizarEtapa(RepositorioEtapa repositorioEtapa) {
        return new ServicioActualizarEtapa(repositorioEtapa);
    }

    //BeanServiciosProceso
    @Bean
    public ServicioCrearProceso servicioCrearProceso(RepositorioProceso repositorioProceso, RepositorioUsuario repositorioUsuario, RepositorioEtapa repositorioEtapa) {
        return new ServicioCrearProceso(repositorioProceso, repositorioUsuario, repositorioEtapa);
    }

    @Bean
    public ServicioActualizarProceso servicioActualizarProceso(RepositorioProceso repositorioProceso, RepositorioUsuario repositorioUsuario, RepositorioEtapa repositorioEtapa) {
        return new ServicioActualizarProceso(repositorioProceso, repositorioUsuario, repositorioEtapa);
    }

    @Bean
    public ServicioEliminarProceso servicioEliminarProceso(RepositorioProceso repositorioProceso) {
        return new ServicioEliminarProceso(repositorioProceso);
    }
}

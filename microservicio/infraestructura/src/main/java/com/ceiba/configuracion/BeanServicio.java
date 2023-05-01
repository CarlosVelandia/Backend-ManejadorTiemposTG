package com.ceiba.configuracion;

import com.ceiba.parque.puerto.respositorio.RepositorioParque;
import com.ceiba.parque.servicio.ServicioActualizarParque;
import com.ceiba.parque.servicio.ServicioCrearParque;
import com.ceiba.parque.servicio.ServicioEliminarParque;
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

    //BeanServiciosParque
    @Bean
    public ServicioCrearParque servicioCrearParque(RepositorioParque repositorioParque) {
        return new ServicioCrearParque(repositorioParque);
    }

    @Bean
    public ServicioEliminarParque servicioEliminarParque(RepositorioParque repositorioParque) {
        return new ServicioEliminarParque(repositorioParque);
    }

    @Bean
    public ServicioActualizarParque servicioActualizarParque(RepositorioParque repositorioParque) {
        return new ServicioActualizarParque(repositorioParque);
    }

    //BeanServiciosProceso
    @Bean
    public ServicioCrearProceso servicioCrearProceso(RepositorioProceso repositorioProceso, RepositorioUsuario repositorioUsuario, RepositorioParque repositorioParque) {
        return new ServicioCrearProceso(repositorioProceso, repositorioUsuario, repositorioParque);
    }

    @Bean
    public ServicioActualizarProceso servicioActualizarProceso(RepositorioProceso repositorioProceso, RepositorioUsuario repositorioUsuario, RepositorioParque repositorioParque) {
        return new ServicioActualizarProceso(repositorioProceso, repositorioUsuario, repositorioParque);
    }

    @Bean
    public ServicioEliminarProceso servicioEliminarProceso(RepositorioProceso repositorioProceso) {
        return new ServicioEliminarProceso(repositorioProceso);
    }
}

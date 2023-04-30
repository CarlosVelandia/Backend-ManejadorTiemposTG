package com.ceiba.configuracion;

import com.ceiba.parque.puerto.respositorio.RepositorioParque;
import com.ceiba.parque.servicio.ServicioActualizarParque;
import com.ceiba.parque.servicio.ServicioCrearParque;
import com.ceiba.parque.servicio.ServicioEliminarParque;
import com.ceiba.tiquete.puerto.repositorio.RepositorioTiquete;
import com.ceiba.tiquete.servicio.ServicioActualizarTiquete;
import com.ceiba.tiquete.servicio.ServicioCrearTiquete;
import com.ceiba.tiquete.servicio.ServicioEliminarTiquete;
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

    //BeanServiciosTiquete
    @Bean
    public ServicioCrearTiquete servicioCrearTiquete(RepositorioTiquete repositorioTiquete, RepositorioUsuario repositorioUsuario, RepositorioParque repositorioParque) {
        return new ServicioCrearTiquete(repositorioTiquete, repositorioUsuario, repositorioParque);
    }

    @Bean
    public ServicioActualizarTiquete servicioActualizarTiquete(RepositorioTiquete repositorioTiquete, RepositorioUsuario repositorioUsuario, RepositorioParque repositorioParque) {
        return new ServicioActualizarTiquete(repositorioTiquete, repositorioUsuario, repositorioParque);
    }

    @Bean
    public ServicioEliminarTiquete servicioEliminarTiquete(RepositorioTiquete repositorioTiquete) {
        return new ServicioEliminarTiquete(repositorioTiquete);
    }
}

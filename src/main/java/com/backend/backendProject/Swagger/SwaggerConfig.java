package com.backend.backendProject.Swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        type = SecuritySchemeType.HTTP,
        name = "CookieAuth", // Cambia el nombre según tu preferencia
        scheme = "cookie" // Indica que la autenticación se basa en cookies
)
@OpenAPIDefinition(
        info = @Info(
                title = "API Módulo de Registro"
                )
        ,
        servers = {
                @Server(url="https://backendproject-production-6d25.up.railway.app/",description="Servidor de Producción"),
                @Server(url = "http://localhost:8081/", description = "Servidor local")
        }
)
public class SwaggerConfig {

}

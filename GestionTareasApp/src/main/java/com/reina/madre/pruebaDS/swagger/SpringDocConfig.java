package com.reina.madre.pruebaDS.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringDocConfig {
	
	   @Bean
	    public OpenAPI customOpenAPI() {
	        return new OpenAPI()
	                .info(new Info()
	                		.title("Aplicación de Gestión de Tareas")
	                        .version("1.0.0")
	                        .description("Esta aplicación permite la gestión de tareas como: crear, listar, consultar, actualizar y eliminar tareas")
	                        .termsOfService("N/A")
	                        .contact(new Contact()
	                                .name("Coderio")
	                                .url("http://coderio.com/contacto")
	                                .email("coderio@coderio.com"))
	                        .license(new License()
	                                .name("OpenSource")
	                                .url("http://prueba.com/prueba")));
	    }		

}

# Prueba-tecnica-coderio-backend

	BACKEND
	
	El backend fue desarrollado en Spring boot, arquitectura de microservicios, cuenta con tres controller, tres services y tres respository.
	Se utiliza una base de datos H2, con tres tablas y su data, que se encuentra en la ruta: 
	- src/main/resources
	
	Teconologias usadas:
	
		- Java 17
		- Spring boot 4.20.1.RELEASE
		- BD H2
		- IDE: Spring Tool Suite 4
	
	
	Despliegue:
	
	Esta es una aplicacion para despliegue en ambiente local, con las siguientes configuraciones:
	
		- Nombre de la app: GestionTareasApp
		- Variables entorno JAVA_HOME: C:/Program Files/Java/jdk-17
		- Puerto: 8085
	
	Url consumo servicios:
	
		- http://localhost:8085/api/v1/gestiontareas
		- http://localhost:8085/api/v1/prioridades	
		- http://localhost:8085/api/v1/estados
		
		
	Acceso H2:
	
	http://localhost:8085/h2-console/login.jsp 
	
		Driver class: 	org.h2.Driver
		Jdbc url: 		jdbc:h2:mem:testdb
		User name:		test
		Password:		
		
	

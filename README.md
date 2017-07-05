Spring Boot, Spring Data JPA, In-memory h2 and Basic Auth
---------------------------------------------------

This sample calendar events project shows how a spring-boot application can be setup with an embedded SQL database over JPA.
The focus of this project is to show how to configure an embedded database with Spring Boot, it also contains RestControllers and Spring Data Repository.


Step by step
---------------------------------------------------

**Maven dependencies**
To load an embedded database with Spring Boot, all you really need is to add its maven dependency into your pom. The rest will be taken care of.
In my case I chose h2, so I added the following dependency:
```
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
</dependency>
```

**Spring Boot configuration**
```
spring.datasource.url=jdbc:h2:mem:tinroofdb;MVCC=FALSE;MV_STORE=FALSE;DB_CLOSE_DELAY=-1;MODE=MYSQL
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.platform=h2

spring.datasource.initialize=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
spring.datasource.data=classpath:data-h2.sql

spring.h2.console.enabled=true
spring.h2.console.path=/console
spring.jpa.hibernate.ddl-auto=none
```

* **spring.datasource.***: sets up an in-memory H2 database;
* **spring.datasource.initialize**: tells spring-boot to initialize the database with scripts;
* **datasource.data**: the data sql script. By default, it is data-${platform}.sql then data.sql;
* **spring.h2.console.enabled**: allow us to access the memory database from a web interface;
* **spring.jpa.hibernate.ddl-auto**: hibernates also tries to initialize the database. 
When it detects an embedded database, it sets ddl-auto to create-drop and initialize the database with entities annotated with @Table (and also looks for imports.sql). 
This may lead to creating the same table twice. I prefer to stick with Spring Boot magic, so I set this to none



Spring Boot entry point:
```
@SpringBootApplication
@EnableScheduling
public class CalendarapiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CalendarapiApplication.class, args);
	}
}
```
Then, you can access h2's console at: [localhost:8080/h2-console](http://localhost:8080/h2-console)
Simply type in the url ```jdbc:h2:mem:tinroofdb;MVCC=FALSE;MV_STORE=FALSE;DB_CLOSE_DELAY=-1;MODE=MYSQL``` 


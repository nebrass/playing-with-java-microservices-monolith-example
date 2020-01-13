# playing-with-java-microservices-monolith-example
Monolith sample code for the book/course Playing with Java Microservices on Kubernetes and OpenShift

This application runs on PostgreSQL:
```properties
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
spring.datasource.url=jdbc:postgresql://localhost:5432/demo
spring.datasource.username=developer
spring.datasource.password=p4SSW0rd
```

To quickly get a running instance of PostgreSQL, you can run it in the official PostgreSQL docker container:
```bash
docker run -d --name demo-postgres \
        -e POSTGRES_USER=developer \
        -e POSTGRES_PASSWORD=p4SSW0rd \
        -e POSTGRES_DB=demo \
        -p 5432:5432 postgres:latest
```

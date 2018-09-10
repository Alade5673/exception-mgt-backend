# Ticketing

A minimal ticketing application that provides a number of interfaces to submit trouble-tickets. Rather domain specific at the moment for financial services and submission of tickets will mostly come from automated processes submiting tickets after some batch processing.

It will resolve issues such as:

1. ageing
1. workflow to closure
1. reports e.g dispense errors
1. escalation
1. raising tickets for every issue generated

# Running

Update your database configuration in the application.properties file inside resources. We are somewhat partial towards postgresql now because it's close enough to Oracle and most of our present clients will run oracle in production. The app will not run without a valid database setup.

Most of the database settings are wired to take a default, except the database password of course which must be passed in as follows:

For spring-boot:run with mvn or mvnw

```
mvn spring-boot:run -Dspring-boot.run.arguments=--spring.datasource.password=xxxxx
```

or passing using name and password for database

```
mvn spring-boot:run -Dspring-boot.run.arguments=--spring.datasource.password=xxx,--spring.datasource.username=xxx
```

Using Maven directly, you could do the following

```
mvn clean package

java -jar target/ticketing-0.0.1.jar -Ddbpassword=xxxxxx -Ddbuser=xxxxx
```


And so on, you get the flow :)
 

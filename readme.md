# Springboot Schedule Project

## Requirements

For building and running the application you need:
- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven](https://maven.apache.org)
- [MySql](https://www.mysql.com/downloads/)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `backend.home.challenge.job.schedule.ScheduleApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
## Project Description

This has only post request. Once server starts go to [swagger-ui](http://localhost:8080/swagger-ui.html).
You will notice a controller called "Message Controller". click on post request [message](http://localhost:8080/swagger-ui.html#!/Message_Controller/createUsingPOST) and filled the requird data and click on Try it out button.
Once you click your job will get scheduled and as a response you will get data.

## Sample Request
{
  "timing": "2020-12-29 22:48",
  "value": "string"
}

## Sample Response
* <b>Response Code - </b> 202 
* <b>Response Body - </b><br>
{
  "data": {
    "message": {
      "id": 17,
      "value": "string",
      "timing": "2020-12-29 22:48"
    },
    "status": "SUCCESS"
  }
}

## Internal Details
To store the details in database first create a db called "message_job" and make sure your datasource username and password should be present in application.properties.
<br>
One cron job has created with the name of "executeScheduledTask". It executes every minute to checks whether any job present in database within a minute or not(current time + 1 min).  
Once it gets the list of job, those jobs get scheduled and run at their particular time.

If we change the corn job timing from 1 min to 1 hour then we should also change the timing of end date to "new Date(System.currentTimeMillis() + 3600 * 1000)".

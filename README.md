### Rest API and SpringMVC CodingChallenge

This coding challenge task shows following my skills:

1. [Spring MVC](https://github.com/Vedenin/RestAndSpringMVC-CodingChallenge/tree/master/src/main/java/com/github/vedenin/codingchallenge/mvc)

2. [Spring Security](https://github.com/Vedenin/RestAndSpringMVC-CodingChallenge/blob/master/src/main/java/com/github/vedenin/codingchallenge/mvc/security/SpringSecurityConfiguration.java)

3. [Integration with REST service using Java-RS client](https://github.com/Vedenin/RestAndSpringMVC-CodingChallenge/tree/master/src/main/java/com/github/vedenin/codingchallenge/restclient)

4. [Spring Rest Service](https://github.com/Vedenin/RestAndSpringMVC-CodingChallenge/blob/master/src/main/java/com/github/vedenin/codingchallenge/mvc/controler/MainRestController.java) 

5. [Spring Boot](https://github.com/Vedenin/RestAndSpringMVC-CodingChallenge/blob/master/src/main/java/com/github/vedenin/codingchallenge/Application.java)

6. [JPA](https://github.com/Vedenin/RestAndSpringMVC-CodingChallenge/tree/master/src/main/java/com/github/vedenin/codingchallenge/persistence)

6. [Hibernate](https://github.com/Vedenin/RestAndSpringMVC-CodingChallenge/tree/master/src/main/java/com/github/vedenin/codingchallenge/persistence)  

7. [H2 database](https://github.com/Vedenin/RestAndSpringMVC-CodingChallenge/tree/master/src/main/java/com/github/vedenin/codingchallenge/persistence)  

8. [MockMvc](https://github.com/Vedenin/RestAndSpringMVC-CodingChallenge/tree/master/src/test/java/com.github.vedenin.codingchallenge)

9. [Thymeleaf](https://github.com/Vedenin/RestAndSpringMVC-CodingChallenge/tree/master/src/main/resources/templates)

10. [Java Script](https://github.com/Vedenin/RestAndSpringMVC-CodingChallenge/tree/master/src/main/resources/templates) 

#### How run in IDE (Eclipse, Idea)

1. Run 
     "mvn clean install"
     
2. Run Application.class in any Java IDE

#### How run using jar file and Spring Boot 
1. Run 
     "mvn clean install"
     
2. Run Application.class in codingchallenge-1.0-SNAPSHOT.jar, for example 

   java -jar target/codingchallenge-1.0-SNAPSHOT.jar
    
See more info in [Spring Boot documentation](http://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-running-your-application.html)

#### How see result in web
Use following link: [https://currency-convector.herokuapp.com/](https://currency-convector.herokuapp.com/)

### BONUS POINTS:

1.  Spring MVC for the registration and login forms - [done](https://github.com/Vedenin/RestAndSpringMVC-CodingChallenge/tree/master/src/main/resources/templates)

2. rovide an automated build and test run on a continuous integration server - done: [circleci.com](https://circleci.com/gh/Vedenin/RestAndSpringMVC-CodingChallenge/1) and [travis-ci.org](https://travis-ci.org/Vedenin/RestAndSpringMVC-CodingChallenge)

3. Integrate very well with the external components - [done](https://github.com/Vedenin/RestAndSpringMVC-CodingChallenge/blob/master/src/main/java/com/github/vedenin/codingchallenge/restclient/FaultTolerantRestClient.java) using collection of Rest sevice and resend request if error.

4. Implement monitoring and management interface (JMX, REST, etc..) - [done](https://github.com/Vedenin/RestAndSpringMVC-CodingChallenge/blob/master/src/main/java/com/github/vedenin/codingchallenge/mvc/controler/MainRestController.java)

Using following Rest monitoring and management interface:

   - Show all users (type: get): https://currency-convector.herokuapp.com/rest/user?access_key=sg435jklj
   - Show all errors (type: get): https://currency-convector.herokuapp.com/rest/error?access_key=sg435jklj
   - Show all request history (type: get): https://currency-convector.herokuapp.com/rest/history?access_key=sg435jklj
   - Show all properties (type: get): https://currency-convector.herokuapp.com/rest/property?access_key=sg435jklj
   - Change all properties (type: post): https://currency-convector.herokuapp.com/rest/property?access_key=sg435jklj
  




#### Coding Challenge Requirements 

Develop a protected currency converter application using a public currency converter API

(https://openexchangerates.org/signup/free, https://currencylayer.com/documentation, etc... ). The application

should provide a login/registration screen and a main screen to query historical or current exchange rates. After the

successful login the application should show the last 10 queries and their results on the main screen as reminder.


Some main currencies (EUR, USD, GBP, NZD, AUD, JPY, HUF, etc...) are enough.


- Create a Java web app. Store your source code in your Github account and provide documentation on how

we can build executable war/jar.


- Make your app available via Internet (hint: Heroku, Digital Ocean, Google App Engine or CloudFoundry) and

share with us the link.


- You could use in-memory (h2, etc.), cloud database providers (http://mongolab.com,

https://www.mongosoup.de/en/index.html) or some RDBMS provider with MySQL hosting for persistence.


- A reliable, working code is a must! We should see a login screen, a registration screen and the main screen

with logout feature. Any simple web page with a basic GUI will suffice, i.e. three fields with currencies and

the date and a simple list of past entries. Show an application based on some Spring stuff and JPA

persistence to make us smile.


### BONUS POINTS:


- Use Spring MVC for the registration and login forms. The registration should require a valid email

address (according to the RFC), a reasonable date of birth, as well as a postal address with street, zip

code, city, and a country selectable from a list. Mandatory if you want to be considered for the Shop

dev. team


- Implement acceptance tests with a BDD framework like Cucumber or JBehave


- Provide an automated build and test run on a continuous integration server (it could be hosted on

https://travis-ci.org/, https://shippable.com, https://circleci.com/ or something similar, but you can also

setup your own Jenkins instance)


- Implement monitoring and management interface (JMX, REST, etc..)


- Cache external request with configurable TTL


- Any stuff that ensures the application can integrate very well with the external components, checks and

protects the quality, automates things could be a nice extra.


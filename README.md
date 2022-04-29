# Spring-Players
Spring API with a database of players
Complete CRUD project with Spring Boot, Java, Javascript and Axios

This project is a springboot API that takes in data and return a playerbase list. It consists of one entity class, a rest controller class and a service class. There is also testing for the service and controller classes. It is compatible with h2 console, and SQL to generate databases. It can be tested with Postman to generate instances of the entity.

Getting Started These insturctions will get you a copy of the project up and running on your local machine for development and testing purposes. 

Prerequisites What things you need to install the software and how to install them:
Maven, Springboot, Lombok, (ALL INCLUDED IN THE POM FILE) 

To run the application use the following command:
java -jar Spring-Playerbase-0.0.1-SNAPSHOT

This API is has full CRUD functionality.
Simply run the application as a springboot application and go to http//:localhost:8080 to get started.
You will start off on a home page with a navigation bar that has two headers Home and Entities.
Click the Entities button and a drop down list will appear with a tab called players. Click that link and you will be redirected to the players page where you will see a list of players and a creation form for you to create read update and delete players. 
Alternatively you can go to http://localhost:8080/players.html.

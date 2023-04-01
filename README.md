# About this project

<p align="center">
<img src="https://user-images.githubusercontent.com/98110966/229280997-46e57145-5e21-4026-a8f8-a203fb7fac1e.png" width="400">
</p>

  
# Overview
  
  **Hospital Organizer** is a simple **RESTful API** that allows users to manage entities related to hospitals. It is written in **Java** and uses the **Spring Boot** framework. Data is stored in a **relational database**. The project is deployed using **Amazon Web Services – Relational Database Service and Elastic Beanstalk**. Currently, only GET operations are supported via the web page.
  
  **Currently working on**: User interface, Refactoring certain pieces of code according to best practices
  
# Database Schema

<p align="center">
<img width="564" src="https://user-images.githubusercontent.com/98110966/229273117-cc1385b4-0f06-47ed-9f31-6cd722aaf6fc.png">
</p>

# Functionalities

GET - all entities - /entitites

Returns a list of all entities of given type

GET - all entities - /entitites/{id}

Returns entity of given type and id with any entities related to it

POST - all entities - /entities/{id}

Creates the given entity

PUT - all entities - /entities/{id}

Updates the entity matching given id

DELETE - all entities - /entities/{id}

Deletes the entity matching given id
  
GET - hospitals - /filter/{capacity}

Returns a list of all hospitals which have a capacity greater than or equal to the given number

GET - shifts - /stats

Returns a list of doctor ids along with the number of patients which they have under care during their shifts

*The list of functionalities is constantly expanding.*

# Video Demonstration

Demonstration using Postman for requests

https://user-images.githubusercontent.com/98110966/229280670-5bbf9d23-0582-45e0-80ba-308daaa710c8.mp4

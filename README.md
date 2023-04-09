# About this project

<p align="center">
<img src="https://user-images.githubusercontent.com/98110966/229280997-46e57145-5e21-4026-a8f8-a203fb7fac1e.png" width="400">
</p>

  
# Overview
  
  **Hospital Organizer** is a simple **RESTful API** that allows users to manage entities related to hospitals. It is written in **Java** and uses the **Spring Boot** framework. Data is stored in a **relational database**. The project is deployed using **Amazon Web Services – Relational Database Service and Elastic Beanstalk**. Currently, only GET operations are supported via the web page.
  
  **Currently working on**: User interface, Refactoring certain pieces of code according to best practices
  
  FOR **VIDEO DEMONSTRATION** PLEASE REFER TO THE FOLLOWING ANCHOR:

  [Video Demonstration](#video-demonstration)
  
# Database Schema

<p align="center">
<img width="564" src="https://user-images.githubusercontent.com/98110966/229273117-cc1385b4-0f06-47ed-9f31-6cd722aaf6fc.png">
</p>

# Functionalities

GET - all entities - /entities

Returns a list of all entities of given type

GET - all entities - /entities/{id}

Returns entity of given type and id with any entities related to it

POST - all entities - /entities/{id}

Creates the given entity

PUT - all entities - /entities/{id}

Updates the entity matching given id

DELETE - all entities - /entities/{id}

Deletes the entity matching given id

PUT - hospitals - /{id}/patients

Links the given list of patient ids to the hospital with given id
  
GET - hospitals - /filter/{capacity}

Returns a list of all hospitals which have a capacity greater than or equal to the given number

GET - shifts - /stats

Returns a list of doctor ids along with the number of patients which they have under care during their shifts

*The list of functionalities is constantly expanding.*

# Input validation

All entity post requests are validated in order to ensure that all required fields are present and correct.

<p align="center">
<img src="https://user-images.githubusercontent.com/98110966/230772402-7ebd4eee-d9d0-4484-a61e-f2b05cc31740.png" width="400">
</p>


# Video Demonstration

Demonstration using Postman for requests:

https://user-images.githubusercontent.com/98110966/230775210-53773e67-2e79-4e0c-8ab8-5bb65b5cfb11.mp4


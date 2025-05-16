# Spring Boot Content Negotiation Project

This project demonstrates how to handle **content negotiation** using Spring Boot — allowing the same URL to return either a **web HTML page** or a **JSON response**, depending on the request source (browser or Postman/API).

---

##  Key Features

-  **HTML Page (Web)** rendering using **Spring MVC + Thymeleaf**
-  **JSON API responses** for REST clients like Postman
- Smart **Content Negotiation** using the `Accept` header
-  Same URL supports both frontend (web view) and backend (API) behavior

---

## Technologies Used

- Java + Spring Boot
- Spring MVC
- Thymeleaf
- Spring Data JPA (optional)
- H2/MySQL Database (optional for persistence)

##  How It Works

### To access the web version:
Run the application: http://localhost:8080

Open your browser and navigate to:

http://localhost:8080/users

You’ll see a rendered HTML page showing the list of users.


### To access the API response:

Open Postman.

Make a GET request:

GET http://localhost:8289/users

Set the header:

Accept: application/json
You will receive a JSON array of user objects.


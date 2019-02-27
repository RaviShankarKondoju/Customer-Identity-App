# Web-Customer-Tracker
A customer relationship management app which leverages Spring MVC, Hibernate and MySQL database to display a list of customers and apply CRUD operations. Moreover. Spring AOP has also been used for logging.

# Technology

- Front End
  - HTML
  - CSS
  - JavaScript
 
 - Back End
    - Java
    - Spring MVC
    - Hibernate
    - Spring AOP
  
 - Database
    - MySQL
    
 - Server
    - Apache Tomcat
    
 
 - Platform
    - Windows 10
    
# Features

- Adding, updating and deleting customers
- Search functionality
  - A search box has been added which allows a user to search by name
  - On the backend, the input name will be compared to the customer's first name or last name in the database. 
  - If the input is empty, the entire customer list is returned.
  - If the input is not empty, we can search for substrings.

- Spring AOP for logging
  - @Before advice has been used to display the calling method and the arguments in the logger before method call.
  - @AfterReturning advice has been implemented to display the calling method and the results in the logger after method call.
  - Pointcut expressions have been utilized to implement the advices on every method.

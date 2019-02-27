# Web-Customer-Tracker
A customer relationship management app which leverages Spring MVC, Hibernate and MySQL database to display a list of customers and apply CRUD operations. Moreover. Spring AOP has also been used for logging.

![customer-list](https://user-images.githubusercontent.com/33348004/53490609-232d2500-3aba-11e9-9efb-8f336f03080a.PNG)

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

- Adding customers
  - a form is presented in which the user can enter a first name, last name and email as well as go back to the list page.
  
  ![customer-form](https://user-images.githubusercontent.com/33348004/53490867-ced67500-3aba-11e9-9dfc-dea6ce9975e1.PNG)
 
- updating customers
  - When a user selects an update for a particular customer, the specific user id is passed to the URL from which the details of a customer are fetched and populated in the form.
  - The user can make necessary updates and click save.
 
  ![update-page](https://user-images.githubusercontent.com/33348004/53490970-1ceb7880-3abb-11e9-84c2-a6bd9e77701d.PNG)

- deleting customers
  - When a user selects delete, a prompt appears to confirm his action.
  - If yes, a specific user is deleted.
  - If no, the action is cancelled.
 
  ![delete-info](https://user-images.githubusercontent.com/33348004/53491260-f974fd80-3abb-11e9-90a3-3ad0ac19b761.PNG)

- Search functionality
  - A search box has been added which allows a user to search by name
  - On the backend, the input name will be compared to the customer's first name or last name in the database. 
  - If the input is empty, the entire customer list is returned.
  - If the input is not empty, we can search for substrings.

- Spring AOP for logging
  - @Before advice has been used to display the calling method and the arguments in the logger before method call.
  - @AfterReturning advice has been implemented to display the calling method and the results in the logger after a method call.
  - Pointcut expressions have been utilized to implement the advice on every method.

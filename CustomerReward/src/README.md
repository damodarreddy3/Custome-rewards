# Customer rewards
 This project is all about to get the users reward points based on the tranction done by the respective users.  

This service contain 3 end points called

1) Get ("/rewards/{customerID}"): This end point provides last 3 months rewards points based on there transactions spend with respective to the customer.
2) Get("/transactions"): This end point provides total amount of transactions done by the each individual customers
3) Get("/rewards"): This end point provides total amount of rewards earned by the each individal customers.

 

# Inorder to run this project:

1) Install latest java version you can do that with this link
   https://www.oracle.com/java/technologies/downloads/#jdk19-windows

2) Along with that the user need to have IDE like intelIJ, Eclipse. So that user can run in the project in that platform

3) Clean and build the project, run the command:
mvn install

4) For the database i have used MySQL and created a local database and performed operation on that database. So whoever want to run this project 
Firstly they need to create a sample Database and create two tables using the content in the  entity folder.
( src/main/java/com/rewards/entity)

5) To connect to the local database give the Database connection details in the application.properties floder. 

6) Now users can run the project in there local.





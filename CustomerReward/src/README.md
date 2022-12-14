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

# How to clone a repository
## Cloning a repository can be done in 2 ways

1) On GitHub.com, navigate to the main page of the repository. 
 Above the list of files, click Download Code and run on the local IDE

2) Copy the URL for the repository.

To clone the repository using HTTPS, under "HTTPS", click  copy .

To clone the repository using an SSH key, including a certificate issued by your organization's SSH certificate authority, click SSH, then click copy.

To clone a repository using GitHub CLI, click GitHub CLI, then click copy .







# contact-management-api
This REST API serves as an interface to add, update, delete and view all the contacts in the system. This application has an in-memory H2 database which will be initialized with 2 contacts in the database. The data.sql file is loaded during the startup and as soon as the application is up, the table and databsse will be ready with the initial data. You can hit the GET /contacts endpoint to get the list of available contacts in the database at any give point of time. You can use other POST, PUT, DELETE endpoints to add, update, or delete contacts from the database.

Build and Run the application:
1. Clone/download this repository and run the application as a Spring Boot Application.
2. The application has an embedded tomcat server which will start the server and will accept request on port 8080.
3. This application also starts with an in-memory H2 database which creates the database using the hibernate entity annotations and the data.sql script which gets executed while the application is started. The database has a table named CONTACT which stores all the contact information. You can also check the H2 console for a graphical interface to check the records in the database.
4. This application has been integrated with Swagger-UI which serves the purpose as an interface documentation as well as it helps in testing the resource endpoints from it's user interface.

The endpoints can be tested using command-line Curl, Postman or Swagger-UI. Below are the steps describing all the 3 ways.

Testing using Curl Commands:
1. Get list of all contacts: curl -X GET "http://localhost:8080/v1/contacts" -H "accept: application/json"
2. Get information for a specific contact: curl -X GET "http://localhost:8080/v1/contacts/2" -H "accept: application/json"
3. Add a new contact: curl -X POST "http://localhost:8080/v1/contacts" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"contactId\": 0, \"email\": \"abc@abc.com\", \"firstName\": \"name1\", \"lastName\": \"name2\"}"
4. Update an existing contact: curl -X PUT "http://localhost:8080/v1/contacts/2" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"contactId\": 0, \"email\": \"atr@yht.com\", \"firstName\": \"Kane\", \"lastName\": \"Williamson\"}"
5. Delete an existing contact: curl -X DELETE "http://localhost:8080/v1/contacts/3" -H "accept: application/json"

Testing using Swagger UI:
1. Once the application is up and running, load this URL in your browser: http://localhost:8080/swagger-ui.html#/
2. It will provide a user interface from which you can execute the requests for any endpoint which is available in the API

Testing from Postman:
1. Download the open source Postman Client
2. Open a new tab and load this URL in the tab and click on Send: GET http://localhost:8080/v1/contacts/1
3. Similarly you can execute other resources and methods using similar routes for each endpoint.

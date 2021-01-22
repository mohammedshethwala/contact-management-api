# contact-management-api
This REST API serves as an interface to add, update, delete and view all the contacts in the system. This application has an in-memory H2 database which will be initialized with 2 contacts on the database. The data.sql file is loaded during the startup and as soon as the application is up, the table and databsse will be ready with the initial data. You can hit the GET /contacts endpoint to get the list of available contacts in the database at any give point of time. You can use other POST, PUT, DELETE endpoints to add, update, or delete contacts from the database.

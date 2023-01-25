# Introduction
A CRUD API which exposes user's information such as personal number , first name , last name , date of birth
and email address.

# Getting Started
1. Configuring the DB in mySQL server
2. Importing basic SpringBoot application with dependencies from springinitializer.io

# Build and Test
$ mvn clean install

# Design Notes

* Create User
  - It will create a user with unique person number and return response payload which includes person number
  and user data ( first name, last name , date of birth , email address)
* Delete User
  - Deletes the user based on person number which is passed as URI parameter.
  - Returns response entity with HTTP status OK or NOT_FOUND.
* Update User
  - Update user details based on person number which is passed as URI parameter and user details
  in the request body
  - Checks if user is present or not , if exists updates the record in the database or
  else throws PersonEntityNotFoundException .
* Get User by person number
  - Retrieves the user data based on the person number provided in URI parameter .
* Get all users
  - Retrieves all user information based on the pagination details provided .
  - Pagination is implemented using spring JPARepository.
* Validations
  - Validations are implemented on request dto to keep restrictions on data ,so that only
  proper data is passed . If not a proper data then proper exceptions are sent back to user .
* Exception Handling
  - Right now exceptions are handled for invalid data and person entity not found exceptions only .

# Known Improvements
    - Implement Open API for swagger documentation
    - Detailed Junit test cases
    - Exposing various API for different person attributes.
    - Detailed exception handling for more business use cases
    - Implementing Spring security

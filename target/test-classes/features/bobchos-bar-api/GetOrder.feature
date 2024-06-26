#Author: raviteja.cvs15@gmail.com
@GetOrderAPI
Feature: Validating Get Order API's

  		
   @GetOrderAPI
  Scenario Outline: Verify if Order is being Succesfuly retireved using GetOrderAPI
   Given I have an order with the following details:
  | Field       | Value          |
  |--------------|----------------|
  | IsAdult      | <isadult>      |
  | Id          | <id>            |
  | TypeId      | <typeid>        |
  | Quantity    | <quantity>      |
  | Name        | <name>          |
  | Email       | <email>         |
  | Price       | <price>         |
  | Date        | <date>          |
  And verify order id "<id>" created matches "<name>" using "GetOrderAPI"
  Then the API call got success with status code 200
  Examples:
  	|isadult	|id |typeid	|quantity	|name	|	email|price	|date	|
  	|true			|2	|	1			|1				|Hershel Nader|beertest4@mail.com|3.00|2024-06-24T19:30:37.3973259+03:00	|
  	
  	
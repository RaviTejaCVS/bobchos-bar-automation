#Author: raviteja.cvs15@gmail.com
@DeleteOrderAPI
Feature: Validating Delete Order API's

 
 @DeleteOrderAPI
  Scenario Outline: Verify if Order is being Succesfuly deleted using DeleteOrderAPI
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
  And verify order details are deleted for the orderid equals to "<id>" using "DeleteOrderAPI"
  Then the API call got success with status code 405
  
   Examples:
  	|isadult	|id |typeid	|quantity	|name	|	email|price	|date	|
  	|true			|2	|	1			|1				|BEER TEST4|beertest4@mail.com|3.00|2024-06-24T19:30:37.3973259+03:00	|
  	
   	
  	
  	
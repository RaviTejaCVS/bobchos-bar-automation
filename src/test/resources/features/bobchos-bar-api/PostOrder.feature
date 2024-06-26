#Author: raviteja.cvs15@gmail.com
@PostOrderAPI
Feature: Validating Post Order API's

  @PlaceOrderAPI
  Scenario Outline: Verify if Order is being Succesfuly placed using PlaceOrderAPI
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
  When user calls "PlaceOrderAPI" with "POST" http request
  Then the API call got success with status code 201
  And verify order id created maps to "<name>" using "GetOrderAPI"
  
  
  Examples:
  	|isadult	|id |typeid	|quantity	|name	|	email|price	|date	|
  	|true			|2	|	1			|1				|BEER TEST6001|beertest61@mail.com|3.00|2024-07-24T19:30:37.3973259+03:00	|
  	
  	
  @IsAdult_True
  Scenario Outline: Verify if Order is being Succesfuly placed using PlaceOrderAPI
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
  When user calls "PlaceOrderAPI" with "POST" http request
  Then the API call got success with status code 405
  
  Examples:
  	|isadult	|id |typeid	|quantity	|name	|	email|price	|date	|
  	|false			|2	|	1			|1				|BEER TEST6|beertest6@mail.com|3.00|2024-07-24T19:30:37.3973259+03:00	|
  	
  	
  	
  @DuplicatePlaceOrderAPI
  Scenario Outline: Verify if Order is being Succesfuly placed using PlaceOrderAPI
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
  When user calls "PlaceOrderAPI" with "POST" http request
  Then the API call got success with status code 409
  And verify order id created maps to "<name>" using "GetOrderAPI"
  
  
  Examples:
  	|isadult	|id |typeid	|quantity	|name	|	email|price	|date	|
  	|true			|2	|	1			|1				|BEER TEST600|beertest6@mail.com|3.00|2024-07-24T19:30:37.3973259+03:00	|
  	 @InValid_EmailAddress
  Scenario Outline: Verify if Order is being Succesfuly placed using PlaceOrderAPI
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
  When user calls "PlaceOrderAPI" with "POST" http request
  Then the API call got success with status code 400
  
  Examples:
  	|isadult	|id |typeid	|quantity	|name	|	email|price	|date	|
  	|false			|2	|	1			|1				|BEER TEST6|beertest6!&)mailcom|3.00|2024-07-24T19:30:37.3973259+03:00	|
  	
  	
  @Missing_fields
  Scenario Outline: Verify if Order is being Succesfuly placed using PlaceOrderAPI
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
  When user calls "PlaceOrderAPI" with "POST" http request
  Then the API call got success with status code 400
  
  Examples:
  	|isadult	|id |typeid	|quantity	|name	|	email|price	|date	|
  	|			|	|			|		|||||
  		
  		
  @Missing_mandatory_fields
  Scenario Outline: Verify if Order is being Succesfuly placed using PlaceOrderAPI
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
  When user calls "PlaceOrderAPI" with "POST" http request
  Then the API call got success with status code 400
  
  Examples:
  	|isadult	|id |typeid	|quantity	|name	|	email|price	|date	|
  	|false			|2	|				|1				|||3.00|2024-07-24T19:30:37.3973259+03:00	|
  		
   
  	
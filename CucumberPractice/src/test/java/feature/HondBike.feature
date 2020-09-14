Feature: Book a Bike
Scenario: TC001_BookBike
Given Launch URL
And Click on Scooter and Click on Dio
And Click on Specification MouseHover on Engine
And All Details of Dio Specification in Map
And Goto Scooter and Click on Activa
And All Details of Activa Specification in Map
And Compare Dio and Activa Specification print the different values of the samekeys
And Click FAQ from Menu and Click dio under Browse By Product
And Click  Vehicle Price and Select scooter Dio BS-VI from the dropdown and click submit
And click the price link Go to the new Window and select the state city
And Print the price and model 
And Click Product Enquiry and Fill all the * field except Mobile check the terms and conditions box and click submit
And Verify the error message under the mobile number field
Then Close the Browser
Project title: # TaxiBookingProject

Project description: The programm adds various drivers to the database storing their full names,
age, phone number, car model, number of seats in the car. Additionally, it asks for a date of travel, 
destinations which are later used in an algorithm that matches user with a needed driver. It gives the customer 
list of all available drivers, and asks the user to refine the search by choosing departure date and travel route. 
It presents a new list of drivers with matching routes and dates, to the customers. The customer then is free to choose 
a driver by clicking on a person and pressing "book". The program than shows a 'confirmation window' with a contact 
information of the chosen driver and asks to confirm the book, and independently contact the driver.

Software & libraries used: Java, JavaFX, mysql-connector-java.jar
Installation instruction: 
I) Set up JavaFX project on IntelliJIDEA and add JM options and mysql-connector-java.jar library. 
II) Set up the Databasetby creating mysql database called driverinfo with table named 'drivers'. 
Table should have:
('id' int, 'full_name' varchar, 'age' int, 'phone_num' varchar, 'car_model' varchar, 'number_of_seats' varchar, 'date' date, 'destination' varchar).
III) Run the Main.java

Planned App's feature list: Registration by driver and customer, Deletion, Login and Password for both 'customers' and 'drivers', showing a list of all drivers/ available drivers
Search options for 'customers' of a needed driver, an option of online booking linking with banking system, linking the driver and the customer
option of choosing a preffered seat by the customer by pressing buttons on the picture for each car model,
main page of a driver showing customers that have booked a seat & number of empty seats, end-to-end encryption of drivers' and customers'
personal information & calls could be only made in a system not sharing phone numbers of 'customers' and 'drivers' with either of them or any third party.

List of completed features:
Registration by drivers, reset option during registration, showing a list of all drivers/ available drivers to the customer, linking the driver and the customer. 

List of features yet to implement:
Login and Password for both 'customers' and 'drivers', advanced search options for 'customers' of a needed driver, 
an option of online booking linking with banking system, option of choosing a preffered seat by the customer by pressing buttons on the picture for each car model,
main page of a driver showing customers that have booked a seat & number of empty seats, end-to-end encryption of drivers' and customers'
personal information & calls could be only made in a system not sharing phone numbers of 'customers' and 'drivers' with either of them or any third party



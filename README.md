# Travel-Thru-Air
It is a web application for “Travel Thru Air” using servlets to support the following two use cases
1. A list of current special deals must appear on the home page. Each special deal must display the departure city, the arrival city, and the cost. These special deals are inserted in the database through mysql commands in mysql workbench by the marketing department and change during the day, so it can’t be static. Special deals are only good for a limited amount of time.
2. A user may search for flights, given a departure city, time and an arrival city. The results must display the departure city, the arrival city, the total cost.


Prerequisites for running this web application:

1.install eclipse for java ee
2.install tomcat 9 and configure it with eclipse
3.install mysql
4.create a database "my_flightsdb" in mysql
5.create a table flights(id int AI PK, departure_city varchar(120), arrival_city varchar(120), discount int, cost int, start_time time, end_time time, departure_time       time, arrival_time time
6.Edit line number 18 with your password created during mysql installation
7.Connect mysql
8.Run home.jsp

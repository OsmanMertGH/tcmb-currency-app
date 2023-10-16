## TCMB CURRENCY APP

TCMB_CurrencyApp is a simple application that fetches data from the Central Bank of Turkey (CBRT) in XML format for a specified date and displays it on the front end after parsing.
---

## Versions

- `Spring Boot :`  2.7.16
- `Angular CLI:` 16.2.6
- `Node:` 18.17.1
- `Package Manager:` npm 9.6.7
- `Java:` 1.8
---

## Integrations

- `PostGreSQL` for database
- `Angular` for frontend
- `Spring Boot` for backend
---

## To run backend

1. Open IntelIJ and open project.

2. Before starting the project, database installations must be made according to the settings in the application.yml.

3. After PostGreSQL is up and running, run the project.
---

## Endpoints

List currencies by get request
shell
String date = "yyyy-MM-dd"

hhttp://localhost:8080/api/{date}


Swagger endpoint
shell
http://localhost:8080/docs
---

## Install the necessary dependencies for UI by running the following command:

shell
1) npm install
2) npm start or ng serve

browse : http://localhost:4200
---

## Usage
1. Select the desired date from the date picker.
2. Click the "GETİR" button.
3. The application will retrieve the exchange rate data from CBRT for the selected date and display it in a user-friendly format.
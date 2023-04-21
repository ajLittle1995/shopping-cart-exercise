# shopping-cart-exercise
Short Spring Boot Shopping Cart Exercise

1. To run this project please clone the repo and navigate into the project directory
2. This project has a maven wrapper so to perform a clean install please run "mvnw clean install"
3. Next please run "java -jar target/shopping-cart-exercise-0.0.1-SNAPSHOT.jar" to launch the Spring Boot Application
4. Navigate to http://localhost:8080/ShoppingCart.html to test this application through a basic UI where you are able to upload a .json file.
5. Alternatively you can test the endpoint by sending json to http://localhost:8080/calculateReceipt (through Postman or other)
6. Coupons and Tax can be managed within the application.properties file with the following key {coupons.json.string} and {store.tax.rate}

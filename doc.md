# Documentation of ReadingIsGood

This project is developed by İlkay Aktaş and submitted at 10/02/2022. You can find some detailed information.
Java Version: 11.0.10 2021-01-19 LTS


### Build
When you take a look at application.yml file, you'll see that mysql ip address is given as environment variable. When you build or run test my assignment in IDE, you can change it manually, you can add environment variable from <u>run configuration</u> or you can use `export MYSQL_IP=localhost` terminal command.

I have created a build script in project. It runs unit tests, clear previously readingisgood-getir container, remove readingisgood-getir container and docker image.
You can also find Dockerfile in project structure. <u>**For a successful build and test, mysql daemon should be run. Also, MYSQL_IP environment should be set.**</u>

You will see a **build.sh** file. It's intentionally created by me. When you run it, gradle build task is called. After jar file generated, previously created readingisgood-getir docker container and image is deleted. Finally docker build command is run. After everything finished successfully, you can list newly created docker image using this command: `docker image ls | grep readingisgood-getir`

In addition, i have created a docker compose file. When you run `docker-compose up` command, mysql and readingisgood-getir are run. readingisgood-getir waits until mysql gets ready.

### Stock
Stock can be updated via rest using negative or positive integer. Negative means that remove book from stock, positive means that add book to stock.

### Time
Time units on Order query are epoc time in second.

### Bean Validation
In this assignment, i have used bean validation for rest objects. This functionality can be extended to all rest and entity objects. 
PasswordCriteria requires minimum 4 characters. 
EmailCriteria checks if the email is valid or not. 
OrderCountCriteria checks if the count is greater than zero or not.
PriceCriteria checks if the price is greater than zero or not.
StockCountCriteria checks if the stock count is greater than zero or not.
UsernameAndEmailUniqueCriteria checks if username and email are unique or not.

In addition, some valid email addresses are: `username@domain.com user.name@domain.com user-name@domain.com username@domain.co.in user_name@domain.com`

Here is a shortlist of some invalid email addresses:
`username.@domain.com .user.name@domain.com user-name@domain.com. username@.com`

### Informing About Postman
### Usage
You can find two extra file in project folder: **getir.postman_collection.json, getir.postman_environment.json**

You can test this application using these files. After import collection and environment, you have to select **getir** environments which i prrovided you.

All request has default admin:admin authentication data.

### Authorization & Authentication
Spring security is used for authentication and authorization.

Since i supposed that the detailed security is out of this assignment scope, i have created two role: ADMIN, USER.
Practically, there is not any difference between these roles.  

During database initialization, admin user is added for general purpose usage. **Username: admin Password: admin**

### Cookies
Previously i talked about authentication. I have used spring security. Using postman, you can send credentials and than be authorized.
In this way, postman keeps jsessionid and uses it for next calls. Even you don't enter credentials, postman can use jsessionid.
If you want to try unauthorized call, don't forget to delete cookies.

### SCENARIO in Collection
I have created a scenario in postman. Before running this scenario, previously database tables should be empty (Except admin user).

Best practice is delete all tables and rerun application. This will be a clean start.

Basicly, 5 customers are created. 4 different books are inserted. Book stock are updated on scripts. You can enter negative value to remove books from scripts. In total, 8 orders are created.
Also, you can find statistics script in postman collection.
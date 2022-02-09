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
Time units on Order query are epoc time.
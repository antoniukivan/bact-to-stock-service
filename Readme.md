# BackToStock Service

Service for notifying customers when the product back in the stock by send email.

### REST API

http://localhost:8080 - This is BackToStock Service API url.

|          Web API               |  HTTP  |           endpoint          |
|--------------------------------|:------:|:---------------------------:|
|Add product to store            |POST    |/products                    |
|Get product by id               |GET     |/products/id                 |
|Add user to the stock db        |POST    |/users                       |
|Get users by id                 |GET     |/users/id                    |
|Subscribe user for notification |POST    |/users/id/subscribe          |
|Unsubscribe user                |POST    |/users/id/unsubscribe        |





### To start you need:
1. Download and install the [JDK](https://www.oracle.com/java/technologies/javase-downloads.html)  
2. Download and install servlet container (for example [Apache Tomcat](https://tomcat.apache.org/download-90.cgi,))  
3. Setup connection with your DataBase 
  - add dependency to pom.xml file
  - spring.datasource.user=<your-username>  
  - spring.datasource.password=<your-password>  
  - spring.datasource.driverClassName=<your-db-driver>
  - spring.datasource.url: jdbc:mysql://<your-host-name>:<your-port>/<your-name-db>?useUnicode=true&serverTimezone=UTC  
4. Enter your data to application.properties file   
  - spring.mail.host=<your-mail-host>  
  - spring.mail.port=<your-mail-port>  
  - spring.mail.username=<your-username@mail.com>   
  - spring.mail.password=<your-password>  
  - spring.mail.protocol=<your-protocol>  
5. Run

### If you'll use Gmail - follow these steps:

1. Login to Gmail   
2. Access the URL as https://www.google.com/settings/security/lesssecureapps   
3. Select "Turn on"   

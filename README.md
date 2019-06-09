# vue-springboot-demo
A demo for using vue and springboot. It's a simple tiny machine management which can add、query、update or delete the machines. The project **dosen't think about the security** which may be completed in the future.

## Framework

* Element
* VUE
* Springboot
* Mybatis

## Directory

```
├─DB       // the sql file, which to creat the table in database
├─src      // the source code for java and html
│  ├─main 
│  │  ├─java
│  │  └─resources
│  │      ├─mapping   // mybatis sql files
│  │      └─static    // the html and css files will be placed here
```

## Using

1. Execute the file in DB directory to create the table in database.
2. Edit the file `src/main/resources/application-dev.yml`, change properties value of database. Making sure it can connect to the database successfully.
3. Open the terminal window in the root directory of this project and run the command:`mvn spring-boot:run`
4. Open the browser and enter `localhost:8080` 
5. Guest can only query or have a look at the machines while the administrator can add、update and delete the machines if he is login. There is only one account whose username is `admin` and the password is `admin`. If you want to change the password, write a `main` function in `com.guozhchun.util.EncryptUtil` and call function `com.guozhchun.util.EncryptUtil#encrypt` inside the `main` function. The input parameter of `encrypt` is a `String` which is the password you want to change and the output of this function is the encrypt password. You should change the value of   `com.guozhchun.service.LoginService#ADMIN_ENCRYPTION_PASSWORD` with the encrypt password you just get. Finally, you should recompile and run the application and then you can login with the new password.
6. The default language is Chinese and you can change it to English by click the button `English` on the upper right corner of the page.

# Change log

## 2019.06.02

* initial the project with the basic CRUD

## 2019.06.09

* add the condition query
* add the control for administrator
* add the internationalization
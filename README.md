# vue-springboot-demo
A demo for using vue and springboot. It's a simple tiny machine management which can add、query、update or delete the machines. The project **dosen't think about the internationalization or the security** which may be completed in the future.

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
# springboot-app
The purpose of this app is to query an aws database to look for an item by a barcode number and return information about that item.

Currently the functionility is:

The api queries the aws table to see if the product has been stored in there if it has it will return the information, if not
the api will add the barcode into another table to be added to the previous database.
### Note:
the database authentication information in application.properties is purposefully not commited, if you would like to see the api at work
send harajlyhassan@gmail.com an email and he will turn on the pcf instance that it is deployed (its turned off to save some money as the author develops the api locally).
## Running:
mvn package

java -jar target/demo-0.0.1-SNAPSHOT.jar

Deploying:
=======
cf login -a  https://api.run.pivotal.io --sso
(credentials will be provided for authorized personal only)

mvn package

cf push hassansApplication -p /c/Users/hassan/projects/springboot-app/target/demo-0.0.1-SNAPSHOT.jar

Post Request( for my entire postman collection go to https://www.getpostman.com/collections/21a90207e4924210de87):
===
localhost:8080/api/v1/itemLookup/saveifnotfound/0012612 (this number is an id number  representing an item barcode)

Get Request:
===
localhost:8080/api/v1/itemLookup/dontsaveifnotfound/0012612 (this number is an id number representing an item barcode)


===

### pcf base url:
http://hassanmharajlyapp.cfapps.io/

## Testing:
run "mvn test" command

to view the line coverage paste this url into your browser(this isnt an absolute path you need to find it on your machine): 
target/site/jacoco/index.html.
to test new classes in intellij right click inside of the file and click generate and select test, the testing library used is junit5.

## Setup:
Java version 8 only supported pcf only supports 8 not 11:
https://www.oracle.com/java/technologies/javase-jdk8-downloads.html
make sure the jdk is put on your path in the console to check type in "which java" no quotes you should see something similar to this:
/c/Program Files/Java/jdk1.8.0_251/bin/java


Download Apache maven 3.6.3 from:
https://maven.apache.org/download.cgi
to verify same enter the "which mvn" command you should see something similar to:
/c/apache-maven-3.6.3/bin/mvn

Download pcf for deployment:
https://docs.pivotal.io/pcf-dev/install-windows.html

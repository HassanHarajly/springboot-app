# springboot-app
## Running:
mvn package

java -jar target/demo-0.0.1-SNAPSHOT.jar

Deploying:
=======
cf login -a  https://api.run.pivotal.io --sso
(credentials will be provided for authorized personal only)

mvn package

cf push hassansApplication -p /c/Users/hassan/projects/springboot-app/target/demo-0.0.1-SNAPSHOT.jar

Post Request:
===
localhost:8080/api/v1/itemLookup/saveifnotfound/0012612 (this number is an id number  representing an item barcode)

Get Request:
===
localhost:8080/api/v1/itemLookup/dontsaveifnotfound/0012612 (this number is an id number representing an item barcode)

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

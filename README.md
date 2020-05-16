# springboot-app

Deploying:
=======
cf login -a  https://api.run.pivotal.io --sso

mvn package

cf push hassansApplication -p /c/Users/hassan/projects/springboot-app/target/demo-0.0.1-SNAPSHOT.jar

Posting:
===
hassanmharajlyapp.cfapps.io/api/v1/person

Getting:
===
hassanmharajlyapp.cfapps.io/api/v1/person/getMapping

## Setup:
Java version 8 only supported pcf only supports 8 not 11:
https://www.oracle.com/java/technologies/javase-jdk8-downloads.html
make sure the jdk is put on your path in the console to check type in "which java" no quotes you should see something similar to this:
/c/Program Files/Java/jdk1.8.0_251/bin/java


Download Apache maven 3.6.3 from:
https://maven.apache.org/download.cgi
to verify same as java do which mvn you should see something similar to:
/c/apache-maven-3.6.3/bin/mvn

Download pcf for deployment:
https://docs.pivotal.io/pcf-dev/install-windows.html

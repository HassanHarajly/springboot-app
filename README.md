# springboot-app

Deploying:
=======
cf login -a  https://api.run.pivotal.io --sso
mvn package
cf push hassansApplication -p /c/Users/hassan/projects/springboot-app/target/demo-0.0.1-SNAPSHOT.jar

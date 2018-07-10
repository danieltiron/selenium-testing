# How to run tests

From project folder:

`java -DappUrl="http://jsonplaceholder.typicode.com" -jar target/selenium-play-1.0-SNAPSHOT-jar-with-dependencies.jar testApi.xml` to run API tests

`java -DappUrl="http://the-internet.herokuapp.com/login" -jar target/selenium-play-1.0-SNAPSHOT-jar-with-dependencies.jar testLoginPage.xml` to run selenium tests

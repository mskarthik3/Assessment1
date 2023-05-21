
# Front End Testing Scenario

To build automated tests inorder to verify the working of borrowing calculator webpage.


## Step 1: Setup tools
1. I used Eclipse as my IDE because I can download Cucumber plugins and generate a Maven project, used Java as a programming language.
2. If you use Eclipse, install the Cucumber Plugin via Eclipse Marketplace.
3. Install Maven.

## Step 2: Initial setup and add dependencies
1. Created a Maven project
2. Added all the required dependencies into pom.xml file. You can find them in the [Maven repository](https://mvnrepository.com/)
3. To generate log files, used log4j2 file which is available in [APache logging](https://logging.apache.org/log4j/2.x/manual/configuration)
## Step 3: Framework structure
1. Under src/test/java--->pageObjects,
 webelements and action methods are created using Page Factory approach in Home.java class. And reusable methods like webdriver instance is created in BasePage.java
2. Under Features folder--->Calculator.feature, test scenarios are mentioned.
3. Under src/test/java--->stepDefinitions, all the corresponding methods for calculator.feature is created in steps.java
4. src/test/java--->testRunner--->TestRunner is created to execute Calculator.feature file which is mentioned above.
5. Under resources--->config.properties file, browser names are included which is used by steps.java to run tests under different browsers.
6. And log4j2.xml is added in resources folder which is used for logging. 
## Step 4: To run the tests
1. To run the test, go to src/test/java--->testRunner--->TestRunner, now run as Junit test.
2. We can also use pom.xml file to run the tests.Go to pom.xml,use run as Maven test command . Also remotely using command prompt by mvn test command.

## Step 5: Generate reports
1. After executing tests successfully, we get reports under reports--->myreport.html, myreport.jsn files. Output is also displayed in console.
2. Also log files are generated under logs folder after executing tests.

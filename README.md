This Project is related to validating the PwC Digital Pulse WebSite. In this project we have used Cucumber framework where we write BDD code in Feature file, the source code related to the feature file written in StepDefination files. We also implemented Page Object Model here and we created different page files related to different pages in the application. We have implemented hooks to implement common code which runs before and after each scenario. We define tags also in this framework so that we can run the scenarios as per our need.

We need to have below prerequisite to run the code in local environment:

	1. JDK(Version 11 is preferable)
	2. Maven
	3. Eclipse or IntelliJ IDE
	4. Cucumber Plugin should be installed in the Project.
	5. TestNG Plugin should be installed in the project.


Steps for executing the project Locally:

	1. Take a fresh clone of the codebase from github.
	2. Build the project to download the maven dependencies for the project.
	3. Execute the command via commandline using mvn commands or exucute direcly the CucumberTestRunner.java file under src/test/java/runner package.
	4. check the test-output folder for the Extent Spark and HTML report.

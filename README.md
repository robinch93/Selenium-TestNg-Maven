# MyTheresa
This project is implementation of UI and API tests.  

**Prerequisite**

- Java 
- Maven 
- Eclipse 
- TestNG

**RUN**

Below are the ways to run all three files :
1. Test 1: Run [testng.xml](https://github.com/robinch93/MyTheresa/blob/master/MyTheresa/src/test/java/GuiTest/testng.xml) file in GuiTest package, Right Click - Run As - TestNG Suite
2. Test 2: Run [TC_2_ApiTest.java](https://github.com/robinch93/MyTheresa/blob/master/MyTheresa/src/test/java/ApiTest/TC_2_ApiTest.java) file in ApiTest package, Right Click - Run As - TestNG Suite 
3. Test 3: Run [TC_3_Code.java](https://github.com/robinch93/MyTheresa/blob/master/MyTheresa/src/test/java/CodingProblem/TC_3_Code.java) file in CodingProblem package, Right Click - Run As - Java Application

Below is the dicussion about all the three Challenges with their respective link to the corresponding files:

- TC_1_GuiTest 1: This was a GUI test which was parameterized using TestNG to run it in three browsers, firefox, IE and Chrome in parallel. Before execution, the second argument of setProperty method need to be updated for respective drivers of each browser according to their location in local machine. 

&nbsp; [src/test/java/GuiTest/TC_1_GuiTest.java](https://github.com/robinch93/MyTheresa/blob/master/MyTheresa/src/test/java/GuiTest/TC_1_GuiTest.java)

&nbsp; [src/test/java/GuiTest/testng.xml](https://github.com/robinch93/MyTheresa/blob/master/MyTheresa/src/test/java/GuiTest/testng.xml)

- TC_2_ApiTest: This was an API test which has six test cases, for different kind of validations on the API provided. The Schema files were created by converting json to pojo format, to easily access different attributes of json using methods, and perform validations. Those schema files are are also in ApiTest package. 

&nbsp; [src/test/java/ApiTest/TC_2_ApiTest.java](https://github.com/robinch93/MyTheresa/blob/master/MyTheresa/src/test/java/ApiTest/TC_2_ApiTest.java)

- TC_3_Code: This was a coding challenge. It executes in the console and requires user input in between. 

&nbsp; [src/test/java/CodingProblem/TC_3_Code.java](https://github.com/robinch93/MyTheresa/blob/master/MyTheresa/src/test/java/CodingProblem/TC_3_Code.java)


- Maven POM.xml: Maven framework was used to easily manage libraries through the pom file. 

&nbsp; [MyTheresa/pom.xml](https://github.com/robinch93/MyTheresa/blob/master/MyTheresa/pom.xml)

- Execution Results: Below folder contains the results generated after execution of all three challenges, as screenshots. 

&nbsp; [src/test/resources](https://github.com/robinch93/MyTheresa/tree/master/MyTheresa/src/test/resources)











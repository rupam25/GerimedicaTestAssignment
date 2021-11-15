Selenium-TestNg-Java-Maven
=================

Selenium-TestNg : Automation Testing Using Java

This is a test assignment for application url https://www.vangoghmuseum.nl

Documentation
-------------
Step 1 : `mvn clean install`

Step 2 : `Run testng.xml`

It will execute all test scripts and generate an excel report at location /reports.By Default it will run on firefox browser.
User can change browser through pom.xml.
 


Project Structure
--------------
	Project-Name
		|_reports
		|_src/main/java
		|       |_Pages
		|           |_CollectionPage.java
        |               |_HomePage.java		
		|       |...
		|	|_Services
		|           |_BaseServices.java
		|           |_CommonServices.java	
		|	|_Utils
		|	    |_ExcelGenerate.java
		|	    |_TestRunData.java
		|	    |_UtilConstants.java	
		|_src/main/resources
		|       |_project.properties
		|_src/test/java
		|	|_FunctionalTest
		|           |_TestScripts.java

Test Cases
--------------

###  TC1: navigateToCollectionPage()
This test script verifies all default page elements on page navigation
#### Steps:
1. Open Url
2. Click on Accord Button
3. Scroll Horizontally
4. Click on Ont de Collectie link
5. Verify all page elements

###  TC2: performSearch()
This test script verifies total number of Search result greater than 700
#### Steps:
1. Open Url
2. Click on Accord Button
3. Scroll Horizontally
4. Click on Ont de Collectie link
5. Search "Het Gele Huis"
6. Verify number of search result > 700

###  TC3: verifyDataofFirstSearchResult()
This test script verifies all page elements after search with multiple data
#### Steps:
1. Open Url
2. Click on Accord Button
3. Scroll Horizontally
4. Click on Ont de Collectie link
5. Search "Het Gele Huis"
6. Click on First search result
7. Scroll Vertically
8. Open Objectgegevens details
9. Verify F-nummer , JH-nummer , Inventarisnummer field along with data


Reports
--------------
An excel report will be generated after execution of Test Suite at location /reports

Format of Report is shown below:

[![Result-1.png](https://i.postimg.cc/nhPMWq8L/Result-1.png)](https://postimg.cc/mP7bzzgx)
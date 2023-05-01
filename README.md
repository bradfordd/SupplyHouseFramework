# Selenium Java with Cucumber SupplyHouse Regression Suite

This project contains a Selenium Java regression suite using the Cucumber framework for SupplyHouse.com. The test suite covers various functional and UI aspects of the application.

## Requirements:
- jdk 11
- Cucumber-java 7.5.0
- junit 4.11
- testng 6.14.3
- Selenium java 4.8.0
- cucumber-testng 7.5.0
- Apache Maven 3.8.6
- SupplyHouseFramework

## Table of Contents
- [Getting Started](#getting-started)



## Getting Started

Follow these steps to set up the SupplyHouseFramework project on your local machine and import it into your Java IDE:

Clone the repository:
Use the following command to clone the remote Git repository located at https://github.com/bradfordd/SupplyHouseFramework.git to your local machine. This creates a new directory called SupplyHouseFramework containing the project files.



git bash:
    ``` git clone https://github.com/bradfordd/SupplyHouseFramework.git ```
    Navigate to the project directory:
    Change your current directory to the newly cloned SupplyHouseFramework directory with this command:

git bash:

	 cd SupplyHouseFramework 
Import the project into your Java IDE as a Maven project:
Open your preferred Java IDE (such as IntelliJ IDEA or Eclipse) and follow the steps below to import the project as a Maven project.

For IntelliJ IDEA:

Open IntelliJ IDEA.
Select "Open" or "Import Project" from the welcome screen or File menu.
Navigate to the SupplyHouseFramework directory and select the pom.xml file.
Click "OK" to import the project as a Maven project.
For Eclipse:

Open Eclipse.
Go to File > Import.
Select "Existing Maven Projects" under the "Maven" folder.
Click "Next."
Click "Browse" and navigate to the SupplyHouseFramework directory.
Select the pom.xml file.
Click "Finish" to import the project as a Maven project.
After completing these steps, the SupplyHouseFramework project will be set up in your Java IDE, and you can start working with it.







































Clone the repository:
bash
Copy code
git clone https://github.com/bradfordd/SupplyHouseFramework.git
Navigate to the project directory:
bash
Copy code
cd SupplyHouseFramework
Import the project into your favorite Java IDE (e.g., IntelliJ IDEA or Eclipse) as a Maven project.

Ensure that you have the required JDK version installed and configured in your IDE.

Running Tests
To run the test suite from your IDE, follow these steps:

Locate the test runner class (usually named TestRunner or similar) in the src/test/java directory.

Right-click on the test runner class and select 'Run' or 'Debug' to execute the tests.

Alternatively, you can run the tests from the command line using Maven:

mvn test
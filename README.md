
## Overview
This repository contains the complete source code of the Automation framework task.

# Requirements
This Solution requires the following Softwares for working and building upon the same:
- IntelliJ IDE Community version

## Building and Installing
The following explains the steps involved in Building and Installing the Solution:
- Clone the Repository in a local folder
- Open Project in IntelliJ IDE
- right click on POM.xml-> import dependencies

# Execute tests using Runner file
- Open project in IntelliJ IDE Community version
- Got to Test -> Java -> Runners
   - select file RunCukesTest -> right click on it -> Run "RunCuckesTest"
   
# Execute tests using maven Build
- Open project in IntelliJ IDE Community version
- Got to View -> ToolWindows -> Maven
   - select Test option -> click on Run   

# Automation Framework expectations: 
- Automation framework should be designed in such a way that it should be moduler, extendable, maintainable, scalable, high performance, easy to write scripts, easy to understand the code logic.

# How proposed automation framework Meet the expectations:

# Automation framework overview 

- Design 
  - This is moduler based automation framework. 

- Used programming concept to increase maintanability:
 - class
 - object
 - abstraction
- encapsulaton 
- solid principles 

- Used design patterns
 - page object
 - factory 

# Extendable : Locator type, value and test data is decoupled from the framework. which makes it Supportive to automation frameworks like
- data driven
- keyword driven
- BDB (cucumber)
- screenplay(jbehave)

# High performance
- wait for element handled using intelligent wait having pooling time. This will increase script execution time.

# Easy to write scripts:  
- Method naming used across framework based on the product functionality. So any manual/ automation tester can write test script without any hustle.

# Easy to understand  code: 
- All methods have code comment attached, to define its purpose and help developer to understand the code.

   
# Automation framework design flow

![Alt text](/AutomationArchitecture.png "Automation Architecture Digram")

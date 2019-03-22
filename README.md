Example of Selenium Parallel Run  
=======================

[Easy Setup for Parallel Test Execution with Selenium Docker](https://sqadays.com/en/talk/62825)

[How to Dockerize Parallel Execution of Selenium Tests](https://sqadays.eu/en/talk/69114)

How to run:
1. Open a terminal
2. Clone this project.
3. `cd selenium-parallel-run`
4. `mvn clean install -DskipTests`
5. `mvn failsafe:integration-test`

All dependencies should be downloaded and the example tests will run successfully in chrome in 3 parallel threads.

As a target application for a testing was used [Todolist MVC](https://github.com/benas/todolist-mvc) 

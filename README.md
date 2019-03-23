# DataStructure_Momenton
Hierarchy code challenge

Requirement:
(full requirements found in Coding challenge.pdf)
Design a suitable representation of this data. Feel free to choose any database (RDBMS, in- memory database etc), file system or even a data structure like List or Map. Then write code (in any language and framework) that displays the organisation hierarchy as below:
The result can be simply displayed on the console, or HTML page or even a file; whatever suits you.
Try to cover all the possible scenarios, for example an employee with no manager, a manager who is not valid employee; etc.
Pay more attention on writing the actual logic of representing the employee tabular data into the hierarchical format.

Deliverable:
Code in java 8 which represents the provided data and structure and handle all scenarios provided in requirements document.
Test all scenarios to prove capabilities of code.
Code quality - (used jacoco, spotbugs and junit5)


To run main requirement:

from terminal:
mvn compile site - builds code, runs tests and generates code coverage and test results report visa surefire, spotbugs.

Code Quality Reports:
Code Coverage = .\target\site\jacoco\index.html
Code Quality = .\target\site\spotbugs.html




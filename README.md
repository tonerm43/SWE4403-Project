# SWE4403-Project
Design Patterns project winter 2019

#### CS4015/SWE4403/CS6015 Project Requirement and Guide

##### Project due: Thursday, Apr. 18, 2019 at 4:30 pm (AST). Please note that due to University requirements, no extensions can be given.

In this project, you need to design and implement a software application which implements one or more architectural pattern and 12 or more design patterns. If you implement more than 12 patterns in your project, for each additional pattern implemented and documented correctly, there will be a 1% bonus toward your course total scores. 

You can develop any application in which you are interested, as long as your implementation fulfils the requirement to have one or more architectural patterns and 12 design patterns. If you do not have your own idea about what application you can develop, a suggestion is provided in the paragraphs at the end of this document.

Your application should be developed using Java.

For this project, you need to submit the following 3 artefacts in a single zip file with name “CS4015Project_studentname.zip”, “SWE4403Project_studentname.zip”, or “CS6075Project_studentname.zip” in the course D2L.

Exported Design model with the main class diagram of your software application in Rational Software Architect Designer. In the class diagram, you only need to give class names and their relationships without class attributes/variables and operations/methods. 
A PDF document in which you need to describe how each of the architectural and design patterns is implemented in your application.
Exported source code of your Java application in Eclipse or Rational Software Architect Designer.

##### Application Suggestion

Write an application to schedule courses for the Bachelor of Computer Science undergraduate program. The system works as follows: professors receive teaching assignments and enter them into the system; they express preferences on their teaching times and enter them into the system; then courses are all combined into a single timetable, maximizing the number of teaching time preferences that can be accommodated. Some constraints on the courses are that there is a limited number of classes, each with a specified capacity (the user can enter these classes in the system); that one professor cannot teach in two courses at the same time; and a student who attends the program as indicated in the program schedule (which as well can be entered by the user) will be able to attend every course in her/his schedule for the semester. Electives can be superimposed, but there must be at least enough scheduled separately that a student can complete every semester of a program; whereas core courses cannot be superimposed. If you wish to use a model for the program, feel free to adapt the Computer Science program in the calendar, although the program described is not sophisticated enough to understand the distinction among electives. The design of this program lends itself to the use of both architectural and design patterns. Feel free to use an object-based database (as simple as just serializable Java objects), but other more formal databases (like SQL) can be used. Please gauge the complexity of this program, especially the matching algorithms, very carefully: the project is not about succeeding in implementing an optimal scheduling algorithm, but rather about implementing architectural and design patterns to create the project. The timeliness of your submission is paramount.
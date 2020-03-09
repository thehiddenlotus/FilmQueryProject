
## Film Query Project
### Week 6 Skill Distillery Homework Project

#### Overview
This is a java program for for accessing and retrieving data from a database. The program connects to a MySQL database through JDBC so the user can analyze data.
Once initialized the program will loop prompts for user input until the user exits the program with the corresponding menu option. The program utilizes the shell to display text to the user and take keyboard input.

The program utilizes several classes divided into three categories. There is the app class as usual as well as a couple object classes for Actors and Films. There is a new interface and implementing class for accessing the MySQL database.

#### Technologies Used
_Java_
- OOP
- Polymorphism
- Inheritance
- Encapsulation
- JDBC

_MySQL_
- Prepared Statements
- Joins

_Eclipse_

#### How to Run
1. Launch the Java application.
2. The program will display to the user a menu from which they can pick from 3 options to search films by ID, search films by keyword or exit.
3. The user may select to search films by ID from which they will be prompted to enter an integer that will be used to match to film ID's in the database. If there is a match it will be shown, if not the user will be notified.
4. The user may select to search films by keyword from which they will be prompted to enter an String that will be used to match to film titles and descriptions in the database. If there is a match it will be shown, if not the user will be notified.
5. The user menu will repeat after each decision unless the user should choose the option to exit the program.

#### Lessons Learned

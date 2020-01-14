# HUMAIN
ERP module - HR - sofware<br>
HR tool for managing employee data. It provides full access for HR personel and restricted access to other employees in order to monitor, update or insert data regarding employees.

## How To Run

### Dependencies
* jdk 1.8.0
* git

### Execute:

Import into IDE (Eclipse and Intellij tested)<br>
Find /src/hrManagementMain.java and run it.

### Data to sign in :

Admin user
username : maria
password : maria

Simple user
username : kate
password : kate

### Data to sign up :

In order to successfully sign up to HUMAIN the user should enter the unique ID (given by the company).The system checks whether this id exists in the Employee database (csv file). If this id doesn't the user cannot sign up. 
In the security question and answer fields the user has to enter whatever but has to remember that in case of forgeting the password.
And finally selects from the radio button the type of user (admin or simple user).

### Navigation through the Admin dashboard :

(Follow this procedure)
Press the Load Employee Data Button to see all the information about the personnel.
You can now
1. Add an Employee record by filling in all the fields needed and clicking Add Employee button.
2. Select an Employee from the table and see the information on the right.
3. Update an Employee's information (by selecting the particular row) , edit the fields you want to update and click the Update Button.
4. Delete an Employee from the database by selecting the particular row in the table and click the Delete Button.


After this you can go to the Search Area (right to the Load Employee Data Button) and type keywords. The table, after this filtering, shows only the records including these keywords. 
ATTENTION! You have to go to the Search Area AFTER going through all the others functionalities otherwise you won't be able to check them after the filtering.

There is also the ability to check the signed-in user profile by clicking My profile Button.

### Navigation through the User dashboard :

On the left side there is the user's personal information and on the right you can load your colleagues data (the employees that work in the same department with the user) by clicking on the Load Colleagues. 




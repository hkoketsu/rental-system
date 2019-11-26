# CarRentalSystem
CPSC 304 project

## To run this program
1. Tunnel into undergrad server
```
  $ ssh -l username -L localhost:1522:dbhost.students.cs.ubc.ca:1522 remote.students.cs.ubc.ca
```
  change username to your CWL id
 
2. Change oracle database username and password to yours
  
  src/ca/ubc/cs304/databaseDatabaseConnectionHandler 
  
  line 20, 21

3. Compile and Run
```
  $ cd src/ca/ubc/cs304/app
  $ javac App.java
  $ java App
```
  
## Admin option
```
  $ java App admin
```
This will allow you to manipulate reservation table directly (for grading schema).

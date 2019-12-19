# About
This is a course project from CPSC 304

## To run this program
1. Tunnel into undergrad server
```
  $ ssh -l username -L localhost:1522:dbhost.students.cs.ubc.ca:1522 remote.students.cs.ubc.ca
```
  change username to your CWL id
  
2. Compile and Run
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

CS542 Design Patterns
Spring 2015
PROJECT <1> README FILE

Due Date: <Monday, March 09, 2015>
Submission Date: <Monday, March 09, 2015>
Grace Period Used This Project: <0> Days
Grace Period Remaining: <0> Days
Author(s): <Pravin Nagare> 
e-mail(s): <pnagare1@binghamton.edu> 

PURPOSE:
[
  To design a simple multi-threaded client-server code in Java and apply the design principles/patterns we have learned so far.
]

PERCENT COMPLETE:
[
  I believe I have completed 100% of this assignment as per the requirements. 
]

PARTS THAT ARE NOT COMPLETE:
[
  I believe everything is complete.
]

BUGS:

[
  None
]

FILES:

[

Included with this project are 12 class files and 2 interfaces:
Class files-
PrimeDriver.java: The driver class which contains main function.
ServerDriver.java: The server socket thread is created and server menu method is called in this file.
ClientDriver.java: The server socket is created in this file.
ServerMenu.java: Displays menu on server side to access data from hash table.
ClientMenu.java: Displays menu on client side to take input from client.
Debug.java: Debug the flow of program.
CheckPrime.java: Checks if number is prime or not
AllPrimeQueries.java: Operations to add data entries to data structure and display them.
PrimeServerSocket.java: File creates socket and PrimeServerWorker thread is started
PrimeServerWorker.java: To interact with client
PrimeClientSocket.java: File creates socket and PrimeClientWorker thread is started.
PrimeClientWorker.java: To interact with server

Interface files-
ClientMenuInterface interface for client menu
ServerMenuInterface interface for server menu

]

SAMPLE OUTPUT:

[


]

TO COMPILE:

[
  ant -buildfile src/build.xml all
]

TO RUN:

[
  ant -buildfile src/build.xml run
]

EXTRA CREDIT:

[
  Project running successfully using ANT. 
  DEBUG_VALUE=1 [Print to stdout everytime a constructor is called] 			
  DEBUG_VALUE=2 [Print all the client side methods]
  DEBUG_VALUE=3 [Print all server side methods]
  DEBUG_VALUE=4 [Print to stdout everytime server socket created, client/server responded]
    	
]

BIBLIOGRAPHY:

[
http://stackoverflow.com/questions/22663107/print-all-key-value-pairs-in-a-java-concurrenthashmap
http://www.dotnetperls.com/arraylist-java
http://stackoverflow.com/questions/12358363/how-do-i-store-many-values-with-one-key
]

ACKNOWLEDGEMENT:
[

Prof. Madhusudhan Govindaraju
cs542.cs.binghamton.edu mailing list

]

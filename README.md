# ITCS 3166 Final Project

## Project Requirements
[Full Requirements](https://webpages.uncc.edu/aatzache/ITCS3166/Project/ITCS3166ProjectAssignment.txt)

3. Implement IP router function, which does the following:
- takes as an input: 
	- a 32 bit IP address
	- a routing table: a list of IP address - subnet mask - Interface (NIC card) pairs
- does a binary AND of the subnet mask with the input IP address to extract the network part of the address
- compares the network part of the address with each address in its routing table
- if it matches with one of them , it routes the packet to the matching Interface
- if it matches none of them , it routes the packet to the Default Router (Gateway)

4. Use the data (IP addresses and routing table) from Exercise 33 Chapter 5  for your program.

Hint: the IP addresses first need to be converted to binary in order to extract and compare the network part . see sample IP address conversion here:
https://webpages.uncc.edu/aatzache/ITCS3166/ExerciseD.doc

5. Create a Graphical User Interface - showing which packet gets routed to which Interface at any given time. Use Java programming language for this project.




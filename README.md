# CodenaVirusSimulation
Simulation of the spreading of the virus using multidimensional arrays <br />
• One infected person will infect only one healthy person next to him each day <br />
• If a person is infected, he will infect the person on his right, unless the latter is already infected, then he will infect the person on his top instead, but if that person is also already infected, then he will infect the one on his left, lastly if this one is also already infected, the he will infect the one below if this one is still healthy. (The examples will clarify) <br />
• A newly infected person will start infecting other people one day after the infection. <br />
• An infected person will recover after exactly 3 days of illness, counting from the day he got infected, and he will become immune to the virus (he won't be infected anymore) <br />



Inputs <br />
• world: a matrix of characters representing the proximity of people in a the world. A person is represented by "#" and empty spaces are represented by ".". One person is next to another one if they share the same row OR the same column and there is no empty space or another person between them. <br />
• firstInfected: an array of integer of size 2 ([row, col]) storing the coordinates of the first person to contract the virus on day 1. <br />

Output <br />
An array of 4 integers [a, b, c, d] where: <br />
• a : number of days until the virus stops spreading <br />
• b : number of infected people at the end of the spread <br />
• c : number of recovered people at the end <br />
• d : number of uninfected people <br />
	
	
Prioritize lower indexes if there is a case where one person is about to be infected by two neighbors, in that case the neighbor with lower row/col will win (Eg. Day 3 of test 4). <br />
Example <br />
• For world = 
[["#","#","#"],  <br />
["#","#","#"],  <br />
["#","#","#"]] <br />
and firstInfected = [1, 1], the answer is [7, 3, 6, 0] <br />
Explanation: H for healthy, I for infected, R for recovered <br />

DAY 0: <br />
[ <br />
["H", "H", "H"],
["H", "H", "H"],
["H", "H", "H"],
]
DAY 1:
[
["H", "H", "H"], <br />
["H", "I", "H"], <br />
["H", "H", "H"], <br />
] <br />
DAY 2: <br />
[ <br />
["H", "H", "H"], <br />
["H", "I", "I"], <br />
["H", "H", "H"], <br />
] <br />
DAY 3: <br />
[ <br />
["H", "I", "I"], <br />
["H", "I", "I"], <br />
["H", "H", "H"], <br />
] <br />
DAY 4: <br />
[ <br />
["I", "I", "I"], <br />
["H", "R", "I"], <br />
["H", "H", "I"], <br />
] <br />
DAY 5: <br />
[ <br />
["I", "I", "I"], <br />
["I", "R", "R"], <br />
["H", "I", "I"], <br />
] <br />
DAY 6: <br />
[ <br />
["I", "R", "R"], <br />
["I", "R", "R"], <br />
["I", "I", "I"], <br />
] <br />
DAY 7: <br />
[ <br />
["R", "R", "R"], <br />
["I", "R", "R"], <br />
["I", "I", "R"], <br />
] <br />
 <br />
• [input] array.array.char world <br />
• [input] array.integer firstInfected <br />
• [output] array.integer <br />
1

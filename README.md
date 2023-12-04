# advent-of-code-2023

Last year, I viewed Advent of Code as just puzzles and solved them using my existing skills in Java without improving them.
This year, my approach is to solve them in a way which would also improve my development skills. If I know what to do but unsure about the
best approach, I will search for it rather than struggling by with what I already know.

Day 1
-
I tried to start with creating a project structure without really planning ahead. So what happened is that all logic ended up in a single
class. I also created a separate package for utility classes, which at the moment seems like it's a good choice. I'm putting all the
upcoming input files in a resources directory. This seems right.

For the puzzle I first created an utility class for manipulating text files while hoping that it's going to be useful in the upcoming
puzzles. I also used a hashmap to match spelled out digits (strings) with integers. After that i used some general logic to parse the text
line by line and calculate the needed values. Fortunately the second part logic could be built on top of the first one.

New or unfamiliar things used: **.charAt**, **.trim**;

Day 2
-
I tried to start with creating a project structure, but this time i did a little planning ahead. This only helped only a little, but it's
slowly getting better.
The puzzle was solved similarly to the first one. I put the hashmap in it's own class. Looking back I think i should have made a class for
colors and included the map in there. I also
created a class for game logic. This approach worked in the beginning but fell apart as i progressed. I wasn't sure how to access some
methods from other classes and by the time i figured it out i was done with the puzzle.
The utility class i created was used again and the input directory also looks to prove useful.

New or unfamiliar things used: **Switch statement**,

Day 3
-
Today I did the most planning before coding, but the result was the worst yet. I wrote out the logic I would need, the methods and classes i
would use and how I would structure it on a whiteboard. What i didn't account for was how difficult this days puzzle would be. Everything
was built under one class as things were slowly falling apart. I managed to solve the first part of the puzzle. When i saw the second part i
realised that there is no way i could solve it using the same logic that i built. Due to time constraints i decided not to attempt the
second part.

New or unfamiliar things used: **Pattern**, **Regex**

Day 4
-
Today i tried a different approach, as at the moment it takes more time than i have to try build a project structure for each puzzle. I just
started writing logic in Main class. Suprisingly i think this attempt looks the best yet, even though everything is in one class. I
refactored my logic by extracting methods. It seems to be a bit worse than building the methods during the coding, which is not suprising.
Overall i'm pleased with how it turned out. Most logic got decoupled into short methods and should be sort of understandable for someone
looking at it for the first time.

New or unfamiliar things used: i didn't need anything new as the puzzle today was quite easy for me.
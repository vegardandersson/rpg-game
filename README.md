# README

I know that a README should normally specify project parameters and not fully fleshed out assignment thoughts/feedback but I did not know where else to convey this information

## Notes on assignment
### Branching
For this assignment, I did not catch the fact that we were required to implement additonal/extra features on a separate branch.
I agree that this is obviously the smartest thing to do, but seeing as I was quite comfortable with adding additional features without affecting
the quality or reliability of the already implemented assignment-part of the system, I did not implement the extra features on a separate branch.
I have instead tried my absolute best to ensure that the extra content that I have implemented is mostly completely separated from the content relating to the
standard assignment. For the extra content that actually exists within the classes of the original assignment implementation in order for the extra features
to operate, I have tried to mark everything with a "*extra" comment so that it should be fairly easy to read/grade only the parts concerning the main assignment 
requirements. Otherwise the structure is as follows: Everything in the packages "game_elements_extra" and "game_logic_extra" is extra content. In the test-folder, only the files "EquipmentTest.java" and "HeroTest.java" relate to the assignment requirements, all other test-files are extra content.
### TDD
The application is built with the Maven framework and the testing pipeline used in the project is supplied using Github Actions with Maven.
The conditions for the pipeline(workflow) are defined in the "maven.yml" file. The pipeline can be viewed by looking at the "Actions" tab in this repository,
where the entirety of the pipeline runs/pushes should be visible. By clicking on a specific commit/run and then clicking on the "build" elmement, one can view
the entire run of the pipeline for that specific push. By expanding the "> Build with Maven" tab and scrolling a bit down, the generated test-report for running the tests can be viewed. Initial tests for the project were written early in a relatively test driven manner and were continuously used to check that the application behaved as expected when adding new features. Towards the end of the project, I realized that although I had tested all the main functionality as expected while developing, I had not adhered to all the requirements for testing defined by the assignment. That is why there is a huge edit/redesign of the tests that occur later in the pipeline history. Although I feel I adhere to most principles of good test design, I break the rule of having only one assertion per test in some cases. I feel that in those cases, there is a good argument for why it makes sense to have say an additional assertion in one test but I understand the argument for avoiding this as much as possible.
### General
For the requirements relating to the main assignment, I have tried to implement/cover everything it asks for. For the extra content I have also tried to incorporate as many of the common, good practices of java programming and design as possible but considering that I understood that the extra content can not really affect your grade, I sacrifised some key elements in order to achieve a better functioning game-loop (the object of my extra content). It is therefore more lacking in terms of test coverage and documentation than the part relating to the main assignment but I hope this is acceptable. 

## Notes on base application

### Design of system


### Deliberate Design choices/interpretations of the assignment
I don't remember the assignment mentioning a specific required implementation of the levelAttribute situation. I chose to have the "Hero" class have an additional attribute not mentioned in the assignment called levelUpAttribute. By doing this, we do not need to concretely implement or polymorph the "levelUp()" function in all child classes of "Hero" based on specific attributes, and instead we just have a general "levelUp()" function in the parent class with each child having a unique levelUpAttribute defining what "levelUp()" should increase the levelAttribute with. The same logic could be applied to "CalculateDamage" but I feel there is a great possibility that in the future, if one were to expand on the game, different classes would have very different ways of dealing damage that would need concrete(or from interface) implementations.

I created a service called "DisplayService" that generalizes and handles all printing to the console for the application. I felt that it made sense to have such a service when thinking about what a potentially larger system would look like and how this would create more clearity and maintainability of printing to the console when the application grows. Most of it is used in the extra content, but the required method "displayHero" is also found in this service class. I felt that it made more sense to leave this responsibility to the game logic and not the Hero. An alternative would be to have a very advanced toString() in Hero and just lett DisplayService display the message without a specific implementation in the service.


## Notes on extra application

The extra content does not have related UML-diagrams for class-structure or program-flow but I have tried to explain the additions below

### Entity additions to the main application
I added an Enemy type that has the same type of hierarchic structure as Hero which the hero can engage combat with. A concrete implement
of the Enemy exists in the form of a Goblin. I also added the interface IsCombatant which I attach to Hero and Enemy. This interface will supply the main actions expected of any entity in the game that can engage in combat. I also added the Chest item which implements the IsLootable interface which is designed to supply any lootable objects in the game world with necessary actions for supplying the hero with loot when interacted with, since there can exists many lootable objects besides chests. In order for combat and leveling to actually make sense in a game world I also added the managers EXPManager and HPManager which manage exp (experience points) and hp(hit/health points) respectively. HP is mainly used in direct combat while EXP is a reward from combat and is a condition for leveling up based on EXP thresholds. I added a WorldGrid class which contains a 2 dimensional grid representation of a game world and where world objects can exist in the form of different WorldObjectTypes such as ENEMY and CHEST that will prompt an interaction with the above described entities when encountered.

### Logic/Script additions to the main application
In order to set up a general game loop that actually made a playable console game possible, I created a few scripts/controllers for facilitating game flow. The game controller controls the main game loop and triggers or activates other controllers/events when needed based on player actions. The game starts by making use of a HeroCreationController to create a character and the game controller then enters the game loop. The main game loop consists of traversing the world grid by using the WASD keys which is achieved by continuously updating a 2d position of the hero in the world grid. When the hero enters a position in the grid where a WorldObjectType other than NULL is present, the game controller triggers a game event based on the contents. I created two different events, CombatEvent and LootEvent whichi both implement standard event methods from the interface GameEvent. These contain logic for completing a scripted event relating to the nature of the object encountered (Enemy -> CombatEvent, Chest -> LootEvent). After the event finishes, the game loop continues. The player is able to encounter the EXIT WorldObjectType which a hero can use to advance to the next floor. The floor increment by one each time and everytime, a fresh game board is generated which the hero can then continue exploring

### Improvements/Additions
As time was running out, I managed to create a decent amount of elements to provide a runnable game environment but lacked time to populate it with any actually engaging mechanics. A lot of the interfaces and/or classes can also appear empty or unneeded but they serve to create a structure/architecture which can be used to expand and add more resources and concrete implementations in the future. Extra mechanics that were planned but not implemented were: Write a generation algorithm that actually generates a more varying game world each floor, make chests generate random rewards (and not hard coded axe as of right now), make Equipment rewards and enemiy threat scale with what floor you are on so it actually becomes challenging to advance, add more items that would make a run of the game feel unique (like permanent buffs and upgrades found in the Rouge-like genre of games), add more types of stats like defenses (magic and physical defense provided by armor), damages (magic and physical damage), add spellcasting and other uniqe abilities to each class. The mentioned features are not too difficult to implement but require some extra time that I unfortunately do not have.

### Testing
I wrote some tests for the extra content as well but I did not write any tests that test game logic and interactions between entities or game events as this would almost constitute integration testing and could include actual game testing and I did not have the time for this.


# AE2DMS-CW-20124983

WORD COUNT: 496             FIGURE: 34

### Refactoring

#### Use of OO design pattern

- **State design pattern**

State design pattern is used in the **GameEngine class** in the **GameState package**. Divide GameEngine into **playState** and **debugState**. *move()* and *debug()* methods are controlled by different state. <u>Reduce if else statements.</u>

<img src="/docs/README_imgs/GameState.png" alt="GameState"/>



<img src="/docs/README_imgs/GameState_Package.png" alt="GameState_Package" width="60%"/>



- **Factory design pattern**

Factory design pattern is used in the **Dialog package**. **DialogFactory class** is instantiate in **GameController** **class** to generate different type dialogs. <u>Reduce code duplication and become more maintainable.</u>

<img src="/docs/README_imgs/Dialog.png" alt="Dialog"/>



<img src="/docs/README_imgs/Dialog_Package.png" alt="Dialog" width="60%"/>

- **Singleton design pattern**

Singleton design pattern is used in the **Music package**. Include two BGMs, interface sound effects and game sound effects. All those classes are called play/stop by **Controller classes**. Game music effects are used in **move()**. <u>Improve the efficiency of the game, without having to load music resources every time.</u>

<img src="/docs/README_imgs/Music.png" alt="Music"/>



<img src="/docs/README_imgs/Music_Package.png" alt="Music" width="60%"/>

#### Use of GUI design patterns

- **MVC design pattern**

MVC design patterns are implemented in the project. For example, **game.fxml** is the **view**, **GameEngine class** is the **model** and **GameConroller class** is the **controller** that *modify the data in the model and updates the view*. Here are two MVC examples in the game. <u>Make the structure of game simpler, enable code reuse.</u>



<img src="/docs/README_imgs/MVCs.png" alt="MVCs" width="60%"/>



- **Code and view are separated**

The **code** and **views** of all the JavaFX scenes in the game are separated clearly. Use **css** to improve the **UI design**.

<img src="/docs/README_imgs/Controller.png" alt="Controller"/>



<img src="/docs/README_imgs/FXML.png" alt="Controller"/>



<img src="/docs/README_imgs/Controller_Package.png" alt="Controller_Package" width="60%"/>



####  Refactoring Methodologies (Difficult to give example, all bad-smell source code is re-factored)

- “SOLID” Design Principles are considered during coding.
- Extract Method From A Larger Block of Code
- Simplifying Methods
- Replace Temporary with Query
- Replace Parameter with Explicit Method
- etc.



#### Maven Use

Maven is used in the project. <u>Make it easy to download dependencies when other developers start work on the code.</u>

<img src="/docs/README_imgs/Maven.png" alt="Maven"/>

The .jar file built by Maven. Run successfully in IDEA.

<img src="/docs/README_imgs/Maven_jar.jpg" alt="Maven_jar" width="50%"/>



#### Fixing Errors

All the errors in the source code are fixed, including **save(), load(), toggle music(), etc.** They have been **fixed** and **refined** according to my design requirements. These method are all in the **GameController class**. <u>This is a part of **"Corrective Maintenance"**.</u>





### Additions

There are 14 new features in the game.

#### 1. Start Animation Screen

First scene of the game. Players can enjoy **animation** and **music** until they click the screen to enter the Menu scene.

<img src="/docs/README_imgs/Start_Animation.png" alt="Start_Animation" width="40%"/>

#### 2. Start Menu Screen

Menu scene of the game, user can **click one of the buttons to enter another scene**.

<img src="/docs/README_imgs/Menu_Scene.png" alt="Menu_Scene" width="40%"/>

#### 3. Select Archive Screen

Player can have **three different archives** in this game. If the **slot is empty**, player can **create new archive**, set the **nickname**. The player’s **game progress** is also displayed. e.g. 4/8 Level is in 4th level. Click the **non-empty slot**, **continue to play the game**! Click the **"ERASE SLOT"** to the erase screen.

<img src="/docs/README_imgs/Select_Archive.png" alt="Select_Archive" width="40%"/>



<img src="/docs/README_imgs/New_Game.png" alt="New_Game" width="40%"/>

#### 4. Erase Archive Screen

Click a slot button to **erase the corresponding archive**. If the slot is not empty, player needs to do a **confirmation**; otherwise, there is a **warning dialog**.

<img src="/docs/README_imgs/Erase_Slot.png" alt="Erase_Slot" width="40%"/>



<img src="/docs/README_imgs/Erase_Confirm.png" alt="Erase_Confirm" width="40%"/>



<img src="/docs/README_imgs/Erase_Warning.png" alt="Erase_Warning" width="40%"/>

#### 5. Setting Screen

Player can **turn on/off the sound effects**(keeper walk/impact crate/impact wall) in the game and **change the crate skin** to different color.

<img src="/docs/README_imgs/Setting_Scene.png" alt="Setting_Scene" width="40%"/>

#### 6. Help Screen

Show the **operation guide**.

<img src="/docs/README_imgs/Help.png" alt="Help" width="40%"/>

#### 7. Ranking Screen

Show the ranking, including the player's **nickname**, **total move count** and **move count for each level**. When mouse enter the label, the size will change.

<img src="/docs/README_imgs/Ranking_Scene.png" alt="Ranking_Scene" width="40%"/>

#### 8. Game Screen Refine

Add the **Level_Move** in the upper left corner. Add options that can **return to menu** and **go to select level scene** **(Save the game automatically if do those operations)**. User need to **confirm the reset operation**. Toggle music can **turn on/off the BGM**. **Refine the game GUI**.

<img src="/docs/README_imgs/Game_Scene1.png" alt="Game_Scene1" width="40%"/>

<img src="/docs/README_imgs/Game_Scene2.png" alt="Game_Scene2" width="40%"/>

<img src="/docs/README_imgs/Game_Scene3.jpg" alt="Game_Scene2" width="40%"/>

#### 9. Game Sound Effects

Add game sound effects, including **walk, impact crates, impact walls**. The game sound effects can turn on/off in the setting scene.

#### 10. Interface Sound Effects

All the **button and interface element are bind with corresponding sound** to make more user-friendly.

#### 11. Game Pause Feature

When in the game scene, **press ESC** in the keyboard, player can **pause the game**. **When the game is paused**, **press ESC** again to **resume the game** or **press F1 save the game and return to menu**.

<img src="/docs/README_imgs/Pause.jpg" alt="Pause" width="40%"/>

#### 12. Add 3 New Levels

Design three new levels to the game.

<img src="/docs/README_imgs/Level6.jpg" alt="Level6" width="40%"/>

<img src="/docs/README_imgs/Level7.jpg" alt="Level6" width="40%"/>

<img src="/docs/README_imgs/Level8.jpg" alt="Level6" width="40%"/>

#### 13. Select Level Feature

The player can **return to the previous level,** but the state will remain in the state of level_completed. If the player wants to **replay** a certain level, he needs to **perform a reset level operation**. But this means **giving up the previous results**, and will **change the highest level of the archive** (for example, from the eighth level back to the fourth level, he cannot return to the eighth level after reset, but the completion status of levels 5, 6, and 7 will not be affected).

<img src="/docs/README_imgs/Levels.jpg" alt="Levels" width="40%"/>

Go back to level 4.

<img src="/docs/README_imgs/Goback.jpg" alt="Goback" width="40%"/>

Reset and select level. Cannot select levels after level 4.

<img src="/docs/README_imgs/Reset.jpg" alt="Reset" width="40%"/>

<img src="/docs/README_imgs/Level_status.jpg" alt="Level_Status" width="40%"/>



#### 14. Tutorial Screen

Play the **concise tutorial video** of the game. (The video added in the game now is very rough.)

<img src="/docs/README_imgs/Tutorial_Scene.jpg" alt="Tutorial_Scene" width="40%"/>



------

------



### Test Case

##### GameEngine Test

##### Function: isDebugActive()

| Test Case ID | Date | Test Scenario                                                | Test Data                  | Expected Results | Actual Results | P/F  | Comments                          |
| ------------ | ---- | ------------------------------------------------------------ | -------------------------- | ---------------- | -------------- | ---- | --------------------------------- |
| 1            | 12/2 | When instantiate a new gameEngine, the debug status of gameEngine. | gameEngine.isDebugActive() | false            | false          | P    | The default debug status is false |

##### Function: handleKey()

| Test Case ID | Date | Test Scenario | Test Data               | Expected Results | Actual Results | P/F  | Comments                           |
| ------------ | ---- | ------------- | ----------------------- | ---------------- | -------------- | ---- | ---------------------------------- |
| 1            | 12/2 | UP case       | direction of gameEngine | 1                | 1              | P    | The direction changed successfully |
| 2            | 12/2 | RIGHT case    | direction of gameEngine | 2                | 2              | P    | The direction changed successfully |
| 3            | 12/2 | DOWN case     | direction of gameEngine | 3                | 3              | P    | The direction changed successfully |
| 4            | 12/2 | LEFT case     | direction of gameEngine | 4                | 4              | P    | The direction changed successfully |

##### Function: isGameComplete()

| Test Case ID | Date | Test Scenario                                                | Test Data                   | Expected Results | Actual Results | P/F  | Comments                                   |
| ------------ | ---- | ------------------------------------------------------------ | --------------------------- | ---------------- | -------------- | ---- | ------------------------------------------ |
| 1            | 12/2 | When instantiate a new gameEngine, the isGameComplete status of gameEngine. | gameEngine.isGameComplete() | false            | false          | P    | The default isGameComplete status is false |

##### Function: getNextLevel()

| Test Case ID | Date | Test Scenario                                              | Test Data                            | Expected Results | Actual Results | P/F  | Comments                |
| ------------ | ---- | ---------------------------------------------------------- | ------------------------------------ | ---------------- | -------------- | ---- | ----------------------- |
| 1            | 12/2 | When instantiate a new gameEngine, the next level's index. | gameEngine.getNextLevel().getIndex() | 2                | 2              | P    | Next level's index is 2 |

##### Function: getCurrentLevel()

| Test Case ID | Date | Test Scenario                                                | Test Data                               | Expected Results | Actual Results | P/F  | Comments                       |
| ------------ | ---- | ------------------------------------------------------------ | --------------------------------------- | ---------------- | -------------- | ---- | ------------------------------ |
| 1            | 12/2 | When instantiate a new gameEngine, the current level's index. | gameEngine.getCurrentLevel().getIndex() | 1                | 1              | P    | The current level's index is 1 |

##### Function: toggleDebug()

| Test Case ID | Date | Test Scenario                                                | Test Data                  | Expected Results | Actual Results | P/F  | Comments                                    |
| ------------ | ---- | ------------------------------------------------------------ | -------------------------- | ---------------- | -------------- | ---- | ------------------------------------------- |
| 1            | 12/2 | When instantiate a new gameEngine, and then toggle the debug. | gameEngine.isDebugActive() | true             | true           | P    | The debug status after toggle debug is true |

##### Function: getLevels()

| Test Case ID | Date | Test Scenario                                                | Test Data                     | Expected Results | Actual Results | P/F  | Comments                |
| ------------ | ---- | ------------------------------------------------------------ | ----------------------------- | ---------------- | -------------- | ---- | ----------------------- |
| 1            | 12/2 | When instantiate a new gameEngine, return the levels of gameEngine object, and test its size | gameEngine.getLevels().size() | 8                | 8              | P    | The size of levels is 8 |

##### Function: movesCount()

| Test Case ID | Date | Test Scenario                                                | Test Data               | Expected Results | Actual Results | P/F  | Comments                            |
| ------------ | ---- | ------------------------------------------------------------ | ----------------------- | ---------------- | -------------- | ---- | ----------------------------------- |
| 1            | 12/2 | When instantiate a new gameEngine, the total move count of levels | gameEngine.movesCount() | 0                | 0              | P    | The total move count of levels is 0 |

##### Function: getLevelMove()

| Test Case ID | Date | Test Scenario                                                | Test Data                 | Expected Results         | Actual Results           | P/F  | Comments                                                 |
| ------------ | ---- | ------------------------------------------------------------ | ------------------------- | ------------------------ | ------------------------ | ---- | -------------------------------------------------------- |
| 1            | 12/2 | When instantiate a new gameEngine, return the int array of level move | gameEngine.getLevelMove() | [0, 0, 0, 0, 0, 0, 0, 0] | [0, 0, 0, 0, 0, 0, 0, 0] | P    | The initial level move array is [0, 0, 0, 0, 0, 0, 0, 0] |

##### Function: setSoundEffect()

| Test Case ID | Date | Test Scenario                                                | Test Data                  | Expected Results | Actual Results | P/F  | Comments                          |
| ------------ | ---- | ------------------------------------------------------------ | -------------------------- | ---------------- | -------------- | ---- | --------------------------------- |
| 1            | 12/2 | When instantiate a new gameEngine, set the SoundEffect of gameEngine object to false | gameEngine.isSoundEffect() | false            | flase          | P    | setSoundEffect() run successfully |

##### Function: setState()

| Test Case ID | Date | Test Scenario                                                | Test Data        | Expected Results          | Actual Results | P/F  | Comments                                                     |
| ------------ | ---- | ------------------------------------------------------------ | ---------------- | ------------------------- | -------------- | ---- | ------------------------------------------------------------ |
| 1            | 12/2 | When instantiate a new gameEngine, set the state to debugState | gameEngine.state | gameEngine.getPlayState() | playState      | P    | after set the state as playState, the state of gameEngine object is playState |

##### Function: getPlayState()

| Test Case ID | Date | Test Scenario                                                | Test Data        | Expected Results          | Actual Results | P/F  | Comments                                                   |
| ------------ | ---- | ------------------------------------------------------------ | ---------------- | ------------------------- | -------------- | ---- | ---------------------------------------------------------- |
| 1            | 12/2 | When instantiate a new gameEngine, return the playState of the gameEngine object | gameEngine.state | gameEngine.getPlayState() | playState      | P    | The playState of gameEngine is equal to gameEngine's state |

##### Function: getDebugState()

| Test Case ID | Date | Test Scenario                                                | Test Data        | Expected Results           | Actual Results | P/F  | Comments                                                     |
| ------------ | ---- | ------------------------------------------------------------ | ---------------- | -------------------------- | -------------- | ---- | ------------------------------------------------------------ |
| 1            | 12/2 | When instantiate a new gameEngine, set the return the state to debugState | gameEngine.state | gameEngine.getDebugState() | debugState     | P    | The debugState  of ameEngine is equal to gameEngine's state after setState to debug |

##### Function: setDebug()

| Test Case ID | Date | Test Scenario                                                | Test Data                  | Expected Results | Actual Results | P/F  | Comments                                  |
| ------------ | ---- | ------------------------------------------------------------ | -------------------------- | ---------------- | -------------- | ---- | ----------------------------------------- |
| 1            | 12/2 | When instantiate a new gameEngine, set the debug status to true | GameEngine.isDebugActive() | true             | true           | P    | Set the debug status to true successfully |

##### Function: isSoundEffect()

| Test Case ID | Date | Test Scenario                                                | Test Data                  | Expected Results | Actual Results | P/F  | Comments                                   |
| ------------ | ---- | ------------------------------------------------------------ | -------------------------- | ---------------- | -------------- | ---- | ------------------------------------------ |
| 1            | 12/2 | When instantiate a new gameEngine, return the SoundEffect of gameEngine object | GameEngine.isSoundEffect() | true             | true           | P    | The original status of SoundEffect is true |

##### Function: setCurrentLevel()

| Test Case ID | Date | Test Scenario                                                | Test Data                               | Expected Results | Actual Results | P/F  | Comments                                                   |
| ------------ | ---- | ------------------------------------------------------------ | --------------------------------------- | ---------------- | -------------- | ---- | ---------------------------------------------------------- |
| 1            | 12/2 | When instantiate a new gameEngine, set the current level to level[1], get the currentlevel's level index | gameEngine.getCurrentLevel().getIndex() | 2                | 2              | P    | Successfully set the current level from level 1 to level 2 |

##### Function: getSavedLevel()

| Test Case ID | Date | Test Scenario                                                | Test Data                  | Expected Results | Actual Results | P/F  | Comments                                     |
| ------------ | ---- | ------------------------------------------------------------ | -------------------------- | ---------------- | -------------- | ---- | -------------------------------------------- |
| 1            | 12/2 | When instantiate a new gameEngine, return the SavedLevel value of the gameEngine object | gameEngine.getSavedLevel() | 1                | 1              | P    | The saved level value of the gameEngine is 1 |

##### Function: setSavedLevel()

| Test Case ID | Date | Test Scenario                                                | Test Data                  | Expected Results | Actual Results | P/F  | Comments                                                     |
| ------------ | ---- | ------------------------------------------------------------ | -------------------------- | ---------------- | -------------- | ---- | ------------------------------------------------------------ |
| 1            | 12/2 | When instantiate a new gameEngine, set the saved level value to 4 | gameEngine.getSavedLevel() | 4                | 4              | P    | Set saved level value to 4, then the saved level gotten from gameEngine is 4 |

------



##### Level Test

##### Function: getMove()

| Test Case ID | Date | Test Scenario                       | Test Data       | Expected Results | Actual Results | P/F  | Comments                           |
| ------------ | ---- | ----------------------------------- | --------------- | ---------------- | -------------- | ---- | ---------------------------------- |
| 1            | 12/2 | Get the level move count of level 1 | level.getMove() | 0                | 0              | P    | The original level move count is 0 |

##### Function: setMove()

| Test Case ID | Date | Test Scenario                                                | Test Data       | Expected Results | Actual Results | P/F  | Comments                    |
| ------------ | ---- | ------------------------------------------------------------ | --------------- | ---------------- | -------------- | ---- | --------------------------- |
| 1            | 12/2 | set the level move to 50, and get the level move to check whether set successfully | level.getMove() | 50               | 50             | P    | Set level move successfully |

##### Function: setKeeperPosition()

| Test Case ID | Date | Test Scenario                                                | Test Data                 | Expected Results | Actual Results | P/F  | Comments                              |
| ------------ | ---- | ------------------------------------------------------------ | ------------------------- | ---------------- | -------------- | ---- | ------------------------------------- |
| 1            | 12/2 | set the keeperPosition of the level to (1,2), then get the level keeperPosition to check whether set successfully | level.getKeeperPosition() | (1,2)            | (1,2)          | P    | Set level keeperPosition successfully |

##### Function: isComplete()

| Test Case ID | Date | Test Scenario                              | Test Data          | Expected Results | Actual Results | P/F  | Comments                                       |
| ------------ | ---- | ------------------------------------------ | ------------------ | ---------------- | -------------- | ---- | ---------------------------------------------- |
| 1            | 12/2 | Check whether the level is complete or not | level.isComplete() | false            | false          | P    | The original level's isComplete value is false |

##### Function: getName()

| Test Case ID | Date | Test Scenario                    | Test Data       | Expected Results | Actual Results | P/F  | Comments                          |
| ------------ | ---- | -------------------------------- | --------------- | ---------------- | -------------- | ---- | --------------------------------- |
| 1            | 12/2 | Return the level name of level 1 | level.getName() | "lEVEL 1"        | "lEVEL 1"      | P    | Get the level 1 name successfully |

##### Function: getIndex()

| Test Case ID | Date | Test Scenario                   | Test Data        | Expected Results | Actual Results | P/F  | Comments                           |
| ------------ | ---- | ------------------------------- | ---------------- | ---------------- | -------------- | ---- | ---------------------------------- |
| 1            | 12/2 | Return the level1's level index | level.getIndex() | 1                | 1              | P    | Get the level 1 index successfully |

##### Function: getKeeperPosition()

| Test Case ID | Date | Test Scenario                      | Test Data                 | Expected Results | Actual Results | P/F  | Comments                                    |
| ------------ | ---- | ---------------------------------- | ------------------------- | ---------------- | -------------- | ---- | ------------------------------------------- |
| 1            | 12/2 | Return the level1's keeperPosition | level.getKeeperPosition() | (18,10)          | (18,10)        | P    | Get the level 1 keeperPosition successfully |

##### Function: getTargetObject()

| Test Case ID | Date | Test Scenario                                                | Test Data                                                    | Expected Results | Actual Results | P/F  | Comments                     |
| ------------ | ---- | ------------------------------------------------------------ | ------------------------------------------------------------ | ---------------- | -------------- | ---- | ---------------------------- |
| 1            | 12/2 | Check the current keeper position move (1,0) is "W" gameObject | level.getTargetObject(level.getKeeperPosition(), new Point(1, 0)).getStringSymbol() | "W"              | "W"            | P    | Get target gameObject is "W" |

------



##### GameGrid Test

##### Function: translatePoint()

| Test Case ID | Date | Test Scenario                                                | Test Data                                                    | Expected Results | Actual Results | P/F  | Comments                                   |
| ------------ | ---- | ------------------------------------------------------------ | ------------------------------------------------------------ | ---------------- | -------------- | ---- | ------------------------------------------ |
| 1            | 12/3 | Translate the keeper position point by (1, 0) and test the new point position. | GameGrid.translatePoint(level.getKeeperPosition(), new Point(1, 0)) | Point(19, 10)    | Point(19, 10)  | P    | Keeper position is translated successfully |

##### Function: getDimension()

| Test Case ID | Date | Test Scenario                                                | Test Data                  | Expected Results  | Actual Results    | P/F  | Comments                          |
| ------------ | ---- | ------------------------------------------------------------ | -------------------------- | ----------------- | ----------------- | ---- | --------------------------------- |
| 1            | 12/3 | Use the level 1 objectsGrid to do the test, get the map size | objectsGrid.getDimension() | Dimension(20, 20) | Dimension(20, 20) | P    | The dimension of the map is 20*20 |

##### Function: getTargetFromSource()

| Test Case ID | Date | Test Scenario                                                | Test Data                                                    | Expected Results | Actual Results | P/F  | Comments                                                 |
| ------------ | ---- | ------------------------------------------------------------ | ------------------------------------------------------------ | ---------------- | -------------- | ---- | -------------------------------------------------------- |
| 1            | 12/3 | Move the keeper position by (1, 0), and check whether the target position's game object is "W" | objectsGrid.getTargetFromSource(level.getKeeperPosition(), new Point(1, 0)) | "W"              | "W"            | P    | Successfully get the target position's game object type. |

##### Function: getGameObjectAt()

| Test Case ID | Date | Test Scenario                                              | Test Data                           | Expected Results | Actual Results | P/F  | Comments                               |
| ------------ | ---- | ---------------------------------------------------------- | ----------------------------------- | ---------------- | -------------- | ---- | -------------------------------------- |
| 1            | 12/3 | Return the game object at (18, 10) using col and row value | objectsGrid.getGameObjectAt(18, 10) | "S"              | "S"            | P    | The game object at (18, 10) is keeper. |
| 2            | 12/3 | Return the game object at (19, 10) using col and row value | objectsGrid.getGameObjectAt(19, 10) | "W"              | "W"            | P    | The game object at (19, 10) is wall.   |

##### Function: testGetGameObjectAt()

| Test Case ID | Date | Test Scenario                                  | Test Data                                      | Expected Results | Actual Results | P/F  | Comments                               |
| ------------ | ---- | ---------------------------------------------- | ---------------------------------------------- | ---------------- | -------------- | ---- | -------------------------------------- |
| 1            | 12/3 | Return the game object at (18, 10) using Point | objectsGrid.getGameObjectAt(new Point(18, 10)) | "S"              | "S"            | P    | The game object at (18, 10) is keeper. |
| 2            | 12/3 | Return the game object at (19, 10) using Point | objectsGrid.getGameObjectAt(new Point(19, 10)) | "W"              | "W"            | P    | The game object at (19, 10) is wall.   |

##### Function: removeGameObjectAt()

| Test Case ID | Date | Test Scenario                            | Test Data                           | Expected Results | Actual Results | P/F  | Comments                                            |
| ------------ | ---- | ---------------------------------------- | ----------------------------------- | ---------------- | -------------- | ---- | --------------------------------------------------- |
| 1            | 12/3 | Remove the game object at Point (19, 10) | objectsGrid.getGameObjectAt(19, 10) | null             | null           | P    | The game object at (19, 10) is removed successfully |

##### Function: putGameObjectAt()

| Test Case ID | Date | Test Scenario                                            | Test Data                          | Expected Results | Actual Results | P/F  | Comments                                                   |
| ------------ | ---- | -------------------------------------------------------- | ---------------------------------- | ---------------- | -------------- | ---- | ---------------------------------------------------------- |
| 1            | 12/3 | put null to Point (2, 10) using col and row as parameter | objectsGrid.getGameObjectAt(2, 10) | null             | null           | P    | The game object at (2, 10) is null after the method called |

##### Function: testPutGameObjectAt()

| Test Case ID | Date | Test Scenario                                      | Test Data                          | Expected Results | Actual Results | P/F  | Comments                                                   |
| ------------ | ---- | -------------------------------------------------- | ---------------------------------- | ---------------- | -------------- | ---- | ---------------------------------------------------------- |
| 1            | 12/3 | put null to Point (2, 10) using Point as parameter | objectsGrid.getGameObjectAt(2, 10) | null             | null           | P    | The game object at (2, 10) is null after the method called |

##### Function: testToString()

| Test Case ID | Date | Test Scenario                                   | Test Data              | Expected Results                                             | Actual Results                                               | P/F  | Comments                                                    |
| ------------ | ---- | ----------------------------------------------- | ---------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ---- | ----------------------------------------------------------- |
| 1            | 12/3 | Get the string type of level1's objectsGrid map | objectsGrid.toString() | "WWWWWWWWWWWWWWWWWWWW\n" +         "W    W             W\n" +         "W C  W             W\n" +         "W    W      WWWWWWWW\n" +         "W    WWWW  WWWWWWWWW\n" +         "W            WWWWWWW\n" +         "W    WWWWW   WWWWWWW\n" +         "W    WWWWWWWWWWWWWWW\n" +         "W    WWWWWWWWWWWWWWW\n" +         "W    WWWWWWWWWWWWWWW\n" +         "W    WWWWWWWWWWWWWWW\n" +         "W           WWWWWWWW\n" +         "W         WWWWWWWWWW\n" +         "WWWWWWW   WWWWWWWWWW\n" +         "WWWWWWW   WWWWWWWWWW\n" +         "WWWWWWW   WWWWWWWWWW\n" +         "WWWWWWW   WWWWWWWWWW\n" +         "WWWWWWW   WWWWWWWWWW\n" +         "WWWWWWW   SWWWWWWWWW\n" +         "WWWWWWWWWWWWWWWWWWWW\n" | "WWWWWWWWWWWWWWWWWWWW\n" +         "W    W             W\n" +         "W C  W             W\n" +         "W    W      WWWWWWWW\n" +         "W    WWWW  WWWWWWWWW\n" +         "W            WWWWWWW\n" +         "W    WWWWW   WWWWWWW\n" +         "W    WWWWWWWWWWWWWWW\n" +         "W    WWWWWWWWWWWWWWW\n" +         "W    WWWWWWWWWWWWWWW\n" +         "W    WWWWWWWWWWWWWWW\n" +         "W           WWWWWWWW\n" +         "W         WWWWWWWWWW\n" +         "WWWWWWW   WWWWWWWWWW\n" +         "WWWWWWW   WWWWWWWWWW\n" +         "WWWWWWW   WWWWWWWWWW\n" +         "WWWWWWW   WWWWWWWWWW\n" +         "WWWWWWW   WWWWWWWWWW\n" +         "WWWWWWW   SWWWWWWWWW\n" +         "WWWWWWWWWWWWWWWWWWWW\n" | P    | The objectsGrid map in string type is returned successfully |

------



##### GameObject Test

##### Function: fromChar()

| Test Case ID | Date | Test Scenario             | Test Data                                  | Expected Results | Actual Results | P/F  | Comments                       |
| ------------ | ---- | ------------------------- | ------------------------------------------ | ---------------- | -------------- | ---- | ------------------------------ |
| 1            | 12/3 | new a object use char 'c' | GameObject.fromChar('c').getStringSymbol() | "C"              | "C"            | P    | A CRATE game object generated  |
| 2            | 12/3 | new a object use char 's' | GameObject.fromChar('s').getStringSymbol() | "S"              | "S"            | P    | A KEEPER game object generated |
| 3            | 12/3 | new a object use char 'f' | GameObject.fromChar('f').getStringSymbol() | "W"              | "W"            | P    | A WALL game object generated   |

##### Function: getStringSymbol()

| Test Case ID | Date | Test Scenario                                       | Test Data                                           | Expected Results | Actual Results | P/F  | Comments                                                     |
| ------------ | ---- | --------------------------------------------------- | --------------------------------------------------- | ---------------- | -------------- | ---- | ------------------------------------------------------------ |
| 1            | 12/3 | get the string symbol of objectsGrid point (18, 10) | bjectsGrid.getGameObjectAt(18,10).getStringSymbol() | "S"              | "S"            | P    | The game object at (18, 10) is KEEPER, the string symbol of KEEPER is "S" |

##### Function: getCharSymbol()

| Test Case ID | Date | Test Scenario                                     | Test Data                                         | Expected Results | Actual Results | P/F  | Comments                                                     |
| ------------ | ---- | ------------------------------------------------- | ------------------------------------------------- | ---------------- | -------------- | ---- | ------------------------------------------------------------ |
| 1            | 12/3 | get the char symbol of objectsGrid point (18, 10) | bjectsGrid.getGameObjectAt(18,10).getCharSymbol() | 'S'              | 'S'            | P    | The game object at (18, 10) is KEEPER, the char symbol of KEEPER is 'S' |

------



##### PlayerInfo Test

##### Function: getMoveCount()

| Test Case ID | Date | Test Scenario                              | Test Data                 | Expected Results | Actual Results | P/F  | Comments                                            |
| ------------ | ---- | ------------------------------------------ | ------------------------- | ---------------- | -------------- | ---- | --------------------------------------------------- |
| 1            | 12/3 | get the total move count of the playerInfo | playerInfo.getMoveCount() | 50               | 50             | P    | The total move count of info is return successfully |

##### Function: getLevelMoveCount()

| Test Case ID | Date | Test Scenario                                    | Test Data                      | Expected Results                  | Actual Results                    | P/F  | Comments                                                     |
| ------------ | ---- | ------------------------------------------------ | ------------------------------ | --------------------------------- | --------------------------------- | ---- | ------------------------------------------------------------ |
| 1            | 12/3 | get the level move count array of the playerInfo | playerInfo.getLevelMoveCount() | {50, 10, 30, 20, 50, 10, 20, 200} | {50, 10, 30, 20, 50, 10, 20, 200} | P    | The level move count array of playerInfo is return successfully |

##### Function: getNickName()

| Test Case ID | Date | Test Scenario                      | Test Data                | Expected Results | Actual Results | P/F  | Comments                                          |
| ------------ | ---- | ---------------------------------- | ------------------------ | ---------------- | -------------- | ---- | ------------------------------------------------- |
| 1            | 12/3 | get the nickName of the playerInfo | playerInfo.getNickName() | "Jack"           | "Jack"         | P    | The NickName of playerInfo is return successfully |

------



##### RankList Test

##### Function: getRankTop5()

| Test Case ID | Date | Test Scenario                                                | Test Data                     | Expected Results | Actual Results | P/F  | Comments                                                     |
| ------------ | ---- | ------------------------------------------------------------ | ----------------------------- | ---------------- | -------------- | ---- | ------------------------------------------------------------ |
| 1            | 12/3 | get the top5 in the ranking.txt and check whether the first player nickname is "pwq" | rankTop5.get(0).getNickName() | "pwq"            | "pwq"          | P    | The ranking.txt file is successfully  sorted and get the right nickname |
| 2            | 12/3 | get the top5 in the ranking.txt and check whether the second player nickname is "Jenny" | rankTop5.get(1).getNickName() | "Jenny"          | "Jenny"        | P    | The ranking.txt file is successfully  sorted and get the right nickname |

------



##### Main Test

##### Function: setRoot()

| Test Case ID | Date | Test Scenario                                                | Test Data                                                    | Expected Results    | Actual Results      | P/F  | Comments                             |
| ------------ | ---- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------- | ------------------- | ---- | ------------------------------------ |
| 1            | 12/4 | set the scene root from animation scene to menu scene, test the scene change. | scene.setRoot(FXMLLoader.load(Main.class.getResource("/FXML/menu.fxml"))) | Root change to menu | Root change to menu | P    | SetRoot() method called successfully |

------



##### AnimationController Test

##### Function: startGame()

| Test Case ID | Date | Test Scenario                                                | Test Data           | Expected Results               | Actual Results                 | P/F  | Comments                                                     |
| ------------ | ---- | ------------------------------------------------------------ | ------------------- | ------------------------------ | ------------------------------ | ---- | ------------------------------------------------------------ |
| 1            | 12/4 | Click the animation scene and the scene can change to mune scene | clickOn(Main.scene) | The scene change to menu scene | The scene change to menu scene | P    | startGame() successfully, the scene root changed to menu.fxml |

------



##### EraseController Test

##### Function: returnSlot()

| Test Case ID | Date | Test Scenario                                        | Test Data                             | Expected Results               | Actual Results                 | P/F  | Comments                                                     |
| ------------ | ---- | ---------------------------------------------------- | ------------------------------------- | ------------------------------ | ------------------------------ | ---- | ------------------------------------------------------------ |
| 1            | 12/4 | Click the Return button and return to the slot scene | clickOn(Main.scene.lookup("#Return")) | The scene change to slot scene | The scene change to slot scene | P    | returnSlot() successfully, the scene root changed to slot.fxml |

------

##### HelpController Test

##### Function: returnMenu()

| Test Case ID | Date | Test Scenario                                        | Test Data                             | Expected Results               | Actual Results                 | P/F  | Comments                                                     |
| ------------ | ---- | ---------------------------------------------------- | ------------------------------------- | ------------------------------ | ------------------------------ | ---- | ------------------------------------------------------------ |
| 1            | 12/4 | Click the Return button and return to the menu scene | clickOn(Main.scene.lookup("#Return")) | The scene change to menu scene | The scene change to menu scene | P    | returnMenu() successfully, the scene root changed to menu.fxml |

------



##### LevelController Test

##### Function: loadLevel1()

| Test Case ID | Date | Test Scenario                                              | Test Data                           | Expected Results                                | Actual Results                                  | P/F  | Comments                                                     |
| ------------ | ---- | ---------------------------------------------------------- | ----------------------------------- | ----------------------------------------------- | ----------------------------------------------- | ---- | ------------------------------------------------------------ |
| 1            | 12/4 | Click the Level1 button and jump to the level1 of archive1 | clickOn(Main.scene.lookup("#Btn1")) | The scene change to game scene and it is level1 | The scene change to game scene and it is level1 | P    | loadLevel1() successfully, the scene root changed to game.fxml, and level is level1 |

Other loadLevel functions are similar.

------

##### MenuController Test

##### Function: startGame()

| Test Case ID | Date | Test Scenario                                     | Test Data                            | Expected Results               | Actual Results                 | P/F  | Comments                          |
| ------------ | ---- | ------------------------------------------------- | ------------------------------------ | ------------------------------ | ------------------------------ | ---- | --------------------------------- |
| 1            | 12/4 | Click the Start button and jump to the slot scene | clickOn(Main.scene.lookup("#Start")) | The scene change to slot scene | The scene change to slot scene | P    | Change to slot scene successfully |

##### Function: openSetting()

| Test Case ID | Date | Test Scenario                                           | Test Data                              | Expected Results                  | Actual Results                    | P/F  | Comments                             |
| ------------ | ---- | ------------------------------------------------------- | -------------------------------------- | --------------------------------- | --------------------------------- | ---- | ------------------------------------ |
| 1            | 12/4 | Click the Setting button and jump to the setting  scene | clickOn(Main.scene.lookup("#Setting")) | The scene change to Setting scene | The scene change to Setting scene | P    | Change to Setting scene successfully |

##### Function: openRank()

| Test Case ID | Date | Test Scenario                                    | Test Data                              | Expected Results               | Actual Results                 | P/F  | Comments                          |
| ------------ | ---- | ------------------------------------------------ | -------------------------------------- | ------------------------------ | ------------------------------ | ---- | --------------------------------- |
| 1            | 12/4 | Click the Rank button and jump to the Rank scene | clickOn(Main.scene.lookup("#Ranking")) | The scene change to Rank scene | The scene change to Rank scene | P    | Change to Rank scene successfully |

##### Function: openHelp()

| Test Case ID | Date | Test Scenario                                    | Test Data                           | Expected Results               | Actual Results                 | P/F  | Comments                          |
| ------------ | ---- | ------------------------------------------------ | ----------------------------------- | ------------------------------ | ------------------------------ | ---- | --------------------------------- |
| 1            | 12/4 | Click the Help button and jump to the Help scene | clickOn(Main.scene.lookup("#Help")) | The scene change to Help scene | The scene change to Help scene | P    | Change to Help scene successfully |



------

##### RankController Test

##### Function: returnMenu()

| Test Case ID | Date | Test Scenario                                      | Test Data                             | Expected Results               | Actual Results                 | P/F  | Comments                          |
| ------------ | ---- | -------------------------------------------------- | ------------------------------------- | ------------------------------ | ------------------------------ | ---- | --------------------------------- |
| 1            | 12/4 | Click the Return button and jump to the menu scene | clickOn(Main.scene.lookup("#Return")) | The scene change to menu scene | The scene change to menu scene | P    | Change to menu scene successfully |



------

##### SettingController Test

##### Function: returnMenu()

| Test Case ID | Date | Test Scenario                                      | Test Data                             | Expected Results               | Actual Results                 | P/F  | Comments                          |
| ------------ | ---- | -------------------------------------------------- | ------------------------------------- | ------------------------------ | ------------------------------ | ---- | --------------------------------- |
| 1            | 12/4 | Click the Return button and jump to the menu scene | clickOn(Main.scene.lookup("#Return")) | The scene change to menu scene | The scene change to menu scene | P    | Change to menu scene successfully |

##### unction: soundControl()

| Test Case ID | Date | Test Scenario                                                | Test Data                                   | Expected Results                                          | Actual Results                                            | P/F  | Comments                                  |
| ------------ | ---- | ------------------------------------------------------------ | ------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- | ---- | ----------------------------------------- |
| 1            | 12/4 | Click the SoundControl checkbox                              | clickOn(Main.scene.lookup("#SoundControl")) | The imgOff becomes visible and the checkbox becomes false | The imgOff becomes visible and the checkbox becomes false | P    | Check box click make sense                |
| 2            | 12/4 | Click the SoundControl checkbox, check the SettingController.soundEffect value is false or not | SettingController.soundEffect               | false                                                     | false                                                     | P    | The soundEffect value be changed to false |



------

##### SlotController Test

##### Function: returnToMenu()

| Test Case ID | Date | Test Scenario                                      | Test Data                             | Expected Results               | Actual Results                 | P/F  | Comments                          |
| ------------ | ---- | -------------------------------------------------- | ------------------------------------- | ------------------------------ | ------------------------------ | ---- | --------------------------------- |
| 1            | 12/4 | Click the Return button and jump to the menu scene | clickOn(Main.scene.lookup("#Return")) | The scene change to menu scene | The scene change to menu scene | P    | Change to menu scene successfully |

##### Function: eraseSlot()

| Test Case ID | Date | Test Scenario                                      | Test Data                            | Expected Results                | Actual Results                  | P/F  | Comments                           |
| ------------ | ---- | -------------------------------------------------- | ------------------------------------ | ------------------------------- | ------------------------------- | ---- | ---------------------------------- |
| 1            | 12/4 | Click the Erase button and jump to the erase scene | clickOn(Main.scene.lookup("#Erase")) | The scene change to erase scene | The scene change to erase scene | P    | Change to erase scene successfully |



------

##### TutorialController Test

##### Function: returnMenu()

| Test Case ID | Date | Test Scenario                                      | Test Data                             | Expected Results               | Actual Results                 | P/F  | Comments                          |
| ------------ | ---- | -------------------------------------------------- | ------------------------------------- | ------------------------------ | ------------------------------ | ---- | --------------------------------- |
| 1            | 12/4 | Click the Return button and jump to the menu scene | clickOn(Main.scene.lookup("#Return")) | The scene change to menu scene | The scene change to menu scene | P    | Change to menu scene successfully |

##### Function: playVideo()

| Test Case ID | Date | Test Scenario                                        | Test Data                           | Expected Results         | Actual Results           | P/F  | Comments                |
| ------------ | ---- | ---------------------------------------------------- | ----------------------------------- | ------------------------ | ------------------------ | ---- | ----------------------- |
| 1            | 12/4 | Click the Play button, check the video is going play | clickOn(Main.scene.lookup("#Play")) | The video starts to play | The video starts to play | P    | Play video successfully |

##### Function: stopVideo()

| Test Case ID | Date | Test Scenario                                 | Test Data                           | Expected Results | Actual Results   | P/F  | Comments                |
| ------------ | ---- | --------------------------------------------- | ----------------------------------- | ---------------- | ---------------- | ---- | ----------------------- |
| 1            | 12/4 | Click the Stop button, check the video stoped | clickOn(Main.scene.lookup("#Stop")) | The video stoped | The video stoped | P    | Stop video successfully |


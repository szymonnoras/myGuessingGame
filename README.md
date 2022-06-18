# myGuessingGame
Basic guess the number game which is a final project for subject code testing and optimization.
Author: Szymon Noras.

To start the game you need to: 
-download project to your local directory
-open the project in your favourite IDE
-run MyGuessingGameApplication file

after that you can access 3 endpoints:

http://localhost:8080/start - in which you will get unique id of your session

http://localhost:8080/highscores - in which you will get top 10 scores

http://localhost:8080/guess/{number} - in which you can try and guess the number, you need to replace "{number}" with your guess.
                                       If you will succed, your score will be written to file with all scores.

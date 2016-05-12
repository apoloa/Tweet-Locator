[logo]:https://github.com/wholedev/Tweet-Locator/blob/master/app_logo.png
![alt text][logo]
# Tweet Locator

## What is this

- This is the Android App Twitter Locator, this app can locates the twitter in a map.

## How to use this code

You'll need IntelliJ Idea with Android development plugin or Android Studio 2.1 and upwards.
We're using Gradle plugin 2.1.0

## Main Third party Libraries used

### **RXJava And RXAndroid**

Library can permit use Observer to functionality programming.

### **Twitter4j**

Library to get the Tweets for Twitter

## Nexts Steps

* Create Unit Test for the Models.
* Simplify and Refactor the principal Activity (Main Activity).

## Functionality Steps

The app only downloads 5 tweets with location for moved camera event.

1. The app moves to user position when app starts.
2. Using the location extract the city and check if exists in database. If database exists, the program show the information and download the news tweets.
The app gets the tweets for the user.
3. Show in a map


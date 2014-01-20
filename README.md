twitter-like
============

A simplified, console-based version of a Twitter-like social networking application. Uses in-memory db for ease of potential persistence enhancement. 

System requirements
-------------------
* Java 7 (preferred) or 6

Running instructions
--------------------
In Unix-related terminals/emulators, cd to the root of the project and enter

    ./run

or double-click on **run.bat** in Windows Explorer.

Doing this will:

1. download and install Gradle
2. download and install project dependencies (groovy, spring, hibernate, JSR-330, userType, junit, slf4j, logback, and joda-time)
3. compile the source code
4. connect the standard input
5. run twitter-like

Testing instructions
--------------------
Unix:

    ./gradlew test
    
Windows:

    gradlew test
    
in twitter-like/
    
Playing scenarios
-----------------

Posting: Alice can publish messages to a personal timeline


\> Alice -> I love the weather today

\> Bob -> Oh, we lost!

\> Bob -> at least it's sunny


Note: The program creates the user when the first post is posted.

Reading: Bob can view Alice’s timeline

\> Alice 


I love the weather today (5 minutes ago)


\> Bob


Oh, we lost! (1 minute ago)

at least it's sunny (2 minutes ago)


Following: Charlie can subscribe to Alice’s and Bob’s timelines, and view them on his wall, an aggregated list of all subscriptions 

\> Charlie -> I'm in New York today! Anyone wants to have a coffee?

\> Charlie follows Alice

\> Charlie wall 

Charlie - I'm in New York today! Anyone wants to have a coffee? (2 seconds ago)

Alice - I love the weather today (5 minutes ago)

\> Charlie follows Bob

\> Charlie wall 

Charlie - I'm in New York today! Anyone wants to have a coffee? (15 seconds ago)

Bob - Oh, we lost! (1 minute ago)

Bob - at least it's sunny (2 minutes ago)

Alice - I love the weather today (5 minutes ago)


Grammar
-------------------

• posting: [user name] -> [message]

• reading: [user name]

• following: [user name] follows [another user]

• wall: [user name] wall

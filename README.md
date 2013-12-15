twitter-like
============

A simplified, console-based version of a Twitter-like social networking application.
To run in Unix-related terminals, cd to the root of the project and type 

    ./run

or for Windows double-click on **run.bat**


Playing scenarios:

Posting: Alice can publish messages to a personal timeline

> Alice -> I love the weather today

> Bob -> Oh, we lost!

> Bob -> at least it's sunny

Note: The program creates the user when the first post is posted.

Reading: Bob can view Alice’s timeline

> Alice 

I love the weather today (5 minutes ago)

> Bob

Oh, we lost! (1 minute ago)

at least it's sunny (2 minutes ago)

Following: Charlie can subscribe to Alice’s and Bob’s timelines, and view 

them on his wall, an aggregated list of all subscriptions 

> Charlie -> I'm in New York today! Anyone wants to have a coffee?

> Charlie follows Alice

> Charlie wall 

Charlie - I'm in New York today! Anyone wants to have a coffee? (2 seconds ago)

Alice - I love the weather today (5 minutes ago)

> Charlie follows Bob

> Charlie wall 

Charlie - I'm in New York today! Anyone wants to have a coffee? (15 seconds ago)

Bob - Oh, we lost! (1 minute ago)

Bob - at least it's sunny (2 minutes ago)

Alice - I love the weather today (5 minutes ago)

General information

- Application use the console for input and output;

- User submits commands to the application:

• posting: [user name] -> [message]

• reading: [user name]

• following: [user name] follows [another user]

• wall: [user name] wall

- Assumes that the user will always type the correct commands.

- Uses groovy/gradle

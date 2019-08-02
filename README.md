# java-webdriver-cucumber

Base framework for Java Webdriver automation with Cucumber

Scenario — a label for the behavior you’re going to describe

Given steps are used to describe the initial context of the system - the scene of the scenario. It is typically something that happened in the past.
Given — the beginning state of the scenario

When — a specific action that the user takes
When Cucumber executes a Given step, it will configure the system to be in a well-defined state, such as creating and configuring objects or adding data to a test database.

Then — a testable outcome, usually caused by the action in When
And — this continues any of the other three operators
//-------------------------------------

Scenario: Some determinable business situation

Given some precondition exists

And some other precondition exits

When some action by the actor

And some other action

And yet another action

Then some testable outcome is achieved

And something else have also happened

* matches anything (or nothing), literally “any character (except a newline) 0
or more times”
.+ matches at least one of anything
[0-9]* or d* matches a series of digits (or nothing)
[0-9]+ or d+ matches one or more digits
"[^"]*" matches something (or nothing) in double quotes
an? matches a or an (the question mark makes the n optional)
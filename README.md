# city-auto-suggestions

Many situations in web applications arise when a user is prompted to fill in some text in a form where the text is expected to be one of a fixed number of strings. This could be people names, profession names, cities, countries, etc. A common interface in this kind of "choose from a large but fixed set" scenario is to let the user type a few characters and provide completion suggestions. You are to design and implement a standalone java application that provides such auto completion suggestions for cities in India.

The application is supposed to take 2 arguments start and atmost. For eg. java -jar autocomplete.jar che 5.  The first argument is start (che) and second is atmost(5). The "start" parameter gives the characters that the city starts with and the "atmost" parameter gives the maximum number of suggestions needed.
The outcome is to be printed with each line containing one suggestion.

# Prerequisites

* This is a standalone java program which doesn't need any tool to run except:
  Java 8



# Installing

* create a java jar file[ say: cityautocomplete.jar] and store at local location
* go to that directory
* run below command:
java -jar cityautocomplete.jar a 5

or simply import the project in eclipse and run Application.java as a java program after setting Runtime configuration parameters as:  "a 5"

# Details

 
* The project already has a cities.txt file which is used to generate the suggestions based on the user input like args[0] i.e. first command line parameter.
* The Project creates a Prefix tree to load the cities.txt records which are the city names. link for prefix tree could be find like below:

https://en.wikipedia.org/wiki/Trie
[Prefix Tree](https://en.wikipedia.org/wiki/Trie)

# Test Cases

Test cases has been created for CitySearchHandler.java and CitySuggesterImpl.java that could be run directly.

# Authors

Lavesh Singhal

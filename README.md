# celebrity-finder
Algorithm to solve "In a team of n people, a celebrity is known by everyone but he/she doesn't know anybody"

## Run the project

gradlew run -Parg="JSON_FILE_PATH"

The json file should follow this structure

````
[
  {
    "identification": "1234",
    "known": {
      "21": {
        "identification": "21"
      }
    }
  }
]
````

## Test the app

````
gradlew test
````

## Extend the app

If you want to read from another source you can implement the following interface and change the CelebrityProcessor class

````
com.vividseats.business.Reader
````

If you want to write to another destination you can implement the following interface and change the CelebrityProcessor class

````
com.vividseats.business.Writer
````


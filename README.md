# java-atc-rest-api

Notes/Thoughts:

This certainly isn't fully fleshed out. Definitely could use error handling, different status codes for the API responses, better test coverage,
and also a standardized Response wrapper. Lastly, there is NO exception handling besides the built in stuff.

However considering this was just a small exercise I think it gets the job done.

There is a basic smoke test using Rest Assured. The service needs to be running before the test is run however.

Building/Running:

`mvn package`

`java -jar atc-rest-api-0.1.0.jar`

API doc:

`GET /api/aqm/statusz #Get system status/queue size`

`POST /api/aqm/boot #boot the system`

`POST /api/aqm/enqueue/{type}/{size} #type={PASSENGER|CARGO} size={LARGE|SMALL}`

`POST /api/aqm/dequeue `

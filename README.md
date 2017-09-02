# java-atc-rest-api

Building/Running:

`mvn package`

`java -jar atc-rest-api-0.1.0.jar"

API doc:

`GET /api/aqm/statusz #Get system status/queue size`

`POST /api/aqm/boot #boot the system`

`POST /api/aqm/enqueue/{type}/{size} #type={PASSENGER|CARGO} size={LARGE|SMALL}`

`POST /api/aqm/dequeue `

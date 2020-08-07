# jwt-audience-demo

This demonstrates how a Spring Boot application can validate a JWT Bearer token and also ensuring its 
Audience claim matches the specified URL (http://localhost:8080/home)

The  audience claim passed into the request is added to the Bearer token in the JwtUtils.generateToken() method.

The jwt.util.JwtUtils class contains the logic to validate the token.  This is located in the "validateToken"
method of that class.  The "getAudienceFromToken" method extracts the Audience claim from the JWT and asserts
it matches the hardcoded URL "http://localhost:8080/home"

You can run this demo as follows:

### Start Spring Boot

mvn spring-boot:run

### Request a token
 
curl -X POST -H "Content-Type: application/json"  --data '{"username": "test", "password": "test", "audience: "http://localhost:8080/home"} '  http://localhost:8080/authenticate

_{"token":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiYXVkIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2hvbWUiLCJleHAiOjE1OTY4Mjc1MzEsImlhdCI6MTU5NjgwOTUzMX0.TvmM8R-nwgUlw3LW2gat43GzpNQ-n75N2W28sIj15umgUuAA2uEztlAL8MWiJRD_rNxMihF1jOK6P7Tb2wCaUg"_

### Access a resource matching the JWT's audience claim

curl -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiYXVkIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2hvbWUiLCJleHAiOjE1OTY4Mjc1MzEsImlhdCI6MTU5NjgwOTUzMX0.TvmM8R-nwgUlw3LW2gat43GzpNQ-n75N2W28sIj15umgUuAA2uEztlAL8MWiJRD_rNxMihF1jOK6P7Tb2wCaUg"  http://localhost:8080/home

_Hello JWT_

### Attempt to access a resource *not* matching the JWT's audience claim

 curl -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiYXVkIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2hvbWUiLCJleHAiOjE1OTY4Mjc1MzEsImlhdCI6MTU5NjgwOTUzMX0.TvmM8R-nwgUlw3LW2gat43GzpNQ-n75N2W28sIj15umgUuAA2uEztlAL8MWiJRD_rNxMihF1jOK6P7Tb2wCaUg"  http://localhost:8080/not-home

_{"timestamp":"2020-08-07T14:25:26.166+0000","status":401,"error":"Unauthorized","message":"Unauthorized","path":"/not-home"}%_


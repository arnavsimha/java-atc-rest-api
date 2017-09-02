package atcapi.controller;

import atcapi.model.AircraftSize;
import atcapi.model.AircraftType;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class AqmControllerTest {

    @BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(8080);
        }
        else{
            RestAssured.port = Integer.valueOf(port);
        }


        String basePath = System.getProperty("server.base");
        if(basePath==null){
            basePath = "/api/aqm";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;

    }

    @Test
    public void basicStatusTest(){
        given().when()
                .get("/statusz")
                .then()
                .statusCode(200);
    }

    @Test
    public void aqmTest(){

        //boot system
        given().when()
                .post("/boot")
                .then()
                .statusCode(200);

        for(int i = 0; i < 100; i++){
            AircraftType t = ((int) Math.random() * 2 == 0) ? AircraftType.CARGO : AircraftType.PASSENGER;
            AircraftSize s = ((int) Math.random() * 2 == 0) ? AircraftSize.LARGE : AircraftSize.SMALL;

            given().when()
                    .param("type", t)
                    .param("size, s")
                    .post("/enqueue/" + t + "/" + s)
                    .then()
                    .statusCode(200);

        }

        given().when()
                .get("/statusz")
                .then()
                .body("queueSize", equalTo(100) );

        given().when()
                .post("/dequeue")
                .then()
                .statusCode(200);

        given().when()
                .get("/statusz")
                .then()
                .body("queueSize", equalTo(99) );


    }

}

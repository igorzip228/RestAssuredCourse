import config.EndPoint;
import config.TestConfig;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MyFirstTest extends TestConfig {

    /*
// FIRST TEST
    @Test
    public void myFirstTest(){
        given().
        when().get("matches").          //basePath and baseURI in the TestConfig
        then().statusCode(200);
    }

// LOG ALL
    @Test
    public void loggingAllTest(){
        given().
                log().
                all().
        when().get("matches").
        then().statusCode(200);
    }

// LOG IF VALIDATION
    @Test
    public void loggingIfValidationTest(){
        given().
                log().
                ifValidationFails().            // if test was failed logging will be displayed
        when().get("matches").
        then().statusCode(200);         //if you change the status code you will see the logs
    }

// ADD REQUEST SPECIFICATION - do not add any for the specification
    @Test
    public void addSpecificationTest(){
        given().
                log().
                all().
        when().get("matches").
        then().
                log().
                all().
                statusCode(200);
    }


// ADD RESPONSE SPECIFICATION - we can remove fields which we mentioned in the response specification
    @Test
    public void addResponseSpecificationTest(){
        given().
                log().
                all().
        when().get("matches").
        then().
                log().
                all();
    }



// ADD REQUEST / RESPONSE SPECIFICATION - we can remove fields which we mentioned in the response specification
    @Test
    public void addClassSpecS(){
        given().
                spec(videoGame_requestSpec).    // added from TestConfig
        when().get("matches").
        then().
                spec(videoGame_responseSpec);   // added from TestConfig
    }


// ADD ENDPOINT  - create EndPoint interface
    @Test
    public void addENDPOINT() {
        given().
                when().get(EndPoint.GET_MATCHES).        // here we added the endPoint
                then().
                spec(videoGame_responseSpec);
    }

     */
}

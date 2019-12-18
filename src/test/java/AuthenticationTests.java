import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AuthenticationTests {

    @BeforeClass
    public static void setup() {
        RestAssured.proxy("localhost", 8866);
    }


    @Test
    public void basicPreemtoveAuthTest(){
        given().
                auth().preemptive().basic("username", "password").
        when().
                get("http://localhost:8080/someEndPoint");
    }


    @Test
    public void basicAuthTest(){
        given().
                auth().basic("username", "password").
                when().
                get("http://localhost:8080/someEndPoint");
    }


    @Test
    public void oauth1Test(){
        given().
                auth().oauth("consumerKey", "sdfssdf", "sdfssdfs", "sdfsfsdf").
        when().
                get("http://localhost:8080/someEndPoint");
    }



    @Test
    public void oauth2Test(){
        given().
                auth().oauth2("accessToken").
        when().
                get("http://localhost:8080/someEndPoint");
    }


    @Test
    public void relaxedHTTPSTest(){
        given().
                relaxedHTTPSValidation().
        when().                    // relaxed
                get("http://localhost:8080/someEndPoint");
    }


    @Test
    public void keyStoreTest(){
        given().
                keyStore("/pathToJKS", "password").
        when().                    // relaxed
                get("http://localhost:8080/someEndPoint");
    }
}

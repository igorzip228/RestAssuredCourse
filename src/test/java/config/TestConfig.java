package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import static org.hamcrest.Matchers.lessThan;

public class TestConfig {
    /*
=========================================================================================================
    SETUP TILL ADD RESPONSE SPECIFICATION
=========================================================================================================
    @BeforeClass
    public static void setup() {



        RestAssured.baseURI = "https://api.football-data.org";
//        RestAssured.port = 8080;
        RestAssured.basePath = "/v2/";
        RestAssured.proxy("localhost", 8866);

        RequestSpecification requestSpecification = new RequestSpecBuilder().               // add info
                addHeader("Content-Type", "application/json").
                addHeader("Accept", "application/json").            // and build spec
                build();
        RestAssured.requestSpecification = requestSpecification;


        ResponseSpecification responseSpecification = new ResponseSpecBuilder().
                expectStatusCode(200).
                build();
        RestAssured.responseSpecification = responseSpecification;
    }

=========================================================================================================


    public static RequestSpecification videoGame_requestSpec;
    public static ResponseSpecification videoGame_responseSpec;

    @BeforeClass
    public static void setup() {
        videoGame_requestSpec = new RequestSpecBuilder().
                setBaseUri("https://api.football-data.org").
//                setPort(8888).
                setBasePath("/v2/").
                addHeader("Content-Type", "application/json").
                addHeader("Accept", "application/json").
                build();

        RestAssured.requestSpecification = videoGame_requestSpec;


        videoGame_responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                build();

        RestAssured.responseSpecification = videoGame_responseSpec;


    }
=========================================================================================================


    public static RequestSpecification nickson_requestSpec;
    public static ResponseSpecification nickson_responseSpec;

    @BeforeClass
    public static void setup() {
        nickson_requestSpec = new RequestSpecBuilder().
                setBaseUri("http://qanickson.webprv.com").
//                setPort(8888).
        setBasePath("/api/").
                        addHeader("Content-Type", "text/html; charset=UTF-8").  //change spec addHeader("Content-Type", "application/xml") if we POST XML
                        addHeader("Accept", "text/html; charset=UTF-8").        //change spec addHeader("Content-Type", "application/xml") if we POST XML
                        build();

        RestAssured.requestSpecification = nickson_requestSpec;


        nickson_responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectResponseTime(lessThan(3000L)).
                expectHeader("Content-Type", "text/html; charset=UTF-8").
                expectHeader("Accept", "text/html; charset=UTF-8").

//                expectContentType( "text/html").
                build();

        RestAssured.responseSpecification = nickson_responseSpec;


    }

*/

}

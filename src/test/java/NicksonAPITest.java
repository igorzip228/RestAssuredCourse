import config.EndPoint;
import config.TestConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.lessThan;

public class NicksonAPITest extends TestConfig {

    /*
    // GET REQUEST EXAMPLE
    @Test
    public void getRequest() {
        given().
                when().get(EndPoint.GET_PRODUCTS). // get request
                then().
                log().
                all();
    }

    // POST JSON REQUEST EXAMPLE
    @Test
    public void postJSONRequest() {
        String JSONBody = "{\n  \"orderId\": 7056}";

        given().
                body(JSONBody).
                when().
                post(EndPoint.GET_PRODUCTS). // post request
                then();
    }


    // POST XML REQUEST EXAMPLE     need to change spec addHeader("Content-Type", "application/xml").
    @Test
    public void postXMLRequest() {
        String XMLBody = "<root>\n" +
                "   <orderId>7056</orderId>\n" +
                "</root>";

        given().
                body(XMLBody).
                when().
                post(EndPoint.GET_PRODUCTS).
                then();
    }


    // PUT JSON REQUEST EXAMPLE
    @Test
    public void putJSONRequest() {
        String JSONBody = "{\n  \"orderId\": 7056}";

        given().
                body(JSONBody).
                when().
                put(EndPoint.GET_PRODUCTS).         // put request
                then();
    }


    // DELETE JSON REQUEST EXAMPLE
    @Test
    public void deleteJSONRequest() {

        given().
                when().
                delete("orders/123").         // put request for example by id = 123
                then();
    }


    // PATH PARAMETER like .../orders/10
    @Test
    public void addPathParameter() {

        given().
                pathParam("productId", "10").          // we can named "productId" as we want
                when().
                get("orders/{productId}").         // we set productId to get path URI
//                get(EndPoint.GET_SINGLE_PRODUCT)      // if we will use EndPoint
        then();
    }


    // QWERY PARAMETER like .../orders?id = 10
    @Test
    public void addQweryParameer() {

        given().
                queryParam("productId", "10").          // we can named "productId" as in API doc
                when().
                get("orders/").
                then();
    }


// ASSERT FIELD BODY
    @Test
    public void assertFieldOfResponse() {
        given().
                spec(nickson_requestSpec).
                when().get(EndPoint.GET_PRODUCTS).
                then().
                spec(nickson_responseSpec).
//                    body("type", equalTo(2));   // equalTo - from hamcrest library, see imports
        body("data.id[0]", equalTo(65));   // equalTo - from hamcrest library, see imports
    }


// EXTRACT RESPONSE DATA
    @Test
    public void extractDataFromResponse() {
        String responseBody =
                given().
                        spec(nickson_requestSpec).
                        when().get(EndPoint.GET_PRODUCTS).
                        asString();

        System.out.println(responseBody);
    }


// EXTRACT RESPONSE AS JSON
    @Test
    public void extractSingleDataFromResponse() {
        Response response =
                given().
                        spec(nickson_requestSpec).
                        when().get(EndPoint.GET_PRODUCTS).
                        then().
                        contentType(ContentType.HTML).
                        extract().response();

        String jsonResponseAsString = response.asString();
        System.out.println(jsonResponseAsString);

    }


// EXTRACT HEADERS
    @Test
    public void extractHeadersResponse() {
        Response response =
                given().
                        spec(nickson_requestSpec).
                        when().get(EndPoint.GET_PRODUCTS).
                        then().
                        contentType(ContentType.HTML).
                        extract().response();

        Headers headers = response.getHeaders();                         //extract all headers
        String contentType = response.getHeader("Content-Type");      // extract Content-Type header

        System.out.println(contentType);

    }


// EXTRACT EXPLICIT DATA FROM BODY
    @Test
    public void extractDATAFROMBODY() {
        String firstTitle =
                given().
                        spec(nickson_requestSpec).
                        when().get(EndPoint.GET_PRODUCTS).
                        jsonPath().getString("data.title[0]");      // extract data in body with JSON PATH

        System.out.println(firstTitle);

    }


    // EXTRACT LIST OF DATA FROM BODY
    @Test
    public void extractListOfDATAFROMBODY() {
        Response response =
                given().
                        spec(nickson_requestSpec).
                        when().get(EndPoint.GET_PRODUCTS).
                        then().
                        contentType(ContentType.HTML).
                        extract().response();

        List<String> titles = response.path("data.title"); // extract list of data use .path

        for (String s : titles) {
            System.out.println(s);
        }
    }


// SERIALIZATION FROM JSON  - write object to stream. We convert object to json and post it after
    @Test
    public void serializationFromJSON() {

        Product product = new Product(null, "true", "1");       // create object

        given().
                body(product).
        when().
                post(EndPoint.GET_PRODUCTS).                                        // post the object
        then();
    }



// VALIDATE XML - need to generate xml to XSD with https://freeformatter.com/xsd-generator.html. Save xsc to separate file in the project file.xsd
    @Test
    public void validateXML() {
       given().
               pathParam("product", 5).
       when().
               get(EndPoint.GET_PRODUCTS).
       then().
               body(matchesXsdInClasspath("file.xsd"));                  //must ber import import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath; file.xsd in the separate file

    }



// VALIDATE JSON - need to generate json schema from response
    @Test
    public void validateJSON() {

        given().
        when().
                get("products/65").
        then().
                body(matchesJsonSchemaInClasspath("schema1.json"));       //need to import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
    }



// CONVERT JSON TO POJO -   need to create default constructor in Product class
    @Test
    public void convertJSONToPojo() {

        Response response = given().
                when().
                get("products/65");

        Product product = response.getBody().as(Product.class);         //CONVERT JSON TO POJO

        System.out.println(product.toString());
    }



// MEASURING TIME
    @Test
    public void measuringTime() {

          given().
           when().
                get("products/65").
           then().
                time(lessThan(2000L));              //need long (L), we can add to response specification
    }

*/

}

import config.TestConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class GpathJSONTests extends TestConfig {

    // GPath setup and basic find
    @Test
    public void gPathFind() {

        Response response =
                given().
                        when().
                        get("http://api.football-data.org/v2/competitions").
                        then().
                        header("Content-Type", "application/json;charset=UTF-8").       //need to set headers!!!!!!
                        extract().
                        response();

        Map<String, ?> allUsersData = response.path
                ("competitions.area.find { it.name == 'Africa' } ");                        //it - main word

        System.out.println(allUsersData);
    }


    // GPath extract single value with find
    @Test
    public void extractSingleValueWithFind() {

        Response response =
                given().
                when().
                        get("http://api.football-data.org/v2/competitions").
                then().
                        header("Content-Type", "application/json;charset=UTF-8").       //need to set headers!!!!!!
                        extract().
                        response();

        String name = response.path("competitions.area.find {  it.id == 2001 }.name");  // use find
/*
        {
            "count": 148,
                "filters": {},
            "competitions": [
            {
                "id": 2006,
                    "area": {
                "id": 2001,
                        "name": "Africa"   ------ this value we find
            },
                "name": "WC Qualification",
                    "code": null,
                    "emblemUrl": null,
                    "plan": "TIER_FOUR",
                    "currentSeason": {
                "id": 7,
*/

        System.out.println(name);
    }



    // GPath extract list values with findAll GPath extract list values with findAll max and collect for sum
    @Test
    public void extractListValuesWithFindAllMaxCollect() {

        Response response =
                given().
                when().
                        get("http://api.football-data.org/v2/competitions").
                then().
                        header("Content-Type", "application/json;charset=UTF-8").
                        extract().
                        response();

        List<String> list = response.path("competitions.area.findAll {  it.id > 2001 }.name");  // use findAll
        String nameMax = response.path("competitions.area.max {  it.id }.name");  // use max for find max value
        int sum = response.path("competitions.area.collect {  it.id }.sum()");  // use collect for sum values
/*
        {
            "count": 148,
                "filters": {},
            "competitions": [
            {
                "id": 2006,
                    "area": {
                "id": 2001,
                        "name": "Africa"   ------ this value we find
            },
                "name": "WC Qualification",
                    "code": null,
                    "emblemUrl": null,
                    "plan": "TIER_FOUR",
                    "currentSeason": {
                "id": 7,
*/
        System.out.println(list);
        System.out.println(nameMax);
        System.out.println(sum);
    }



    // GPath combining find and findAll
    @Test
    public void extractMapOfObjectWithFindAndFindAll() {

        Response response =
                given().
                        when().
                        get("http://api.football-data.org/v2/competitions").
                        then().
                        header("Content-Type", "application/json;charset=UTF-8").
                        extract().
                        response();

        Map<String, ?> list = response.path("competitions.findAll {  it.id > 2000 }.find {it.name == 'WC Qualification'}");  // combine find and find all


        System.out.println(list);
    }



    // GPath combining find and findAll WITH SPECIFY PARAMETERS
    @Test
    public void extractMapOfObjectWithFindAndFindAllSPECIFYpARAMS() {

        String plan = "TIER_FOUR";
        String name = "WC Qualification";

        Response response =
                given().
                        when().
                        get("http://api.football-data.org/v2/competitions").
                        then().
                        header("Content-Type", "application/json;charset=UTF-8").
                        extract().
                        response();

        Map<String, ?> list = response.path("competitions.findAll {  it.plan == '%s' }.find{ it.name == '%s'}", plan, name);  // format only String  findAll - find


        System.out.println(list);
    }


    // GPath combining find and findAll WITH SPECIFY PARAMETERS
    @Test
    public void extractMapOfObjectWithFindAllAndFindAll() {

        String plan = "TIER_ONE";
        String name = "Bundesliga";

        Response response =
                given().
                        when().
                        get("http://api.football-data.org/v2/competitions").
                        then().
                        header("Content-Type", "application/json;charset=UTF-8").
                        extract().
                        response();

        ArrayList<Map<String, ?>> list = response.path("competitions.findAll {  it.plan == '%s' }.findAll{ it.name == '%s'}", plan, name);  // format only String findAll - find


        System.out.println(list);
    }



}

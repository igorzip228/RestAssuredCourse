import config.TestConfig;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.config.XmlPathConfig;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.*;


public class jPathXMLTests {

// get name from XML   -REQUEST DOESN'T WORK , NEED TO CHANGE Content-Type to XML
    @Test
    public void basicGPathXML() {

        Response response =
                given().
                        when().
                        get("https://www.nasa.gov/rss/dyn/lg_image_of_the_day.rss").
                        then().
                        header("Content-Type", "application/rss+xml; charset=utf-8").
                        extract().
                        response();

        String name = response.path("description.link.name[0]");


        System.out.println(name);
    }



    // get attribute from XML   -REQUEST DOESN'T WORK , NEED TO CHANGE Content-Type to XML
    @Test
    public void extractCategoryXML() {

        Response response =
                given().
                        when().
                        get("https://www.nasa.gov/rss/dyn/lg_image_of_the_day.rss").
                        then().
                        header("Content-Type", "application/rss+xml; charset=utf-8").
                        extract().
                        response();

        String category = response.path("description.name[0].@category"); // category - attribute like <videoGame category = "Shooter" rating="Universal">


        System.out.println(category);
    }


    // get aList of XML nodes   -REQUEST DOESN'T WORK , NEED TO CHANGE Content-Type to XML
    @Test
    public void extractNodeXML() {



        String responseString = given().when().get("https://www.nasa.gov/rss/dyn/lg_image_of_the_day.rss").asString();

       List<Node> allResult = XmlPath.from(responseString).get(
               "videoGames.videoGame.findAll {element -> return element } " );

//        System.out.println(allResult.get(1).get("name").toString);
    }


    // get List of XML nodes by FindAll on Atribute   -REQUEST DOESN'T WORK , NEED TO CHANGE Content-Type to XML
    @Test
    public void extractListofXMLnodesbyFindAllonAtribute() {



        String responseString = given().when().get("https://www.nasa.gov/rss/dyn/lg_image_of_the_day.rss").asString();

        List<Node> allResult = XmlPath.from(responseString).get(
                "videoGames.videoGame.findAll { videogame -> def category = videoGame.@category == 'Driving' } " );

//        System.out.println(allResult.get(1).get("name").toString());
    }


    // get single node   -REQUEST DOESN'T WORK , NEED TO CHANGE Content-Type to XML

    @Test
    public void getSingleNodeofXML() {


        String responseString = given().when().get("https://www.nasa.gov/rss/dyn/lg_image_of_the_day.rss").asString();

        Node videoGame = XmlPath.from(responseString).get(
                "videoGames.videoGame.findAll { videogame -> def name = videoGame.name; name =='Tetris' } " );

//        System.out.println(allResult.get(1).get("name").toString());
    }



    // get single element depth   -REQUEST DOESN'T WORK , NEED TO CHANGE Content-Type to XML

    @Test
    public void getSingleElementDepthFirstNodeofXML() {


        String responseString = given().when().get("https://www.nasa.gov/rss/dyn/lg_image_of_the_day.rss").asString();

        int reviewScore = XmlPath.from(responseString).getInt(
                "**.find { it.name == 'Gran Turismo 3'}.reviewscore " );

        System.out.println(reviewScore);
    }



    // get sall nodes on condition  -REQUEST DOESN'T WORK , NEED TO CHANGE Content-Type to XML

    @Test
    public void getAllNodesOnCondoition () {


        String responseString = given().when().get("https://www.nasa.gov/rss/dyn/lg_image_of_the_day.rss").asString();

        int reviewScore = 30;

        List<Node> allNOdes = XmlPath.from(responseString).get(
                "videoGames.videoGame.findAll { it.reviewScore.toFloat() >= " + reviewScore + " } " );

        System.out.println(allNOdes);
    }

}

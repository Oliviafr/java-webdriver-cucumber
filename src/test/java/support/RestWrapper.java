package support;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import java.util.Map;

//import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

public class RestWrapper {
    private String baseUrl = "https://skryabin.com/recruit/api/v1/";
    private static String loginToken;
    Object positionId;
    Map<String, Object> result;
    private static JsonPath metadata;


//    private String positionId;

    public static final String CONTENT_TYPE = "Content-Type";
    public static final String JSON = "application/json";
    public static final String AUTH = "Authorization";

    private static Map<String, Object> lastPosition;

    public static Map<String, Object> getLastPosition() {
        return lastPosition;
    }


    public void logIn( Map<String, String> credentials ) {
        //prepare
        RequestSpecification request = RestAssured
                .given()
                .log().all()
                .header(CONTENT_TYPE, JSON)
                .body(credentials);

        //execute
        Response response = request
                .post(baseUrl + "login");

        //verify and extract
        Map<String, String> result = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");
        loginToken = "Bearer " + result.get("token");
        getMetadata();
    }

    //    public Map<String, String> createPosition(Map<String, String> position) {
    public Map<String, Object> createPosition( Map<String, String> position ) {

        String dateOpen = position.get("dateOpen");
        String isoDateOpen = new SimpleDateFormat("yyyy-MM-dd").format(new Date(dateOpen));
        position.put("dateOpen", isoDateOpen);
        // prepare
        RequestSpecification request = RestAssured
                .given()
                .log().all()
                .header(CONTENT_TYPE, JSON)
                .header(AUTH, loginToken)
                .body(position);

        //execute
        Response response = request
                .post(baseUrl + "positions");

//        verify and extract
//        Map<String,String> result = response
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .jsonPath()
                .getMap("");
        lastPosition = result;
//        loginToken = "Bearer " + result.get("token");

        positionId = result.get("id");
        return result;
    }

    public List<Map<String, Object>> getPositions() {
        // prepare
        RequestSpecification request = RestAssured
                .given()
                .log().all();

        // execute
        Response response = request.get(baseUrl + "positions");

        // extract and verify
        List<Map<String, Object>> result = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("");
        assertMetadata(result.get(0),"positions");
        return result;
    }

    public Map<String, Object> getPositionById(Object id) {
        Map<String, Object> result = RestAssured
                .given()
                .log().all()
                .when()
                .get(baseUrl + "positions/" + id)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        assertMetadata(result, "positions");
        return result;
    }

    public Map<String, Object> updatePosition( Map<String, String> updatedFields, Object id ) {
        if (id == lastPosition.get("id")) {
            // prepare
            RequestSpecification request = RestAssured
                    .given()
                    .log().all()
                    .header(CONTENT_TYPE, JSON)
                    .header(AUTH, loginToken)
                    .body(updatedFields);

            //execute
            Response response = request
                    .put(baseUrl + "positions/" + lastPosition.get("id"));
            result = response
                    .then()
                    .log().all()
                    .statusCode(200)
                    .extract()
                    .jsonPath()
                    .getMap("");
        }
        return result;
    }

    public void delete(Object id) {
        RequestSpecification request = RestAssured
                .given()
                .log().all()
                .header(CONTENT_TYPE, JSON)
                .header(AUTH, loginToken);
        //execute
        Response response = request
                .delete(baseUrl + "positions/" + lastPosition.get("id"));
    }

    public void deletePositionById(Object id) {
        RestAssured
                .given()
                .log().all()
                .header(AUTH, loginToken)
                .when()
                .delete(baseUrl + "positions/" + id)
                .then()
                .log().all()
                .statusCode(204)
                .header("X-Frame-Options", "SAMEORIGIN");
    }



    public JsonPath getMetadata() {
        JsonPath result = RestAssured
                .given()
                .log().all()
                .when()
                .get(baseUrl + "swagger.json")
                .then()
                .log().headers()
                .extract()
                .jsonPath();

        metadata = result;

        return result;
    }


    private static void assertMetadata(Map<String, Object> actual, String type) {
        for (String key : actual.keySet()) {
            if (actual.get(key) != null) {
                String actualDataType = actual.get(key).getClass().toString();
                actualDataType = actualDataType.substring(actualDataType.lastIndexOf('.') + 1);
                String expectedDataType = metadata.getString("definitions." + type + ".properties." + key + ".type");
                assertThat(actualDataType).isEqualToIgnoringCase(expectedDataType);
            }
        }
    }
}

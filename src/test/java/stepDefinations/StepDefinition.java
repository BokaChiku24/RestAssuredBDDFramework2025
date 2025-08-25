package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefinition extends Utils {
    Response addPlaceBaseResponse;
    RequestSpecification res;
    ResponseSpecification resSpec;
    TestDataBuild data = new TestDataBuild();
    @Given("add place payload {string}{string}{string}")
    public void add_place_payload(String name, String language, String address) throws IOException {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
        res = given().spec(requestSpecification()).body(data.addPlacePayLoad(name, language, address));
    }

    @When("user calls {string} with POST http request")
    public void user_calls_with_post_http_request(String addPlace) {
        // Write code here that turns the phrase above into concrete actions
        APIResources resourceAPI = APIResources.valueOf(addPlace);
        addPlaceBaseResponse = res.when()
                .post(resourceAPI.getResource()).then().spec(resSpec).extract().response();
    }

    @Then("the API call is success with status code {int}")
    public void the_api_call_is_success_with_status_code(int number) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(addPlaceBaseResponse.getStatusCode(), number);
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String key, String value) {
        // Write code here that turns the phrase above into concrete actions
        String string1 = addPlaceBaseResponse.asString();
        JsonPath path = new JsonPath(string1);
        assertEquals(path.get(key).toString(), value);
    }
}

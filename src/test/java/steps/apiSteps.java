package steps;

import br.com.wexigor.wexigor.WexigorApplication;
import br.com.wexigor.wexigor.models.User;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@SpringBootTest(classes = WexigorApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration
@DirtiesContext
public class apiSteps {

    int response = 0;
    String baseURL =  "http://localhost:8080/user";
    protected RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> statusMovieEndPoint;
    User userById;

    @When("calls \\/movies")
    public void callsMovies() {
        try{
            statusMovieEndPoint = restTemplate.getForEntity(new URI(baseURL + "/movies"), String.class);
        } catch (Exception e){
            System.out.println("url failed");
        }
    }

    @Then("receives response status value {string}")
    public void receivesResponseStatusValue(String status) {
        Assert.assertEquals(status, statusMovieEndPoint.getStatusCode().toString());
    }

    @When("calls \\/id with {string}")
    public void callsIdWith(String id) {
        try{
            userById = restTemplate.getForObject(new URI(baseURL + "/id/" + id), User.class);
        } catch (Exception e){
            System.out.println("url failed");
        }
    }

    @Then("receives response with first_name key value {string}")
    public void receivesResponseWithFirst_nameKeyValue(String firstname) {
        Assert.assertEquals(firstname, userById.getFirstName());
    }



}

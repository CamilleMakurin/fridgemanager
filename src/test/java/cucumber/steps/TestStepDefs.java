package cucumber.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fridgemanager.fridgemanager.ping.PingResponse;
import io.cucumber.java.en.Given;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TestStepDefs {

    private static final String LOCAL_HOST = "http://localhost:8080";
    private ObjectMapper mapper = new ObjectMapper();

    @Given("application is pinged")
    public void testPing() {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(
                    URI.create(LOCAL_HOST + "/ping"))
                    .header("accept", "application/json")
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            System.out.println("info: response: " + response);
            System.out.println("info: responseBody: " + responseBody);
            PingResponse resp = mapper.readValue(responseBody, PingResponse.class);
            assertThat(resp.getApplicationStatus(), is("UP"));
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}

package poc.bdd.emi.api;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class EMICalculatorAPISteps {

    private String name;
    private double price;
    private String purchaseDate;
    private String emiDuration;
    private double emiPerc;
    
    private ResponseEntity<?> response;
    private RestTemplate restTemplate;
   

    @Given("the Product name is <name>, Price is <price>, PurchaseDate is <purchaseDate>, EMIPerc is <emiPerc>, EMIDuration is <emiDuration>")
    public void createAccount(@Named("name") String name, @Named("price") double price, @Named("purchaseDate") String purchaseDate, @Named("emiPerc") double emiPerc, @Named("emiDuration") String emiDuration) {
        this.name = name;
        this.price = price;
        this.purchaseDate = purchaseDate;
        this.emiDuration = emiDuration;
        this.emiPerc = emiPerc;
    }

    @When("the Product is valid")
    public void createCreditCard() throws Exception {
    	restTemplate = new RestTemplate();
    	URI url = new URI("http://172.16.124.15:2018/api/emi/management");
    	response = restTemplate.exchange(url, HttpMethod.POST, null, String.class);
    }

    @Then("the EMI calculated for the product <httpStatus>")
    public void checkMoney(@Named("result") int amount) {
    	assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

}

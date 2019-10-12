package caffeinateme;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class OrderCoffeeSteps {

    Customer kathy = new Customer();
    Barrista barry = new Barrista();
    String kathysOrder;

    @Given("^Kathy is (\\d+) meters from the coffee shop$")
    public void kathy_is_n_meters_from_the_coffee_shop(int distanceInMeters) {

        kathy.setDistanceFromShop(distanceInMeters);

    }

    @When("^Kathy orders a (.*)$")
    //reemplazamos "large cappuccino$" por (.*) para que kathy no solo pueda ordenar cappuccino sino cualquier otro cafe.
    public void kathy_orders_a(String order) {  //tambien aqui reemplazamos large_cappuccino por el parámetro (String order)
        kathysOrder = order;
        kathy.placesOrderFor(order);
    }

    @Then("^Barry should reiceive the order$")
    public void barry_should_reiceive_the_order() {
        assertThat(barry.getPendingOrders(), hasItem(kathysOrder)); //>estas aserciones pueden encontrarse en el sitio de Hamcrest.
    }

    @Then("^Barry should know that the coffee is Urgent$")
    public void barry_should_know_that_the_coffee_is_Urgent() {
        assertThat(barry.getUrgentOrders(), hasItem(kathysOrder));
    }

}

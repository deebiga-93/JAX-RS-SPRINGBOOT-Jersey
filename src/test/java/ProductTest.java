import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(classes = Application.class)
public class ProductTest extends JerseyTest {

    @Override
    protected Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
    return null;}
    // Testing for GET function whether fetch all products
    @Test
    public void getproducts(String expected) {
        Response response = target("/v1/products").request()
                .get();

       assertEquals("Http Response should be 200: ", Response.Status.OK.getStatusCode(), response.getStatus());


        String content = response.readEntity(String.class);
       assertEquals("THE PRODUCTS ARE: ", "{'RED-T shirt','Hugo-boss','Red-hugo boss',{'red Tshirt','Hugo-boss'},'apparel'}");
    }
// Testing for GET functions whether fetchby category and its details
@Test
public void givenProductsExists_whenSearching_thenResponseContainsProductEntity(String expected) {
    final String json = target("v1/products").request()
            .get(String.class);
    assertThat(json, containsString("\"b6afac37-c9a-4fd4-8254-f096dbc5cd34d,Red T-shirt,Hugo-Boss,Red T-shirt hugo boss,{Red T-shirt,hugo-boss},apparel,2020-11-10T12:16:45Z"));
}



    //testing for Post function whether it checks bad request from client side
    @Test
    public void givenCreateProduct_whenProductIsInvalid_thenResponseCodeIsBadRequest() {
        Response response = target("/products").request()
                .post(Entity.json("b6afac37-c9a-4fd4-8254-f096dbc5cd34d,Red T-shirt,Hugo-Boss,Red T-shirt hugo boss,{Red T-shirt,hugo-boss},apparel,2020-11-10T12:16:45Z"));

        assertEquals("Http Response should be 201 ", Response.Status.CREATED.getStatusCode(), response.getStatus());
        assertThat(response.readEntity(String.class), containsString(""));
    }}
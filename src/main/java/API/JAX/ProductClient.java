

package API.JAX;
import repository.entity.Product;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ProductClient {
    public static void main(String[] argus) {

        Client client = ClientBuilder.newClient( );
    WebTarget webTarget = client.target("http://localhost:8080/v1/products").path("products");

    Product clientProduct = new Product("b6afac37-c9a-4fd4-8254-f096dbc5cd34d","blue T-shirt","Decathalon","blue t-shirt","apparel","{blue,T-shirt}","2020:11:10T12:24:45Z");
clientProduct.setId("1");
clientProduct.setName("Hugo-Boss T-shirt");

    Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
    Response response = invocationBuilder.post(Entity.entity(clientProduct, MediaType.APPLICATION_JSON));

System.out.println(response.getStatus());
System.out.println(response.readEntity(String.class));

}}

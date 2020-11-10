package controller;

import model.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ProductRepositoryImpl;
import repository.entity.Product;
import services.ProductService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
@Path("/v1/products")
    public class ProductController {
    private ProductRepositoryImpl repository;
    @Autowired
    private ProductService service;


    @GET
    @Path("products/{category}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("category") String category) {
        List<ProductResponse> response = service.fetchBy(category);
        return Response.ok().entity(response).build();
    }
    @POST
    @Path("/products")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct( Product addproduct) throws URISyntaxException {
        if (addproduct == null) {
            return Response.status(400).entity("Please add product details !!").build();
        }

        if (addproduct.getName() == null) {
            return Response.status(400).entity("Please provide the product name !!").build();
        }

        return Response.created(new URI("/v1/products/" + addproduct.getCategory())).build();
    }}

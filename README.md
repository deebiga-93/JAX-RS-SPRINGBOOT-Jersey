# JAX-RS-SPRINGBOOT-Jersey
ABOUT PROJECT:<br>
     To develop and designed simple Product REST API storing data in H2 database using Java<br>
     
 Tools/Frameworks:<br>
 Spring Boot <br>
 JAX-RS <br>
Jersey <br>
  Gradle<br>
intellij Idea(IDE)<br>
 
 REST Functions:<br>
 // HTTP  GET <br>
 @Path("/v1/products")<br>
 @Produces(MediaType.APPLICATION_JSON)<br>
 
 the following steps are to create Jersey client builder :<br>
 1)Use ClientBuilder.newClient() static method.<br>
2)Use client.target() method on above obtained client instance.<br>
3)Get Invocation.Builder using webTarget.request() method on WebTarget instance obtained in second step.<br>
4)Execute invocationBuilder.get(), put(), post() or delete() methods to invoke corresponding REST APIs.<br>
In my project where uesd in ProductClient class:<br>

          Client client = ClientBuilder.newClient( );
          WebTarget webTarget = client.target("http://localhost:8080/v1/products").path("products");
       Product clientProduct = new Product("b6afac37-c9a-4fd4-8254-f096dbc5cd34d","blue T-shirt","Decathalon","blue t-shirt","apparel","{blue,T-shirt}","2020:11:10T12:24:45Z");
       clientProduct.setId("1");
	   clientProduct.setName("Hugo-Boss T-shirt");
        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(clientProduct, MediaType.APPLICATION_JSON));
// REST API CODE:<br>
        private ProductResponse from(Product product) {<br>
        ProductResponse response = new ProductResponse();<br>
        response.setId(product.getId());<br>
        response.setBrand(product.getBrand());<br>
        response.setCategory(product.getCategory());<br>
        response.setCreatedAt(product.getCategory());<br>
        response.setTags(splitTags(product.getTags()));<br>
        return response; }<br>
    
    Sample Input:
    { name:Red T-shirt,Brand:Hugo-Boss,description:Red T-shirt hugo boss,tags:{Red T-shirt,hugo-boss},category:apparel"}<br>

Sample OUTPUT:
{<br> id:"b6afac37-c9a-4fd4-8254-f096dbc5cd34d,<br>name:Red T-shirt,<br>brand:Hugo-Boss,<br> description:Red T-shirt hugo boss,<br>tags:{Red T-shirt,hugo-boss},<br>category:apparel,<br>created_at:2020-11-10T12:16:45Z"}<br>

//HTTP/GET BY CATEGORY<br>
@PATH"/V1/PRODUCTS/Apparel"<br>
REST API CODE:<br>
        public List<ProductResponse> fetchBy(String category) throws NotFoundException {<br>
        List<Product> products = (List<Product>) repository.findByCategory(category);<br>
        return products.stream().map(this::from).collect(Collectors.toList());}<br>
    
	Sample INPUT: v1/products/apparel
    
Sample Output:<br>
{<br>id:"b6afac37-c9a-4fd4-8254-f096dbc5cd34d,<br>name:Red T-shirt,<br>brand:Hugo-Boss, <br>description:Red T-shirt hugo boss,<br>tags:{Red T-shirt,hugo-boss},<br>category:apparel,<br>created_at:2020-11-10T12:16:45Z"<br>}<br>
{<br>id:"b6afac37-c9a-4fd4-8254-f096ddmkl34d,<br>name:blue T-shirt,<br>brand:Hugo-Boss, <br>description:blue T-shirt hugo boss,<br>tags:{blue T-shirt,hugo-boss},<br>category:apparel,<br>created_at:2020-11-10T12:16:45Z"<br>}<br>

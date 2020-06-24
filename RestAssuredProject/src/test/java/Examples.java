import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
public class Examples {

	
	//@Test
	public void test_get() {
		
		baseURI="http://localhost:3000/";
		given().
		      get("/posts").
		       then(). 
		          statusCode(200).
		          log().all();
	
	}
	
	//@Test
	public void test_POST() {
		
		baseURI="http://localhost:3000/";
		
		JSONObject req= new JSONObject();
		req.put("title","lokeshpgm");
		req.put("author","authorlok");
		
		given().
		     contentType(ContentType.JSON).
                     accept(ContentType.JSON).
                     	body(req.toJSONString()).
       when(). 
        post("/posts")
          .then()
            .statusCode(201)
             .log().all();
	
	}
	
	@Test
	public void test_PATCH() {
		
		baseURI="http://localhost:3000/";
		
		JSONObject req= new JSONObject();
		
		req.put("author","authorislok");
		
		given().
		     contentType(ContentType.JSON).
                     accept(ContentType.JSON).
                     	body(req.toJSONString()).
       when(). 
        patch("/posts/6")
          .then()
            .statusCode(200)
             .log().all();
	
	}
}

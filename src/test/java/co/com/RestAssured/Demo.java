package co.com.RestAssured;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class Demo {
	
	//@Before
	public void setup() {
	    RestAssured.baseURI ="http://swapi.co/api/people/1";
	    RestAssured.port = 443;
	}
	
	 

	//@Test
	public void testGET() {
		String body = RestAssured
                .given()
                    .baseUri("http://swapi.co/api")
                    .and()
                    .queryParam("format", "json")
                .when()
                    .get("/people/2")
                .then()
                    .log().all()
                    .and().assertThat().statusCode((200))
                    .body("mass", response -> equalTo("75"))
                    .body("species", response -> notNullValue())
                    
                    .and().extract().body().asString();

	}
	
	//@Test
    public void whenRequestingAResourceThenLinksToResourcesMustBeReturned() {

        BaseApiResponse baseApiResponse = RestAssured
            .given()
                .baseUri("http://swapi.co/api")
                .and()
                .queryParam("format", "json")
                .log().all()
            .when()
                .get("/")
            .then()
                .statusCode(is(equalTo(200)))
                .and()
                .body("films", response -> notNullValue())
                .body("vehicles", response -> notNullValue())
                .body("people", response -> notNullValue())
                .body("starships", response -> notNullValue())
                .body("species", response -> notNullValue())
                .body("planets", response -> notNullValue())
                .and().extract().body().as(BaseApiResponse.class);

        RestAssured
            .given()
                .queryParam("format", "json")
                .log().all()
            .when()
                .post(baseApiResponse.getPeople())
            .then()
                .log().all() //log : nos permite configurar el nivel de detalle (de request y response por separado
                .and()
                .assertThat()
                    .statusCode(is(equalTo(405)));
    }
	
	//@Test
	public void metodo_POST_Para_People() {
		   ApiResponsePOST apiResponsePOST = RestAssured
		            .given()
		                .baseUri("http://swapi.co/api")
		                .and()
		                .queryParam("format", "json")
		                .log().all()
		            .when()
		                .get("/people/")
		            .then()
		                .statusCode(is(equalTo(200)))
		                .and()
		                .body("name", response -> notNullValue())
		                .body("height", response -> notNullValue())
		                .body("mass", response -> notNullValue())
		                .body("hair_color", response -> notNullValue())
		                .body("skin_color", response -> notNullValue())
		                .body("eye_color", response -> notNullValue())
		                .body("birth_year", response -> notNullValue())
		                .body("gender", response -> notNullValue())
		                .body("homeworld", response -> notNullValue())
		                .body("films", response -> notNullValue())
		                .body("species", response -> notNullValue())
		                .body("vehicles", response -> notNullValue())
		                .body("starships", response -> notNullValue())
		                .body("created", response -> notNullValue())
		                .body("edited", response -> notNullValue())
		                .body("url", response -> notNullValue())
		                .and().extract().body().as(ApiResponsePOST.class);

		        RestAssured
		            .given()
		                .queryParam("format", "json")
		                .log().all()
		            .when()
		                .post(apiResponsePOST.getEye_color()) 
		            .then()
		                .log().all() //log : nos permite configurar el nivel de detalle (de request y response por separado
		                .and()
		                .assertThat()
		                    .statusCode(is(equalTo(405)));
	}

	@Test
	public void metodo_POST_Para_JSONPLACEHOLDER() {
		   ApiResponseJSONPLACEHOLDER apiResponseJSONPLACEHOLDER = RestAssured
		            .given()
		                .baseUri("https://jsonplaceholder.typicode.com/todos")
		                .and()
		                .queryParam("format", "json")
		                .log().all()
		            .when()
		                .get("/")
		            .then()
		                .statusCode(is(equalTo(200)))
		                .and()
		                .body("userId", response -> notNullValue())
		                .body("id", response -> notNullValue())
		                .body("title", response -> notNullValue())
		                .body("completed", response -> notNullValue())
		             
		               
		                .and().extract().body().as(ApiResponseJSONPLACEHOLDER.class);

		        RestAssured
		            .given()
		                .queryParam("format", "json")
		                .log().all()
		            .when()
		                .post(apiResponseJSONPLACEHOLDER.getTitle()) 
		            .then()
		                .log().all() //log : nos permite configurar el nivel de detalle (de request y response por separado
		                .and()
		                .assertThat()
		                    .statusCode(is(equalTo(405)));
	}
	
	
//	@Test
//	public void metodo_PUT_Para_People() {
//		
//	}


}
	
	
	
	
	
	
	
	



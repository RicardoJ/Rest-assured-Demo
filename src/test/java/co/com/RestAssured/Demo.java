package co.com.RestAssured;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;;


public class Demo {
//	@Before
//	public void setup() {
//	    RestAssured.baseURI ="http://swapi.co/api/people/1";
//	    RestAssured.port = 443;
//	}	

	@Test
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
	
	}



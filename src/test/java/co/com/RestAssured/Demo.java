package co.com.RestAssured;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class Demo {
//	@Before
//	public void setup() {
//	    RestAssured.baseURI ="http://swapi.co/api/people/1";
//	    RestAssured.port = 443;
//	}	
/*
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

	}*/
	
	@Test
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

    private static class BaseApiResponse {
        private String films;
        private String vehicles;
        private String people;
        private String starships;
        private String species;
        private String planets;

        public String getFilms() {
            return films;
        }

        public String getVehicles() {
            return vehicles;
        }

        public String getPeople() {
            return people;
        }

        public String getStarships() {
            return starships;
        }

        public String getSpecies() {
            return species;
        }

        public String getPlanets() {
            return planets;
        }
    }
}
	
	
	
	
	
	
	
	



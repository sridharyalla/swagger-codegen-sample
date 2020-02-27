package org.example;

import com.google.gson.Gson;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.api.PetApi;
import io.swagger.client.model.Pet;
import org.junit.Before;
import org.junit.Test;

public class DemoTest {

    PetApi api = null;
    Gson gson = new Gson();
    @Before
    public  void setup(){
        api = new PetApi();
    }
    @Test
    public void testGet() throws ApiException {
        System.out.println(api.getPetById(1L).toString());
    }

    @Test
    public void testPost() throws ApiException {
        String payload = "{\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"name\": \"happy\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        Pet p = gson.fromJson(payload, Pet.class);
        ApiResponse<Void> resp = api.addPetWithHttpInfo(p);
        System.out.println(resp.getStatusCode());
    }
}

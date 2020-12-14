package com.example.WordCount;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/calculateMostFrequentNWords/{text}/{amount}")
public class MostFrequentResource {

    CalculateService calculateService = new CalculateService();

    @GET
    @Produces("text/plain")
    public String getCalculateMostFrequentNWords(@PathParam("text") String text, @PathParam("amount") int amount) {

        return calculateService.getCalculateMostFrequentNWords(text,amount);}
}
package com.example.WordCount;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/calculateHighestFrequency")
public class CalculateResource {

    CalculateService calculateService = new CalculateService();

    @Path("/General/{text}")
    @GET
    @Produces("text/plain")
    public String giveHighestFrequency(@PathParam("text") String text) {

        return calculateService.getCalculateHighestFrequency(text);}

    @Path("/ForWord/{word}/with/{text}/")
    @GET
    @Produces("text/plain")
    public String giveHighestFrequencyOfWord(@PathParam("text") String text, @PathParam("word") String word) {
        return calculateService.getCalculateFrequencyForWord(text,word);}
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parallax.server.blocklyprop.rest;

import com.cuubez.visualizer.annotation.Detail;
import com.cuubez.visualizer.annotation.Group;
import com.cuubez.visualizer.annotation.HttpCode;
import com.cuubez.visualizer.annotation.Name;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.inject.Inject;
import com.parallax.client.cloudsession.CloudSessionLocalUserService;
import com.parallax.client.cloudsession.CloudSessionUserService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.apache.commons.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Michel
 */
@Path("/client")
@Group(name = "/client", title = "BlocklyPropClient info")
@HttpCode("500>Internal Server Error,200>Success Response")
public class RestBlocklyPropClient {

    private static final Logger log = LoggerFactory.getLogger(RestBlocklyPropClient.class);

    private CloudSessionLocalUserService cloudSessionLocalUserService;
    private CloudSessionUserService cloudSessionUserService;
    private Configuration configuration;

    @Inject
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
        cloudSessionLocalUserService = new CloudSessionLocalUserService(configuration.getString("cloudsession.server"), configuration.getString("cloudsession.baseurl"));
        cloudSessionUserService = new CloudSessionUserService(configuration.getString("cloudsession.baseurl"));
    }

    @GET
    @Path("/list")
    @Detail("Save base profile data")
    @Name("Save base profile data")
    @Produces("application/json")
    public Response saveBase() {
        JsonObject result = new JsonObject();

        JsonArray clients = new JsonArray();

        JsonObject client1 = new JsonObject();
        client1.addProperty("identifier", "Desktop");
        JsonArray ports1 = new JsonArray();
        ports1.add(new JsonPrimitive("com1"));
        client1.add("ports", ports1);
        clients.add(client1);

        JsonObject client2 = new JsonObject();
        client2.addProperty("identifier", "RaspberryPi");
        JsonArray ports2 = new JsonArray();
        ports2.add(new JsonPrimitive("com2"));
        ports2.add(new JsonPrimitive("com3"));
        client2.add("ports", ports2);
        clients.add(client2);

        result.addProperty("success", true);
        result.add("clients", clients);
        return Response.ok(result.toString()).build();
    }

}

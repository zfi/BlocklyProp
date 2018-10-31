/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parallax.server.blocklyprop.config;

import com.parallax.server.blocklyprop.rest.RestCompile;
import com.parallax.server.blocklyprop.rest.RestMotd;
import com.parallax.server.blocklyprop.rest.RestProfile;
import com.parallax.server.blocklyprop.rest.RestProject;
import com.parallax.server.blocklyprop.rest.RestSharedProject;
import com.parallax.server.blocklyprop.rest.RestUser;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

/**
 *
 * @author Michel
 */
public class RestModule extends JerseyServletModule {

    @Override
    protected void configureServlets() {
        
        // Bind the REST interfaces to their implementations
        bind(RestCompile.class);
        bind(RestUser.class);
        bind(RestProject.class);
        bind(RestSharedProject.class);
        bind(RestProfile.class);
        bind(RestMotd.class);

        /* bind jackson converters for JAXB/JSON serialization */
        bind(MessageBodyReader.class).to(JacksonJsonProvider.class);
        bind(MessageBodyWriter.class).to(JacksonJsonProvider.class);

        serve("/rest/*").with(GuiceContainer.class);
    }

}

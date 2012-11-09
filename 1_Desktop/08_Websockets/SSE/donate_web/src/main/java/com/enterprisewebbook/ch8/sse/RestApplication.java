package com.enterprisewebbook.ch8.sse;

import com.enterprisewebbook.ch8.sse.controller.DonationResource;
import com.enterprisewebbook.ch8.sse.service.DataProvider;
import org.glassfish.jersey.media.sse.OutboundEventWriter;
import org.glassfish.jersey.moxy.json.MoxyJsonBinder;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * TODO
 *
 * @author Viktor Gamov (http://log.javaheadbrain.com)
 * @since 11/5/12
 */
@ApplicationPath("api")
public class RestApplication extends ResourceConfig {

    public RestApplication(){
        super(DonationResource.class, OutboundEventWriter.class);
        addBinders(new MoxyJsonBinder());
        DataProvider.init();
    }
}

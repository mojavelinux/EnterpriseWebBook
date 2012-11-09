package com.enterprisewebbook.ch8.sse.controller;

import com.enterprisewebbook.ch8.sse.domain.Donation;
import com.enterprisewebbook.ch8.sse.service.DataProvider;
import org.glassfish.jersey.media.sse.EventChannel;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * TODO
 *
 * @author Viktor Gamov (http://log.javaheadbrain.com)
 * @since 11/5/12
 */
@Path("donations")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DonationResource {

    /**
     *
     * @param uriInfo
     * @param donation
     * @return
     */
    @POST
    public Response create(@Context UriInfo uriInfo, Donation donation) {
        return Response.created(uriInfo.getBaseUriBuilder()
                .path(DonationResource.class)
                .path("{id}")
                .build(DataProvider.createDonation(donation))
        ).build();
    }

    @GET
    public List<Donation> getAll(){
        return DataProvider.getAllDonations();
    }

    /**
     * @return
     */
    @GET
    @Path("events")
    @Produces(EventChannel.SERVER_SENT_EVENTS)
    public EventChannel getEvents() {
        EventChannel eventChannel = new EventChannel();
        DataProvider.addEventChannel(eventChannel);
        return eventChannel;
    }
}

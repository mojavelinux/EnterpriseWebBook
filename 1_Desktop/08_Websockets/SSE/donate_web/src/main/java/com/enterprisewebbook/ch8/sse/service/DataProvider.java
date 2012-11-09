package com.enterprisewebbook.ch8.sse.service;

import com.enterprisewebbook.ch8.sse.domain.Donation;
import com.enterprisewebbook.ch8.sse.domain.Donor;
import org.glassfish.jersey.media.sse.EventChannel;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseBroadcaster;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 *
 * @author Viktor Gamov (http://log.javaheadbrain.com)
 * @since 11/5/12
 */
public class DataProvider {

    private static AtomicInteger lastId = new AtomicInteger(0);

    private static final HashMap<Integer, Donation> donations = new HashMap<Integer, Donation>();
    private static SseBroadcaster sseBroadcaster = new SseBroadcaster();

    public static synchronized int createDonation(Donation donation) {
        Donation result = new Donation();
        result.id = lastId.incrementAndGet();
        result.donor = donation.donor;
        result.amount = donation.amount;
        donations.put(result.id, result);
        sseBroadcaster.broadcast(new OutboundEvent.Builder()
                .name("create")
                .data(Donation.class, result)
                .mediaType(MediaType.APPLICATION_JSON_TYPE)
                .build());
        return result.id;
    }

    public static void init(){
        Donation result = new Donation();
        result.id = lastId.incrementAndGet();
        Donor donor = new Donor();
        donor.setFullName("Viktor Gamov");
        donor.setEmail("viktor.gamov@faratasystems.com");
        donor.setAddress("154 Summit Ave");
        donor.setCity("Lyndhurst");
        donor.setState("NJ");
        donor.setCountry("United States");
        donor.setZip("07071");
        result.donor = donor;
        result.amount = Double.valueOf("100.00");
        donations.put(result.id, result);
    }

    public static void addEventChannel(EventChannel eventChannel){
        sseBroadcaster.add(eventChannel);
    }

    public static List<Donation> getAllDonations() {

        return new ArrayList(donations.values());
    }
}

package br.ufrn.imd.moviesbackend.config;

import br.ufrn.imd.moviesbackend.service.FiwareService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.io.IOException;
import java.util.ArrayList;

@Configuration
public class ServicesConfig {

    @Value("${application.data.mode}")
    private String dataMode;

    @Value("${application.fiware.orion.host}")
    private String orionHost;

    @Value("${application.fiware.orion.port}")
    private String orionPort;

    @Value("${notification.endpoint}")
    private String notificationEndpoint;

    @EventListener(ApplicationReadyEvent.class)
    public void configOrion(){

        if(dataMode.equals("create")){
            System.out.println("Subscribing...");
            ArrayList<String> attributes = new ArrayList<String>();
            attributes.add("title");
            attributes.add("genre");
            attributes.add("exibitionDate");
            attributes.add("type");
            attributes.add("id");

            try {
                FiwareService.subscribeOrion("Receive movies updates", "Movie",
                        attributes, notificationEndpoint, orionHost, orionPort);
                System.out.println("Subscription done!");
            } catch (IOException e) {
                System.out.println("Error creating subscription");
                e.printStackTrace();
            }
        }
    }
}

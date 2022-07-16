package br.ufrn.imd.moviesbackend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class ServicesConfig {

    @Value("${application.data.mode}")
    private String dataMode;

    @Value("${application.fiware.orion.host}")
    private String orionHost;

    @Value("${application.fiware.orion.port}")
    private String orionPort;

    @EventListener(ApplicationReadyEvent.class)
    public void configOrion(){
        System.out.println("ServicesConfig");

        if(dataMode.equals("create")){
            System.out.println("Configuring Orion");

        }

    }


}

package br.ufrn.imd.moviesbackend.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class RequestsConfigHelper {

    public static String configEndpointProtocol(String endpoint){
        if(!endpoint.startsWith("http://")){
            endpoint = "http://" + endpoint;
        }
        return endpoint;
    }

    public static String createEndpoint(String host, String port, String context){
        return configEndpointProtocol(host) + ":" + port + context;
    }

    public static String toJson(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

}
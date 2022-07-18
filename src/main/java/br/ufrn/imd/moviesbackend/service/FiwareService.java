package br.ufrn.imd.moviesbackend.service;

import br.ufrn.imd.moviesbackend.model.orion.MovieEntity;
import br.ufrn.imd.moviesbackend.model.orion.OrionSubscription;
import br.ufrn.imd.moviesbackend.util.HttpRequests;
import br.ufrn.imd.moviesbackend.util.RequestsConfigHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class FiwareService {

    public static String orionSubscriptionContext = "/v2/subscriptions/";

    public static String orionEntityContext = "/v2/entities/";
    public static String fiware_service = "MOVIES";
    public static String fiware_servicepath = "/movies";

    public static Map<String, String> fiwareHeaders() {
        Map<String, String> fiwareHeaders = new HashMap<>();
        fiwareHeaders.put("Content-Type", "application/json");
        fiwareHeaders.put("fiware-service", fiware_service);
        fiwareHeaders.put("fiware-servicepath", fiware_servicepath);
        return fiwareHeaders;
    }


    public static String subscribeOrion(
            String description, String pattern, ArrayList<String> attrs,
            String cygnusDockerEndpoint, String orionHost, String orionPort) throws IOException {

        String url = RequestsConfigHelper.createEndpoint(orionHost, orionPort, orionSubscriptionContext);
        OrionSubscription orionSubscription = new OrionSubscription(description, pattern, attrs, cygnusDockerEndpoint);
        String data = null;
        String subscriptionId = null;
        try {
            data = RequestsConfigHelper.toJson(orionSubscription);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ResponseEntity<String> response;
        try {
            response = HttpRequests.post(url, data, fiwareHeaders());
            String location = response.getHeaders().get("Location").get(0);
            String[] locationSplit = location.split("/");
            subscriptionId = locationSplit[3];
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException(e.getMessage());
        }
        if(response.getStatusCode() != HttpStatus.CREATED){
            throw new IOException(response.getBody());
        }
        return subscriptionId;
    }

    public static void createEntity(MovieEntity entity, String orionHost, String orionPort) throws IOException {
        String url = RequestsConfigHelper.createEndpoint(orionHost, orionPort, orionEntityContext);
        ResponseEntity<String> response;
        try {
            response = HttpRequests.post(url, RequestsConfigHelper.toJson(entity), fiwareHeaders());
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException(e.getMessage());
        }
        if(response.getStatusCode() != HttpStatus.CREATED){
            throw new IOException(response.getBody());
        }
    }
}

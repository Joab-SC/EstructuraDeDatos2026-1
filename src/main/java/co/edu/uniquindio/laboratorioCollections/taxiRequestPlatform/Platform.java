package co.edu.uniquindio.laboratorioCollections.taxiRequestPlatform;

import java.util.LinkedHashMap;
import java.util.Map;

public class Platform {
    LinkedHashMap<String, Request> requests;

    public Platform() {
        this.requests = new LinkedHashMap<>();
    }

    public void addRequest(Request request) throws Exception {
        if(requests.get(request.getCode()) != null){
            throw new Exception("There is already a request with that Id");
        }
        requests.put(request.getCode(), request);
    }

    public Request serveRequest() {
        if (requests.isEmpty()) {
            throw new RuntimeException("No more requests to serve");
        }
        Map.Entry<String, Request> nextRequest = requests.entrySet().iterator().next();
        requests.remove(nextRequest.getKey());
        return nextRequest.getValue();
    }

    public Request cancelRequest(String code) {
        if (!requests.containsKey(code)) {
            throw new RuntimeException("No request exists with that code");
        }
        return requests.remove(code);
    }

    public void showPendingRequests() {
        for (Map.Entry<String, Request> request : requests.entrySet()) {
            System.out.println(request.getValue().toString());
        }
    }
}
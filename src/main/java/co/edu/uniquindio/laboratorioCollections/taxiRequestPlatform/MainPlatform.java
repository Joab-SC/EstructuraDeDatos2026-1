package co.edu.uniquindio.laboratorioCollections.taxiRequestPlatform;

import co.edu.uniquindio.laboratorioCollections.Benchmark;


import java.util.List;

public class MainPlatform {
    public static void main(String[] args) throws InterruptedException {
        Platform platform = new Platform();

        List<Request> requests = RequestGenerator.generate(10000);

        Benchmark.run("Add 10,000 requests", () -> {
            for (Request request : requests) {
                try {
                    platform.addRequest(request);
                } catch (Exception e) {
                    continue;
                }
            }
            try{
                platform.addRequest(new Request("R999999", "Downtown"));
            } catch (Exception e) {
            }

        });

        Benchmark.run("Serve first request", () -> {
            System.out.println(platform.serveRequest());
        });

        Benchmark.run("Cancel a request by code", () -> {
            System.out.println(platform.cancelRequest("R999999"));
        });

        Benchmark.run("Show pending requests", () -> {
            platform.showPendingRequests();
        });
    }
}
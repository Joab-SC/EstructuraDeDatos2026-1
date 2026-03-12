package co.edu.uniquindio.laboratorioCollections;

public class Benchmark {

    public static void run(String label, Runnable operation) {
        Runtime rt = Runtime.getRuntime();

        rt.gc();
        rt.gc();
        sleep(50);

        long memBefore  = rt.totalMemory() - rt.freeMemory();
        long timeBefore = System.nanoTime();

        operation.run();

        long timeNs   = System.nanoTime() - timeBefore;
        long memBytes = (rt.totalMemory() - rt.freeMemory()) - memBefore;

        System.out.println("=== " + label + " ===");
        System.out.printf("Tiempo : %.3f ms%n", timeNs / 1_000_000.0);
        System.out.printf("Memoria: %+.2f KB%n%n", memBytes / 1024.0);
    }

    private static void sleep(long ms) {
        try { Thread.sleep(ms); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
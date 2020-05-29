package lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MontePi {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        long start = System.currentTimeMillis();

        final int numThreads = 4;
        final int iterations = 1_000_000_000;

        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        List<Callable<Integer>> tasks = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            tasks.add(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int inCircle = 0;
                    for (int j = 0; j < iterations / numThreads; j++) {
                        double x = ThreadLocalRandom.current().nextDouble();
                        double y = ThreadLocalRandom.current().nextDouble();
                        double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
                        if (distance <= 1) {
                            inCircle++;
                        }
                    }
                    return inCircle;
                }
            });
        }
        List<Future<Integer>> results = executorService.invokeAll(tasks);
        executorService.shutdown();

        int totalInCircle = 0;
        for (Future<Integer> result : results) {
            totalInCircle += result.get();
        }

        double pi = ((double) totalInCircle / iterations) * 4;

        long end = System.currentTimeMillis();
        long duration = end - start;

        System.out.println("PI is " + pi);
        System.out.println("THREADS " + numThreads);
        System.out.println("ITERATIONS " + iterations);
        System.out.println("TIME " + duration + "ms");
    }
}

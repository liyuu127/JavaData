package base.multithread.cf;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class Shop {
    Random random = new Random(100L);

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    private Future<Double> getPriceAsync(String product) {
//        CompletableFuture<Double> future = new CompletableFuture<>();
//        new Thread(() -> {
//            try {
//                double v = calculatePrice(product);
//                future.complete(v);
//            } catch (Exception e) {
//                future.completeExceptionally(e);
//            }
//        }).start();
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }


    public List<String> findPrice(List<String> products) {
//      return   products.stream()
//                .map(product -> String.format("%s price is %.2f", product, getPrice(product)))
//                .collect(Collectors.toList());
        List<CompletableFuture<String>> collect = products.stream()
                .map(product -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", product, getPrice(product))))
                .collect(Collectors.toList());
      return   collect.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test() throws ExecutionException, InterruptedException {
//        Shop shop = new Shop();
//        Future<Double> priceAsync = shop.getPriceAsync("aa");
//        Double v = priceAsync.get();
//        System.out.println("v = " + v);

        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        List<String> price = findPrice(list);
        System.out.println("price = " + price);

    }
}

package com.poortoys.examples;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppMain {

    public static void main(String[] args) {
        int n = Runtime.getRuntime().availableProcessors();
        ExecutorService service = null;
        try  {
            service = Executors.newFixedThreadPool(n);
            List<PowTask> powTaskList = new ArrayList<>();
            Random random = new Random();

            for (int i = 0; i < 10000; i++) {
                powTaskList.add(new PowTask(
                        new BigInteger(String.valueOf(random.nextInt(100))),
                        new BigInteger(String.valueOf(random.nextInt(100))) )
                );
            }

           for(PowTask pt : powTaskList){
               service.execute(pt);
           }


        }finally {
            if(service != null) service.shutdown();


        }

    }

}

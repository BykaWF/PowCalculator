package com.poortoys.examples;

import java.math.BigInteger;

public class PowTask implements  Runnable{
    private final BigInteger base;
    private final BigInteger power;
    private BigInteger result;

    public PowTask(BigInteger base, BigInteger pow){
        this.base = base;
        this.power = pow;
        this.result = BigInteger.ONE;
    }

    @Override
    public void run() {
        for (BigInteger i = BigInteger.ZERO; i.compareTo(power) < 0; i = i.add(BigInteger.ONE) ){
            result = result.multiply(base);
        }

        System.out.println("Result: " + result );
    }
}

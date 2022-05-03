package com.haibin.concurrency.examples;

import com.haibin.concurrency.annotations.GuardedBy;
import com.haibin.concurrency.annotations.ThreadSafe;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.math.BigInteger;

@ThreadSafe
public class SynchronizedFactorizer extends GenericServlet implements Servlet {

    @GuardedBy ("this") private BigInteger lastNumber;
    @GuardedBy ("this") private BigInteger[] lastFactors;

    public synchronized void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        if (i.equals(lastNumber)){
            encodeIntoResponse(resp,lastFactors);
        }else{
            BigInteger[] factors = factor(i);
            lastNumber = i;
            lastFactors = factors;
            encodeIntoResponse(resp, factors);
        }

    }

    void encodeIntoResponse(ServletResponse res, BigInteger[] factors) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[] { i };
    }

}

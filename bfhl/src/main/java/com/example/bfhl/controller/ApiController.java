package com.example.bfhl.controller;

import com.example.bfhl.model.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ApiController {

    private final String EMAIL = "tamanna2381.be23@chitkara.edu.in";

    // ---------------- HEALTH API ----------------
    @GetMapping("/health")
    public ApiResponse health() {
        return new ApiResponse(true, EMAIL, null, null);
    }

    // ---------------- BFHL POST API ----------------
    @PostMapping("/bfhl")
    public ApiResponse bfhl(@RequestBody Map<String, Object> body) {

        try {

            // -------- FIBONACCI --------
            if (body.containsKey("fibonacci")) {
                int n = ((Number) body.get("fibonacci")).intValue();

                List<Integer> fib = new ArrayList<>();
                int a = 0, b = 1;

                for (int i = 0; i < n; i++) {
                    fib.add(a);
                    int c = a + b;
                    a = b;
                    b = c;
                }

                return new ApiResponse(true, EMAIL, fib, null);
            }

            // -------- PRIME --------
            if (body.containsKey("prime")) {
                List<Integer> arr = (List<Integer>) body.get("prime");
                List<Integer> primes = new ArrayList<>();

                for (int num : arr) {
                    if (isPrime(num)) {
                        primes.add(num);
                    }
                }

                return new ApiResponse(true, EMAIL, primes, null);
            }

            // -------- LCM --------
            if (body.containsKey("lcm")) {
                List<Integer> arr = (List<Integer>) body.get("lcm");
                int result = arr.get(0);

                for (int i = 1; i < arr.size(); i++) {
                    result = lcm(result, arr.get(i));
                }

                return new ApiResponse(true, EMAIL, result, null);
            }

            // -------- HCF --------
            if (body.containsKey("hcf")) {
                List<Integer> arr = (List<Integer>) body.get("hcf");
                int result = arr.get(0);

                for (int i = 1; i < arr.size(); i++) {
                    result = hcf(result, arr.get(i));
                }

                return new ApiResponse(true, EMAIL, result, null);
            }

            // -------- AI (MOCK) --------
            if (body.containsKey("AI")) {
                String question = (String) body.get("AI");

                // TEMP mock answer
                return new ApiResponse(true, EMAIL, "Mumbai", null);
            }

            return new ApiResponse(false, EMAIL, null, "Invalid Key");

        } catch (Exception e) {
            return new ApiResponse(false, EMAIL, null, "Error Processing Request");
        }
    }

    // ---------------- HELPER METHODS ----------------

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    private int hcf(int a, int b) {
        return (b == 0) ? a : hcf(b, a % b);
    }

    private int lcm(int a, int b) {
        return (a * b) / hcf(a, b);
    }
}

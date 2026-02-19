package com.biz.app.app3;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello from Java Console App (Maven + OpenJDK)!");
        System.out.println("Package: com.biz.app.app3");
        System.out.println("Current time: " + LocalDateTime.now());

        if (args.length > 0) {
            System.out.println("Arguments:");
            for (int i = 0; i < args.length; i++) {
                System.out.printf("  args[%d] = %s%n", i, args[i]);
            }
        }
    }
}

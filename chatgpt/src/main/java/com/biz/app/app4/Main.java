package com.biz.app.app4;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("ตัวอย่าง Maven Project (OpenJDK)");
        System.out.println("Package: com.biz.app.app4");
        System.out.println("Today: " + LocalDate.now());

        String name = args.length > 0 ? args[0] : "Developer";
        GreetingService greetingService = new GreetingService();
        System.out.println(greetingService.createGreeting(name));
    }
}

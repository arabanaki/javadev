package com.biz.app.app1;

public final class App1 {
    private App1() {
        // prevent instantiation
    }

    public static void main(String[] args) {
        GreetingService greetingService = new GreetingService();
        ConsoleOutput consoleOutput = new ConsoleOutput();

        String message = greetingService.createGreeting();
        consoleOutput.printLine(message);
    }
}

package com.biz.app.app1;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public final class ConsoleOutput {
    private final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8), true);

    public void printLine(String message) {
        writer.println(message);
    }
}

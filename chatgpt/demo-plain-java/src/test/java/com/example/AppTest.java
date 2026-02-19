package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class AppTest {

    @Test
    void mainShouldRunWithoutException() {
        assertDoesNotThrow(() -> App.main(new String[0]));
    }
}

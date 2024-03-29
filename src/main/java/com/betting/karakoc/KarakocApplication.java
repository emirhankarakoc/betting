package com.betting.karakoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KarakocApplication {
    public static final int GAME_MAX_COUNT = 2;

    public static void main(String[] args) {
        SpringApplication.run(KarakocApplication.class, args);
    }

}

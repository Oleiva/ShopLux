package io.github.Oleiva;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.Oleiva.services.Logger;

@SpringBootApplication
public class Application implements CommandLineRunner {

  @Autowired
  Logger logger;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    logger.alert("Hallo from Server!");
  }
}

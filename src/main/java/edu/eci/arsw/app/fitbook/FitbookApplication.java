package edu.eci.arsw.app.fitbook;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FitbookApplication implements CommandLineRunner {

  public static void main(String[] args) {
    try {
      SpringApplication.run(FitbookApplication.class, args);
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  @Override
  public void run(String... args) throws Exception {

  }
}

package kr.kspring.new_year_bible;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NewYearBibleApplication {

  public static void main(String[] args) {
    SpringApplication.run(NewYearBibleApplication.class, args);
  }

}

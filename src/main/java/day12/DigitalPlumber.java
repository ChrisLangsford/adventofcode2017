package day12;


import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.exit;

@SpringBootApplication
public class DigitalPlumber implements CommandLineRunner{

    public static void main(String[] args){

        SpringApplication app = new SpringApplication(DigitalPlumber.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String...args) throws Exception{
        exit(0);

        System.out.println("Spring Boot CommandLine Runner works!");
    }

}

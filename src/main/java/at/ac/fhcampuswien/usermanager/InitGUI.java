package at.ac.fhcampuswien.usermanager;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class InitGUI {
    public static void main(String[] args){
        new SpringApplicationBuilder(InitGUI.class).headless(false).run(args);
    }
}

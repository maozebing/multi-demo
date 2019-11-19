package cn.net.rhea.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.websocket.DeploymentException;
import java.io.IOException;

@SpringBootApplication(scanBasePackages = {"cn.net.rhea"})
public class AppApplication {

    public static void main(String[] args) throws IOException, DeploymentException {

        SpringApplication.run(AppApplication.class, args);
    }

}

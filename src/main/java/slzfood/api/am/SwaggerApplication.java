package slzfood.api.am;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@EnableWebMvc

public class SwaggerApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(SwaggerApplication.class)
                .run(args);

        Environment env = applicationContext.getEnvironment();
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }

        String serverPort = env.getProperty("server.port");
        String contextPath = env.getProperty("server.servlet.context-path");
        if (contextPath == null) {
            contextPath = "";
        }

        String hostAddress = InetAddress.getLocalHost().getHostAddress();

        System.out.println("\n----------------------------------------------------------\n\t" +
                "Application is running! Access URLs:\n\t" +
                "Local: \t\t" + protocol + "://localhost:" + serverPort + contextPath + "\n\t" +
                "External: \t" + protocol + "://" + hostAddress + ":" + serverPort + contextPath + "\n\t" +
                "Swagger UI: \t" + protocol + "://" + hostAddress + ":" + serverPort + contextPath + "/swagger-ui.html\n\t" +
                "----------------------------------------------------------");

        openSwaggerUI(protocol, hostAddress, serverPort, contextPath);
    }

    private static void openSwaggerUI(String protocol, String host, String port, String contextPath) {
        String swaggerUrl = protocol + "://" + host + ":" + port + contextPath + "/swagger-ui.html";
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + swaggerUrl);
            } else {
                Runtime.getRuntime().exec("xdg-open " + swaggerUrl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

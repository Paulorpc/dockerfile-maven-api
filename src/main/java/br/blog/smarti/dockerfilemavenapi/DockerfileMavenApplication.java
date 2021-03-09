package br.blog.smarti.dockerfilemavenapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/***
 * SpringBootServletInitializer é uma classe abstrata que implementa a interface
 * WebApplicationInitializer. Através dessa extenção é possível que a aplicação
 * rode como um pacote WAR tradicional em qualquer servidor de aplicação, como o
 * Apache Tomcat.
 */

@SpringBootApplication
public class DockerfileMavenApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DockerfileMavenApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DockerfileMavenApplication.class, args);
	}

}

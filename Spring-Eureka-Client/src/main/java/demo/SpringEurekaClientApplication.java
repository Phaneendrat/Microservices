package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableEurekaClient
public class SpringEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaClientApplication.class, args);
	}
	
	   @Bean
	    public Sampler defaultSampler() {
	    	return Sampler.ALWAYS_SAMPLE;
	    }
	 
	/*
	 * public void configureContentNegotiation(ContentNegotiationConfigurer
	 * configurer) { configurer.favorPathExtension(false). favorParameter(true).
	 * parameterName("mediaType"). ignoreAcceptHeader(true). useJaf(false).
	 * defaultContentType(MediaType.APPLICATION_JSON). mediaType("xml",
	 * MediaType.APPLICATION_XML). mediaType("json", MediaType.APPLICATION_JSON); }
	 */
}

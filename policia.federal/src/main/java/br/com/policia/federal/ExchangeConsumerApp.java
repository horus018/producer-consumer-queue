package br.com.policia.federal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.policia.federal")
public class ExchangeConsumerApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ExchangeConsumerApp.class, args);
	}

}

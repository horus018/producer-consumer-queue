package br.com.receita.federal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.receita.federal")
public class ExchangeConsumerApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ExchangeConsumerApp.class, args);
	}

}

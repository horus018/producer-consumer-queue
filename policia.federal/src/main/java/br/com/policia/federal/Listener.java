package br.com.policia.federal;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {
	
	@RabbitListener(queues = "policia.federal")
	public void listen(String in) {
		System.out.println("Polícia Federal");
		System.out.println("Processando transação suspeita: "+in);
	}
}

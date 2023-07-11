package br.com.transacoes.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class Listener {
	
	@Autowired
    private RabbitTemplate rabbitTemplate;

	@RabbitListener(queues = "transacoes.financeiras")
	public void listen(String in) {
		processarTransacao(in);
	}
	
	public void processarTransacao(String in) {
		try {			
			
			Thread.sleep(1000);

			Transacao transacao = new Gson().fromJson(in, Transacao.class);
			
			if (transacao.getValor() > 40000) {
				rabbitTemplate.convertAndSend("transacoes.suspeitas", "", in);
			}else {
				System.out.println(in);
			}
		
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}

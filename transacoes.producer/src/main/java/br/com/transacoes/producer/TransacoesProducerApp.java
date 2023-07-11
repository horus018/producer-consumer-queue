package br.com.transacoes.producer;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.google.gson.Gson;

@SpringBootApplication
@ComponentScan("br.com.transacoes.producer")
public class TransacoesProducerApp {

    @Autowired
    private AmqpAdmin amqpAdmin;
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    private Queue filaTransacoes;
    
    public static void main(String[] args) throws Exception{
        SpringApplication.run(TransacoesProducerApp.class, args);
    }
    
    @PostConstruct
    public void criarFila() {
        filaTransacoes = new Queue("transacoes.financeiras", true);
        amqpAdmin.declareQueue(filaTransacoes);
        
        LeitorArquivo leitorArquivo = new LeitorArquivo();
        List<Transacao> listaTransacoes = leitorArquivo.lerArquivo();
        
        Gson gson = new Gson();
        for (Transacao transacao : listaTransacoes) {
            String transacaoJson = gson.toJson(transacao);
            rabbitTemplate.convertAndSend(filaTransacoes.getName(), transacaoJson);
        }

    }
}

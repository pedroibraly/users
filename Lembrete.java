import javax.swing.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JanelaMensagem {
    public static void main(String[] args) {
        // Criando um agendador de tarefas
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Definindo a tarefa para exibir a janela
        Runnable mostrarJanela = () -> {
            SwingUtilities.invokeLater(() -> {
                int resposta = JOptionPane.showOptionDialog(
                    null,
                    "Está na hora de conferir a mensagem!",
                    "Alerta",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    new String[]{"Fechar", "OK"}, // Botões personalizados
                    "OK" // Botão padrão selecionado
                );

                // Tratamento de resposta
                if (resposta == 0) { // Botão "Fechar"
                    System.out.println("Usuário clicou em Fechar.");
                } else if (resposta == 1) { // Botão "OK"
                    System.out.println("Usuário clicou em OK.");
                }
            });
        };

        // Agendando a tarefa para ser executada a cada 5 minutos
        scheduler.scheduleAtFixedRate(mostrarJanela, 0, 5, TimeUnit.MINUTES);
    }
}

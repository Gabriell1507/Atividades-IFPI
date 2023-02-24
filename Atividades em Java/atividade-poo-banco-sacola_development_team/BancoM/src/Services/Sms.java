package Services;

import Services.Interfaces.Notificacao;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sms implements Notificacao {
    Date data = new Date();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    @Override
    public void enviarNotificacao(String operacao, double valor) {
        JOptionPane.showMessageDialog(null,
                "Enviando SMS..." + "\n"
                        + "Operação: " + operacao +
                        "\n" + "Valor: R$ " + valor + "\n"
                        + "Data da operação: " + dateFormat.format(data.getTime()));
    }
}


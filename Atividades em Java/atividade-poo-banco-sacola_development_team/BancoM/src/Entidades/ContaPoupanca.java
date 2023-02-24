package Entidades;

import DAO.ContaDAO;
import Services.Email;
import Services.Sms;

import javax.swing.*;

public class ContaPoupanca extends Conta {
    private double rendimento = 0.1;


    public void sacar(double valor, int numConta) {
        ContaDAO contaDAO = new ContaDAO();
        int opcao;
        if (valor <= contaDAO.puxarSaldoConta(numConta)) {
            contaDAO.puxarConta(numConta);
            contaDAO.saqueContaPoupanca(valor);

            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
            opcao = JOptionPane.showOptionDialog(null,
                    "Deseja receber o comprovante?", "Banco", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, new String[]{"Sim", "Não"}, "Comprovante");
            if (opcao == 0) {
                opcao = JOptionPane.showOptionDialog(null,
                        "Por qual via deseja receber?", "Banco", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, new String[]{"SMS", "EMAIL"}, "Comprovante");
                switch (opcao) {
                    case 0 -> {
                        Sms sms = new Sms();
                        sms.enviarNotificacao("Saque", valor);
                    }
                    case 1 -> {
                        Email email = new Email();
                        email.enviarNotificacao("Saque", valor);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
        }
    }

    public void depositar(double valor, int numConta) {
        ContaDAO contaDAO = new ContaDAO();
        if (valor > 0) {
            contaDAO.puxarConta(numConta);
            contaDAO.depositoContaPoupanca(valor);
            JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!");

            int opcao = JOptionPane.showOptionDialog(null,
                    "Deseja receber o comprovante?", "Banco", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, new String[]{"Sim", "Não"}, "Comprovante");
            if (opcao == 0) {
                opcao = JOptionPane.showOptionDialog(null,
                        "Por qual via deseja receber?", "Banco", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, new String[]{"SMS", "EMAIL"}, "Comprovante");
                switch (opcao) {
                    case 0 -> {
                        Sms sms = new Sms();
                        sms.enviarNotificacao("Depósito", valor);
                    }
                    case 1 -> {
                        Email email = new Email();
                        email.enviarNotificacao("Depósito", valor);
                    }
                }
            }
        }
    }


    @Override
    public void transferir(double valor, int numeroConta, int numConta) {
        ContaDAO contaDAO = new ContaDAO();
        double saldo = contaDAO.puxarSaldoConta(numConta);
        if (valor + (valor * getTaxaJuros()) < saldo) {
            contaDAO.puxarConta(numConta);
            contaDAO.transferenciaContaPoupanca(valor, numeroConta);

            JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso!");
            int opcao = JOptionPane.showOptionDialog(null,
                    "Deseja receber o comprovante?", "Banco", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, new String[]{"Sim", "Não"}, "Comprovante");
            if (opcao == 0) {
                opcao = JOptionPane.showOptionDialog(null,
                        "Por qual via deseja receber?", "Banco", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, new String[]{"SMS", "EMAIL"}, "Comprovante");
                switch (opcao) {
                    case 0 -> {
                        Sms sms = new Sms();
                        sms.enviarNotificacao("Transferência", valor);
                    }
                    case 1 -> {
                        Email email = new Email();
                        email.enviarNotificacao("Transferência", valor);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
        }
    }

    // Getters and Setters
    public double getTaxaJuros() {
        return 0.05;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }
}

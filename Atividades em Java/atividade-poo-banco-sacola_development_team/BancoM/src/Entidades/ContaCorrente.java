package Entidades;

import DAO.ContaDAO;
import Services.Email;
import Services.Sms;

import javax.swing.*;

public class ContaCorrente extends Conta {
    private double chequeEspecial;


    @Override
    public void depositar(double valor, int numConta) {
        ContaDAO contaDAO = new ContaDAO();
        if (valor > 0) {
            contaDAO.puxarConta(numConta);
            contaDAO.depositoContaCorrente(valor);
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
    public void sacar(double valor, int numConta) {
        ContaDAO contaDAO = new ContaDAO();
        int opcao;
        if (valor <= contaDAO.puxarSaldoConta(numConta)) {
            contaDAO.puxarConta(numConta);
            contaDAO.saqueContaCorrente(valor);

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
            opcao = JOptionPane.showOptionDialog(null,
                    "Saldo insuficiente! Deseja usar seu cheque especial?", "Banco", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, new String[]{"Sim", "Não"}, "Limite insuficiente");

            if (opcao == 0) {
                double operacao = contaDAO.puxarSaldoConta(numConta) - valor;
                contaDAO.puxarConta(numConta);

                if (contaDAO.puxarSaldoConta(numConta) <= 0) {
                    contaDAO.atualizarChequeEspecial(operacao);
                } else {
                    contaDAO.saqueContaCorrente(valor + operacao);
                    contaDAO.atualizarChequeEspecial(operacao);
                }
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
            }

        }
    }

    @Override
    public void transferir(double valor, int numeroConta, int numConta) {
        ContaDAO contaDAO = new ContaDAO();
        if (valor < contaDAO.puxarSaldoConta(numConta)) {
            contaDAO.puxarConta(numConta);
            if (contaDAO.getContadorTransferencia() > 2) {
                JOptionPane.showMessageDialog(null, "Você atingiu o limite de 2 transferências por dia! A partir desse momento, será cobrado uma taxa de 3% por transferência.");
                contaDAO.transferenciaContaCorrente(valor, numeroConta);
            } else {
                contaDAO.transferenciaContaCorrente(valor, numeroConta);
            }
            contaDAO.atualizarContadorTransferencia();
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

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
}

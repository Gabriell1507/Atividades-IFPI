package Entidades;


public class Conta {

    private int numConta;
    private String agenciaConta;
    private double saldoConta;
    private int tipoConta;


    // Metodos
    public void depositar(double valor, int numConta) {
        if (valor > 0) {
            this.setSaldoConta(this.getSaldoConta() + valor);
        }
    }

    public void sacar(double valor, int numConta) {
        this.saldoConta -= valor;
    }

    public void transferir(double valor, int numeroConta, int numConta) {
        this.saldoConta -= valor;
    }

    public void exibirInformacoesDaConta(int numConta) {
    }

    // Getters e Setters


    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getAgenciaConta() {
        return agenciaConta;
    }

    public void setAgenciaConta(String agenciaConta) {
        this.agenciaConta = agenciaConta;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }

    public int getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(int tipoConta) {
        this.tipoConta = tipoConta;
    }
}

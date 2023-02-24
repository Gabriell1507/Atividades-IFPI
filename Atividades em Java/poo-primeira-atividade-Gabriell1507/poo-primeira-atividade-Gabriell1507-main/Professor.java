public class Professor {
    private String nome;

    public Professor(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        return this.nome.equals(((Professor) obj).nome);
    }
}
public class Aluno {
    private String nome;
    private String email;

    public Aluno(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Aluno: " + nome ;
    }

}
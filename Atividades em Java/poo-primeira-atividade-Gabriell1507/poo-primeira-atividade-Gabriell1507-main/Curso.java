import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private String nivel;
    private int ch;
    private Professor professor;
    private List<Aluno> alunos;

    public Curso(String nome, String nivel, int ch, Professor professor) {
        this.nome = nome;
        this.nivel = nivel;
        this.ch = ch;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }

    public void realizarMatricula(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public int getQuantidadeDeAlunosMatriculados() {
        return this.alunos.size();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCh(int ch) {
        this.ch = ch;
    }

    public String getNome() {
        return this.nome;
    }

    public String getNivel() {
        return nivel;
    }

    public int getCh() {
        return ch;
    }

    public String getNomeProfessor() {
        return this.professor.getNome();
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }



}
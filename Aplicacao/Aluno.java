package prova01_AugustoCesarRezende.Aplicacao;

public class Aluno {
    private String nome;
    private String codigo;
    private String telefone;
    private int acessos;
    int categoria;

    public Aluno(String codigo, String nome, String telefone, int categoria) {
        this.nome = nome;
        this.telefone = telefone;
        this.codigo = codigo;
        this.categoria = categoria;
    }

    public Aluno(String codigo, String nome, String telefone, int categoria, int acessos) {
        this.nome = nome;
        this.telefone = telefone;
        this.codigo = codigo;
        this.categoria = categoria;
        this.acessos = acessos;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getAcessos() {
        return acessos;
    }

    public int getCategoria() {
        return categoria;
    }

    public void incrementaAcessos() {
        this.acessos++;
    }
}
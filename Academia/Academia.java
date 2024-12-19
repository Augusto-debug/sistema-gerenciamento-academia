package prova01_AugustoCesarRezende.Academia;

public class Academia {
    private int alunos;
    static int acessos;

    public Academia() {
        this.alunos = 0;
        acessos = 0;
    }

    public void atualiza(int alunos) {
        this.alunos = alunos;
    }

    public int getAlunos() {
        return alunos;
    }

    public static int getAcessos() {
        return acessos;
    }

    public static void incrementaAcessos(int categoria) {
        if (categoria == 1) {
            System.out.println("Categoria 1 não tem direito a aulas com personal.");
        } else if (categoria == 2 && acessos < 5) {
            acessos++;
            System.out.println("Acesso contabilizado para categoria 2.");
        } else if (categoria == 3 && acessos < 5) {
            acessos++;
            System.out.println("Acesso contabilizado para categoria 3.");
        } else {
            System.out.println("Limite de aulas com personal atingido.");
        }
    }
}
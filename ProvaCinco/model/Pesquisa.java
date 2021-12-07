package model;

public class Pesquisa {
    public static void main(String[] args) {
        // Alimentacao alimentacao = new Alimentacao(1, "10/10/1990", "Comeu tudo muito rapido");
        // Jaula jaula = new Jaula(idJaula, descricao);
        // Golfinho golfinho = new Golfinho(idAnimal, nomeAnimal, jaula, idTreinamento, dataTreinamento, descricao)
        // Treinamento treinamento = new Treinamento(idTreinamento, dataTreinamento, descricao, golfinho)
        // Golfinho golg = new Golfinho(idAnimal, nomeAnimal, jaula)
        Jaula jau = new Jaula(2, "@#2");
        Golfinho gol = new Golfinho(1, "nomeAnimal", jau);
        Leao leao = new Leao(2, 2, "nomeAnimal", jau);
        Treinamento trei = new Treinamento(12, "1990-10-10", "PULAR CERCA");
        System.out.println(jau);
        System.out.println("===========");
        System.out.println(gol);
        System.out.println("===========");
        System.out.println(leao);
        Alimentacao ali = new Alimentacao(12, "1990-10-10", "detalhes");
        leao.adicionarAlimentacao(ali);
        leao.adicionarAlimentacao(ali);
        gol.adicionarTreinamento(trei);
        System.out.println(ali);
        System.out.println("===========");
        System.out.println(leao);
        System.out.println("===========");
        System.out.println("===========");
        System.out.println("===========");
        
        System.out.println(gol);
        System.out.println("===========");
    }
}

package model;

import java.util.Scanner;

public class Pesquisa {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        int escolha = 0;
        int id = 0;
        // Alimentacao alimentacao = new Alimentacao(1, "10/10/1990", "Comeu tudo muito rapido");
        // Jaula jaula = new Jaula(idJaula, descricao);
        // Golfinho golfinho = new Golfinho(idAnimal, nomeAnimal, jaula, idTreinamento, dataTreinamento, descricao)
        // Treinamento treinamento = new Treinamento(idTreinamento, dataTreinamento, descricao, golfinho)
        // Golfinho golg = new Golfinho(idAnimal, nomeAnimal, jaula)
        // Jaula jau = new Jaula(2, "@#2");
        // Golfinho gol = new Golfinho(1, "nomeAnimal", jau);
        // Leao leao = new Leao(2, 2, "nomeAnimal", jau);
        // Treinamento trei = new Treinamento(12, "1990-10-10", "PULAR CERCA");
        // System.out.println(jau);
        // System.out.println(gol);
        // System.out.println(leao);
        // Alimentacao ali = new Alimentacao(12, "1990-10-10", "detalhes");
        // leao.adicionarAlimentacao(ali);
        // leao.adicionarAlimentacao(ali);
        // gol.adicionarTreinamento(trei);
        // System.out.println(ali);
        // System.out.println(leao);
        
        // System.out.println(gol);
        do{
            System.out.println("\n [1] - Alterar Golfinho");
            System.out.println("\n [2] - Alterar Leão");
            System.out.println("\n [3] - Cadastrar Alimentação");
            System.out.println("\n [4] - Cadastrar Golfinho");
            System.out.println("\n [5] - Cadastrar Leão");
            System.out.println("\n [6] - Cadastrar Treinamento");
            System.out.println("\n [7] - Deletar Golfinho");
            System.out.println("\n [8] - Deletar Leão");
            System.out.println("\n [9] - Selecionar Golfinho");
            System.out.println("\n [10] - Selecionar Leão");
            System.out.println("\n [0] - Finalizar operação");
            System.out.println("\n Escolha uma opção: ");
            
            try{
                escolha = print.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            switch(escolha) {
                case 1:
                    System.out.println("\n Você escolheu: Alterar Golfinho");
                    try{
                        System.out.println("\n Informe o id do chef que deseja excluir! ");
                        id = print.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try{
                        view.DeletarLeao.deleteLeao(id);
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                break;
                case 2:
                    System.out.println("\n Você escolheu: Alterar Leão");
                break;
                case 3:
                    System.out.println("\n Você escolheu: Cadastrar Alimentação");
                break;
                case 4:
                    System.out.println("\n Você escolheu: Cadastrar Golfinho");
                break;
                case 5:
                    System.out.println("\n Você escolheu: Cadastrar Leão");
                break;
                case 6:
                    System.out.println("\n Você escolheu: Cadastrar Treinamento");
                break;
                case 7:
                    System.out.println("\n Você escolheu: Deletar Golfinho");
                break;
                case 8:
                    System.out.println("\n Você escolheu: Deletar Leão");
                break;
                case 9:
                    System.out.println("\n Você escolheu: Selecionar Golfinho");
                break;
                case 10:
                    System.out.println("\n Você escolheu: Finalizar operação");
                break;
                default:
                    System.out.println("\n Operação inválida");
                break;
            }
        } while (escolha != 0);
        print.close();
    }
}

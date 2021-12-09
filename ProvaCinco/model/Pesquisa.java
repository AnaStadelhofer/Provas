package model;

import java.sql.Date;
import java.util.Scanner;

import view.CadastrarAlimentacao;
import view.CadastrarGolfinho;
import view.CadastrarLeao;
import view.CadastrarTreinamento;

public class Pesquisa {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        int escolha = 0;
        int id = 0;
        String nome = "";
        int treinamento = 0;
        int idJaula = 0;
        String descricao = "";
        int qtdAlimento = 0;
        int visitante = 0;
        String data = "";
        
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
                break;
                case 2:
                    System.out.println("\n Você escolheu: Alterar Leão");
                break;
                case 3:
                    System.out.println("\n Você escolheu: Cadastrar Alimentação");
                    try{
                        System.out.println("\n Id do leão alimentado ");
                        id = print.nextInt();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    try{
                        System.out.println("\n Data da alimentação: ");
                        data = print.next();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    try{
                        System.out.println("\n Descrição da alimentação: ");
                        descricao = print.next();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    try{
                        Alimentacao alimentacao = new Alimentacao(id, Date.valueOf(data), descricao);
                        Leao leao = new Leao(visitante, id, nome, qtdAlimento, idJaula, descricao);
                        CadastrarAlimentacao.insertAlimentação(alimentacao, leao);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                break;
                case 4:
                    System.out.println("\n Você escolheu: Cadastrar Golfinho");
                    try{
                        System.out.println("\n Nome: ");
                        nome = print.next();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    try{
                        System.out.println("\n Quantidade de Treinamento: ");
                        treinamento = print.nextInt();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    try{
                        System.out.println("\n Descrição: ");
                        descricao = print.next();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    // Vai chamar o metodo para realizar o cadastro do golfinho
                    try{
                        Golfinho golfinho = new Golfinho(id, nome, treinamento, idJaula, descricao);
                        Jaula jaula = new Jaula(idJaula, descricao);
                        CadastrarGolfinho.insertGolfinho(golfinho, jaula);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                break;
                case 5:
                    System.out.println("\n Você escolheu: Cadastrar Leão");
                    try{
                        System.out.println("\n Nome: ");
                        nome = print.next();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    try{
                        System.out.println("\n Quantidade maxima de visitantes: ");
                        visitante = print.nextInt();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    try{
                        System.out.println("\n Quantidade de Alimento por dia: ");
                        qtdAlimento = print.nextInt();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    try{
                        System.out.println("\n Descrição: ");
                        descricao = print.next();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    // Vai chamar o metodo para realizar o cadastro do Leão
                    try{
                        Leao leao = new Leao(visitante, id, nome, qtdAlimento, idJaula, descricao);
                        Jaula jaula = new Jaula(idJaula, descricao);
                        CadastrarLeao.insertLeao(leao, jaula);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                break;
                case 6:
                    System.out.println("\n Você escolheu: Cadastrar Treinamento");
                    try{
                        System.out.println("\n Id do golfinho treinado ");
                        id = print.nextInt();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    try{
                        System.out.println("\n Data do treinamento: ");
                        data = print.next();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    try{
                        System.out.println("\n Descrição do treinamento: ");
                        descricao = print.next();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    try{
                        Treinamento treinamentos = new Treinamento(id, Date.valueOf(data), descricao);
                        Golfinho golfinho = new Golfinho(id, nome, treinamento, idJaula, descricao);
                        CadastrarTreinamento.insertTreinamento(treinamentos, golfinho);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                break;
                case 7:
                    System.out.println("\n Você escolheu: Deletar Golfinho");
                    try{
                        System.out.println("\n Informe o id do Golfinho que deseja excluir! ");
                        id = print.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try{
                        view.DeletarGolfinho.deleteGolfinho(id);
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                break;
                case 8:
                    System.out.println("\n Você escolheu: Deletar Leão");
                    try{
                        System.out.println("\n Informe o id do leão que deseja excluir! ");
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
                case 9:
                    System.out.println("\n Você escolheu: Selecionar Golfinho");
                    System.out.println("\n Você escolheu: Selecionar Leão");
                    try{
                        Golfinho golfinho = new Golfinho(id, nome, treinamento, idJaula, descricao);
                        view.SelecionarGolfinho.selectGolfinho(golfinho);
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                break;
                case 10:
                    System.out.println("\n Você escolheu: Selecionar Leão");
                    try{
                        Leao leao = new Leao(visitante, id, nome, qtdAlimento, idJaula, descricao);
                        view.SelecionarLeao.selectLeao(leao);
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                break;
                case 0:
                    System.out.println("\n Você escolheu: Finalizar operação");
                    System.out.println("\n Tchau...");
                break;
                default:
                    System.out.println("\n Operação inválida");
                break;
            }
        } while (escolha != 0);
        print.close();
    }
}

package Provas.ProvaTres;

public class Imprimir {
    public static void main(String[] args) {

        // Cadastrando dados ficticios //
        ///////////// Padarias ///////////
        Padaria padariaUm = new Padaria(1, "Damasko", "10/10/2020", 1, 1234, "Noel Rosa", 1231451, "Vila Nova", "Joinville", "07:00 das 12:00 e 13:00 das 18:00");
        Padaria padariaDois = new Padaria(2, "Vene", "10/10/2021", 2, 534, "Canoinhas", 3123141, "Floresta", "Joinville", "06:00 das 12:00 e 13:00 das 17:00");
        Padaria padariaTres = new Padaria(3, "Pãonificadora", "08/02/1980", 3, 262, "Glorificado Seja", 131231231, "Gloria", "Joinville", "07:00 das 12:00 e 13:00 das 18:00");

        //////////// Chef ///////////////
        
        Chef chefUm = new Chef(10, "Robertinho", "080345678903", "10/02/1998", "Padeiro");
        Chef chefDois = new Chef(11, "Paulinha", "12312312321", "08/02/1987", "Confeiteiro");
        Chef chefTres = new Chef(12, "Jacan", "13213123123", "30/06/1995", "Decorador de Bolo");

        //////////// Cliente ///////////////

        Cliente clienteUm = new Cliente(1, "Vitória Luna Giovana Farias", "919.132.424-63", "20/08/1950", "(91) 3779-6172");
        Cliente clienteDois = new Cliente(2, "Luís Igor Pedro Henrique Campos", "881.297.727-87", "25/08/1994", "(28) 2548-0962");
        Cliente clienteTres = new Cliente(3, "Tomás Oliver Jesus", "798.484.125-06", "01/08/1941", "(28) 98546-6095");

        //////////// Receitas ///////////////

        Receita receitaUm = new Receita(1, "Feijoada", "1- Cozinhar feijão, 2- Colocar carne, 3- Comer", 1, chefUm);
        Receita receitaDois = new Receita(2, "Pudim", "1- Bater mistura no liquidificador, 2- Colocar no forno em banho maria", 2, chefUm);
        Receita receitaTres = new Receita(3, "Sonho", "1- Fazer massa, 2- Fritar, 3- Enrolar em açucar", 3, chefUm);

        Receita receitaQuatro = new Receita(4, "Sonho de valsa", "Enrolar amendoim em chocolate", 4, chefDois);
        Receita receitaCinco = new Receita(5, "Torta salgada", "Deixar na geladeira", 5, chefDois);
        Receita receitaSeis = new Receita(6, "Bolo de cenoura", "Assar", 6, chefDois);

        Receita receitaSete = new Receita(7, "Brigadeiro", "Panela", 7, chefTres);
        Receita receitaOito = new Receita(8, "Beijinho", "Panela", 8, chefTres);
        Receita receitaNove = new Receita(9, "Cupcake", "Assar", 9, chefTres);
        Receita receitaDez = new Receita(10, "Risole", "Fritar", 10, chefTres);

        Receita receitaOnze = new Receita(11, "Coxinha", "Fritar", 10, chefTres);
        Receita receitaDoze = new Receita(12, "Sorvete", "Fritar", 10, chefTres);
        Receita receitaTreze = new Receita(13, "Geladinho", "Fritar", 10, chefTres);
        Receita receitaQuatorze = new Receita(14, "Empadão", "Fritar", 10, chefTres);
        Receita receitaQuinze = new Receita(15, "Balde de sorvete", "Juntar varias", 10, chefTres);

        //////////// Mercados ///////////////

        Mercado mercadoUm = new Mercado(1, "Bom Jesus", "10/10/2000", 3, 262, "Glorificado Seja", 131231231, "Gloria", "Joinville", "Leve um e pague dois!");
        Mercado mercadoDois = new Mercado(2, "Bom Amor", "02/09/2011",2, 534, "Canoinhas", 3123141, "Floresta", "Joinville", "Leve dois e pague um!");
        Mercado mercadoTres = new Mercado(3, "Odio abençoado", "11/10/2001", 1, 1234, "Noel Rosa", 1231451, "Vila Nova", "Joinville", "Leve um e pague tres!");
        
        //////////// Adicionando receitas a uma padaria ///////////////

        padariaUm.adicionarReceita(receitaUm);
        padariaUm.adicionarReceita(receitaDois);
        padariaUm.adicionarReceita(receitaTres);
        padariaUm.adicionarReceita(receitaQuatro);
        padariaUm.adicionarReceita(receitaCinco);

        padariaDois.adicionarReceita(receitaSeis);
        padariaDois.adicionarReceita(receitaSete);
        padariaDois.adicionarReceita(receitaOito);
        padariaDois.adicionarReceita(receitaNove);
        padariaDois.adicionarReceita(receitaDez);

        padariaTres.adicionarReceita(receitaOnze);
        padariaTres.adicionarReceita(receitaDoze);
        padariaTres.adicionarReceita(receitaTreze);
        padariaTres.adicionarReceita(receitaQuatorze);
        padariaTres.adicionarReceita(receitaQuinze);

        //////////// Adicionando receitas a um cliente ///////////////

        clienteUm.adicionarReceitaCliente(receitaUm);

        // Imprimindo dados //

        System.out.println("\n =========== Chefs ===========");
        System.out.println(chefUm);
        System.out.println(chefDois);
        System.out.println(chefTres);

        System.out.println("\n =========== Clientes =========== \n");
        System.out.println(clienteUm);
        System.out.println(clienteDois);
        System.out.println(clienteTres);

        System.out.println("\n =========== Padarias =========== \n");
        System.out.println(padariaUm);
        System.out.println(padariaDois);
        System.out.println(padariaTres);

        System.out.println("\n =========== Mercado =========== \n");
        System.out.println(mercadoUm);
        System.out.println(mercadoDois);
        System.out.println(mercadoTres);

        //////////// Imprimir receita de cada chef ////////////////
        System.out.println("\n =========== Receita do Chef Um ===========");
        for (Receita receita : chefUm.receitasPadock) {
             System.out.println(receita);
        }
        System.out.println("\n =========== Receita do Chef Dois ===========");
        for (Receita receita : chefDois.receitasPadock) {
            System.out.println(receita);
        }
        System.out.println("\n =========== Receita do Chef Tres ===========");
        for (Receita receita : chefTres.receitasPadock) {
            System.out.println(receita);
        }
        System.out.println("\n\n");

        //////////// Imprimir receita de cada padaria ////////////////
        System.out.println("\n =========== Receitas da padaria Um ===========");
        for (Receita receita : padariaUm.receitas) {
            System.out.println(receita);
        }
        System.out.println("\n =========== Receitas da padaria Dois ===========");
        for (Receita receita : padariaDois.receitas) {
            System.out.println(receita);
        }
        System.out.println("\n =========== Receitas da padaria Três ===========");
        for (Receita receita : padariaTres.receitas) {
            System.out.println(receita);
        }

        //////////// Imprimir receita qu cada cliente comprou ////////////////
        System.out.println("\n =========== Receitas do cliente Um ===========");
        for (Receita receita : clienteUm.receitasCliente) {
            System.out.println(receita);
        }
        System.out.println("\n =========== Receitas do cliente Dois ===========");
        for (Receita receita : clienteDois.receitasCliente) {
            System.out.println(receita);
        }
        System.out.println("\n =========== Receitas do cliente Três ===========");
        for (Receita receita : clienteTres.receitasCliente) {
            System.out.println(receita);
        }
        
        System.out.println("\n\n");
    }
}

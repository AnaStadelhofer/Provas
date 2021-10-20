package Provas.ProvaDoisss;
import java.util.ArrayList;
public class Padaria {
    int id;
    String nome;
    String dataDeAbertura;
    Endereco endereco;

    ArrayList<Receita> receitas = new ArrayList<>();

    public Padaria(
        int id,
        String nome,
        String dataDeAbertura,
        int idEndereco,
        int cep,
        String rua,
        int numero,
        String bairro,
        String cidade
        
    ) {
        this.id = id;
        this.nome = nome;
        this.dataDeAbertura = dataDeAbertura;
        this.endereco = new Endereco(
            idEndereco,
            cep,
            rua,
            numero,
            bairro,
            cidade,
            this
            );
    }
    public static void main(String[] args) {

        ///////////// Padarias ///////////
        Padaria padariaUm = new Padaria(1, "Damasko", "10/10/2020", 1, 1234, "Noel Rosa", 1231451, "Vila Nova", "Joinville");
        Padaria padariaDois = new Padaria(2, "Vene", "10/10/2021", 2, 534, "Canoinhas", 3123141, "Floresta", "Joinville");
        Padaria padariaTres = new Padaria(3, "Pãonificadora", "08/02/1980", 3, 262, "Glorificado Seja", 131231231, "Gloria", "Joinville");
        System.out.println("\n =========== Padarias criadas ===========");
        System.out.println(" Padaria Um: " + padariaUm.nome);
        System.out.println("    Rua: " + padariaUm.endereco.rua
                           + ", Número: "+ padariaUm.endereco.numero
                           + ", Bairro: "+ padariaUm.endereco.bairro
                           + ", Cidade: "+ padariaUm.endereco.cidade
                           + ", CEP: "+ padariaUm.endereco.cep + "\n");

        System.out.println(" Padaria Um: " + padariaDois.nome);
        System.out.println("    Rua: " + padariaDois.endereco.rua
                           + ", Número: "+ padariaDois.endereco.numero
                           + ", Bairro: "+ padariaDois.endereco.bairro
                           + ", Cidade: "+ padariaDois.endereco.cidade
                           + ", CEP: "+ padariaDois.endereco.cep + "\n");

        System.out.println(" Padaria Um: " + padariaTres.nome);
        System.out.println("    Rua: " + padariaTres.endereco.rua
                           + ", Número: "+ padariaTres.endereco.numero
                           + ", Bairro: "+ padariaTres.endereco.bairro
                           + ", Cidade: "+ padariaTres.endereco.cidade
                           + ", CEP: "+ padariaTres.endereco.cep + "\n");

        //////////// Chef ///////////////
        System.out.println("\n =========== Chefs ===========");
        Chef chefUm = new Chef(10, "Robertinho", "080345678903", "10/02/1998");
        Chef chefDois = new Chef(11, "Paulinha", "12312312321", "08/02/1987");
        Chef chefTres = new Chef(12, "Jacan", "13213123123", "30/06/1995");

        System.out.println(" Nome: " + chefUm.nomeChef
                           + ", CPF: "+chefUm.cpfChef
                           + ", Data de nascimento: "+chefUm.dataNascimento +"\n");
        System.out.println(" Nome: " + chefDois.nomeChef
                           + ", CPF: "+chefDois.cpfChef
                           + ", Data de nascimento: "+chefDois.dataNascimento +"\n");
        System.out.println(" Nome: " + chefTres.nomeChef
                           + ", CPF: "+chefTres.cpfChef
                           + ", Data de nascimento: "+chefTres.dataNascimento +"\n");

        Receita receitaUm = new Receita(10, "Feijoada", "1- Cozinhar feijão, 2- Colocar carne, 3- Comer", 1, chefUm, padariaDois);
        Receita receitaDois = new Receita(1, "Pudim", "1- Bater mistura no liquidificador, 2- Colocar no forno em banho maria", 2, chefUm, padariaDois);
        Receita receitaTres = new Receita(10, "Sonho", "1- Fazer massa, 2- Fritar, 3- Enrolar em açucar", 3, chefUm, padariaDois);

        Receita receitaQuatro = new Receita(10, "Sonho de valsa", "Enrolar amendoim em chocolate", 4, chefDois, padariaDois);
        Receita receitaCinco = new Receita(10, "Torta salgada", "Deixar na geladeira", 5, chefDois, padariaDois);
        Receita receitaSeis = new Receita(10, "Bolo de cenoura", "Assar", 6, chefDois, padariaUm);

        Receita receitaSete = new Receita(10, "Brigadeiro", "Panela", 7, chefTres, padariaUm);
        Receita receitaOito = new Receita(10, "Beijinho", "Panela", 8, chefTres, padariaUm);
        Receita receitaNove = new Receita(10, "Cupcake", "Assar", 9, chefTres, padariaUm);
        Receita receitaDez = new Receita(10, "Risole", "Fritar", 10, chefTres, padariaUm);

        Receita receitaOnze = new Receita(10, "Coxinha", "Fritar", 10, chefTres, padariaTres);
        Receita receitaDoze = new Receita(10, "Sorvete", "Fritar", 10, chefTres, padariaTres);
        Receita receitaTreze = new Receita(10, "Geladinho", "Fritar", 10, chefTres, padariaTres);
        Receita receitaQuatorze = new Receita(10, "Empadão", "Fritar", 10, chefTres, padariaTres);
        Receita receitaQuinze = new Receita(10, "Balde de sorvete", "Juntar varias", 10, chefTres, padariaTres);
        
        //////////// Imprimir receita de cada chef ////////////////
        System.out.println("\n =========== Receita do Chef Um ===========");
        for (Receita receita : chefUm.receitasPadock) {
            System.out.println("Nome receita: " + receita.nomeReceita
                               + ", Etapa: " + receita.etapaDescricao
                               + ", Número de etapas: "+ receita.numEtapas);
        }
        System.out.println("\n =========== Receita do Chef Dois ===========");
        for (Receita receita : chefDois.receitasPadock) {
            System.out.println("Nome receita: " + receita.nomeReceita
                               + ", Etapa: " + receita.etapaDescricao
                               + ", Número de etapas: "+ receita.numEtapas);
        }
        System.out.println("\n =========== Receita do Chef Tres ===========");
        for (Receita receita : chefTres.receitasPadock) {
            System.out.println("Nome receita: " + receita.nomeReceita
                               + ", Etapa: " + receita.etapaDescricao
                               + ", Número de etapas: "+ receita.numEtapas);
        }
        System.out.println("\n\n");
        //////////// Imprimir receita de cada padaria ////////////////
        System.out.println("\n =========== Receitas da padaria Um ===========");
        for (Receita receita : padariaUm.receitas) {
            System.out.println("Nome receita: " + receita.nomeReceita);
        }
        System.out.println("\n =========== Receitas da padaria Um ===========");
        for (Receita receita : padariaDois.receitas) {
            System.out.println("Nome receita: " + receita.nomeReceita);
        }
        System.out.println("\n =========== Receitas da padaria Um ===========");
        for (Receita receita : padariaTres.receitas) {
            System.out.println("Nome receita: " + receita.nomeReceita);
        }
        System.out.println("\n\n");
    }
    public void adicionarReceita(Receita receita) {
        this.receitas.add(receita);
    }
    
}
package Provas.ProvaDoisss;

import java.util.ArrayList;

public class Chef {
    int idChef;
    String nomeChef;
    String cpfChef;
    String dataNascimento;

    ArrayList<Receita> receitasPadock = new ArrayList<>();

    public Chef(int idChef, String nomeChef, String cpfChef, String dataNascimento) {
        this.idChef = idChef;
        this.nomeChef = nomeChef;
        this.cpfChef = cpfChef;
        this.dataNascimento = dataNascimento;
    }

    public void adicionarReceitaPadocks(Receita receita) {
        this.receitasPadock.add(receita);
    }
}

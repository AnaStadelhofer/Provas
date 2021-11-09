package Provas.ProvaDoisss;
import java.util.ArrayList;
public class Receita {
    int idReceita;
    String nomeReceita;
    String etapaDescricao;
    int numEtapas;
    Chef chef;

    ArrayList<Padaria> padarias = new ArrayList<>();

    public Receita(
        int idReceita,
        String nomeReceita,
        String etapaDescricao,
        int numEtapas,
        Chef chef
        
    ) {
        this.idReceita = idReceita;
        this.nomeReceita = nomeReceita;
        this.etapaDescricao = etapaDescricao;
        this.numEtapas = numEtapas;
        this.chef = chef;
        chef.adicionarReceitaPadocks(this);
    }

    public void adicionarReceita(Padaria padaria) {
        this.padarias.add(padaria);
        padaria.adicionarReceita(this);
    }
}

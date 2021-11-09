package Provas.ProvaTres;
import java.util.ArrayList;
import java.util.Objects;
public class Receita {
    private int idReceita;
    private String nomeReceita;
    private String etapaDescricao;
    private int numEtapas;
    private Chef chef;

    ArrayList<Padaria> padarias = new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Mercado> mercados = new ArrayList<>();


    public Receita(int idReceita, String nomeReceita, String etapaDescricao, int numEtapas, Chef chef) {
        this.idReceita = idReceita;
        this.nomeReceita = nomeReceita;
        this.etapaDescricao = etapaDescricao;
        this.numEtapas = numEtapas;
        this.chef = chef;
        chef.adicionarReceitaPadocks(this);
    }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    public int getIdReceita() {
        return idReceita;
    }

    public void setNomeReceita(String nomeReceita) {
        this.nomeReceita = nomeReceita;
    }

    public String getNomeReceita() {
        return nomeReceita;
    }

    public void setEtapaDescricao(String etapaDescricao) {
        this.etapaDescricao = etapaDescricao;
    }

    public String getEtapaDescricao() {
        return etapaDescricao;
    }

    public void setNumEtapas(int numEtapas) {
        this.numEtapas = numEtapas;
    }

    public int getNumEtapas() {
        return numEtapas;
    }

    public Chef getChef(){
        return chef;
    }

    public void setChef(Chef chef){
        this.chef = chef;
    }

    public void adicionarReceita(Padaria padaria) {
        this.padarias.add(padaria);
        padaria.adicionarReceita(this);
    }

    public void adicionarReceitaCliente(Cliente cliente) {
        this.clientes.add(cliente);
        cliente.adicionarReceitaCliente(this);
    }

    public void adicionarReceitaMercado(Mercado mercado) {
        this.mercados.add(mercado);
        mercado.adicionarReceitaMercado(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Receita)) {
            return false;
        }
        Receita receita = (Receita) obj;
        return Objects.equals(this.getIdReceita(), receita.getIdReceita());
    }

    @Override
    public String toString(){
		return "\n O id da receita: " + getIdReceita() +
               "\n O nome da receita: " + getNomeReceita() +
               "\n Etapas: " + getEtapaDescricao() +
               "\n Número de etapas: " + getNumEtapas() + 
               "\n Chef da receita: " + chef.getNome();
    }

}

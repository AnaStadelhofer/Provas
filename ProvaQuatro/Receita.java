
import java.util.ArrayList;

public class Receita {
    private int idReceita;
    private String nomeReceita;
    private String etapaDescricao;
    private int numEtapas;
    private Chef chef;

    private ArrayList<Padaria> padarias = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Mercado> mercados = new ArrayList<>();


    public Receita(int idReceita, String nomeReceita, String etapaDescricao, int numEtapas, Chef chef) {
        this.idReceita = idReceita;
        this.nomeReceita = nomeReceita;
        this.etapaDescricao = etapaDescricao;
        this.numEtapas = numEtapas;
        this.chef = chef;
        chef.adicionarReceitaPadocks(this);
    }

    // get e set dos arraylist

    public void setMercado(Mercado mercado) {
        this.mercados.add(mercado);
    }

    public ArrayList<Mercado> getMercado() {
        return this.mercados;
    }

    public void setCliente(Cliente clientes) {
        this.clientes.add(clientes);
    }

    public ArrayList<Cliente> getCliente() {
        return this.clientes;
    }

    public void setPadaria(Padaria padarias) {
        this.padarias.add(padarias);
    }

    public ArrayList<Padaria> getPadaria() {
        return this.padarias;
    }

    /// fim dos get e set dos array

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
        //cliente.adicionarReceitaCliente(this);
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
        return this.getChef().getCpf() == receita.getChef().getCpf()
        && this.getIdReceita() == receita.getIdReceita();
    }

    @Override
    public String toString(){
		return "\n O id da receita: " + getIdReceita() +
               "\n O nome da receita: " + getNomeReceita() +
               "\n Etapas: " + getEtapaDescricao() +
               "\n Número de etapas: " + getNumEtapas() + "\n\n"; 
    }

}

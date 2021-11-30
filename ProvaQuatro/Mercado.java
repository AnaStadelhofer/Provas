
import java.util.Objects;
import java.util.ArrayList;
public class Mercado extends Estabelecimentos{
    private String promocao;
    
    private ArrayList<Receita> receitasMercado = new ArrayList<>();

    public Mercado(int idEsta, String nome, String dataDeAbertura, int idEndereco, int cep, String rua, int numero, String bairro, String cidade, String promocao) {
        super(idEsta, nome, dataDeAbertura, idEndereco, cep, rua, numero, bairro, cidade);
        this.promocao = promocao;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }

    public String getPromocao() {
        return promocao;
    }

    public void adicionarReceitaMercado(Receita receita) {
        this.receitasMercado.add(receita);
    }

    public void setReceita(Receita receita) {
        this.receitasMercado.add(receita);
    }

    public ArrayList<Receita> getReceita() {
        return this.receitasMercado;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Mercado)) {
            return false;
        }
        Mercado mercado = (Mercado) obj;
        return Objects.equals(this.getIdEsta(), mercado.getIdEsta());
    }

    @Override
    public String toString(){
		return "\n O id da padaria é: " + getIdEsta() +
               "\n O nome da padaria é: " + getNome() +
               "\n Data de inauguração: " + getDataDeAbertura() +
               "\n =========== Promoções =========== \n " + getPromocao() + "\n\n";
    }
}


import java.util.ArrayList;
import java.util.Objects;
public class Padaria extends Estabelecimentos {
    private String horario;

    private ArrayList<Receita> receitas = new ArrayList<>();

    public Padaria(int idEsta, String nome, String dataDeAbertura, int idEndereco, int cep, String rua, int numero, String bairro, String cidade, String horario) {
        super(idEsta, nome, dataDeAbertura, idEndereco, cep, rua, numero, bairro, cidade);
        this.horario = horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }

    public void adicionarReceita(Receita receita) {
        this.receitas.add(receita);
        
    }
    
    public void setReceita(Receita receita) {
        this.receitas.add(receita);
    }

    public ArrayList<Receita> getReceita() {
        return this.receitas;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Padaria)) {
            return false;
        }
        Padaria padaria = (Padaria) obj;
        return Objects.equals(this.getIdEsta(), padaria.getIdEsta());
    }

    @Override
    public String toString(){
		return "\n O id da padaria é: " + getIdEsta() +
               "\n O nome da padaria é: " + getNome() +
               "\n Data de inauguração: " + getDataDeAbertura() +
               "\n Horario de funcionamento: " + getHorario() +
               "\n Endereço: " + getEndereco() +
               "\n Receitas: " + getReceita() + "\n\n";
    }

}
package Provas.ProvaTres;
import java.util.ArrayList;
import java.util.Objects;
public class Chef extends Pessoas{
    private String especialidade;

    ArrayList<Receita> receitasPadock = new ArrayList<>();

    public Chef(int id, String nome, String cpf, String dataNascimento, String especialidade) {
       super(id, nome, cpf, dataNascimento);
       this.especialidade = especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void adicionarReceitaPadocks(Receita receita) {
        this.receitasPadock.add(receita);
    }

    public void setReceita(Receita receita) {
        this.receitasPadock.add(receita);
    }

    public ArrayList<Receita> getReceita() {
        return this.receitasPadock;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Chef)) {
            return false;
        }
        Chef chef = (Chef) obj;
        return Objects.equals(this.getCpf(), chef.getCpf());
    }

    @Override
    public String toString(){
		return " O nome do chef é: " + getNome() +
                "\n O cpf é: " + getCpf() +
                "\n A data de nascimento é: " + getDataNascimento() + 
                "\n Sua especialidade é: "+ getEspecialidade() + "\n\n";
	}
}


import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;
public class Chef extends Pessoas{
    private String especialidade;
    private Double salario;
    private ArrayList<Receita> receitasPadock = new ArrayList<>();

    public Chef(int id, String nome, String cpf, Date dataNascimento, String especialidade, Double salario) {
       super(id, nome, cpf, dataNascimento);
       this.especialidade = especialidade;
       this.salario = salario;
       
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public Double getSalario(){
        return salario;
    }

    public void setSalario(Double salario){
        this.salario = salario;
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

    public String carteira(){
        return "\n O nome do chef é: " + getNome() +
                "\n O cpf é: " + getCpf() +
                "\n A data de nascimento é: " + getDataNascimento() +
                "\n Salario: " + getSalario();
    }

    @Override
    public String toString(){
		return "\n O nome do chef é: " + getNome() +
                "\n O cpf é: " + getCpf() +
                "\n A data de nascimento é: " + getDataNascimento() + 
                "\n Sua especialidade é: "+ getEspecialidade() +
                "\n =========== Receitas do Chef =========== \n" + getReceita() + "\n\n"; 
	}
}

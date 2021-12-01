package Provas.ProvaTres;
import java.util.Objects;
import java.util.ArrayList;
public class Cliente extends Pessoas {
    private String telefone;

    ArrayList<Receita> receitasCliente = new ArrayList<>();

    public Cliente(int id, String nome, String cpf, String dataNascimento, String telefone) {
        super(id, nome, cpf, dataNascimento);
        this.telefone = telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void adicionarReceitaCliente(Receita receita) {
        this.receitasCliente.add(receita);
    }

    public void setReceita(Receita receita) {
        this.receitasCliente.add(receita);
    }

    public ArrayList<Receita> getReceita() {
        return this.receitasCliente;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) obj;
        return Objects.equals(this.getCpf(), cliente.getCpf());
    }

    @Override
    public String toString(){
		return "\n O nome do cliente é: " + getNome() +
                "\n O cpf é: " + getCpf() +
                "\n A data de nascimento é: " + getDataNascimento() + 
                "\n Seu telefone é: "+ getTelefone() +
                "\n =========== Receitas Compradas =========== \n " + getReceita() + "\n\n";
	}

}

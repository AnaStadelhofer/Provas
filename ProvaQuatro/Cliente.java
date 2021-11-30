
import java.util.Objects;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class Cliente extends Pessoas {
    private String telefone;

    private ArrayList<Receita> receitasCliente = new ArrayList<>();

    public Cliente(int id, String nome, String cpf, Date dataNascimento, String telefone) {
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
        // referencia aqui, sempre fica o this onde ta chamando na main
        receita.adicionarReceitaCliente(this);
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

    public String carteira(){
        return "\n O nome do cliente é: " + getNome() +
        "\n O cpf é: " + getCpf() +
        "\n A data de nascimento é: " + getDataNascimento();
    }

    @Override
    public String toString(){
		return "Id do cliente: " + getId() + 
                "\n O nome do cliente é: " + getNome() +
                "\n O cpf é: " + getCpf() +
                "\n A data de nascimento é: " + getDataNascimento() + 
                "\n Seu telefone é: "+ getTelefone() +
                "\n =========== Receitas Compradas =========== \n " + getReceita() + "\n\n";
	}

    public static void setCliente(Cliente cliente) throws Exception {
        try{
            final String url = "jdbc:mysql://localhost:3306/bdpadocks?useTimezone=true&serverTimezone=UTC";
            final String user = "root";
            final String password = "";
                
            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();
                
            boolean sql = statement.execute("Insert into cliente (nome, cpf, data_nascimento, telefone) VALUES ('"+cliente.getNome()+"', '"+cliente.getCpf()+"', '"+cliente.getDataNascimento()+"', '"+cliente.getTelefone()+"')");
            if(!sql){
                System.out.println("\n Operação efetuada com sucesso! ");
            } else {
                System.out.println("\n Deu ruim! ");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}

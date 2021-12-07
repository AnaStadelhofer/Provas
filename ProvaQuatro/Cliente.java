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
    private final static String url = "jdbc:mysql://localhost:3306/bdpadocks?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";


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
    
    @Override
    public String toString(){
		return "Id do cliente: " + getId() + 
                "\n O nome do cliente é: " + getNome() +
                "\n O cpf é: " + getCpf() +
                "\n A data de nascimento é: " + getDataNascimento() + 
                "\n Seu telefone é: "+ getTelefone() +
                "\n =========== Receitas Compradas =========== \n " + getReceita() + "\n\n";
	}

    // METODO PARA CADASTRAR CLIENTE - STATEMENT
    public static void insertCliente(Cliente cliente) throws Exception {
        try{      
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

    // METODO PARA SELECIONAR TODOS CLIENTES - STATEMENT
    public static void selectCliente() throws Exception {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM cliente");
            while (results.next()) {
                Cliente cliente = new Cliente(
                    results.getInt("idcliente"),
                    results.getString("nome"), 
                    results.getString("cpf"), 
                    results.getDate("data_nascimento"),
                    results.getString("telefone"));
                System.out.println(cliente);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // METODO PARA EDITAR O CLIENTE INFORMADO
    public static void updateCliente(Cliente cliente) throws Exception {
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();
            
            Boolean sql = statement.execute(
                "UPDATE cliente SET nome = '"+cliente.getNome()+"', cpf = '"+cliente.getCpf()+"', data_nascimento = '"+cliente.getDataNascimento()+"', telefone = '"+cliente.getTelefone()+"' WHERE idcliente = "+cliente.getId()+"");
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

    // METODO PARA SELECIONAR CLIENTE ESPECIFICO
    public static void selectClienteId(int id) throws Exception {
        try{     
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM cliente WHERE idcliente = " + id);
            if(!result.next()) {
               System.out.println("\n Usuário não existe");
            }
            new Cliente(
                result.getInt("idcliente"),
                result.getString("nome"), 
                result.getString("cpf"), 
                result.getDate("data_nascimento"),
                result.getString("telefone"));
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // METODO PARA DELETAR O CLIENTE INFORMADO
    public static void deleteCliente(int id) throws Exception {
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();
            boolean sql = statement.execute("DELETE FROM cliente WHERE idcliente = "+ id);
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

import java.util.Objects;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Chef extends Pessoas{
    private String especialidade;
    private Double salario;
    private ArrayList<Receita> receitasPadock = new ArrayList<>();
    
    private final static String url = "jdbc:mysql://localhost:3306/bdpadocks?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

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

    @Override
    public String toString(){
		return "\n O id do chef é: " + getId() +
                "\n O nome do chef é: " + getNome() +
                "\n O cpf é: " + getCpf() +
                "\n A data de nascimento é: " + getDataNascimento() + 
                "\n Sua especialidade é: "+ getEspecialidade() +
                "\n Salario: " + getSalario() +
                "\n =========== Receitas do Chef =========== \n" + getReceita() + "\n\n"; 
	}

    // CADASTRAR CHEF - PREPARED STATEMENT
    public static void insertChef(Chef chef) throws Exception {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement Statement = con.prepareStatement(
                "Insert into chef (idchef, nome, cpf, data_nascimento, especialidade, salario) VALUES (null, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            
            Statement.setString(1, chef.getNome());
            Statement.setString(2, chef.getCpf());
            Statement.setDate(3, chef.getDataNascimento());
            Statement.setString(4, chef.getEspecialidade());
            Statement.setDouble(5, chef.getSalario());
            
            if(Statement.executeUpdate() > 0){
                ResultSet resultado = Statement.getGeneratedKeys();
                if(resultado.next()){
                    resultado.getString(1);
                    resultado.getString(2);
                    resultado.getDate(3);
                    resultado.getString(4);
                    resultado.getDouble(5);
                }
            }
            System.out.println("\n Chef Cadastrado! ");
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // METODO PARA SELECIONAR TODOS CHEFS - STATEMENT
    public static void selectChef() throws Exception {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM chef");
            while (results.next()) {
                Chef chef = new Chef(
                    results.getInt("idchef"),
                    results.getString("nome"), 
                    results.getString("cpf"), 
                    results.getDate("data_nascimento"),
                    results.getString("especialidade"),
                    results.getDouble("salario"));
                System.out.println(chef);
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
            ResultSet result = stm.executeQuery("SELECT * FROM chef WHERE idchef = " + id);
            if(!result.next()) {
               System.out.println("\n Usuário não existe");
            }
            new Chef(
                result.getInt("idchef"),
                result.getString("nome"), 
                result.getString("cpf"), 
                result.getDate("data_nascimento"),
                result.getString("especialidade"),
                result.getDouble("salario"));
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // METODO PARA EDITAR O CHEF INFORMADO
    public static void updateChef(Chef chef) throws Exception {
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();
            
            Boolean sql = statement.execute(
                "UPDATE chef SET nome = '"+chef.getNome()+"', cpf = '"+chef.getCpf()+"', data_nascimento = '"+chef.getDataNascimento()+"', especialidade = '"+chef.getEspecialidade()+"', salario = "+chef.getSalario()+" WHERE idchef = "+chef.getId()+"");
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
    
    // METODO PARA DELETAR O CHEF INFORMADO
    public static void deleteChef(int id) throws Exception {
        try{ 
            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();
            boolean sql = statement.execute("DELETE FROM chef WHERE idchef = "+ id);
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

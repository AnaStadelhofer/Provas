package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import model.Golfinho;
import model.Jaula;

public class CadastrarGolfinho {

    private final static String url = "jdbc:mysql://localhost:3306/bdzoo?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

    // METODO PARA CADASTRAR GOLFINHO
    public static void insertGolfinho(Golfinho golfinho, Jaula jaula) throws Exception {
        try{      
            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();
            boolean sql2 = statement.execute("Insert into jaula (id, descricao) VALUES ('"+jaula.getIdJaula()+"', '"+jaula.getDescricao()+"')");
            if(!sql2){
                System.out.println("\n Jaula do Golfinho cadastrada! ");
            } else {
                System.out.println("\n Deu ruim, jaula do golfinho não foi cadastrado! ");
            }
            boolean sql = statement.execute("Insert into golfinho (nome, treinamento, jaula_id) VALUES ('"+golfinho.getNomeAnimal()+"', '"+golfinho.getQtdTreinamento()+"', '"+jaula.getIdJaula()+"')");
            if(!sql){
                System.out.println("\n Golfinho cadastrado com sucesso! ");
            } else {
                System.out.println("\n Deu ruim, golfinho não foi cadastrado! ");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

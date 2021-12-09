package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import model.Leao;
import model.Jaula;

public class CadastrarLeao {
    private final static String url = "jdbc:mysql://localhost:3306/bdzoo?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

    // METODO PARA CADASTRAR LEÃO
    public static void insertLeao(Leao leao, Jaula jaula) throws Exception {
        try{      
            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();
            boolean sql2 = statement.execute("Insert into jaula (descricao) VALUES ('"+jaula.getDescricao()+"')");
            if(!sql2){
                System.out.println("\n Jaula do leao cadastrada! ");
            } else {
                System.out.println("\n Deu ruim, jaula do leao não foi cadastrado! ");
            }
            boolean sql = statement.execute("Insert into leao (nome, alimentacao, visitantes, jaula_id) VALUES ('"+leao.getNomeAnimal()+"', '"+leao.getQtdAlimento()+"', '"+leao.getVisitante()+"', '" +jaula.getIdJaula()+"')");
            if(!sql){
                System.out.println("\n Leao cadastrado com sucesso! ");
            } else {
                System.out.println("\n Deu ruim, leao não foi cadastrado! ");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Golfinho;
import model.Jaula;

public class AlterarGolfinho {

    private final static String url = "jdbc:mysql://localhost:3306/bdzoo?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";
    
    public static void selectGolfinho(int id) throws Exception {
        try{     
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            ResultSet results = stm.executeQuery("SELECT * FROM golfinho WHERE id = " + id);
            if(!results.next()) {
               System.out.println("\n Golfinho não existe");
            }
            Golfinho golfinho = new Golfinho(
                results.getInt("id"),
                results.getString("nome"), 
                results.getInt("treinamento"),
                results.getInt("jaula_id"),
                results.getString("descricao"));
                System.out.println(golfinho);
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateGolfinho(Golfinho golfinho, Jaula jaula) throws Exception {
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();
            
            Boolean sql = statement.execute(
                "UPDATE golfinho SET nome = '"+golfinho.getNomeAnimal()+"', treinamento = '"+golfinho.getQtdTreinamento()+"' WHERE id = '"+golfinho.getIdAnimal()+"'");
            if(!sql){
                System.out.println("\n Golfinho editado com sucesso");
            } else {
                System.out.println("\n Ops! Parece que ocorreu um erro! ");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

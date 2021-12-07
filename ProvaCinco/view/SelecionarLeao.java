package view;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Leao;

public class SelecionarLeao {

    private final static String url = "jdbc:mysql://localhost:3306/bdzoo?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";
    
    // METODO PARA SELECIONAR TODOS CHEFS - STATEMENT
    public static void selectLeao() throws Exception {
        /*
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM leao");
            while (results.next()) {
                Leao leao = new Leao(
                    results.getInt("id"),
                    results.getString("nome"), 
                    results.getInt("alimentacao"), 
                    results.getInt("visitantes"),
                    results.getInt("jaula_id"),
  
                System.out.println(model.leao);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        */
    }
}

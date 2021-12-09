package view;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Golfinho;

public class SelecionarGolfinho {

    private final static String url = "jdbc:mysql://localhost:3306/bdzoo?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

    // METODO PARA SELECIONAR TODOS GOLFINHOS CADASTRADOS
    public static void selectGolfinho(Golfinho golfinho) throws Exception {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM golfinho g INNER JOIN jaula j ON g.jaula_id = j.id");
            while (results.next()) {
                golfinho = new Golfinho(
                results.getInt("id"),
                results.getString("nome"), 
                results.getInt("treinamento"),
                results.getInt("jaula_id"),
                results.getString("descricao"));
                System.out.println(golfinho);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

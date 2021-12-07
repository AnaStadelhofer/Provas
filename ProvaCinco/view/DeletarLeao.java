package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeletarLeao {
    private final static String url = "jdbc:mysql://localhost:3306/bdzoo?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

    // METODO PARA DELETAR O LEAO INFORMADO
    public static void deleteLeao(int id) throws Exception {
        try{ 
            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();
            boolean sql = statement.execute("DELETE FROM leao WHERE id = "+ id);
            if(!sql){
                System.out.println("\n Leão deletado com sucesso! ");
            } else {
                System.out.println("\n Deu ruim, leão não foi deletado! ");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

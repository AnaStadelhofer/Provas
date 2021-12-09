package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeletarGolfinho {
    
    private final static String url = "jdbc:mysql://localhost:3306/bdzoo?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

    // METODO PARA DELETAR O GOLFINHO INFORMADO
    public static void deleteGolfinho(int id) throws Exception {
        try{ 
            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();
            boolean sql = statement.execute("DELETE FROM golfinho WHERE id = "+ id);
            if(!sql){
                System.out.println("\n Golfinho deletado com sucesso! ");
            } else {
                System.out.println("\n Deu ruim, golfinho não foi deletado! ");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

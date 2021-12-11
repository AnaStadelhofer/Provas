package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Leao;
import model.Jaula;

public class AlterarLeao {
    
    private final static String url = "jdbc:mysql://localhost:3306/bdzoo?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";
    
    public static void selectLeao(int id) throws Exception {
        try{     
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            ResultSet results = stm.executeQuery("SELECT * FROM leao WHERE id = " + id);
            if(!results.next()) {
               System.out.println("\n Leão não existe");
            }
            Leao leao = new Leao(
                results.getInt("id"),
                results.getInt("visitantes"), 
                results.getString("nome"),
                results.getInt("alimentacao"),
                results.getInt("jaula_id"),
                results.getString("descricao"));
                System.out.println(leao);
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateLeao(Leao leao, Jaula jaula) throws Exception {
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();
            
            Boolean sql = statement.execute(
                "UPDATE leao SET nome = '"+leao.getNomeAnimal()+"', alimentacao = '"+leao.getQtdAlimento()+"', visitantes = '"+leao.getVisitante()+"' WHERE id = '"+leao.getIdAnimal()+"'");
            if(!sql){
                System.out.println("\n Leão editado com sucesso");
            } else {
                System.out.println("\n Ops! Parece que ocorreu um erro! ");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

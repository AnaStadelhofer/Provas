package view;

import model.Golfinho;
import model.Treinamento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CadastrarTreinamento {
    
    private final static String url = "jdbc:mysql://localhost:3306/bdzoo?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

    // METODO PARA CADASTRAR TREINAMENTO
    public static void insertTreinamento(Treinamento treinamento, Golfinho golfinho) throws Exception {
        try{      
            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();
            boolean sql = statement.execute("Insert into treinamento (golfinho_id, data, detalhes) VALUES ('"+golfinho.getIdAnimal()+"', '"+treinamento.getDataTreinamento()+"', '"+treinamento.getDescricao()+"')");
            if(!sql){
                System.out.println("\n Treinamento cadastrado com sucesso! ");
            } else {
                System.out.println("\n Deu ruim, treinamento não foi cadastrado! ");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}


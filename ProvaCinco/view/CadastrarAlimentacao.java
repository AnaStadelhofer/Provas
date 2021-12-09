package view;

import model.Alimentacao;
import model.Leao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CadastrarAlimentacao {

    private final static String url = "jdbc:mysql://localhost:3306/bdzoo?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

    // METODO PARA CADASTRAR ALIMENTAÇÃO
    public static void insertAlimentação(Alimentacao alimentacao, Leao leao) throws Exception {
        try{      
            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();
            boolean sql = statement.execute("Insert into alimentacao (leao_id, data, detalhes) VALUES ('"+leao.getIdAnimal()+"', '"+alimentacao.getDataAlimentacao()+"', '"+alimentacao.getDetalhes()+"')");
            if(!sql){
                System.out.println("\n Alimentação cadastrado com sucesso! ");
            } else {
                System.out.println("\n Deu ruim, alimentação não foi cadastrado! ");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

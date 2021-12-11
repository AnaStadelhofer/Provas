package view;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Golfinho;
import model.Pesquisa;
import javax.swing.*;
import java.awt.*;

public class SelecionarGolfinho extends JFrame {

    // CRIANDO O FRAME DE SELECIONAR GOLFINHO
    public SelecionarGolfinho(){
        JLabel title = new JLabel("-- SELECIONAR GOLFINHOS! -- ", JLabel.CENTER);
        JButton voltar = new JButton("Voltar");
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(title);
        pane.add(voltar);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(250,400);
        this.setResizable(false);
        this.setVisible(true);

        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                new Pesquisa();
            }
        });
    }

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

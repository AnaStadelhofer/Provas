package view;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Leao;
import model.Pesquisa;
import javax.swing.*;
import java.awt.*;

public class SelecionarLeao extends JFrame{

    // CRIANDO O FRAME DE SELECIONAR LEÃO
    public SelecionarLeao(){
        JLabel title = new JLabel("-- SELECIONAR LEÃO! --    ", JLabel.CENTER);
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

    // METODO PARA SELECIONAR TODOS LEÕES CADASTRADOS
    public static void selectLeao(Leao leao) throws Exception {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM leao l INNER JOIN jaula j ON l.jaula_id = j.id");
            while (results.next()) {
                leao = new Leao(
                results.getInt("id"),
                results.getInt("visitantes"), 
                results.getString("nome"),
                results.getInt("alimentacao"),
                results.getInt("jaula_id"),
                results.getString("descricao"));
                System.out.println(leao);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

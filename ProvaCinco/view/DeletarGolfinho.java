package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import java.awt.*;
import model.Pesquisa;

public class DeletarGolfinho extends JFrame {

    // CRIANDO O FRAME DE DELETAR O GOLFINHO
    public DeletarGolfinho(){
        JLabel title = new JLabel("-- DELETAR GOLFINHO! --    ", JLabel.CENTER);
        JLabel selectId = new JLabel("Informe o Id do golfinho: ", JLabel.CENTER);
        JButton voltar = new JButton("Voltar");
        JTextField informaId = new JTextField(15);
        JButton deletar = new JButton("Deletar");
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(title);
        pane.add(selectId);
        pane.add(informaId);
        pane.add(deletar);
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

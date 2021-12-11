package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

import model.Pesquisa;

import java.awt.*;
import java.awt.event.ActionListener;

public class DeletarLeao extends JFrame{

    // CRIANDO O FRAME DE DELETAR O LEÃO
    public DeletarLeao(){
        JLabel title = new JLabel("-- DELETAR LEÃO! --    ", JLabel.CENTER);
        JLabel selectId = new JLabel("\n Informe o Id do leão: ", JLabel.CENTER);
        JTextField informaId = new JTextField(15);
        JButton deletar = new JButton("Deletar");
        JButton voltar = new JButton("Voltar");
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

    public static void addActionListener(ActionListener actionListener) {
    }
}

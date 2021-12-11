package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import java.awt.*;

import model.Golfinho;
import model.Jaula;
import model.Pesquisa;

public class AlterarGolfinho extends JFrame {

    public AlterarGolfinho(){
        JLabel title = new JLabel(" -- CADASTRAR GOLFINHO! -- ", JLabel.CENTER);
        JLabel infoName = new JLabel("Informe o nome do golfinho: ", JLabel.CENTER);
        JButton voltar = new JButton("Voltar");
        JTextField insertName = new JTextField(15);
        JLabel infoId = new JLabel("Informe o id do Golfinho: ", JLabel.CENTER);
        JTextField insertID = new JTextField(15);
        JLabel infoTreino = new JLabel("Informe a quantidade de treinamento: ", JLabel.CENTER);
        JTextField insertTreino = new JTextField(15);
        JButton cadastrar = new JButton("Cadastrar");
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(title);
        pane.add(infoId);
        pane.add(insertID);
        pane.add(infoName);
        pane.add(insertName);
        pane.add(infoTreino);
        pane.add(insertTreino);
        pane.add(cadastrar);
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
    
    public static void selectGolfinho(int id) throws Exception {
        try{     
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            ResultSet results = stm.executeQuery("SELECT * FROM golfinho WHERE id = " + id);
            if(!results.next()) {
               System.out.println("\n Golfinho não existe");
            }
            Golfinho golfinho = new Golfinho(
                results.getInt("id"),
                results.getString("nome"), 
                results.getInt("treinamento"),
                results.getInt("jaula_id"),
                results.getString("descricao"));
                System.out.println(golfinho);
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateGolfinho(Golfinho golfinho, Jaula jaula) throws Exception {
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();
            
            Boolean sql = statement.execute(
                "UPDATE golfinho SET nome = '"+golfinho.getNomeAnimal()+"', treinamento = '"+golfinho.getQtdTreinamento()+"' WHERE id = '"+golfinho.getIdAnimal()+"'");
            if(!sql){
                System.out.println("\n Golfinho editado com sucesso");
            } else {
                System.out.println("\n Ops! Parece que ocorreu um erro! ");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

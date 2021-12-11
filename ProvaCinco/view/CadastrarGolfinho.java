package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import java.awt.*;

import model.Golfinho;
import model.Jaula;
import model.Pesquisa;

public class CadastrarGolfinho extends JFrame{

    // CADASTRAR GOLFINHO
    public CadastrarGolfinho(){
        JLabel title = new JLabel(" -- CADASTRAR GOLFINHO! -- ", JLabel.CENTER);
        JLabel infoName = new JLabel("Informe o nome do golfinho: ", JLabel.CENTER);
        JButton voltar = new JButton("Voltar");
        JTextField insertName = new JTextField(15);
        JLabel infoTreino = new JLabel("Informe a quantidade de treinamento: ", JLabel.CENTER);
        JTextField insertTreino = new JTextField(15);
        JLabel infoDesc = new JLabel("Informe a descrição: ", JLabel.CENTER);
        JTextArea insertDesc = new JTextArea(8, 15);
        JButton cadastrar = new JButton("Cadastrar");
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(title);
        pane.add(infoName);
        pane.add(insertName);
        pane.add(infoTreino);
        pane.add(insertTreino);
        pane.add(infoDesc);
        pane.add(insertDesc);
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

    // METODO PARA CADASTRAR GOLFINHO
    public static void insertGolfinho(Golfinho golfinho, Jaula jaula) throws Exception {
        try{      
            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();
            boolean sql2 = statement.execute("Insert into jaula (id, descricao) VALUES ('"+jaula.getIdJaula()+"', '"+jaula.getDescricao()+"')");
            if(!sql2){
                System.out.println("\n Jaula do Golfinho cadastrada! ");
            } else {
                System.out.println("\n Deu ruim, jaula do golfinho não foi cadastrado! ");
            }
            boolean sql = statement.execute("Insert into golfinho (nome, treinamento, jaula_id) VALUES ('"+golfinho.getNomeAnimal()+"', '"+golfinho.getQtdTreinamento()+"', '"+jaula.getIdJaula()+"')");
            if(!sql){
                System.out.println("\n Golfinho cadastrado com sucesso! ");
            } else {
                System.out.println("\n Deu ruim, golfinho não foi cadastrado! ");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

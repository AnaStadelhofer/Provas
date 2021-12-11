package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import java.awt.*;

import model.Leao;
import model.Jaula;
import model.Pesquisa;

public class AlterarLeao extends JFrame{
    
    // ALTERAR LEÃO
    public AlterarLeao(){
        JLabel title = new JLabel(" -- Alterar o cadastro do Leão -- ", JLabel.CENTER);
        JLabel infoName = new JLabel("Informe o nome do leão: ", JLabel.CENTER);
        JButton voltar = new JButton("Voltar");
        JTextField insertName = new JTextField(15);
        JLabel infoId = new JLabel("Informe o id do Leão: ", JLabel.CENTER);
        JTextField insertID = new JTextField(15);
        JLabel infoAlimento = new JLabel("Informe a quantidade de alimento: ", JLabel.CENTER);
        JTextField insertAlimento = new JTextField(15);
        JLabel infoVisita = new JLabel("Informe a quantidade de visitantes: ", JLabel.CENTER);
        JTextField insertVisita = new JTextField(15);
        JButton cadastrar = new JButton("Cadastrar");
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(title);
        pane.add(infoId);
        pane.add(insertID);
        pane.add(infoName);
        pane.add(insertName);
        pane.add(infoAlimento);
        pane.add(insertAlimento);
        pane.add(infoVisita);
        pane.add(insertVisita);
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

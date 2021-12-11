package view;

import model.Golfinho;
import model.Pesquisa;
import model.Treinamento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import java.awt.*;

public class CadastrarTreinamento extends JFrame{
    
    // CRIANDO O FRAME DE CADASTRAR TREINAMENTO
    public CadastrarTreinamento(){
        JLabel title = new JLabel(" --CADASTRAR TREINAMENTO! --", JLabel.CENTER);
        JButton voltar = new JButton("Voltar");
        JLabel selectId = new JLabel("Informe o Id do treinamento: ", JLabel.CENTER);
        JTextField informaId = new JTextField(15);
        JLabel insertDate = new JLabel("Informe a data de treino: ", JLabel.CENTER);
        JTextField infoDate = new JTextField(15);
        JLabel insertDesc = new JLabel("Informe a Descrição: ", JLabel.CENTER);
        JTextArea infoDesc = new JTextArea(10, 15);
        JButton cadastrar = new JButton("Cadastrar");
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(title);
        pane.add(selectId);
        pane.add(informaId);
        pane.add(insertDate);
        pane.add(infoDate);
        pane.add(insertDesc);
        pane.add(infoDesc);
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


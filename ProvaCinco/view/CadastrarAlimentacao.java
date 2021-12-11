package view;

import model.Alimentacao;
import model.Leao;
import model.Pesquisa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import java.awt.*;

public class CadastrarAlimentacao extends JFrame {

    // CADASTRAR ALIMENTO
    public CadastrarAlimentacao(){
        JLabel title = new JLabel(" -- CADASTRAR ALIMENTAÇÃO! -- ", JLabel.CENTER);
        JLabel infoID = new JLabel("Informe o id do golfinho: ", JLabel.CENTER);
        JButton voltar = new JButton("Voltar");
        JTextField insertName = new JTextField(15);
        JLabel infoDate = new JLabel("Data da alimentação ", JLabel.CENTER);
        JTextField insertDate = new JTextField(15);
        JLabel infoDesc = new JLabel("Informe a descrição: ", JLabel.CENTER);
        JTextArea insertDesc = new JTextArea(8, 15);
        JButton cadastrar = new JButton("Cadastrar");
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(title);
        pane.add(infoID);
        pane.add(insertName);
        pane.add(infoDate);
        pane.add(insertDate);
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

    // METODO PARA CADASTRAR ALIMENTAÇÃO
    public static void insertAlimentacao(Alimentacao alimentacao, Leao leao) throws Exception {
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

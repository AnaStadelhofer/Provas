package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import java.awt.*;
import model.Leao;
import model.Pesquisa;
import model.Jaula;

public class CadastrarLeao extends JFrame{

    // CRIANDO O FRAME DE CADASTRAR LEÃO
    public CadastrarLeao(){
        JLabel title = new JLabel(" -- CADASTRAR LEÃO! -- ", JLabel.CENTER);
        JLabel infoName = new JLabel("Informe o nome do leão: ", JLabel.CENTER);
        JButton voltar = new JButton("Voltar");
        JTextField insertName = new JTextField(15);
        JLabel infoAlimento = new JLabel("Informe a quantidade de alimento: ", JLabel.CENTER);
        JTextField insertAlimento = new JTextField(15);
        JLabel infoVisita = new JLabel("Informe a quantidade de visitantes: ", JLabel.CENTER);
        JTextField insertVisita = new JTextField(15);
        JLabel infoDesc = new JLabel("Informe a descrição: ", JLabel.CENTER);
        JTextArea insertDesc = new JTextArea(8, 15);
        JButton cadastrar = new JButton("Cadastrar");
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(title);
        pane.add(infoName);
        pane.add(insertName);
        pane.add(infoAlimento);
        pane.add(insertAlimento);
        pane.add(infoVisita);
        pane.add(insertVisita);
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

    // METODO PARA CADASTRAR LEÃO
    public static void insertLeao(Leao leao, Jaula jaula) throws Exception {
        try{      
            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();
            boolean sql2 = statement.execute("Insert into jaula (descricao) VALUES ('"+jaula.getDescricao()+"')");
            if(!sql2){
                System.out.println("\n Jaula do leao cadastrada! ");
            } else {
                System.out.println("\n Deu ruim, jaula do leao não foi cadastrado! ");
            }
            boolean sql = statement.execute("Insert into leao (nome, alimentacao, visitantes, jaula_id) VALUES ('"+leao.getNomeAnimal()+"', '"+leao.getQtdAlimento()+"', '"+leao.getVisitante()+"', '" +jaula.getIdJaula()+"')");
            if(!sql){
                System.out.println("\n Leao cadastrado com sucesso! ");
            } else {
                System.out.println("\n Deu ruim, leao não foi cadastrado! ");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

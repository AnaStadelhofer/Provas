package Provas.ProvaUm;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/*
O programa deverá receber uma lista de valores de um arquivo de texto,
onde esta lista não terá uma determinação de quantidade fixa, podendo variar de arquivo para arquivo.
Após, deverá ser alocado os valores dentro da estrutura de Array (não poderão ser aplicadas Collections para solução),
e realizada a ordenção dos valores, imprimindo em tela os passos ocorridos desta ordenação. Após, deverá ser utilizado 
uma Collection para o recebimento dos mesmos valores, de maneira que estes valores já estejam ordenados. Ao final, deverá 
ser impresso em tela o valor ordenado do Array e da Collection, garantindo que estejam iguais, e deverá ser exportado em 
um arquivo de texto esses valores.
*/
public class ProvaUm {
    public static void main(String[] args) {
        // Vai contar a quantidade de linhas do arquivo
        int contLinha = 0;
        
        int contadorNum = 0;
        String valor = "";
        try{
            // Faz somente a leitura para contar a quantidade de linhas
            BufferedReader leitura = new BufferedReader(new FileReader("./ValorDesordenado.txt"));
            while ((valor = leitura.readLine()) != null){
                contLinha++;
            }
            leitura.close();

            // Termina a leitura e declara as variaveis de numeros/reinicia cont
            int[] numeros = new int[contLinha];
            contLinha = 0;

            leitura = new BufferedReader(new FileReader("./ValorDesordenado.txt"));
            valor = "";
            while ((valor = leitura.readLine()) != null){
                int temp = Integer.parseInt(valor);
                numeros[contLinha] = temp;
                contLinha++;
            }

            System.out.println("\n===========Números desordenados======== \n");
            for(contadorNum = 0; contadorNum < contLinha; contadorNum++) {
                System.out.println(" Numero da: "+ (contadorNum+1)+ "a posição é: " + numeros[contadorNum]);
            }
            System.out.println("\n");
            // Ele vai comparando um numero com todos os outros do array, o primeiro for (ordernar) é o numero principal, o segundo vai comparar todos os numeros com o principal se ele for menor, ele troca de lugar
            for (int ordernar = 0; ordernar < numeros.length - 1; ordernar++){   
                int ordernarSuporte = ordernar;
                for (contadorNum = ordernar + 1; contadorNum < numeros.length; contadorNum++){  
                    if (numeros[contadorNum] < numeros[ordernarSuporte]){  
                        ordernarSuporte = contadorNum;
                        System.out.println(" Número "+numeros[contadorNum]+" foi trocado...");
                    }  
                }  
                // Aqui ele vai ficar salvando o menor número dessa array
                int smallerNumber = numeros[ordernarSuporte];   
                numeros[ordernarSuporte] = numeros[ordernar];  
                numeros[ordernar] = smallerNumber;  
            }  
            // Imprimi valores ordenados
            System.out.println("\n===========Números ordenados========\n");
            for(contadorNum = 0; contadorNum < contLinha; contadorNum++) {
                System.out.println(" Numero da: "+ (contadorNum+1)+ "a posição é: " + numeros[contadorNum]);
            }
            leitura.close();

            //Adicionando o array em uma collection
            ArrayList<String> list = new ArrayList<>();
            BufferedWriter escreverSet = new BufferedWriter(new FileWriter("./ValoresOrdenadosSet.txt"));
            System.out.println("\n");
            try{
                for(contadorNum = 0; contadorNum < contLinha; contadorNum++) {
                    //Converte o num int temporario em String e adiciona no array da String
                    int tempNum = numeros[contadorNum];
                    String[] numStringArray = new String[contLinha];
                    String numString = Integer.toString(tempNum);
                    numStringArray[contadorNum] = numString;
                    //Termina conversão
                    System.out.println(" Imprimindo num em array de String: "+numStringArray[contadorNum]);
                    list.add(numStringArray[contadorNum]);
                    try{
                        escreverSet.append(numStringArray[contadorNum] + "\n");
                    }catch(Exception e) {
                        System.out.println("Erroouuu...");
                    }
                }
                escreverSet.close();
            }catch (IOException exception){
            System.out.println("Erro de exceção I/O: " + exception.getMessage());
            }

            //Imprimindo a collection
            System.out.println("\n===========Números da collection ordenados=================");
            for(int i=0;i<list.size();i++){
                System.out.print(" Número da collection" + list.get(i)+" \n");
                }

            //Escreve o array ordenado no arquivo
            try{
                BufferedWriter escreverArray = new BufferedWriter(new FileWriter("./ValoresOrdenados.txt"));
                try{ 
                    for(contadorNum = 0; contadorNum < contLinha; contadorNum++) {
                        escreverArray.append(numeros[contadorNum] + "\n");
                    }
                } catch(Exception e) {
                    System.out.println("Erroouuu...");
                }
                escreverArray.close();
            } catch (IOException exception){
                System.out.println("Erro de exceção I/O: " + exception.getMessage());
            }
        } catch (IOException exception){
            System.out.println("Erro de exceção I/O: " + exception.getMessage());
        }
    }
}


package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ClienteTeste01 {
    public static void main(String[]args){
        try{
            Socket conexao = new Socket("localhost",2017);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
             BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter saida = new PrintWriter(conexao.getOutputStream());
             System.out.println("Digite o nome"); 
             Scanner s = new Scanner(System.in);
             String scan = s.nextLine();
             
            System.out.println("Digite a mensagem:");
            String linha = teclado.readLine();
            while(true){
                saida.println("Nome "+scan+" :"+linha);
                saida.flush();
                linha = teclado.readLine();
                if(linha==null){
                    System.out.println("conexao encerrada");
                    break;
                }
                
            }    
        }catch(Exception e){
            System.out.println("excep"+e);
        }           
    }
}

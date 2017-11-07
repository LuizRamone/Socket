package socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTeste01{
    public static void main(String[]args){
        Socket conexao = null;
        ServerSocket s = null;
        try{
          s = new ServerSocket(2017);
            while(true){
                conexao= s.accept();
                System.out.println("conexao aceita!");
                ServerThread01 st = new ServerThread01(conexao);
                st.start();
            }
            
        }catch(Exception e){
            System.out.println("excep"+e);
        }     
        
    }
    
}
 class ServerThread01 extends Thread{
     Socket conexao = null;
     BufferedReader entrada = null;
     PrintWriter saida = null;
     String linha = null;
     
  public ServerThread01(Socket s){
     this.conexao = s;
 }
     public void run(){
         try{
             
         
       BufferedReader entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
       PrintWriter saida = new PrintWriter(conexao.getOutputStream());
       String linha = entrada.readLine();
       while(linha!=null){
           saida.println(linha);
           saida.flush();
           System.out.println(linha);
           linha = entrada.readLine();
           
           
       }conexao.close();
         
         
         
     }catch(Exception e){
             System.out.println("Except"+e);
 }
     }
 }
     
     
     
     
     
     
 
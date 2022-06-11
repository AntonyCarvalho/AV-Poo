
package projetopoo;
import java.util.Scanner;

public class ProjetoPoo {

    
    public static void main(String[] args) {
      Banco bancoDados = new Banco();
      notaC nc = new notaC();
		bancoDados.conecta();
                Scanner leitor=new Scanner(System.in);
        
                
                
        int produtos;
        int quat;    
        int op=0;
        String nome;
        
        while(op !=4){
        nc.menu();
       op = leitor.nextInt();
     
       
        
             switch(op){
                 case 1:
                     
                     bancoDados.listar();
                    
                 case 2: 
                     
                     System.out.println("");
                     System.out.print("Digite o 'ID' do produto desejado: ");
                     System.out.println("");
                    produtos = leitor.nextInt();
                     System.out.print("Quantidade desejada: ");
                     System.out.println("");
                   quat = leitor.nextInt();
                     System.out.print("por favor, informe seu nome: ");
                     System.out.println("");
                   nome = leitor.next();
                     
                    
                     bancoDados.criarPedido(produtos,nome,quat);
                     
                     bancoDados.retirar(quat,produtos);
                    
                   
                    
                 case 3:
                     
                       
                     
                     System.out.println("");
             }    
		
	
                
        }
                
                
        
    }
    
}

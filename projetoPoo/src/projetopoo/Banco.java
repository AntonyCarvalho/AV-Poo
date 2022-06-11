


package projetopoo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Banco {
    
    notaC NC = new notaC();
    
    private Connection con = null;
	private Statement stm  = null;
	private ResultSet result = null;
        
        
        public void conecta() {
		String servidor = "jdbc:mysql://localhost:3306/dbvenda";
		String usuario = "root";
		String senha = "";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			this.con = DriverManager.getConnection(servidor, usuario, senha);
			this.stm = this.con.createStatement();
		} catch (Exception e) {
			System.out.println("erro na conexao : " + e.getMessage());
		}
             
        }
    
        public boolean estaConecatdo() {
		if (this.con != null) {
			return true;
		} 
		else {
			return false;
		}
	}
        public void listar() {
		try {
			String minhaQuery = "SELECT * FROM produto ORDER BY nomeProduto ";
			this.result = this.stm.executeQuery(minhaQuery);
			
			while (this.result.next()) {
				System.out.println("ID: "+this.result.getString("idProduto") + " - Nome: "+this.result.getString("nomeProduto")
                                        + " - R$: "+this.result.getDouble("valorUnitario"));
			}
		} catch(Exception e) {
			System.out.println("Erro na lista: "+ e.getMessage());
		}
                
	}
        
        public void criarPedido(int produtos,String nome, int quant) {
		try {
			String query = "INSERT INTO nota (IDproduto, nomeCliente, qtd) VALUES('"+ produtos +"','"+ nome +"','"+ quant +"')" 
                                ;
                       
			this.stm.executeUpdate(query);
			System.out.println("pedido de " +nome + " criado com sucesso" );
			
		} catch(Exception e) {
			System.out.println("Erro ao criar pedido: "+ e.getMessage());
		}
	}
         public void retirar(int quat, int produtos) {
    	try {
			String query = "UPDATE produto SET qtdEstoque = '"+  quat +"'WHERE idProduto = " + produtos + ";";
			this.stm.executeUpdate(query);
			System.out.println("ID: "+ produtos + " alterado com sucesso" );
		} catch(Exception e) {
			System.out.println("Erro na Atualizaçao "+ e.getMessage());
		}
	}
        
        
        
        
}

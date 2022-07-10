    import java.awt.FlowLayout;   
	import java.awt.event.ActionEvent;   
	import java.awt.event.ActionListener;   
	import java.sql.Connection;   
	import java.sql.DriverManager;   
	import java.sql.SQLException;   
	import java.sql.Statement;   
	   
	import javax.swing.JButton;   
	import javax.swing.JFrame;   
	import javax.swing.JLabel;   
	import javax.swing.JOptionPane;   
	import javax.swing.JTextField;   
	   
	   
	public class Formulario2 extends JFrame implements ActionListener{   
	   
	    private static final long serialVersionUID = 1L;   
	    JTextField jtFilme = new JTextField(40);   
	    JTextField jtData = new JTextField(40);
	    JTextField jtValor = new JTextField(40);
	    JTextField jtQuantidade = new JTextField(11);   
	    JLabel jlFilme = new JLabel("Filme:");   
	    JLabel jlValor = new JLabel("Valor:");   
	    JLabel jlData = new JLabel("Data:");   
	     JLabel jlQuantidade = new JLabel("Quantidade:");   
	      
	          
	    JButton jbSalvar = new JButton("Salvar");   
	       
	    public Formulario2() {   
	        super();   
	        //setLayout(new FlowLayout(FlowLayout.RIGHT));   
	        setLayout(null);
	        setTitle("Filme");   
	        jlFilme.setBounds(18,18,100,30);
	        jtFilme.setBounds(70,18,100,30);
	        jlValor.setBounds(18,80,100,30);
	        jtValor.setBounds(70,80,100,30);
	        jlData.setBounds(18,140,100,30);
	        jtData.setBounds(70,140,100,30);
	        jbSalvar.setBounds(200,200,100,30);
	        jlQuantidade.setBounds(210,80,100,30);
	        jtQuantidade.setBounds(310,80,100,30);
	       add(jlFilme);   
	        add(jtFilme);   
	        add(jlValor);   
	        add(jtValor); 
	        add(jlData);
	        add(jtData);
	        add(jlQuantidade);
	        add(jtQuantidade);  
	        add(jbSalvar);   
	        setSize(500,300);   
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	        setLocationRelativeTo(null);   
	        setVisible(true);   
	        jbSalvar.addActionListener(this);   
	    }   
	    public static void main(String []args){   
	        new Formulario2();   
    }   
       
	    public void actionPerformed(ActionEvent arg0) {   

	     try {   JOptionPane.showMessageDialog(null,"Cadastrando...");  
 	            Class.forName("com.mysql.jdbc.Driver"); 	     
	            Connection c = DriverManager.getConnection("jdbc:mysql://192.168.50.100/exerciciokilder", "root", "suporte");   
	            Statement stm = c.createStatement();   
	            String filme = jtFilme.getText();   
	            String data = jtData.getText();
	            String quantidade = jtQuantidade.getText();
	           String  valor = jtValor.getText();
	           double valordouble = Double.parseDouble(valor); 
	           int qua = Integer.parseInt(quantidade);
	               
	            stm.executeUpdate("insert into filmes (filme,valor,quantidade,data) values ('"+filme+"','"+valordouble+"','"+qua+"','"+data+"')");   
	            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso.");   
	            jtFilme.setText("");   
	            jtValor.setText("");   
	            jtQuantidade.setText("");
	            jtData.setText("");
	        }   	
	           
	           
	        catch(SQLException ex){   
	            JOptionPane.showMessageDialog(null,"Ha um erro no SQL "+ex.getMessage());   
	        }   
	        catch(Exception ex){   
	            JOptionPane.showMessageDialog(null,"Erro nao definido");   
	        }   
	           
	    }   
	}  

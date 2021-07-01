package backup;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class Backup {

	private String ipMaquina;
	private String user;
	private String senha;
	private String dataBase;
	private Date dataAtual;

	
	public Backup() {
		
		dataAtual = new Date(System.currentTimeMillis());
		SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy"); 
		formatador.format(dataAtual);
		
		try {
			this.ipMaquina = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.user = "root";
		this.senha = "root";
		this.dataBase = "bd_crh";
		
		
	}
	
	public void realizarBackup(){
		  
		Date data = new Date(System.currentTimeMillis());
		SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy"); 
		formatador.format(data);
		
	    File diretorio = new File("C:\\CRH\\Backup");  
			  File arquivo = new File("C:\\CRH\\Backup\\bkp_"+dataBase+"_"+data+".sql");  
			  Boolean snbkp = true;  
			  // Cria diretório
			  if(!diretorio.isDirectory()){
				  new File("C:\\CRH\\Backup").mkdir();  
			  }
			  // Cria Arquivo de Backup  
			  try {  
			      if (arquivo.isFile()){   
			          if(JOptionPane.showConfirmDialog(null,"Já foi criado backup hoje, deseja substituir ?","Backup ja existe",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)  
			          {   
			              arquivo.delete();  
			              snbkp = true;  
			          }  
			          else  
			          {  
			              snbkp = false;  
			          }   
			      }  
			            
			      if(snbkp==true)  
			      {   
			  
			          Process proc = Runtime.getRuntime().exec("cmd /c mysqldump -uroot -p"+senha+" -h "+
			        		  ipMaquina+" "+dataBase+" --result-file=C:/CRH/Backup/bkp_"+dataBase+"_"+data+".sql");
			          			
			          proc.waitFor();  
			        
			          //String comando = "C:\\Program Files\\MySQL\\MySQL Server 5.5\\bin\\mysqldump.exe";
			          String comando = null;/* = "C:\\Arquivos de Programas\\MySQL\\MySQL Server 5.5\\bin\\mysqldump.exe"*/
			          
			          File caminho = new File("C:\\Program Files\\MySQL\\MySQL Server 5.5\\bin\\mysqldump.exe");
			          comando = caminho.getCanonicalPath();
			          
			          if(!caminho.exists()){
			        	  caminho = new File("C:\\Arquivos de Programas\\MySQL\\MySQL Server 5.5\\bin\\mysqldump.exe");
			        	  comando = caminho.getPath();
			          }
			          
			          
			          
			          ProcessBuilder pb = new ProcessBuilder(comando, "--user=root",  
			                  "--password="+senha, dataBase, "--result-file=C:\\CRH\\Backup\\bkp_" +dataBase+"_"+data+".sql");  
			          pb.start();  

			          int res = 0;
			        
			          if (res == 0){
			        	  JOptionPane.showMessageDialog(null,"Backup realizado com Sucesso !"); 
			          }	   
			          else  {  
			        	  JOptionPane.showMessageDialog(null,"Falha ao criar Backup. \n Verifique as configurações ou entre em contato com o suporte !",  
			        			  "Erro ao criar backup", JOptionPane.ERROR_MESSAGE);  
			          }   
			      }  
			  }  
			  catch (IOException ex) {  
			      ex.printStackTrace();    
			      JOptionPane.showMessageDialog(null,"Erro na criação do Backup !\n"+ex.getMessage());  
			  } catch(Exception err){   
			      JOptionPane.showMessageDialog(null,"Erro na criação do Backup !\n"+err.getMessage());  
			  }  
	}

	
	public void restaurarBackup() throws IOException, InterruptedException{
		
					
			          Runtime rt = Runtime.getRuntime();
			          
			          //Criar arquivo .bat para executar comando
			          File file = new File("comando2.bat");
			          FileWriter file2 = new FileWriter(file);
			          
			          JFileChooser chooser = new JFileChooser("c:\\CRH\\Backup");
			          chooser.setDialogTitle("Selecione o arquivo de backup");  
			          chooser.showOpenDialog(chooser); 
			          File arq = chooser.getSelectedFile();
			          
			          String localArquivo = null; 
			          if(arq == null) localArquivo = "null";
			          else localArquivo = arq.getAbsolutePath();
			          
			          File diretorio = new File("C:\\Arquivos de Programas");
			          
			          try {
			        	  
			        	  file2.write("cd\\");
			        	  file2.write("\r\n");
			        	  
			        	  
			        	  if(!diretorio.exists()){
			        		  file2.write("cd Program Files");
			        	  }
			        	  else{
			        		  file2.write("cd Arquivos de Programas");
			        	  }
			        	  
			        	  //file2.write("cd Arquivos de Programas");
			        	  //file2.write("cd Program Files");
			        	  file2.write("\r\n");
			        	  file2.write("cd MySQL");
			        	  file2.write("\r\n");
			        	  file2.write("cd MySQL Server 5.5");
			        	  file2.write("\r\n");
			        	  file2.write("cd bin");
			        	  file2.write("\r\n");
			        	  file2.write("mysql -u"+user+" -p"+senha+" -h localhost "+dataBase+" < "+localArquivo);
			        	  
					} catch (Exception e) {
						//System.out.println(e);
					}  
			           
			          file2.close();
			        
			          if(!localArquivo.equals("null")){
			        	 
				          //Executar .bat
				          @SuppressWarnings("unused")
				          Process proc = null;
				          
				          if(!diretorio.exists()){
				        	  proc = rt.exec(file.getCanonicalPath()); 
				          }
				          else{
				        	  proc = rt.exec(file.getPath());
				          }
				          
				          //Tem que dar um sleep para ele esperar um pouco antes de deletar o arquivo, do contrário ele pode não executar
				         // new ProgressBar();
				          Thread.sleep(500);
				          JOptionPane.showMessageDialog(null, "Restauração de dados realizada com sucesso !");
				          
			          }
			          
			          
			          
			          file.delete();
			          
	}
	
	
}


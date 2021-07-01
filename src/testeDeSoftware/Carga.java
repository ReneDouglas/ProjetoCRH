package testeDeSoftware;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import controle.ControleAlistamento;
import controle.ControleCarteiraDeTrabalho;
import controle.ControleDependente;
import controle.ControleEndereco;
import controle.ControleFerias;
import controle.ControleFuncionario;
import controle.ControleIdentidade;
import controle.ControleLicenca;
import controle.ControleNaturalidade;
import controle.ControleTitulo;
import controle.ControleVidaFuncional;


public class Carga {

	public Carga() throws ParseException {
				
		String[] nomeHomem = {"Renê","Diego","Willian","Bruce","Neto","Emerson","Urbano",
				 "João","Alysson","Juliano","Leonardo","Pedro","Osvaldo","Cicero","Manoel","Antonio","Edvaldo","Rafael","Diogo","Jonas",
				 "guilherme","gustavo","gabriel","vinicius","lazaro","bruno","nicolau","arisvaldo","carlos","henrique","Samuel","jorge"};
		
		String[] nomeMulher = {"Renata","Renia","Alice","Erandi","Maria","Gabriele","Isabella","Sofia","carolina","amanda","larissa",
				"Rafaela", "Beatriz", "Bianca", "Rita", "Nicole", "Joana", "Luana", "Tereza", "Laura","Priscila","Erandi",
				"Maria","Gabriele","Isabella","Sofia","Alice","carolina","amanda","leticia","larissa","Rafaela"};
		
		String[] sobreNome = {"martins","Alves","Carvalho","Nobre","Morais","Silva","Santos","Pereira","Bezerra","Moraes",
					  "Neves","Ferreira","Gomes","Dias","Brito","Costa","Lima","Vieira","Goes","Macena",
					  "abreu","aguiar","alencar","borba","braga","brasil","brito jr.","campos","cordeiro","cunha",
					  "duarte","faria","ferreira","freitas","jesus","leonor","lopes","marques","luz","rosas"};

		
		String sexo = null;

		String[] rua = {"Rua Antonio Alves","Rua Antonio Vidal","Rua JK","Rua Sete de Setembro","Rua Odom Padilha",
			"Rua Manoel Bezerra","Vila Bom Jesus","Rua Jose Barbosa","travessa joao da cruz","rua joaquim nazario",
			"rua alfredo ferreira costa","rua dario macena bastos","rua sindronio do amaral","rua sebastiao rafael rodrigues",
			"rua elisbao pires de almeida","rua antonio miguel","rua professor trindade","rua pedro higino","rua coronel luiz de goes",
			"rua paulo de oliveira","avenida arthur padilha","rua bernardo nunes","rua pedro pires","rua antonio ramos de souza",
			"rua cleber campelo","rua paulo de oliveira","travessa santo antonio","rua cicero cruz","rua laura mariano","rua epitacio pessoa",
			"rua maria do socorro pereira","rua maria izabel","rua cirene de lima alves","rua janele clair","rua laura mariano","rua cirene de lima alves",
			"rua valdecir xavier de meneses","rua da felicidade","rua diomedes gomes","rua floriano peixoto","travessa jose de alencar"};
		
		String[] bairro = {"centro","sao bras","sao francisco","pe. pedro pereira","sobreira","borges","costa","sao cristovao","brotas",
			"manoela valadares","pitombeira","izidio leite","sao sebastiao"};
		
		String[] estadoCivil = {"solteiro","casado","viuvo","divorciado"};
		
		String[] situacaoMilitar = {"dispensado","servidor"};
		
		String[] grau = {"superior completo", "superior incompleto", "ensino médio", "ensino fundamental", "mestrado", "doutorado"};
		
		String[] cargo = {"digitador","gerente","coordenador","tecnico","tecnico administrativo","guarda","diretor",
			"ACS","agente de endemias","telefonista"};
		
		String[] tipoLicenca = {"MÉDICA","OUTRA"};
		
		
		ArrayList<String> nomeFuncM = new ArrayList<String>();
		ArrayList<String> nomeFuncF = new ArrayList<String>();
		ArrayList<String> sobreNomeFunc = new ArrayList<String>();
		
		for (int i = 0; i < nomeHomem.length; i++) {
			nomeFuncM.add(nomeHomem[i]);
			nomeFuncF.add(nomeMulher[i]);
			
			
		}
		
		for (int i = 0; i < sobreNome.length; i++) {
			sobreNomeFunc.add(sobreNome[i]);
		}
		
		
		Collections.shuffle(nomeFuncM);
		Collections.shuffle(nomeFuncF);
		Collections.shuffle(sobreNomeFunc);
		
		ControleFuncionario func = new ControleFuncionario();
		ControleAlistamento alist = new ControleAlistamento();
		ControleCarteiraDeTrabalho trab = new ControleCarteiraDeTrabalho();
		ControleDependente dep = new ControleDependente();
		ControleEndereco end = new ControleEndereco();
		ControleIdentidade ident = new ControleIdentidade();
		ControleNaturalidade nat = new ControleNaturalidade();
		ControleTitulo titulo = new ControleTitulo();
		ControleLicenca licen = new ControleLicenca();
		ControleFerias ferias = new ControleFerias();
		ControleVidaFuncional hist = new ControleVidaFuncional();
		
		Random rand = new Random();
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String data, data_2, data_3, data_4 = null;
		String nome = null;
		
		
		int j = 0;
		int quantidade = 10;
		
		while (j < quantidade) {
			
			System.out.println("Quantidade: "+j);
			
			Collections.shuffle(nomeFuncM);
			Collections.shuffle(nomeFuncF);
			Collections.shuffle(sobreNomeFunc);
			

			data = rand.nextInt(3)+rand.nextInt(9)+"/"+rand.nextInt(2)+rand.nextInt(3)+"/19"+rand.nextInt(10)+rand.nextInt(10);
			
			sexo = (rand.nextInt(2)==0)?"Masculino":"Feminino";
			
			if(sexo.equalsIgnoreCase("Masculino")){
				
				nome = nomeFuncM.get(rand.nextInt(nomeFuncM.size()));
				
			}
			else{
				
				nome = nomeFuncF.get(rand.nextInt(nomeFuncF.size()));
				
			}
			
			/************* FICHA FUNCIONAL ************/
			
			
			
			func.salvar(nome+" "+sobreNomeFunc.get(rand.nextInt(sobreNomeFunc.size())),
					nomeFuncM.get(rand.nextInt(nomeFuncM.size()))+" "+sobreNomeFunc.get(rand.nextInt(sobreNomeFunc.size())),
					nomeFuncF.get(rand.nextInt(nomeFuncF.size()))+" "+sobreNomeFunc.get(rand.nextInt(sobreNomeFunc.size())),
									new java.sql.Date(((formatter.parse(data))).getTime()),
									sexo, estadoCivil[rand.nextInt(estadoCivil.length)],
									""+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(9),
									""+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(9),
									""+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+"."+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+"."+rand.nextInt(9)+rand.nextInt(9)+rand.nextInt(9)+"-"+rand.nextInt(9)+rand.nextInt(9),
									grau[rand.nextInt(grau.length)]);
		
			
			
			end.salvar(bairro[rand.nextInt(bairro.length)], rua[rand.nextInt(rua.length)], ""+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10));
			
			data = rand.nextInt(3)+rand.nextInt(9)+"/"+rand.nextInt(2)+rand.nextInt(3)+"/19"+rand.nextInt(10)+rand.nextInt(10);
			
			nat.salvar("afogados da ingazeira", "PE");
			ident.salvar(""+rand.nextInt(10)+"."+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+"."+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10), "PE", new java.sql.Date(((formatter.parse(data))).getTime()));
			titulo.salvar(""+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)
					+rand.nextInt(10)+rand.nextInt(10), ""+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10), ""+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10));
			
			data = rand.nextInt(3)+rand.nextInt(9)+"/"+rand.nextInt(2)+rand.nextInt(3)+"/19"+rand.nextInt(10)+rand.nextInt(10);
			
			if(sexo.equalsIgnoreCase("Masculino")){
				data = rand.nextInt(3)+rand.nextInt(9)+"/"+rand.nextInt(2)+rand.nextInt(3)+"/19"+rand.nextInt(10)+rand.nextInt(10);
				alist.salvar(situacaoMilitar[rand.nextInt(situacaoMilitar.length)], ""+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10), data);
			}
			
			trab.salvar(""+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10), ""+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10), new java.sql.Date(((formatter.parse(data))).getTime()));
			
			/********END - FICHA FUNCIONAL********/
			
			/** HISTORICO **/
			
			for (int i = 0; i < rand.nextInt(8)+1; i++) {
				
				data = rand.nextInt(3)+rand.nextInt(9)+"/"+rand.nextInt(2)+rand.nextInt(3)+"/19"+rand.nextInt(10)+rand.nextInt(10);
				data_2 = rand.nextInt(3)+rand.nextInt(9)+"/"+rand.nextInt(2)+rand.nextInt(3)+"/19"+rand.nextInt(10)+rand.nextInt(10);
				data_3 = rand.nextInt(3)+rand.nextInt(9)+"/"+rand.nextInt(2)+rand.nextInt(3)+"/19"+rand.nextInt(10)+rand.nextInt(10);
				data_4 = rand.nextInt(3)+rand.nextInt(9)+"/"+rand.nextInt(2)+rand.nextInt(3)+"/19"+rand.nextInt(10)+rand.nextInt(10);
				
				hist.salvar(0, ""+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10), new java.sql.Date(((formatter.parse(data))).getTime()), new java.sql.Date(((formatter.parse(data_2))).getTime()), 
						new java.sql.Date(((formatter.parse(data_3))).getTime()), new java.sql.Date(((formatter.parse(data_4))).getTime()), cargo[rand.nextInt(cargo.length)], "X", "X", "SECRETARIA MUNICIPAL DE SAÚDE", "AFOGADOS DA INGAZEIRA", "Observações:", 1);		
				
			}
			
			for (int i = 0; i < rand.nextInt(8)+1; i++) {
				
				data = rand.nextInt(3)+rand.nextInt(9)+"/"+rand.nextInt(2)+rand.nextInt(3)+"/19"+rand.nextInt(10)+rand.nextInt(10);
				data_2 = rand.nextInt(3)+rand.nextInt(9)+"/"+rand.nextInt(2)+rand.nextInt(3)+"/19"+rand.nextInt(10)+rand.nextInt(10);
				
				licen.salvar(0, tipoLicenca[rand.nextInt(tipoLicenca.length)], new java.sql.Date(((formatter.parse(data))).getTime()), new java.sql.Date(((formatter.parse(data_2))).getTime()), ""+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)
						, "Observações: ", 1);
				
			}
			
			for (int i = 0; i < rand.nextInt(8)+1; i++) {
				
				data = rand.nextInt(3)+rand.nextInt(9)+"/"+rand.nextInt(2)+rand.nextInt(3)+"/19"+rand.nextInt(10)+rand.nextInt(10);
				data_2 = rand.nextInt(3)+rand.nextInt(9)+"/"+rand.nextInt(2)+rand.nextInt(3)+"/19"+rand.nextInt(10)+rand.nextInt(10);
				data_3 = rand.nextInt(3)+rand.nextInt(9)+"/"+rand.nextInt(2)+rand.nextInt(3)+"/19"+rand.nextInt(10)+rand.nextInt(10);
				data_4 = rand.nextInt(3)+rand.nextInt(9)+"/"+rand.nextInt(2)+rand.nextInt(3)+"/19"+rand.nextInt(10)+rand.nextInt(10);
				
				ferias.salvar(0, "DE "+data+" ATÉ "+data_2, "DE "+data_3+" ATÉ "+data_4, ""+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10), 1);	
				
			}
			
			/*** END - HISTORICO ****/
			
			/*** DEPENDENTES ***/
			
			for (int i = 0; i < rand.nextInt(5)+1; i++) {

				data = rand.nextInt(10)+rand.nextInt(10)+"/"+rand.nextInt(10)+rand.nextInt(10)+"/"+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10);
				data_2 = rand.nextInt(10)+rand.nextInt(10)+"/"+rand.nextInt(10)+rand.nextInt(10)+"/"+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10);
				data_3 = rand.nextInt(10)+rand.nextInt(10)+"/"+rand.nextInt(10)+rand.nextInt(10)+"/"+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10);
				
				dep.salvar(0, nomeFuncM.get(rand.nextInt(nomeFuncM.size()))+" "+sobreNomeFunc.get(rand.nextInt(sobreNomeFunc.size())), "FILHO(A)", new java.sql.Date(((formatter.parse(data))).getTime()), new java.sql.Date(((formatter.parse(data_2))).getTime()),
						new java.sql.Date(((formatter.parse(data_3))).getTime()), 1);	
				
			}
			
			/*** END - DEPENDENTES ***/
			
			j++;
									
		}
		
		
		
	}

	
	public static void main(String[] args) {
		try {
			
			new Carga();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	
		List<Carro> lista = new ArrayList<>();
		List<Cliente> list = new ArrayList<>();
		// TODO Auto-generated constructor stub
	
	public static void main(String[] args) {
		Menu obj = new Menu();
		
		obj.lerArquivo();
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		do {
			
			System.out.println("--------------------------------");
			System.out.println("1 - Funcionario:");
			System.out.println("2 - Cliente:");
			opcao = sc.nextInt();
			
			if(opcao==3){
				System.exit(0);
			}
			
			if(opcao==2) {
				
				System.out.println("2 - Efetuar Compra:");
				System.out.println("3 - Carros Disponivei:");
				System.out.println("5 - Sair");
				opcao = sc.nextInt();
				sc.nextLine();
			
			}
			if(opcao==1) {
			System.out.println("--------------------------------");
			System.out.println("1 - Cadastrar Carro:");
			System.out.println("3 - Carros Disponiveis:");
			System.out.println("6 - Cadastrar Cliente: ");
			System.out.println("7 - Exibir Clientes:");
			System.out.println("5 - Sair:");
			opcao = sc.nextInt();
			sc.nextLine();
			}
			switch(opcao) {
			case 1:
				obj.Cadastrar_Carro(sc);
				break;
			
			case 2:
				obj.Efetuar_Compra(sc);
				break;
			case 3: 
				obj.Carros_Disponiveis();
				break;
			case 6:
				obj.Cadastro_Cliente(sc);
				break;
			case 7:
				obj.Clientec();
				break;
		default:
			System.out.println("Opcao Invalida!!!!!!");
		
			}
			
			
		}while(opcao != 99);
		
		obj.escreverArquivo();
		
		
		
	}

	private void Efetuar_Compra(Scanner sc) {
		System.out.println("Informe o Nome do Veiculo:");
		String modelo = sc.nextLine();
		for (Carro exist : lista) {
			if (exist.getModelo().equals(modelo)) {
				lista.remove(exist);
				System.out.println("Compra concluida com sucesso!!!");
				break;
			}
		}
	}

private void Clientec() {
	for (Cliente cc : list){
		System.out.println(cc.getNome()+" " 
				+cc.getNascimento()+" " 
				+ cc.getCpf());
	}
	
}
private void Carros_Disponiveis() {
		for (Carro a : lista) {
			System.out.println(a.getModelo() + "  "
					 + a.getMarca()  + "  "
					 + a.getAno()  + "  "
					 + a.getPreco());
		}
	}

	private void Cadastrar_Carro(Scanner sc) {
		System.out.println("Cadastrar Carro");
		System.out.println("Marca:");
		String marca = sc.nextLine();
		System.out.println("Modelo:");
		String modelo = sc.nextLine();
		System.out.println("Ano:");
		int ano = sc.nextInt();
		System.out.println("Preco:");
		float preco = sc.nextFloat();
		sc.nextLine();
		
		Carro a = new Carro();
		a.setModelo(modelo);
		a.setMarca(marca);
		a.setPreco(preco);
		a.setAno(ano);
		lista.add(a);
		
	}
	private void Cadastro_Cliente(Scanner sc){
	
		System.out.println("Cadastro de Pessoas");
		System.out.println("Nome:");
		String nome = sc.nextLine();
		System.out.println("Nascimento:");
		String cpf = sc.nextLine();
		System.out.println("CPF:");
	String nascimento = sc.nextLine();
		sc.nextLine();
		Cliente cc = new Cliente();
		cc.setNome(nome);
		cc.setNascimento(nascimento);
		cc.setCpf(cpf);
		list.add(cc);
					
	}

	public void lerArquivoc() {
		try {
			FileReader fr = new FileReader("Cliente.csv");
			BufferedReader br = new BufferedReader(fr);
			String linec;
			while ( (linec = br.readLine()) != null ) {
				if (linec.trim().isEmpty()) {
					continue;
				}
				String[] str = linec.split(";");
			Cliente cc = new Cliente();
				cc.setNome(str[0]);
				cc.setNascimento(str[1]);
				cc.setCpf(str[2]);
				list.add(cc);
			}
		} catch (Exception ex) {
			System.out.println("Erro na leitura do arquivo:"
					+ ex.getMessage());
		}
	}
	
	public void escreverArquivoc() {
		try {
			FileWriter fw = new FileWriter("Cliente.csv");
			PrintWriter pw = new PrintWriter(fw);
			for (Cliente cc : list) {
				pw.println(cc.getNome() + ";"
					+ cc.getNascimento() + ";"
					+ cc.getCpf() + ";"
					);
			}
			pw.flush();
			pw.close();
		} catch (Exception ex) {
			System.out.println("Error na gravação do arquivo:" 
		           + ex.getMessage());
		}
	}
	
	public void lerArquivo() {
		try {
			FileReader fr = new FileReader("Carros.csv");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ( (line = br.readLine()) != null ) {
				if (line.trim().isEmpty()) {
					continue;
				}
				String[] str = line.split(";");
			Carro a = new Carro();
				a.setModelo(str[0]);
				a.setMarca(str[1]);
				a.setAno(Integer.parseInt(str[2]));
				a.setPreco(Float.parseFloat(str[3]));
				lista.add(a);
			}
		} catch (Exception ex) {
			System.out.println("Erro na leitura do arquivo:"
					+ ex.getMessage());
		}
	}
	
	public void escreverArquivo() {
		try {
			FileWriter fw = new FileWriter("Carros.csv");
			PrintWriter pw = new PrintWriter(fw);
			for (Carro a : lista) {
				pw.println(a.getMarca() + ";"
					+ a.getModelo() + ";"
					+ a.getAno() + ";"
					+ a.getPreco() + ";");
			}
			pw.flush();
			pw.close();
		} catch (Exception ex) {
			System.out.println("Error na gravação do arquivo:" 
		           + ex.getMessage());
		}
	}
	
}

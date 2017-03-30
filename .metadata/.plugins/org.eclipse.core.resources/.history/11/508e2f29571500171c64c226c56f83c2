package br.com.funcionarios;

import java.util.Scanner;

import org.omg.CORBA.portable.ApplicationException;

import br.com.operacoes.Cadastro;

public class Principal {

	public static void main(String[] args) {
		
	/*Cargo cargo = new Cargo();
	cargo.nome="Programador";
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	em.persist(cargo);
	tx.commit();
	em.close();
	emf.close();
	System.out.println("Cadastrado com sucesso");
	*/
	Scanner entrada = new Scanner(System.in);
	System.out.println("Selecione a opção" + "\n" + "1 - Cadastro" + "\n" + "2 - Remoção" + "\n" +"3 - Consulta");	
	String inicio = entrada.next();
	
	switch (inicio) {
	case "1":		
	Cadastro cad = new Cadastro();
	String op = "";
	System.out.println("Digite a função" + "\n" +"1 - cadastro de funcionario" + "\n" + "2 - Cadastro de cargo" + "\n" + "3 - Cadastro de departamento");
	op = entrada.next();
	
	
	while (!op.equals("0")){
			
	switch (op) {
	case "1":
		Funcionario funcionario = new Funcionario();
		System.out.println("Nome do funcionario");		
		funcionario.setNome(entrada.next());
		funcionario.setTelefone(entrada.next());
		cad.CadastroFuncionario(funcionario);
		break;
	case "2":
		Cargo cargo = new Cargo();
		System.out.println("Nome do cargo");
		cargo.setNome(entrada.next());
		System.out.println("Departamento");
		cargo.setId_departamento(entrada.nextInt());
		cad.CadastroCargo(cargo);
		break;
	case "3":
		Departamento dep = new Departamento();
	    System.out.println("Nome do departamento");
	    dep.setNome(entrada.next());
	    cad.CadastroDepartamento(dep);
	    break;
		}
	System.out.println("Digite a função" + "\n" +"1 - cadastro de funcionario" + "\n" + "2 - Cadastro de cargo" + "\n" + "3 - Cadastro de departamento");
	op = entrada.next();
	
	
		
	
	 
	}
	System.out.println("Opção invalida, programa encerrado");
	System.exit(0);
	break;
	case "2":
		// apagar dados 
		
	break;
	case "3":
		//consultar dados
	break;
		
	
	
	

	}
	
	}
}


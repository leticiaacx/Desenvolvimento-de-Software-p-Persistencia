package com.Spring.Contato.ui;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication(scanBasePackages = "com.Spring.Contato")
@EntityScan("com.Spring.Contato.entity")
//@EnableJpaRepositories("com.Spring.Contato.dao.jpa")
@EnableMongoRepositories("com.Spring.Contato.dao.mongo")
@Slf4j
public class MenuPrincipal implements CommandLineRunner {

    @Autowired
    private MenuContato menuContato;

    @Autowired
    private MenuCompromisso menuCompromisso;

    @Autowired
    private MenuCategoria menuCategoria;


    public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(MenuPrincipal.class);
		builder.headless(false).run(args);
	}

    @Override
	public void run(String... args) throws Exception {
		StringBuilder menu = new StringBuilder("Menu Principal\n")
			.append("1 - Contatos\n")
			.append("2 - COmpromissos\n")
			.append("3 - Categorias\n")
			.append("4 - Sair");
		char opcao = '0';
		do {
			try {
				opcao = JOptionPane.showInputDialog(menu).charAt(0);
				switch (opcao) {
					case '1':     // Contatos
						menuContato.menu();
						break;
					case '2':     // Produtos
						menuCompromisso.menu();
						break;
					case '3':     // Compras
						menuCategoria.menu();
						break;
					case '4':     // Sair
						break;
					default:
						JOptionPane.showMessageDialog(null, "Opção Inválida");
						break;
					}
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
			}

		} while(opcao != '4');
	}


}

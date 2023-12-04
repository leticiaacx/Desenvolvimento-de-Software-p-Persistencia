package com.Spring.Contato.ui;

import com.Spring.Contato.dao.CompromissoDAO;
import com.Spring.Contato.entity.Compromisso;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.swing.*;
import java.util.List;

@Slf4j
@Component
public class MenuCompromisso {
	@Autowired
	private CompromissoDAO compromissoDAO;

	public void obterCompromisso(Compromisso compro) {
		String titulo = JOptionPane.showInputDialog("Titulo", compro.getTitulo());
		String descricao = JOptionPane.showInputDialog("Descrição", compro.getDescricao());
		//LocalDate data = JOptionPane.showInputDialog("Data", compro.getData());
		String horaInicio = JOptionPane.showInputDialog("Hora Inicio", compro.getHoraInicio());
		String horaFim = JOptionPane.showInputDialog("Hora Inicio", compro.getHoraFim());
		compro.setTitulo(titulo);
		//compro.setData(data));
		compro.setHoraInicio(horaInicio);
		compro.setHoraFim(horaFim);
		compro.setDescricao(descricao);
	}

	public void listaCompromissos(List<Compromisso> compromissos) {
		StringBuilder listagem = new StringBuilder();
		for(Compromisso compro : compromissos) {
			listagem.append(compro).append("\n");
		}
		JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum compromisso encontrado" : listagem);
	}

	public void listaCompromisso(Compromisso compro) {
		JOptionPane.showMessageDialog(null, compro == null ? "Nenhum compromisso encontrado" : compro.toString());
	}

	public void menu() {
		StringBuilder menu = new StringBuilder("Menu Compromisso\n")
			.append("1 - Inserir\n")
			.append("2 - Atualizar por titulo\n")
			.append("3 - Remover por titulo\n")
			.append("4 - Exibir por titulo\n")
			.append("5 - Exibir todos\n")
			.append("6 - Exibir por id\n")
			.append("7 - Menu anterior");
		char opcao = '0';
		do {
			try {
				Compromisso compro;
				String titulo;
				opcao = JOptionPane.showInputDialog(menu).charAt(0);
				switch (opcao) {
					case '1':     // Inserir
						compro = new Compromisso();
						obterCompromisso(compro);
						compromissoDAO.save(compro);
						break;
					case '2':     // Atualizar por titulo
						titulo = JOptionPane.showInputDialog("Digite o titulo do compromisso a ser alterado");
						compro = compromissoDAO.findByTitulo(titulo).orElse(null);
						if (compro != null) {
							obterCompromisso(compro);
							compromissoDAO.save(compro);
						} else {
							JOptionPane.showMessageDialog(null, "Não foi possível atualizar, pois o titulo não foi encontrado.");
						}
						break;
					case '3':     // Remover por titulo
						titulo = JOptionPane.showInputDialog("Digite o titulo do compromisso a ser removido");
						compro = compromissoDAO.findByTitulo(titulo).orElse(null);
						if (compro != null) {
							compromissoDAO.deleteByTitulo(compro.getTitulo());
						} else {
							JOptionPane.showMessageDialog(null, "Não foi possível remover, pois o titulo não foi encontrado.");
						}
						break;
					case '4':     // Exibir por titulo
						titulo = JOptionPane.showInputDialog("Digite o titulo do produto a ser exibido");
						compro = compromissoDAO.findByTitulo(titulo).orElse(null);
						if (compro != null) {
							listaCompromisso(compro);
						} else {
							JOptionPane.showMessageDialog(null, "Não foi possível encontrar, pois o titulo não foi encontrado.");
						}
						break;
					case '5':     // Exibir todos
						listaCompromissos(compromissoDAO.findAll());
						break;
					case '6': // Exibir por id
                        try {
                            String compromissoId = JOptionPane
                                    .showInputDialog("Digite o ID do compromisso a ser exibido");
                            String id = compromissoId.replaceAll("[^0-9]", "");
                            compro = compromissoDAO.findById(id).orElse(null);
                            if (compro != null) {
                                listaCompromisso(compro);
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Não foi possível encontrar, pois o ID não foi encontrado.");
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Por favor, digite um número válido para o ID.");
                        }
                        break;
					case '7':     // Sair
						break;
					default:
						JOptionPane.showMessageDialog(null, "Opção Inválida");
						break;
				}
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
			}

		} while(opcao != '7');
	}
}
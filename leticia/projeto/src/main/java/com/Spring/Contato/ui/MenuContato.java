package com.Spring.Contato.ui;

import com.Spring.Contato.dao.ContatoDAO;
import com.Spring.Contato.entity.Contato;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.List;


@Slf4j
@Component
public class MenuContato {
    @Autowired
    private ContatoDAO contatoDAO;

    public void obterContato(Contato contato) {
        String nome = JOptionPane.showInputDialog("Nome", contato.getNome());
        String sobrenome = JOptionPane.showInputDialog("Sobrenome", contato.getSobrenome());
        String numero = JOptionPane.showInputDialog("Numero", contato.getNumero());
        String email = JOptionPane.showInputDialog("Email", contato.getEmail());
        String aniversario = JOptionPane.showInputDialog("Aniversario", contato.getAniversario());
        String cpf = JOptionPane.showInputDialog("CPF", contato.getCpf());

        contato.setNome(nome);
        contato.setSobrenome(sobrenome);
        contato.setNumero(numero);
        contato.setEmail(email);
        contato.setAniversario(aniversario);
        contato.setCpf(cpf);

    }

    public void listaContatos(List<Contato> contatos) {
        StringBuilder listagem = new StringBuilder();
        for (Contato co : contatos) {
            listagem.append(co.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum contato encontrado" : listagem);
    }

    public void listaContato(Contato co) {
        JOptionPane.showMessageDialog(null, co == null ? "Nenhum contato encontrado" : co.toString());
    }

    public void menu() {
        StringBuilder menu = new StringBuilder("Menu Contato\n")
                .append("1 - Inserir\n")
                .append("2 - Atualizar por CPF\n")
                .append("3 - Remover por CPF\n")
                .append("4 - Exibir por CPF\n")
                .append("5 - Exibir por numero\n")
                .append("6 - Exibir todos\n")
                .append("7 - Encontrar contatos por nome\n")
                .append("8 - Voltar ao menu anterior");

        char opcao = '0';
        do {
            try {
                Contato co;
                String cpf;
                String numero;
                opcao = JOptionPane.showInputDialog(menu).charAt(0);

                switch (opcao) {
                    case '1': // Inserir
                        co = new Contato();
                        obterContato(co);
                        contatoDAO.save(co);
                        break;
                    case '2': // Atualizar por CPF
                        cpf = JOptionPane.showInputDialog("Digite o CPF do cliente a ser alterado");
                        co = contatoDAO.findByCpf(cpf);
                        if (co != null) {
                            int escolha = Integer.parseInt(JOptionPane.showInputDialog("Deseja atualizar o cliente com CPF: " + cpf + "? (1 - Sim, 2 - Não)"));
                            if (escolha == 1) {
                                obterContato(co);
                                contatoDAO.save(co);
                                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Operação de atualização cancelada.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Não foi possível atualizar, pois o cliente não foi encontrado.");
                        }
                        break;
                    case '3': // Remover por CPF
                        cpf = JOptionPane.showInputDialog("CPF");
                        co = contatoDAO.findByCpf(cpf);
                        if (co != null) {
                            contatoDAO.delete(co);
                        } else {
                            JOptionPane.showMessageDialog(null, "Não foi possível remover, pois o cliente não foi encontrado.");
                        }
                        break;
                    case '4': // Exibir por CPF
                        cpf = JOptionPane.showInputDialog("CPF");
                        co = contatoDAO.findByCpf(cpf);
                        listaContato(co);
                        break;
                    case '5': // Exibir por numero
                        numero = JOptionPane.showInputDialog("Numero");
                        co = contatoDAO.findByNumero(numero);
                        listaContato(co);
                        break;
                    case '6': // Exibir todos
                        listaContatos(contatoDAO.findAll());
                        break;
                    case '7': // Encontrar contatos por nome (Consulta Nativa)
                        String nomeConsultaNativa = JOptionPane.showInputDialog("Nome");
                        List<Contato> contatosPorNomeNativa = contatoDAO.findByNome(nomeConsultaNativa);
                        listaContatos(contatosPorNomeNativa);
                        break;
                    case '8': // Voltar ao menu anterior
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida");
                        break;
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }

        } while (opcao != '8');
    }
}

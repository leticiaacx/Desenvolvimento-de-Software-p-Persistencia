package com.Spring.Contato.ui;

import com.Spring.Contato.dao.CategoriaDAO;
import com.Spring.Contato.entity.Categoria;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class MenuCategoria {

    @Autowired
    private CategoriaDAO categoriaDAO;

    public void obterCategoria(Categoria cate) {
        String nome = JOptionPane.showInputDialog("Nome", cate.getNome());
        String descricao = JOptionPane.showInputDialog("Descrição", cate.getDescricao());
        String numero = JOptionPane.showInputDialog("Numero", cate.getNumero());
        cate.setNome(nome);
        cate.setDescricao(descricao);
        cate.setNumero(numero);
    }

    public void listaCategorias(List<Categoria> categorias) {
        StringBuilder listagem = new StringBuilder();
        for (Categoria cate : categorias) {
            listagem.append(cate).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhuma categoria encontrada" : listagem);
    }

    public void listaCategoria(Categoria cate) {
        JOptionPane.showMessageDialog(null, cate == null ? "Nenhuma categoria encontrada" : cate);
    }

    public void menu() {
        StringBuilder menu = new StringBuilder("Menu Categoria\n")
                .append("1 - Inserir\n")
                .append("2 - Atualizar por nome\n")
                .append("3 - Remover por nome\n")
                .append("4 - Exibir por nome\n")
                .append("5 - Exibir todos\n")
                .append("6 - Exibir por id\n")
                .append("7 - Menu anterior");
        char opcao = '0';
        do {
            try {
                Categoria cate;
                String nome;
                opcao = JOptionPane.showInputDialog(menu).charAt(0);
                switch (opcao) {
                    case '1':     // Inserir
                        cate = new Categoria();
                        obterCategoria(cate);
                        categoriaDAO.save(cate);
                        break;
                    case '2':     // Atualizar por nome
                        nome = JOptionPane.showInputDialog("Digite o nome da categoria a ser alterado");
                        cate = categoriaDAO.findByNome(nome).orElse(null);
                        if (cate != null) {
                            obterCategoria(cate);
                            categoriaDAO.save(cate);
                        } else {
                            JOptionPane.showMessageDialog(null, "Não foi possível atualizar, pois o nome não foi encontrado.");
                        }
                        break;
                    case '3':     // Remover por nome
                        nome = JOptionPane.showInputDialog("Digite o nome da categoria a ser removido");
                        cate = categoriaDAO.findByNome(nome).orElse(null);
                        if (cate != null) {
                            categoriaDAO.deleteByNome(cate.getNome());
                        } else {
                            JOptionPane.showMessageDialog(null, "Não foi possível remover, pois o nome não foi encontrado.");
                        }
                        break;
                    case '4':     // Exibir por nome
                        nome = JOptionPane.showInputDialog("Digite o nome da categoria a ser exibido");
                        cate = categoriaDAO.findByNome(nome).orElse(null);
                        if (cate != null) {
                            listaCategoria(cate);
                        } else {
                            JOptionPane.showMessageDialog(null, "Não foi possível encontrar, pois o titulo não foi encontrado.");
                        }
                        break;
                    case '5':     // Exibir todos
                        listaCategorias(categoriaDAO.findAll());
                        break;
                    case '6':     // Exibir por id
                        String categoriaId = JOptionPane.showInputDialog("Categoria Id");
                        Optional<Categoria> categoriaOptional = categoriaDAO.findById(categoriaId);
                        if (categoriaOptional.isPresent()) {
                            Categoria categoria = categoriaOptional.get();
                            listaCategoria(categoria);
                        } else {
                            JOptionPane.showMessageDialog(null, "Nenhuma categoria encontrada");
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

        } while (opcao != '7');
    }
}

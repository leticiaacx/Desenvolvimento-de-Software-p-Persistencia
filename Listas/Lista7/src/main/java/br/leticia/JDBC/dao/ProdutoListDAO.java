package br.leticia.JDBC.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.leticia.JDBC.entity.Produto;

public class ProdutoListDAO implements ProdutoDAO {

	private List<Produto> Produtos;
	
	private static int idProximo = 1;
	
	
	public ProdutoListDAO() {
		this.Produtos = new ArrayList<Produto>();
	}
	
	public void save(Produto entity) {
		// Inserir um Produto se o id do objeto for 0.
		if (entity.getId() == 0) {
			entity.setId(idProximo++);
			Produtos.add(entity);
		// Alterar um Produto se o id não for 0.
		} else {
			int posicaoNaLista = findIndex(entity.getId());
			Produtos.set(posicaoNaLista, entity);
		}
	}

	public void delete(int id) {
		Produtos.remove(find(id));
	}

	public Produto find(int id) {
		for (Produto cl : this.Produtos) {
			if (cl.getId() == id) {
				return cl;
			}
		}
		return null;
	}

	private int findIndex(int id) {
		for (int i=0; i < Produtos.size(); i++) {
			if (Produtos.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}
	
	public List<Produto> find() {
		return this.Produtos;
	}

	public Produto findByCodigo(String cpf) {
		for (Produto cl : this.Produtos) {
			if (cl.getCodigo().equals(cpf)) {
				return cl;
			}
		}
		return null;
	}

	public List<Produto> findByDescricao(String str) {
		List<Produto> resultado = new ArrayList<Produto>();
		for (Produto cl : this.Produtos) {
			if (cl.getDescricao().toUpperCase().contains(str.toUpperCase())) {
				resultado.add(cl);
			}
		}
		return resultado;
	}

	public List<Produto> obterProdutosComPrecoMenorOuIgual(double precoMaximo) {
		List<Produto> resultado = new ArrayList<>();
		for (Produto produto : Produtos) {
			if (produto.getPreco() <= precoMaximo) {
				resultado.add(produto);
			}
		}
		return resultado;
	}
	
	public List<Produto> obterProdutosPorDataUltimaEntrada(Date dataInicial, Date dataFinal) {
		List<Produto> resultado = new ArrayList<>();
		for (Produto produto : Produtos) {
			if (produto.getDataUltimaEntrada().after(dataInicial) && produto.getDataUltimaEntrada().before(dataFinal)) {
				resultado.add(produto);
			}
		}
		return resultado;
	}
}

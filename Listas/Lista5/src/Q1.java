import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

// Classe de entidade Contato
class Contato implements Serializable {
    private String nome;
    private String sobrenome;
    private String endereco;
    private String numeroTelefone;

    public Contato(String nome, String sobrenome, String endereco, String numeroTelefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.numeroTelefone = numeroTelefone;
    }

    // Getters e setters (opcional)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    @Override
    public String toString() {
        return "Contato [nome=" + nome + ", sobrenome=" + sobrenome + ", endereco=" + endereco + ", numeroTelefone="
                + numeroTelefone + "]";
    }
}

// Classe que possui uma lista de Contatos
class ContatoList {
    private List<Contato> contatos = new ArrayList<>();

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
}

public class Q1{
    public static void main(String[] args) {
        ContatoList listaContatos = new ContatoList();

        Contato contato1 = new Contato("João", "Silva", "Rua A, 123", "123-456-7890");
        Contato contato2 = new Contato("Maria", "Santos", "Rua B, 456", "987-654-3210");

        listaContatos.adicionarContato(contato1);
        listaContatos.adicionarContato(contato2);

        List<Contato> contatos = listaContatos.getContatos();

        for (Contato contato : contatos) {
            System.out.println(contato);
        }
    }
}

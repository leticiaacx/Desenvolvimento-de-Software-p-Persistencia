import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.projeto.Contato;

public class ContatoDAO {
    private Connection connection;

    public ContatoDAO() {



        String url;  
        String usuario;
        String senha; 
        Connection con;

        Conexao(){
            url = "jdbc:postgresql://localhost:5432/Agenda";
            usuario = "postgres";
            senha = "1234";

            try {
                Class.forName(org.postgresql.Driver);
                con = DriverManager.getConnection(url, usuario, senha);
            } catch (Exception e) {
                // TODO: handle exception
            }
       
        }
    }

    public void fecharConexao() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void adicionarContato(Contato contato) {
        String sql = "INSERT INTO contatos (nome, sobrenome, numero, email, aniversario) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, contato.getNome());
            statement.setString(2, contato.getSobrenome());
            statement.setString(3, contato.getNumero());
            statement.setString(4, contato.getEmail());
            statement.setString(5, contato.getAniversario());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarContato(Contato contato) {
        String sql = "UPDATE contatos SET nome = ?, sobrenome = ?, numero = ?, email = ?, aniversario = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, contato.getNome());
            statement.setString(2, contato.getSobrenome());
            statement.setString(3, contato.getNumero());
            statement.setString(4, contato.getEmail());
            statement.setString(5, contato.getAniversario());
            statement.setInt(6, contato.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirContato(int id) {
        String sql = "DELETE FROM contatos WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Contato> obterTodosContatos() {
        List<Contato> contatos = new ArrayList<>();
        String sql = "SELECT * FROM contatos";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Contato contato = new Contato();
                contato.setId(resultSet.getInt("id"));
                contato.setNome(resultSet.getString("nome"));
                contato.setSobrenome(resultSet.getString("sobrenome"));
                contato.setNumero(resultSet.getString("numero"));
                contato.setEmail(resultSet.getString("email"));
                contato.setAniversario(resultSet.getString("aniversario"));
                contatos.add(contato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contatos;
    }
}

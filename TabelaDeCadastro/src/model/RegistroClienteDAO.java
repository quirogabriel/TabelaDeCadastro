package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RegistroClienteDAO {

    private Connection getConnection() throws Exception {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection(
                "jdbc:derby://localhost:1527/TRABALHO",
                "TRABALHO", "TRABALHO");
    }

    private Statement createStatement() throws Exception {
        return getConnection().createStatement();
    }

    private void closeStatement(Statement st) throws Exception {
        st.getConnection().close();
    }

    public List<RegistroCliente> obterTodos() {
        ArrayList<RegistroCliente> lista = new ArrayList<>();
        try {
            ResultSet r1 = createStatement().executeQuery("SELECT * FROM REGISTROCLIENTE");
            while (r1.next()) {
                lista.add(new RegistroCliente(r1.getInt("ID"),
                        r1.getString("NOME"),
                        r1.getString("ENDEREÇO"),
                        r1.getInt("TELEFONE"),
                        r1.getString("EMAIL"),
                        r1.getBoolean("STATUS")));
            }
            closeStatement(r1.getStatement());
        } catch (Exception e) {
        }
        return lista;
    }

    public RegistroCliente obter(int id) {
        RegistroCliente registro = null;
        try {
            ResultSet r1 = createStatement().executeQuery(
                    "SELECT * FROM REGISTROCLIENTE WHERE ID = " + id);
            if (r1.next()) {
                registro = new RegistroCliente(r1.getInt("ID"),
                        r1.getString("NOME"),
                        r1.getString("ENDEREÇO"),
                        r1.getInt("TELEFONE"),
                        r1.getString("EMAIL"),
                        r1.getBoolean("STATUS"));
            }
            closeStatement(r1.getStatement());
        } catch (Exception e) {
        }
        return registro;
    }

    public void excluir(int id) {
        try {
            Statement st = createStatement();
            st.executeUpdate("DELETE FROM REGISTROCLIENTE WHERE ID = "
                    + id);
            closeStatement(st);
        } catch (Exception e) {
        }
    }

    public void incluir(RegistroCliente r) {
        try {
            PreparedStatement ps = getConnection().prepareStatement(
                    "INSERT INTO REGISTROCLIENTE (ID, NOME, ENDEREÇO, TELEFONE, EMAIL, STATUS) VALUES(?,?,?,?,?,?)");
            ps.setInt(1, r.getId());
            ps.setString(2, r.getNome());
            ps.setString(3, r.getEndereço());
            ps.setInt(4, r.getTelefone());
            ps.setString(5, r.getEmail());
            ps.setBoolean(6, r.getStatus());
            ps.executeUpdate();
            closeStatement(ps);
        } catch (Exception e) {
        }
    }

    public void alterar(RegistroCliente r) {
        try {
            PreparedStatement ps = getConnection().prepareStatement(
                    "UPDATE REGISTROCLIENTE SET NOME=?, ENDEREÇO=?, TELEFONE=?, EMAIL=?, STATUS=? WHERE ID=?");
            ps.setString(1, r.getNome());
            ps.setString(2, r.getEndereço());
            ps.setInt(3, r.getTelefone());
            ps.setString(4, r.getEmail());
            ps.setBoolean(5, r.getStatus());
            ps.setInt(6, r.getId());
            ps.executeUpdate();
            closeStatement(ps);
        } catch (Exception e) {
        }
    }
    
}

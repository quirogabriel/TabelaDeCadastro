package control;

import java.util.List;
import model.RegistroCliente;
import model.RegistroClienteDAO;

public class RegistroClienteControle {

    private static final RegistroClienteDAO dao = new RegistroClienteDAO();

    public static void incluir(RegistroCliente r) throws Exception {
        if (r.getTelefone() < 0) {
            throw new Exception("Telefone inválido");
        }
        if (r.getId() < 1) {
            throw new Exception("Id inválido");
        }
        dao.incluir(r);
    }

    public static void excluir(int id) throws Exception {
        RegistroCliente r = dao.obter(id);
        if (r != null && r.getStatus() == true) {
            throw new Exception("Cliente ainda ativo no sistema");
        }
        if (r == null) {
            throw new Exception("Cliente inexistente");
        }
        dao.excluir(id);
    }

    public static List<RegistroCliente> obterTodos() {
        return dao.obterTodos();
    }

    public static void alterar(int id, RegistroCliente r) throws Exception {
        RegistroCliente i = dao.obter(id);
        if (i == null) {
            throw new Exception("Cliente inexistente");
        }
        if (r.getId() < 1) {
            throw new Exception("Id inválido");
        }       
        if (r.getTelefone() <= 0) {
            throw new Exception("Telefone inválido");
        }        
        if ("".equals(r.getNome())) {
            throw new Exception("Nome inválido");
        }       
        if ("".equals(r.getEndereço())) {
            throw new Exception("Endereço inválido");
        }        
        if ("".equals(r.getEmail())) {
            throw new Exception("Email inválido");
        }       
        
        dao.alterar(r);
    }
}

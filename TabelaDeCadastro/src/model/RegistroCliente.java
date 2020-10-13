package model;

public class RegistroCliente {
    
    private int id;
    private String nome;
    private String endereço;
    private int telefone;
    private String email;
    private boolean status;


    public RegistroCliente() {

    }
    
    public RegistroCliente (int id, String nome, String endereço, int telefone, String email, boolean status ) {
        
        this.id = id;
        this.telefone = telefone;
        this.nome = nome;
        this.endereço = endereço;
        this.email = email;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}

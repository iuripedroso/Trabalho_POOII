package trabalhopoo.poo.model;

public class Departamento {
    private int departamentoID;
    private String nome;

    public Departamento() {}

    public Departamento(int departamentoID, String nome) {
        this.departamentoID = departamentoID;
        this.nome = nome;
    }

    public int getDepartamentoID() {
        return departamentoID;
    }

    public void setDepartamentoID(int departamentoID) {
        this.departamentoID = departamentoID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "departamentoID=" + departamentoID +
                ", nome='" + nome + '\'' +
                '}';
    }
}

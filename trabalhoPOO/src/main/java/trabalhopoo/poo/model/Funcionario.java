package trabalhopoo.poo.model;

public class Funcionario {
    private int funcionarioID;
    private String nome;
    private Departamento departamento;

    public Funcionario() {}

    public Funcionario(int funcionarioID, String nome, Departamento departamento) {
        this.funcionarioID = funcionarioID;
        this.nome = nome;
        this.departamento = departamento;
    }

    public int getFuncionarioID() {
        return funcionarioID;
    }

    public void setFuncionarioID(int funcionarioID) {
        this.funcionarioID = funcionarioID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "funcionarioID=" + funcionarioID +
                ", nome='" + nome + '\'' +
                ", departamento=" + departamento.getNome() +
                '}';
    }
}

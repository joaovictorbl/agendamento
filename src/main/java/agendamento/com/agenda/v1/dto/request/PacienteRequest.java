package agendamento.com.agenda.v1.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class PacienteRequest {

    @NotBlank(message = "Nome obrigatorio.")
    private String nome;

    @NotBlank(message = "CPF obrigatorio.")
    private String cpf;
    @Email(message = "Email invalido.")
    private String email;

    public PacienteRequest() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

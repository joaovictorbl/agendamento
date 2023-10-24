package agendamento.com.agenda.v1.exception.handle;

import java.time.LocalDateTime;

public class DefaultException {


    private Integer status;
    private String mensagem;
    private LocalDateTime dataAgora;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataAgora() {
        return dataAgora;
    }

    public void setDataAgora(LocalDateTime dataAgora) {
        this.dataAgora = dataAgora;
    }
}

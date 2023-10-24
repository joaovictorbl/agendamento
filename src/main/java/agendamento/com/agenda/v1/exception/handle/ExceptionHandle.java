package agendamento.com.agenda.v1.exception.handle;

import agendamento.com.agenda.v1.exception.JaCadastradoExcepetion;
import agendamento.com.agenda.v1.exception.NaoCadastradoExcepetion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.security.PublicKey;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(JaCadastradoExcepetion.class)
    public ResponseEntity<DefaultException> jaCadastrado(JaCadastradoExcepetion exception) {
        DefaultException defaultException = new DefaultException();
        defaultException.setMensagem(exception.getMessage());
        defaultException.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        defaultException.setDataAgora(LocalDateTime.now());

        return ResponseEntity.status(defaultException.getStatus()).body(defaultException);
    }

    @ExceptionHandler(NaoCadastradoExcepetion.class)
    public ResponseEntity<DefaultException> naoCadastrado(NaoCadastradoExcepetion excepetion) {
        DefaultException defaultException = new DefaultException();
        defaultException.setMensagem(excepetion.getMessage());
        defaultException.setStatus(HttpStatus.NO_CONTENT.value());
        defaultException.setDataAgora(LocalDateTime.now());

        return ResponseEntity.status(defaultException.getStatus()).body(defaultException);
    }
}

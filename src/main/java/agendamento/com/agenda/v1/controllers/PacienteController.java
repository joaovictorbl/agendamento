package agendamento.com.agenda.v1.controllers;

import agendamento.com.agenda.v1.domain.Paciente;
import agendamento.com.agenda.v1.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping
    public ResponseEntity<Paciente> salvarPaciente(@RequestBody Paciente paciente){

        Paciente pacienteNovo = service.salvar(paciente);

        return ResponseEntity.status(HttpStatus.CREATED).body(paciente);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos () {
        List<Paciente> listarTodos = service.listarTodods();
        return ResponseEntity.status(HttpStatus.OK).body(listarTodos);
    }
}

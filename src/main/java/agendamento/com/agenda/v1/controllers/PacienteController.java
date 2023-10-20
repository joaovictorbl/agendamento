package agendamento.com.agenda.v1.controllers;

import agendamento.com.agenda.v1.domain.Paciente;
import agendamento.com.agenda.v1.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping
    public ResponseEntity<Paciente> salvarPaciente(@RequestBody Paciente paciente){

        Paciente pacienteNovo = service.salvar(paciente);

        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteNovo);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos () {
        List<Paciente> listarTodos = service.listarTodods();
        return ResponseEntity.status(HttpStatus.OK).body(listarTodos);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Optional<Paciente>> buscarPorCPF(@PathVariable String cpf) {
        Optional<Paciente> buscarPaciente = service.buscarPorCPF(cpf);

        if (buscarPaciente.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(buscarPaciente);
    }

    @PatchMapping
    public ResponseEntity<Paciente> atualizarPacinete(@RequestBody Paciente paciente) {
        Paciente pacienteAtualizado = service.salvar(paciente);
        return ResponseEntity.ok().body(pacienteAtualizado);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable Long id) {
        service. deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

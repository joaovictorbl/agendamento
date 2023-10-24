package agendamento.com.agenda.v1.controllers;

import agendamento.com.agenda.v1.domain.Paciente;
import agendamento.com.agenda.v1.dto.request.PacienteRequest;
import agendamento.com.agenda.v1.dto.response.PacienteResponse;
import agendamento.com.agenda.v1.mapper.PacienteMapper;
import agendamento.com.agenda.v1.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping
    public ResponseEntity<PacienteResponse> salvarPaciente(@RequestBody PacienteRequest request){

        Paciente paciente = PacienteMapper.toPaciente(request);

        Paciente pacienteNovo = service.salvar(paciente);

        PacienteResponse response = PacienteMapper.toPacienteResponse(pacienteNovo);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponse>> listarTodos () {
        List<Paciente> listarTodos = service.listarTodods();
        List<PacienteResponse> listaResponse = PacienteMapper.toPacienteResponseList(listarTodos);
        return ResponseEntity.status(HttpStatus.OK).body(listaResponse);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Optional<PacienteResponse>> buscarPorCPF(@PathVariable String cpf) {

      Optional<Paciente> optionalPaciente = service.buscarPorCPF(cpf);
      if (optionalPaciente.isPresent()) {
          Paciente paciente = optionalPaciente.get();
          PacienteResponse response = PacienteMapper.toPacienteResponse(paciente);
          return ResponseEntity.ok().body(Optional.of(response));
      }else {
          return ResponseEntity.notFound().build();
      }
    }

    @PatchMapping
    public ResponseEntity<PacienteResponse> atualizarPacinete(@RequestBody PacienteRequest request) {

        Paciente paciente = PacienteMapper.toPaciente(request);
        Paciente pacienteNovo = service.salvar(paciente);
        PacienteResponse response = PacienteMapper.toPacienteResponse(pacienteNovo);
        return ResponseEntity.ok().body(response);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable Long id) {
        service. deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

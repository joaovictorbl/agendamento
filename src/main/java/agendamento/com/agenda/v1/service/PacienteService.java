package agendamento.com.agenda.v1.service;

import agendamento.com.agenda.v1.domain.Paciente;
import agendamento.com.agenda.v1.exception.businessExcepetion;
import agendamento.com.agenda.v1.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public Paciente salvar(Paciente paciente) {

        Boolean existeCPF = false;
        Optional<Paciente> base = repository.findByCpf(paciente.getCpf());

        if (base.isPresent()){
            if (!base.get().getId().equals(paciente.getId())){
                existeCPF = true;
            }
        }

        if (existeCPF){
            throw new businessExcepetion("Paciente já cadastrado!");
        }


        return repository.save(paciente);
    }

    public List<Paciente> listarTodods(){
        return repository.findAll();
    }

    public Optional<Paciente> buscarPorID(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

}

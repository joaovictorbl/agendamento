package agendamento.com.agenda.v1.service;

import agendamento.com.agenda.v1.domain.Paciente;
import agendamento.com.agenda.v1.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;



    public Object salvar(Paciente paciente) {

        if (repository.buscarCPF(paciente.getCpf())){
            return new RuntimeException("CPF JÁ EXISTE");
        }

        return repository.save(paciente)
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

    public String buscarPornome(Paciente paciente){
        return repository.BuscarPorNome(paciente.getNome());
    }
}

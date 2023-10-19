package agendamento.com.agenda.v1.service;

import agendamento.com.agenda.v1.domain.Paciente;
import agendamento.com.agenda.v1.exception.businessExcepetion;
import agendamento.com.agenda.v1.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional /* Anotação que impede quando algum de errado não concletiza a TRANSAÇÃO*/
public class PacienteService {

    //TODO: inserir logs
    //TODO: melhorar metodo de validação de email é cpf
    //TODO: melhorar exeçoes com hedler

    @Autowired
    private PacienteRepository repository;

    public Paciente salvar(Paciente paciente) {

        Boolean variavelDeControle = false;
        Optional<Paciente> baseDeDados = repository.findByCpf(paciente.getCpf());

        if (baseDeDados.isPresent()){
            if (!baseDeDados.get().getId().equals(paciente.getId())){
                variavelDeControle = true;
            }
        }

        baseDeDados = repository.findByEmail(paciente.getEmail());

        if (baseDeDados.isPresent()){
            if (!baseDeDados.get().getId().equals(paciente.getId())){
                variavelDeControle = true;
            }
        }

        if (variavelDeControle){
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

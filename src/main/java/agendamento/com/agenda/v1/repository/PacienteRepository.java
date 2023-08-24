package agendamento.com.agenda.v1.repository;

import agendamento.com.agenda.v1.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    String BuscarPorNome(String nome);

    Boolean buscarCPF(String cpf);
}

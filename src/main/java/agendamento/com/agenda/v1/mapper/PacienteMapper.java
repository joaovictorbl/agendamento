package agendamento.com.agenda.v1.mapper;

import agendamento.com.agenda.v1.domain.Paciente;
import agendamento.com.agenda.v1.dto.request.PacienteRequest;
import agendamento.com.agenda.v1.dto.response.PacienteResponse;

public class PacienteMapper {

    public static Paciente toPaciente(PacienteRequest request) {

        Paciente paciente = new Paciente();
        paciente.setNome(request.getNome());
        paciente.setCpf(request.getCpf());
        paciente.setEmail(request.getEmail());
        return paciente;
    }

    public static PacienteResponse toPacienteResponse(Paciente paciente) {

        PacienteResponse response = new PacienteResponse();

        response.setNome(paciente.getCpf());
        response.setCpf(paciente.getCpf());
        response.setEmail(paciente.getEmail());
        return response;
    }
}

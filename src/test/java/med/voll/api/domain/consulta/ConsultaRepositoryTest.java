package med.voll.api.domain.consulta;


import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.domain.endereco.DadosEndereco;
import med.voll.api.domain.medico.Especialidade;
import med.voll.api.domain.paciente.DadosCadastroPaciente;
import med.voll.api.domain.medico.DadosCadastroMedico;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)  // Usando H2 como banco de dados em memória
@ExtendWith(SpringExtension.class)
public class ConsultaRepositoryTest {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;  // Presumindo que você tem o repositório de paciente

    @Autowired
    private MedicoRepository medicoRepository;  // Presumindo que você tem o repositório de médico

    @Test
    void deveRetornarTrueQuandoExistirConsultaNoHorario() {
        // Arrange
        DadosEndereco enderecoPaciente = new DadosEndereco("Rua A", "Bairro B", "12345678", "Cidade C", "Estado D", "123", "Apto 101");
        DadosCadastroPaciente dadosPaciente = new DadosCadastroPaciente("Paciente Teste", "paciente@teste.com", "123456789", "123.456.789-00", enderecoPaciente);
        Paciente paciente = new Paciente(dadosPaciente);
        pacienteRepository.save(paciente);

        DadosEndereco enderecoMedico = new DadosEndereco("Rua X", "Bairro Y", "98765432", "Cidade Z", "Estado W", "456", "Sala 2");
        DadosCadastroMedico dadosMedico = new DadosCadastroMedico("Dr. Teste", "medico@teste.com", "987654321", "12345", Especialidade.CARDIOLOGIA, enderecoMedico);
        Medico medico = new Medico(dadosMedico);
        medicoRepository.save(medico);

        LocalDateTime dataConsulta = LocalDateTime.of(2025, 1, 20, 10, 0);
        Consulta consulta = new Consulta(null, medico, paciente, dataConsulta);
        consultaRepository.save(consulta);

        // Act
        Boolean consultaExistente = consultaRepository.existsByPacienteIdAndDataBetween(
                paciente.getId(),
                LocalDateTime.of(2025, 1, 20, 9, 0),
                LocalDateTime.of(2025, 1, 20, 11, 0)
        );

        // Assert
        assertTrue(consultaExistente);
    }

    @Test
    void deveRetornarFalseQuandoNaoExistirConsultaNoHorario() {
        // Arrange
        DadosEndereco enderecoPaciente = new DadosEndereco("Rua A", "Bairro B", "12345678", "Cidade C", "Estado D", "123", "Apto 101");
        DadosCadastroPaciente dadosPaciente = new DadosCadastroPaciente("Paciente Teste", "paciente@teste.com", "123456789", "123.456.789-00", enderecoPaciente);
        Paciente paciente = new Paciente(dadosPaciente);
        pacienteRepository.save(paciente);

        DadosEndereco enderecoMedico = new DadosEndereco("Rua X", "Bairro Y", "98765432", "Cidade Z", "Estado W", "456", "Sala 2");
        DadosCadastroMedico dadosMedico = new DadosCadastroMedico("Dr. Teste", "medico@teste.com", "987654321", "12345", Especialidade.DERMATOLOGIA, enderecoMedico);
        Medico medico = new Medico(dadosMedico);
        medicoRepository.save(medico);

        LocalDateTime dataConsulta = LocalDateTime.of(2025, 1, 20, 10, 0);
        Consulta consulta = new Consulta(null, medico, paciente, dataConsulta);
        consultaRepository.save(consulta);

        // Act
        Boolean consultaExistente = consultaRepository.existsByPacienteIdAndDataBetween(
                paciente.getId(),
                LocalDateTime.of(2025, 1, 20, 12, 0),
                LocalDateTime.of(2025, 1, 20, 14, 0)
        );

        // Assert
        assertFalse(consultaExistente);
    }
}

package med.voll.api.domain.consulta.validacoes;

import static org.junit.jupiter.api.Assertions.*;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.Especialidade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ValidadorHorarioFuncionamentoClinicaTest {

    @InjectMocks
    private ValidadorHorarioFuncionamentoClinica validador;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void validar_ConsultaDentroDoHorario_NaoDeveLancarExcecao() {
        // Cenário
        DadosAgendamentoConsulta dados = criarDadosAgendamentoConsulta(LocalDateTime.of(2023, 6, 1, 9, 0)); // Segunda-feira, 9:00

        // Execução
        validador.validar(dados);

        // Verificação
        // Nenhuma exceção deve ser lançada
    }

    @Test
    void validar_ConsultaForaDoHorario_LancaValidacaoException() {
        // Cenário
        DadosAgendamentoConsulta dados = criarDadosAgendamentoConsulta(LocalDateTime.of(2023, 6, 1, 19, 0)); // Segunda-feira, 19:00

        // Execução e Verificação
        assertThrows(ValidacaoException.class, () -> validador.validar(dados));
    }

    @Test
    void validar_ConsultaNoDomingo_LancaValidacaoException() {
        // Cenário
        DadosAgendamentoConsulta dados = criarDadosAgendamentoConsulta(LocalDateTime.of(2023, 6, 4, 10, 0)); // Domingo, 10:00

        // Execução e Verificação
        assertThrows(ValidacaoException.class, () -> validador.validar(dados));
    }

    private DadosAgendamentoConsulta criarDadosAgendamentoConsulta(LocalDateTime data) {
        return new DadosAgendamentoConsulta(
                1L,               // idMedico (opcional, pode ser null dependendo do caso)
                1L,               // idPaciente
                data,             // data da consulta
                Especialidade.CARDIOLOGIA // Especialidade (exemplo, pode ser ajustado conforme necessidade)
        );
    }

    @Test
    void naoDeveLancarExcecaoQuandoConsultaForExatamenteAs7Horas() {
        // Arrange
        LocalDateTime as7Horas = LocalDateTime.of(2025, 1, 20, 7, 0);
        DadosAgendamentoConsulta dados = criarDadosAgendamentoConsulta(as7Horas);

        // Act & Assert
        assertDoesNotThrow(() -> validador.validar(dados));
    }

    @Test
    void naoDeveLancarExcecaoQuandoConsultaForExatamenteAs18Horas() {
        // Arrange
        LocalDateTime as18Horas = LocalDateTime.of(2025, 1, 20, 18, 0);
        DadosAgendamentoConsulta dados = criarDadosAgendamentoConsulta(as18Horas);

        // Act & Assert
        assertDoesNotThrow(() -> validador.validar(dados));
    }

    @Test
    void deveLancarExcecaoQuandoDataForNula() {
        // Arrange
        DadosAgendamentoConsulta dados = new DadosAgendamentoConsulta(
                1L, 1L, null, Especialidade.CARDIOLOGIA
        );

        // Act & Assert
        assertThrows(NullPointerException.class, () -> validador.validar(dados));
    }

    @Test
    void deveLancarExcecaoQuandoConsultaNoSabadoForaDoHorario() {
        // Arrange
        LocalDateTime sabadoAposHorario = LocalDateTime.of(2025, 1, 25, 19, 0);
        DadosAgendamentoConsulta dados = criarDadosAgendamentoConsulta(sabadoAposHorario);

        // Act & Assert
        ValidacaoException exception = assertThrows(ValidacaoException.class,
                () -> validador.validar(dados));

        assertEquals("Consulta fora ado hora´rio de funcionamento da clinica", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoConsultaForAs18h01() {
        // Arrange
        LocalDateTime as18h01 = LocalDateTime.of(2025, 1, 20, 18, 1);
        DadosAgendamentoConsulta dados = criarDadosAgendamentoConsulta(as18h01);

        // Act & Assert
        ValidacaoException exception = assertThrows(ValidacaoException.class,
                () -> validador.validar(dados));

        assertEquals("Consulta fora ado hora´rio de funcionamento da clinica", exception.getMessage());
    }

}
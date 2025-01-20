package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroMedico(
        //Utilizando o Bean Validation


        @NotBlank(message = "Nome é obrigatório") //Verifica se não é nulo nem vazio. NotBlank só é para String
        String nome,
        @NotBlank(message = "email é obrigatório")
        @Email //Verifica se é formato de email
        String email,
        @NotBlank(message = "telefone é obrigatório")
        String telefone,
        @NotBlank(message = "crm é obrigatório")
        @Pattern(regexp = "\\d{4,6}") //O crm tem de 4 a 6 digitos, Pattern utilizado para expressão regular
        String crm,
        @NotNull(message = "Especialidade é obrigatória")
        Especialidade especialidade,
        @NotNull(message = "endereco é obrigatório")
        @Valid DadosEndereco endereco) { //@Valid pra validar DadosEndereco, outro DTO dentro de DAdosCadastroMedico
}

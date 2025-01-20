package med.voll.api.domain.medico;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

//Long é o tipo de atributo da chave primária
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByActiveTrue(Pageable paginacao);

    @Query("""
            select m from Medico m 
            where
            m.active = true
            and
            m.especialidade = :especialidade
            and
            m.id not in(
                select c.medico.id from Consulta c
                where
                c.data = :data
            )
            order by rand()
            limit 1
            """)
    Medico escolherMedicoAleatorioLivreNaData(Especialidade especialidade, @NotNull @Future LocalDateTime data);

    @Query("""
            select m.active
            from Medico m
            where
            m.id = :id
            """)
    boolean findAtivoById(Long id);
}


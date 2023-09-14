package br.ufpb.dcx.lab.dto;

import br.ufpb.dcx.lab.entities.Disciplina;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class DisciplinaDTO implements Serializable {
    @NotBlank(message = "O campo (Nome) não pode estar vazio.")
    @Size(min = 4, max = 30, message = "O campo nome precisa ter entre 4 e 30 caracteres.")
    @Column(unique = true)
    private String nome;

    public DisciplinaDTO(Disciplina disciplina) {
        this.nome = disciplina.getNome();
    }
}

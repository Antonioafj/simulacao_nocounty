package br.com.appbit.appbit.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CandidatoSkillId implements Serializable {

    private static final long serialVersionUID = 1L;


    @Column(name = "candidato_id")
    private Integer candidatoId;

    @Column(name = "skill_id")
    private Integer skillId;

}

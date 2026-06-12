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
public class VagaSkillId implements Serializable {

    private static final long serialVersionUID = 1L;


    @Column(name = "vaga_id")
    private Integer vagaId;

    @Column(name = "skill_id")
    private Integer skillId;

}

package br.com.appbit.appbit.repositories;

import br.com.appbit.appbit.entities.CandidatoSkillEntity;
import br.com.appbit.appbit.entities.CandidatoSkillId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoSkillRepository extends JpaRepository<CandidatoSkillEntity, CandidatoSkillId> {
}

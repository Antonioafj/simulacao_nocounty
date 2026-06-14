package br.com.appbit.appbit.services;

import br.com.appbit.appbit.dtos.*;
import br.com.appbit.appbit.entities.CandidatoEntity;
import br.com.appbit.appbit.entities.RegiaoEntity;
import br.com.appbit.appbit.mappers.CandidatoMapper;
import br.com.appbit.appbit.repositories.CandidatoRepository;
import br.com.appbit.appbit.repositories.RegiaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidatoService {

    private final CandidatoRepository candidatoRepository;

    private final RegiaoRepository regiaoRepository;


    private final CandidatoMapper candidatoMapper;

    public CandidatoResponseDTO createCandidato(CandidatoCreateDTO createDTO){


        RegiaoEntity regiao = regiaoRepository.findById(createDTO.regiaoId()).orElse(null);

        if (regiao == null){
            throw new RuntimeException("Regiao Não Encontrada");
        }


        CandidatoEntity candidato = candidatoMapper.toEntity(createDTO);

        candidato.setRegiao(regiao);

        CandidatoEntity candidatoSave = candidatoRepository.save(candidato);

        return candidatoMapper.toResponseDTO(candidatoSave);
    }

    public List<CandidatoResponseDTO> listAllCandidato(){
        List<CandidatoEntity> candidatoList = candidatoRepository.findAll();
        List<CandidatoResponseDTO> candidatoResponseDTOS = new ArrayList<>();

        for (CandidatoEntity candidato : candidatoList) {

            CandidatoResponseDTO responseDTO= candidatoMapper.toResponseDTO(candidato);

            candidatoResponseDTOS.add(responseDTO);
        }
        return candidatoResponseDTOS;
    }

    public CandidatoResponseDTO getCandidatoById(Integer candidatoId){

        CandidatoEntity candidato = candidatoRepository.findById(candidatoId).orElse(null);

        if (candidato == null){
            throw  new RuntimeException("Candidato não encontrado");
        }

        CandidatoResponseDTO responseDTO = candidatoMapper.toResponseDTO(candidato);

        return responseDTO;
    }

    public CandidatoResponseDTO updateCandidatoById(CandidatoUpdateDTO updateDTO, Integer candidatoId){

        CandidatoEntity candidato = candidatoRepository.findById(candidatoId).orElse(null);

        if (candidato == null){
            throw  new RuntimeException("Candidato não encontrado");
        }

        RegiaoEntity regiao = regiaoRepository.findById(updateDTO.regiaoId()).orElse(null);

        if (regiao == null){
            throw new RuntimeException("Regiao Não Encontrado");
        }

        candidato.setNome(updateDTO.nome());
        candidato.setCargo(updateDTO.cargo());
        candidato.setNivel(updateDTO.nivel());
        candidato.setCluster(updateDTO.cluster());
        candidato.setMunicipio(updateDTO.municipio());
        candidato.setGrupo(updateDTO.grupo());
        candidato.setDiversidade(updateDTO.diversidade());
        candidato.setDisponibilidade(updateDTO.disponibilidade());
        candidato.setAtivo(updateDTO.ativo());
        candidato.setRegiao(regiao);

        CandidatoEntity candidatoAtualizada =   candidatoRepository.save(candidato);

        return candidatoMapper.toResponseDTO(candidatoAtualizada);
    }

    public void deleteCandidatoById( Integer candidatoId ){

        CandidatoEntity candidato = candidatoRepository.findById(candidatoId).orElse(null);

        if (candidato == null){

            throw  new RuntimeException("Candidato não encontrado");
        }

        candidatoRepository.delete(candidato);
    }
}

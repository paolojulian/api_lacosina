package com.lacosina.api.Procedure;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProcedureService {

    private final ProcedureRepository procedureRepository;

    public ProcedureService(ProcedureRepository procedureRepository){
        this.procedureRepository = procedureRepository;
    }

    @Transactional
    public Procedure createProcedure(final String name, final String description, final String image,final int duration){
        final Procedure procedure = new Procedure(name,description,image,duration);
        return this.procedureRepository.save(procedure);
    }

    @Transactional
    public Procedure updateProcedure(final int id, Procedure procedure){
        Procedure procedureUpdate = this.procedureRepository.findById(id).orElseThrow();
        procedureUpdate.setDescription(procedure.getDescription());
        procedureUpdate.setProcedureName(procedure.getProcedureName());
        procedureUpdate.setDurationInSeconds(procedure.getDurationInSeconds());
        return this.procedureRepository.save(procedureUpdate);
    }

    @Transactional
    public Procedure getProcedure(final int id){
        return this.procedureRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Boolean deleteProcedure(final int id) {
        try {
            this.procedureRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

package com.lacosina.api.Procedure;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcedureMutation implements GraphQLMutationResolver {

    @Autowired
    private ProcedureService procedureService;

    public Procedure createProcedure(final String name, final String description, final String image,final int duration) {
        return this.procedureService.createProcedure(name,description,image,duration);
    }

    public Procedure createProcedure(final String name, final String description,final int duration) {
        //optional category
        return this.procedureService.createProcedure(name,description,"",duration);
    }

    public Procedure updateProcedure(Integer id, Procedure procedure) {
        return this.procedureService.updateProcedure(id, procedure);
    }

    public Boolean deleteProcedure(Integer id) { return this.procedureService.deleteProcedure(id); }
}

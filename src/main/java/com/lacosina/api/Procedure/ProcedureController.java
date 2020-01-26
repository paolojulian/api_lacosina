package com.lacosina.api.Procedure;

import com.lacosina.api.Profile.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/procedures")
public class ProcedureController {

    @Autowired
    private ProcedureService procedureService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Procedure createProcedure(@Valid @RequestBody Procedure procedure) {
        return this.procedureService.createProcedure(procedure);
    }

    @PutMapping("/{id}")
    public Procedure updateProcedure(
            @RequestParam(name = "id") int id,
            @Valid @RequestBody Procedure procedure
    ) {
        return this.procedureService.updateProcedure(id, procedure);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteProcedure(@RequestParam(name = "id") final int id) { return this.procedureService.deleteProcedure(id); }
}

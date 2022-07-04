package com.j2ee.sorties.controllers;

import com.j2ee.sorties.entities.Type;
import com.j2ee.sorties.services.TypeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/types")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @RequestMapping(method = RequestMethod.PUT)
    public Type createOrUpdate(@RequestBody @Valid Type type) {
        return typeService.createOrUpdate(type);
    }

    @RequestMapping(path = "/{typename}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Type get(@PathVariable(name = "typename") String typename) {
        return typeService.getUserById(typename);
    }

    @Operation(summary = "Récupération de tous les types")
    @RequestMapping(path = "/_all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Type> getAllUsers() {
        return typeService.getAllTypes();
    }

    @RequestMapping(path = "/{typename}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(name = "typename") String typename) {
        typeService.deleteType(typename);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Type> getUsers(Pageable pageable) {
        return typeService.getTypesWithPaging(pageable);
    }
}

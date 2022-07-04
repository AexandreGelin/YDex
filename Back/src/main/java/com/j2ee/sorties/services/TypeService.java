package com.j2ee.sorties.services;

import java.util.List;
import java.util.Optional;

import com.j2ee.sorties.dto.exceptions.ResourceNotFoundException;
import com.j2ee.sorties.entities.Type;
import com.j2ee.sorties.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class TypeService  {
    @Autowired
    private TypeRepository typeRepository;

    public Type createOrUpdate(Type type) {
        return typeRepository.save(type);
    }

    public Type getUserById(String typename) {
        return typeRepository.findById(typename).orElse(null);
    }


    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    public Page<Type> getTypesWithPaging(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    public void deleteType(String username) {
        typeRepository.deleteById(username);
    }


}
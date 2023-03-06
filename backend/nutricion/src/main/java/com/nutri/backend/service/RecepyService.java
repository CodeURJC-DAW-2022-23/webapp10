package com.nutri.backend.service;


import com.nutri.backend.model.Recepy;
import com.nutri.backend.repositories.RecepyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class RecepyService {

    @Autowired
    private RecepyRepository recepyRepository;

    public Page<Recepy> getPageOfRecepies(int page){return recepyRepository.findAll(PageRequest.of(page,6));
    }

}

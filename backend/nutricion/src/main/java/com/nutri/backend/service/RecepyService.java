package com.nutri.backend.service;



import com.nutri.backend.model.Recepy;
import com.nutri.backend.repositories.RecepyRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecepyService {

    @Autowired
    private RecepyRepository recepyRepository;

    public List<Recepy> findAll(){
        return recepyRepository.findAll();
    }

    public Optional<Recepy> findByName(String name){
        return recepyRepository.findByName(name);
    }

    public List<Recepy> findByKindOfRecepy(String type){
        return recepyRepository.findByKindOfRecepy(type);
    }

    public Page<Recepy> findPage(Pageable page){
        return recepyRepository.findAll(page);
    }

    public void save(Recepy recepy){
        recepyRepository.save(recepy);
    }

    public Optional<Recepy> findById(long id){
        return recepyRepository.findById(id);
    }
    public Page<Recepy> getPageOfRecepies(int page){return recepyRepository.findAll(PageRequest.of(page,6));
    }

}

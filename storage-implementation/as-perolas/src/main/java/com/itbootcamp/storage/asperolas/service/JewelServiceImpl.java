package com.itbootcamp.storage.asperolas.service;

import com.itbootcamp.storage.asperolas.entity.Jewel;
import com.itbootcamp.storage.asperolas.exception.NotFoundJewelException;
import com.itbootcamp.storage.asperolas.repository.JewelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class JewelServiceImpl implements JewelService {

    private final JewelRepository repository;

    public JewelServiceImpl(JewelRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Jewel> getJewels() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Jewel saveJewel(Jewel jewel) {
        return repository.save(jewel);
    }

    @Override
    @Transactional
    public void deleteJewel(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Jewel findJewel(Long id) {
        Optional<Jewel> optionalJewel = repository.findById(id);
        optionalJewel.orElseThrow(() -> new NotFoundJewelException("The jewel with ID " +id+ " not found."));
        return optionalJewel.get();
    }
}

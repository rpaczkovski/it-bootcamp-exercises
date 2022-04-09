package com.itbootcamp.storage.asperolas.service;

import com.itbootcamp.storage.asperolas.entity.Jewel;
import com.itbootcamp.storage.asperolas.exception.NotFoundJewelException;

import java.util.List;

public interface JewelService {
    public List<Jewel> getJewels();
    public Jewel saveJewel(Jewel entity);
    public void deleteJewel(Long id);
    public Jewel findJewel(Long id) throws NotFoundJewelException;
}

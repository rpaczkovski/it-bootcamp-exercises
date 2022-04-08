package com.itbootcamp.storage.asperolas.dto.convert;

import com.itbootcamp.storage.asperolas.dto.JewelRequest;
import com.itbootcamp.storage.asperolas.entity.Jewel;

public class JewelRequestToJewel {
    public Jewel convert(JewelRequest request) {
        return Jewel.builder()
                .material(request.getMaterial())
                .weight(request.getWeight())
                .carats(request.getCarats())
                .build();
    }
}

package com.itbootcamp.storage.asperolas.controller;

import com.itbootcamp.storage.asperolas.dto.JewelRequest;
import com.itbootcamp.storage.asperolas.dto.convert.JewelRequestToJewel;
import com.itbootcamp.storage.asperolas.entity.Jewel;
import com.itbootcamp.storage.asperolas.service.JewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/jewels")
public class JewelController {

    @Autowired
    private JewelService service;

    @PostMapping
    public ResponseEntity<String> createJewel(@Valid @RequestBody JewelRequest request, UriComponentsBuilder uriBuilder) {
        Jewel jewel = service.saveJewel(new JewelRequestToJewel().convert(request));

        URI uri = uriBuilder
                .path("{id}")
                .buildAndExpand(jewel.getId())
                .toUri();

        return ResponseEntity.created(uri).body("The jewel was persisted.");
    }

    @GetMapping
    public ResponseEntity<List<Jewel>> getJewels() {
        return ResponseEntity.ok().body(service.getJewels());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Jewel> getJewel(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findJewel(id));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<String> updateJewel(@PathVariable Long id, @Valid @RequestBody JewelRequest request) {
        Jewel jewel = service.findJewel(id);
        jewel.setMaterial(request.getMaterial());
        jewel.setWeight(request.getWeight());
        jewel.setCarats(request.getCarats());
        service.saveJewel(jewel);
        return ResponseEntity.ok().body("The jewel was updated.");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteJewel(@RequestParam(value = "delete") Long id) {
        service.deleteJewel(id);
        return ResponseEntity.ok().body("The jewel was deleted.");
    }
}

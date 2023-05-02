package com.example.application.rest.controllers;

import com.example.application.rest.response.DeactivationReasonResponse;
import com.example.application.rest.response.GenreResponse;
import com.example.application.services.DeactivationReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/deactivation_reasons")
public class DeactivationReasonController {

    @Autowired
    private DeactivationReasonService deactivationReasonService;

    @GetMapping("")
    public ResponseEntity<List<DeactivationReasonResponse>> getAll(){
        List<DeactivationReasonResponse> deactivationReasonResponses =
                deactivationReasonService.getAll();

        return ResponseEntity.ok(deactivationReasonResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeactivationReasonResponse> getById(@PathVariable("id") int id){
        Optional<DeactivationReasonResponse> deactivationReasonResponse = deactivationReasonService.getById(id);

        if (deactivationReasonResponse.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(deactivationReasonResponse.get());
        }
    }
}

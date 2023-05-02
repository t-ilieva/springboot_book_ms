package com.example.application.services;

import com.example.application.data.repositories.DeactivationReasonRepository;
import com.example.application.rest.response.DeactivationReasonResponse;
import com.example.application.rest.transformers.DeactivationReasonTransformer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeactivationReasonService {

    private final DeactivationReasonRepository deactivationReasonRepository;

    public DeactivationReasonService(DeactivationReasonRepository deactivationReasonRepository) {
        this.deactivationReasonRepository = deactivationReasonRepository;
    }

    public List<DeactivationReasonResponse> getAll(){
        return deactivationReasonRepository.
                findAll().
                stream().
                map(DeactivationReasonTransformer::toDeactivationReasonResponse).
                collect(Collectors.toList());
    }

    public Optional<DeactivationReasonResponse> getById(int id){
        return deactivationReasonRepository.
                findById(id).
                map(DeactivationReasonTransformer::toDeactivationReasonResponse);
    }
}

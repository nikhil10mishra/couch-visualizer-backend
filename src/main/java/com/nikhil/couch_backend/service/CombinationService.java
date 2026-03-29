package com.nikhil.couch_backend.service;

import com.nikhil.couch_backend.entity.SavedCombination;
import com.nikhil.couch_backend.repository.CombinationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CombinationService {

    private final CombinationRepository repo;

    public CombinationService(CombinationRepository repo) {
        this.repo = repo;
    }

    public SavedCombination save(String userId, SavedCombination combo) {
        combo.setUserId(userId);
        return repo.save(combo);
    }

    public List<SavedCombination> getUserCombinations(String userId) {
        return repo.findByUserId(userId);
    }

    public void delete(Long id) {
    repo.deleteById(id);
}
}
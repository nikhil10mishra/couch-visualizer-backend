package com.nikhil.couch_backend.repository;

import com.nikhil.couch_backend.entity.SavedCombination;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CombinationRepository extends JpaRepository<SavedCombination, Long> {
    List<SavedCombination> findByUserId(String userId);
}
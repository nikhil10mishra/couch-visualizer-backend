package com.nikhil.couch_backend.controller;

import com.nikhil.couch_backend.entity.SavedCombination;
import com.nikhil.couch_backend.service.CombinationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;

@RestController
@RequestMapping("/api/combinations")

@CrossOrigin(origins = "*")

public class CombinationController {

    private final CombinationService service;

    public CombinationController(CombinationService service) {
        this.service = service;
    }

@PostMapping
public SavedCombination save(
        @RequestHeader("Authorization") String authHeader,
        @RequestBody SavedCombination combo) throws Exception {

    String token = authHeader.replace("Bearer ", "");
    FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);

    String userId = decodedToken.getUid();

    return service.save(userId, combo);
}

@GetMapping
public List<SavedCombination> getAll(
        @RequestHeader("Authorization") String authHeader) throws Exception {

    String token = authHeader.replace("Bearer ", "");
    FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);

    String userId = decodedToken.getUid();

    return service.getUserCombinations(userId);
}

    @DeleteMapping("/{id}")
public void delete(@PathVariable Long id) {
    service.delete(id);
}
}
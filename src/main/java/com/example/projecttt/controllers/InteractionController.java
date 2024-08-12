package com.example.projecttt.controllers;

import com.example.projecttt.entities.Interaction;
import com.example.projecttt.entities.Utilisateur;
import com.example.projecttt.services.InteractionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/interactions")
public class InteractionController {
    @Autowired
    private InteractionServiceImp interactionService;

    @PostMapping("/like")
    public ResponseEntity<String> likePublication(@RequestParam int idPublication, @RequestParam Long utilisateur_id) {
        try {
            interactionService.likePublication(idPublication, utilisateur_id);
            return ResponseEntity.ok("Publication liked successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error liking publication: " + e.getMessage());
        }
    }

    @PostMapping("/unlike")
    public ResponseEntity<String> unlikePublication(@RequestParam int idPublication, @RequestParam Long utilisateur_id) {
        try {
            interactionService.unlikePublication(idPublication, utilisateur_id);
            return ResponseEntity.ok("Publication unliked successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error unliking publication: " + e.getMessage());
        }
    }

    @GetMapping("/likes/{idPublication}")
    public ResponseEntity<List<Interaction>> getLikesByPublication(@PathVariable int idPublication) {
        try {
            List<Interaction> likes = interactionService.getLikesByPublication(idPublication);
            return ResponseEntity.ok(likes);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/users/{idPublication}")
    public ResponseEntity<List<Utilisateur>> getUserLikes(@PathVariable int idPublication) {
        try {
            List<Utilisateur> users = interactionService.getUserLikes(idPublication);
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/count/{idPublication}")
    public ResponseEntity<Integer> getLikes(@PathVariable int idPublication) {
        try {
            int likeCount = interactionService.getLikes(idPublication);
            return ResponseEntity.ok(likeCount);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(0);
        }
    }
}

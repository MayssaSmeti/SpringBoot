package com.example.projecttt.controllers;

import com.example.projecttt.entities.Commentaire;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import com.example.projecttt.repositories.CommentaireRepo;
import com.example.projecttt.repositories.PublicationRepo;
import com.example.projecttt.services.CommentaireService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@Slf4j
public class CommentaireController {
    @Autowired
    CommentaireService service;
    @Autowired
    PublicationRepo publicationRepo;
    @Autowired
    CommentaireRepo commentaireRepo;

    private static final Logger logger = LoggerFactory.getLogger(CommentaireController.class);

    @PostMapping("/addComment")
    public ResponseEntity<String> ajouterComment(@RequestBody Commentaire comment) {
        if (comment.getContenu() == null || comment.getContenu().trim().isEmpty()) {
            logger.info("Comment content is empty, not adding to the database.");
            return ResponseEntity.badRequest().body("Comment content cannot be empty");
        }

        logger.info("Received comment: {}", comment);
        // Sauvegardez le commentaire
        service.addCommentaire(comment);
        return ResponseEntity.ok("Comment added successfully");
    }

    @PostMapping("Comment/ajouterr")
    public ResponseEntity<Commentaire> addCommentairess(@RequestParam int idPublication,
                                                        @RequestBody Commentaire commentaire) {

        Commentaire savedComment = service.addComment2(idPublication, commentaire);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }
    @GetMapping("/commentaires/{idPublication}")
    public List<Commentaire> getCommentairesByPublication(@PathVariable("idPublication") int  idPublication) {
        List<Commentaire> commentairePubs = service.retrieveAllCommentairesByPublication(idPublication);
        return commentairePubs;
    }
    @GetMapping("Commentaire/{id_comment}")
    public Commentaire getComment(@PathVariable Long id_comment) {
        return service.getCommentById(Math.toIntExact(id_comment)).orElseThrow(
                () -> new EntityNotFoundException("Requested Comment not found")
        );
    }

    @GetMapping("/Comment")
    public List<Commentaire> getComment() {
        return service.getCommentaire();
    }

    @GetMapping("/Comment/post/{postId}")
    public List<Commentaire> getCommentsByPostId(@PathVariable Long postId) {
        List<Commentaire> comments = service.getCommentsByPostId(postId);
        return comments;
    }
    @PutMapping("/modifierCom")
    public void modifierCom(@RequestBody Commentaire comment) {
        service.updateCommentaire(comment);
    }

    @DeleteMapping("Clean/{idCommentaire}")
    public ResponseEntity<String> DeleteComment(@PathVariable int idCommentaire) {
        try {
            service.SupprimerCommentaire(idCommentaire);
            return new ResponseEntity<>("Commentaire supprimé avec succès.", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Une erreur est survenue lors de la suppression de commentaire .", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

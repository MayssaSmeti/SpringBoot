package com.example.projecttt.interfacesServices;

import com.example.projecttt.entities.Interaction;
import com.example.projecttt.entities.Utilisateur;

import java.util.List;

public interface IInteractionService {
    public void likePublication(int idPublication, Long utilisateur_id);
    public void unlikePublication(int idPublication,Long utilisateur_id);
    public List<Interaction> getLikesByPublication(int idPublication) ;
    public  List<Utilisateur> getUserLikes(int idPublication) ;
    public int getLikes(int idPublication);
}

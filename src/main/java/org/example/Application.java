package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.EventoDAO;
import org.example.entities.Enum.TipoEvento;
import org.example.entities.Evento;
import org.example.exceptions.NotFoundException;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        EventoDAO eddy = new EventoDAO(em);

        Evento evento1 = new Evento("PoolParty", LocalDate.of(2024, 8, 20), "Facciamo baldoria tutta la notte!", TipoEvento.PRIVATO, 10);
        Evento evento2 = new Evento("RaveParty", LocalDate.of(2024, 9, 18), "La radiamo al suolo questa Me... di casa!", TipoEvento.PUBBLICO, 50);
        Evento evento3 = new Evento("NinnaNanna", LocalDate.of(2025, 1, 1), "Si va a dormire alle 20:00!", TipoEvento.PRIVATO, 2);


        //eddy.save(evento1);
        // eddy.save(evento2);
        // eddy.save(evento3);

        try {
            Evento poolFromDb = eddy.findById(1);
            System.out.println(poolFromDb);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            eddy.findByIdAndDelete(3);
     
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

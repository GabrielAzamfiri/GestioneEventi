package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.EventoDAO;
import org.example.dao.LocationDAO;
import org.example.dao.PartecipazioneDAO;
import org.example.dao.PersonDAO;
import org.example.entities.Enum.TipoEvento;
import org.example.entities.Evento;
import org.example.entities.Location;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        EventoDAO eddy = new EventoDAO(em);
        LocationDAO locd = new LocationDAO(em);
        PartecipazioneDAO pard = new PartecipazioneDAO(em);
        PersonDAO perd = new PersonDAO(em);

        Location location1 = new Location("Carroponte", "Milano");
        locd.save(location1);
        Location loc1FromDB = locd.findById("1154e4dd-2440-44e8-afd4-5b3c4e48e0a7");
        //  Evento evento1 = new Evento("PoolParty", LocalDate.of(2024, 8, 20), "Facciamo baldoria tutta la notte!", TipoEvento.PRIVATO, 10);
        Evento evento2 = new Evento("RaveParty", LocalDate.of(2024, 9, 18), "baldoria tutta notte", TipoEvento.PUBBLICO, 50, loc1FromDB);
        //  Evento evento3 = new Evento("NinnaNanna", LocalDate.of(2025, 1, 1), "Si va a dormire alle 20:00!", TipoEvento.PRIVATO, 2);
        eddy.save(evento2);

        //eddy.save(evento1);
        // eddy.save(evento2);
        // eddy.save(evento3);


    }

}

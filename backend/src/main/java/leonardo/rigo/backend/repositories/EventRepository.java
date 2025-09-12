package leonardo.rigo.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import leonardo.rigo.backend.entities.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}

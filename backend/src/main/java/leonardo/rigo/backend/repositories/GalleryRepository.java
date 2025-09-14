package leonardo.rigo.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import leonardo.rigo.backend.entities.Gallery;
import leonardo.rigo.backend.entities.PhotoVideo;

public interface GalleryRepository extends JpaRepository<Gallery, Long>{

	Gallery save(PhotoVideo photovideo);

}

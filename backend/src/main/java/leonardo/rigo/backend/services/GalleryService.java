package leonardo.rigo.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leonardo.rigo.backend.entities.Gallery;
import leonardo.rigo.backend.entities.PhotoVideo;
import leonardo.rigo.backend.repositories.GalleryRepository;
import leonardo.rigo.backend.repositories.PhotoVideoRepository;

@Service
public class GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;

    @Autowired
    private PhotoVideoRepository photoVideoRepository;

    public Optional<Gallery> findById(Long id) {
        return galleryRepository.findById(id);
    }

    // Adicionar PhotoVideo a uma gallery existente
    public Optional<Gallery> addPhotoVideo(Long galleryId, PhotoVideo photoVideo) {
        return galleryRepository.findById(galleryId).map(gallery -> {
            photoVideo.setGallery(gallery); // seta relação
            photoVideoRepository.save(photoVideo);

            gallery.getListaDeFotos().add(photoVideo);
            return galleryRepository.save(gallery);
        });
    }

    // Alterar dados da Gallery
    public Optional<Gallery> changeGalleryById(Long id, Gallery newData) {
        return galleryRepository.findById(id).map(existing -> {
            existing.setTitulo(newData.getTitulo());
            existing.setDescription(newData.getDescription());
            // outros campos...
            return galleryRepository.save(existing);
        });
    }
    
    public boolean deleteById(Long id) {
        if (galleryRepository.existsById(id)) {
            galleryRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
	public List<Gallery> listGalleries() {
		return galleryRepository.findAll();
	}
}

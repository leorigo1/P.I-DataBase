package leonardo.rigo.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import leonardo.rigo.backend.entities.Gallery;
import leonardo.rigo.backend.entities.PhotoVideo;
import leonardo.rigo.backend.services.GalleryService;


@RestController
@RequestMapping("/galleries")
public class GalleryController {
	
	@Autowired
	private GalleryService galleryService;
	
	@PostMapping
	public void postPhotoVideo(@RequestBody Long galleryId, PhotoVideo photoVideo) {
		galleryService.addPhotoVideo(galleryId, photoVideo);
	}
	
	@PutMapping("{galleryId}")
	public void editPhotoVideo(@PathVariable Long galleryId, Gallery gallery) {
		galleryService.changeGalleryById(galleryId, gallery);
	}
	
	@GetMapping
	public List<Gallery> listAllGalleries() {
		return galleryService.listGalleries();
	}
	
	@DeleteMapping("/{id}")
	public void deleteGalleriesById(@PathVariable Long id) {
		galleryService.deleteById(id);
	}
}

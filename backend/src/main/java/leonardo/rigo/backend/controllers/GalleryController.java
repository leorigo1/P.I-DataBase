package leonardo.rigo.backend.controllers;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/addPublication")
	public void postPhotoVideo(@RequestBody Long galleryId, PhotoVideo photoVideo) {
		galleryService.addPhotoVideo(galleryId, photoVideo);
	}
	
	@PostMapping("/editPublication")
	public void editPhotoVideo(@RequestBody Long galleryId, Gallery gallery) {
		galleryService.changeGalleryById(galleryId, gallery);
	}
	
}

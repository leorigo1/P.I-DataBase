package leonardo.rigo.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import leonardo.rigo.backend.entities.PhotoVideo;
import leonardo.rigo.backend.services.PhotoVideoService;

@RestController
@RequestMapping("/Photovideo")
public class PhotoVideoController {

	@Autowired
	private PhotoVideoService photoVideoService;
	
	@PostMapping("/addPhotoVideo")
	public void addPhotoVideo (@RequestBody PhotoVideo photovideo) {
		photoVideoService.addPhotoVideo(photovideo);
	}
	
	@GetMapping
	public List<PhotoVideo> listAllPhotoVideos() {
		return photoVideoService.ListPhotoVideo();
	}
	
	@DeleteMapping
	public void deletePhotoVideoById (@RequestBody Long id) {
		photoVideoService.deletePhotoVideoById(id);
	}
	
}

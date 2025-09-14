package leonardo.rigo.backend.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import leonardo.rigo.backend.DTOs.PhotoVideoDTO;
import leonardo.rigo.backend.entities.PhotoVideo;
import leonardo.rigo.backend.services.PhotoVideoService;

@RestController
@RequestMapping("/photovideo")
public class PhotoVideoController {

	@Autowired
	private PhotoVideoService photoVideoService;
	
	@PostMapping
    public ResponseEntity<PhotoVideoDTO> addPhotoVideo(@RequestBody PhotoVideo obj) {
        PhotoVideo saved = photoVideoService.addPhotoVideo(obj);
        return ResponseEntity.ok(new PhotoVideoDTO(saved));
    }
	
	@GetMapping
    public List<PhotoVideoDTO> findAll() {
        return photoVideoService.ListPhotoVideo().stream()
                .map(PhotoVideoDTO::new)
                .collect(Collectors.toList());
    }
	
	@DeleteMapping("/{id}")
	public void deletePhotoVideoById (@PathVariable Long id) {
		photoVideoService.deletePhotoVideoById(id);
	}
}

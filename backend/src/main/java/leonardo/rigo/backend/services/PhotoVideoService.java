package leonardo.rigo.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leonardo.rigo.backend.entities.PhotoVideo;
import leonardo.rigo.backend.repositories.PhotoVideoRepository;

@Service
public class PhotoVideoService {

	@Autowired
	private PhotoVideoRepository photoVideoRepository;
	
	public PhotoVideo addPhotoVideo(PhotoVideo photovideo) {
		return photoVideoRepository.save(photovideo);
	}
	
	public List<PhotoVideo> ListPhotoVideo() {
		return photoVideoRepository.findAll();
	}
	
	public void deletePhotoVideoById(Long id) {
		photoVideoRepository.deleteById(id);
	}
}

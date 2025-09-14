package leonardo.rigo.backend.DTOs;

import java.time.LocalDateTime;

import leonardo.rigo.backend.entities.PhotoVideo;

public class PhotoVideoDTO {
	private Long id;
    private String url;
    private LocalDateTime dataEnvio;
    private String description;
    private int likes;

    private UserDTO user;
    private GalleryDTO gallery;

    public PhotoVideoDTO() {}

    public PhotoVideoDTO(PhotoVideo entity) {
        this.id = entity.getId();
        this.url = entity.getUrl();
        this.dataEnvio = entity.getDataEnvio();
        this.description = entity.getDescription();
        this.likes = entity.getLikes();
        this.user = new UserDTO(entity.getUser());
        this.gallery = new GalleryDTO(entity.getGallery());
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public LocalDateTime getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDateTime dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public GalleryDTO getGallery() {
		return gallery;
	}

	public void setGallery(GalleryDTO gallery) {
		this.gallery = gallery;
	}    
}

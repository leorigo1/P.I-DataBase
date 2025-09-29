package leonardo.rigo.backend.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "photos_videos")
public class PhotoVideo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String url;
	private LocalDateTime dataEnvio;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
	private User user;
	
	
	private String description;
	@Column(nullable = false)
	private Integer likes = 0;
	
	@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "gallery_id")
	@JsonBackReference
	private Gallery gallery;
	
	public PhotoVideo () {};
	
	public PhotoVideo(Long id, String url, LocalDateTime dataEnvio, User user, String description, Integer likes,Gallery gallery) {
		this.id = id;
		this.url = url;
		this.dataEnvio = dataEnvio;
		this.user = user;
		this.description = description;
		this.likes = likes;
		this.gallery = gallery;
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

	public void setDataEnvio(LocalDateTime localDateTime) {
		this.dataEnvio = localDateTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Gallery getGallery() {
		return gallery;
	}

	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}
}
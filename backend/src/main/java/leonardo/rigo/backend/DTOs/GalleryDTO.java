package leonardo.rigo.backend.DTOs;

import leonardo.rigo.backend.entities.Gallery;

public class GalleryDTO {
	private Long id;
    private String titulo;
    private String description;

    public GalleryDTO() {}

    public GalleryDTO(Gallery entity) {
        this.id = entity.getId();
        this.titulo = entity.getTitulo();
        this.description = entity.getDescription();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

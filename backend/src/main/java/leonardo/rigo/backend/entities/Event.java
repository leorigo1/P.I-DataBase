package leonardo.rigo.backend.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "events")
public class Event {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String local;
	private LocalDateTime data;
	
	
	// Participantes do evento
    @ManyToMany
    @JoinTable(
        name = "event_user",
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> listaDeParticipantes = new ArrayList<>();
	
	
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gallery_id", referencedColumnName = "id") // nome da coluna no banco
	private Gallery galleryRelacionada;
	
	public Event () {};

	public Event(Long id, String nome, String local, LocalDateTime data, Gallery galleryRelacionada) {
		this.id = id;
		this.nome = nome;
		this.local = local;
		this.data = data;
		this.galleryRelacionada = galleryRelacionada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Gallery getGalleryRelacionada() {
		return galleryRelacionada;
	}

	public void setGalleryRelacionada(Gallery galleryRelacionada) {
		this.galleryRelacionada = galleryRelacionada;
	}

	public List<User> getListaDeParticipantes() {
		return listaDeParticipantes;
	}

	public void setListaDeParticipantes(List<User> listaDeParticipantes) {
		this.listaDeParticipantes = listaDeParticipantes;
	}
	
}

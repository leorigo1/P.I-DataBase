package leonardo.rigo.backend.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "galleries")
public class Gallery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	private String description;
	
	@OneToMany(mappedBy = "gallery", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PhotoVideo> ListaDeFotos = new ArrayList<>();
	
    @ManyToMany
    @JoinTable(
        name = "gallery_user",
        joinColumns = @JoinColumn(name = "gallery_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
	private List<User> listaDeUsers = new ArrayList<>();
	
	public Gallery() {}

	public Gallery(Long id, String titulo, String description, List<PhotoVideo> listaDeFotos, List<User> listaDeUsers) {
		this.id = id;
		this.titulo = titulo;
		this.description = description;
		ListaDeFotos = listaDeFotos;
		this.listaDeUsers = listaDeUsers;
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

	public List<PhotoVideo> getListaDeFotos() {
		return ListaDeFotos;
	}

	public void setListaDeFotos(List<PhotoVideo> listaDeFotos,PhotoVideo url) {
		listaDeFotos.add(url);
	}

	public List<User> getListaDeUsers() {
		return listaDeUsers;
	}

	public void setListaDeUsers(List<User> listaDeUsers,User user) {
		listaDeUsers.add(user);
	};
}

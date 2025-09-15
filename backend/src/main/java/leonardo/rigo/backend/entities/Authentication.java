package leonardo.rigo.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "authentications")
public class Authentication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String provider; // "google", "local", etc.
	private String providerId; // id do usuário no provedor

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Authentication() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}

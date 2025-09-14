package leonardo.rigo.backend.configs;

import leonardo.rigo.backend.entities.*;
import leonardo.rigo.backend.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final GalleryRepository galleryRepository;
    private final PhotoVideoRepository photoVideoRepository;

    public TestConfig(UserRepository userRepository,
                           EventRepository eventRepository,
                           GalleryRepository galleryRepository,
                           PhotoVideoRepository photoVideoRepository) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.galleryRepository = galleryRepository;
        this.photoVideoRepository = photoVideoRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // 1️⃣ Usuários
        User user1 = new User(null, "João", "joao@email.com", "123456");
        User user2 = new User(null, "Maria", "maria@email.com", "123456");
        userRepository.saveAll(Arrays.asList(user1, user2));

        // 2️⃣ Galeria
        Gallery gallery = new Gallery();
        gallery.setTitulo("Festa de aniversário");
        gallery.setDescription("Fotos do evento");
        galleryRepository.save(gallery);
        
        // 3️⃣ Fotos/Vídeos
        PhotoVideo foto1 = new PhotoVideo();
        foto1.setUrl("http://example.com/foto1.jpg");
        foto1.setDataEnvio(LocalDateTime.now());
        foto1.setUser(user1);
        foto1.setGallery(gallery);

        PhotoVideo foto2 = new PhotoVideo();
        foto2.setUrl("http://example.com/video1.mp4");
        foto2.setDataEnvio(LocalDateTime.now());
        foto2.setUser(user2);
        foto2.setGallery(gallery);

        photoVideoRepository.saveAll(Arrays.asList(foto1, foto2));
        
        Event evento = new Event();
        evento.setData(LocalDateTime.now());
        evento.setGalleryRelacionada(gallery);
        evento.setListaDeParticipantes(Arrays.asList(user1,user2));
        evento.setLocal("Dope");
        evento.setNome("Baile do DJ Peke");
        eventRepository.save(evento);
        System.out.println("Banco H2 inicializado com dados de exemplo!");
    }
}

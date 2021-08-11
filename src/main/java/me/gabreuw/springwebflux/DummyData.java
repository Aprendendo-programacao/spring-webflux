package me.gabreuw.springwebflux;

import lombok.RequiredArgsConstructor;
import me.gabreuw.springwebflux.document.Playlist;
import me.gabreuw.springwebflux.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DummyData implements CommandLineRunner {

    private final PlaylistRepository PLAYLIST_REPOSITORY;

    @Override
    public void run(String... args) throws Exception {
        Flux<Playlist> dummyData = Flux
                .just(
                        "API Rest Spring Boot",
                        "Deply de uma aplicação java no IBM Cloud",
                        "Java 8",
                        "GitHub",
                        "Spring Security",
                        "Web Service RESTFUL",
                        "Bean no Spring framework"
                )
                .map(this::createDummyPlayList)
                .flatMap(PLAYLIST_REPOSITORY::save);

        PLAYLIST_REPOSITORY.deleteAll()
                .thenMany(dummyData)
                .subscribe(System.out::println);
    }

    private Playlist createDummyPlayList(String name) {
        return new Playlist(
                UUID.randomUUID().toString(),
                name
        );
    }

}

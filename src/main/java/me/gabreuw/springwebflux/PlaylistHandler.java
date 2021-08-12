package me.gabreuw.springwebflux;

import lombok.RequiredArgsConstructor;
import me.gabreuw.springwebflux.document.Playlist;
import me.gabreuw.springwebflux.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PlaylistHandler {

    private final PlaylistService PLAYLIST_SERVICE;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(APPLICATION_JSON)
                .body(PLAYLIST_SERVICE.findAll(), Playlist.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");

        return ServerResponse
                .ok()
                .contentType(APPLICATION_JSON)
                .body(PLAYLIST_SERVICE.findById(id), Playlist.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        Mono<Playlist> playlist = request.bodyToMono(Playlist.class);

        return ServerResponse
                .created(request.uri())
                .contentType(APPLICATION_JSON)
                .body(
                        fromPublisher(
                                playlist.flatMap(PLAYLIST_SERVICE::save),
                                Playlist.class
                        )
                );
    }

}

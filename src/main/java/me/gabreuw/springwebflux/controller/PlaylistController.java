package me.gabreuw.springwebflux.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import me.gabreuw.springwebflux.document.Playlist;
import me.gabreuw.springwebflux.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

import static org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE;

@RestController
@RequestMapping(path = "/playlists")
@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PlaylistController {

    private final PlaylistService PLAYLIST_SERVICE;

    @GetMapping
    public Flux<Playlist> findAll() {
        return PLAYLIST_SERVICE.findAll();
    }

    @GetMapping(path = "/{id}")
    public Mono<Playlist> findById(@PathVariable String id) {
        return PLAYLIST_SERVICE.findById(id);
    }

    @PostMapping
    public Mono<Playlist> save(@RequestBody Playlist playlist) {
        return PLAYLIST_SERVICE.save(playlist);
    }

    @GetMapping(
            path = "/events",
            produces = TEXT_EVENT_STREAM_VALUE
    )
    public Flux<Tuple2<Long, Playlist>> findByEvents() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(5));
        Flux<Playlist> events = PLAYLIST_SERVICE.findAll();

        log.info("Events passou aqui");

        return Flux.zip(interval, events);
    }

}

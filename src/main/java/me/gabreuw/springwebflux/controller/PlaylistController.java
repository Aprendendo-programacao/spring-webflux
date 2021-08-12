package me.gabreuw.springwebflux.controller;

import lombok.RequiredArgsConstructor;
import me.gabreuw.springwebflux.document.Playlist;
import me.gabreuw.springwebflux.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(path = "/playlists")
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
    @ResponseStatus(code = CREATED)
    public Mono<Playlist> save(@RequestBody Playlist playlist) {
        return PLAYLIST_SERVICE.save(playlist);
    }

}

package me.gabreuw.springwebflux.service.impl;

import lombok.RequiredArgsConstructor;
import me.gabreuw.springwebflux.document.Playlist;
import me.gabreuw.springwebflux.repository.PlaylistRepository;
import me.gabreuw.springwebflux.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository PLAYLIST_REPOSITORY;

    @Override
    public Flux<Playlist> findAll() {
        return PLAYLIST_REPOSITORY.findAll();
    }

    @Override
    public Mono<Playlist> findById(String id) {
        return PLAYLIST_REPOSITORY.findById(id);
    }

    @Override
    public Mono<Playlist> save(Playlist playlist) {
        return PLAYLIST_REPOSITORY.save(playlist);
    }

}

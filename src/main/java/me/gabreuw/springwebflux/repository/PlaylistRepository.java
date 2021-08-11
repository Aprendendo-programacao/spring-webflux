package me.gabreuw.springwebflux.repository;

import me.gabreuw.springwebflux.document.Playlist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {}
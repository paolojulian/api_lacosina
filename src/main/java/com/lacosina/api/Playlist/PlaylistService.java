package com.lacosina.api.Playlist;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    /**
     * Creates a playlist
     *
     * @param name - The name of the playlist
     *
     * @return - Playlist Entity
     */
    @Transactional
    public Playlist createPlaylist(final String name) {
        final Playlist playlist = new Playlist();
        playlist.setName(name);

        return this.playlistRepository.save(playlist);
    }

}

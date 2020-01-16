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

    /**
     * Deletes the playlist by the passed id
     * @param id - id of the playlist
     *
     * @return
     */
    @Transactional
    public Boolean deletePlaylist(final Integer id) {
        try {
            this.playlistRepository.deleteById(id);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

}

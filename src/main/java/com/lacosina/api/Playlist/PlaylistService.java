package com.lacosina.api.Playlist;

import org.hibernate.dialect.Ingres9Dialect;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;

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
     * Update the playlist general information
     *
     * @param id - PK of the playlist
     * @param name - the field to be updated
     *
     * @return - The new Playlist Entity after save
     */
    @Transactional
    public Playlist updatePlaylist(final Integer id, final String name) {
        final Playlist playlist = this.playlistRepository.findById(id).orElseThrow();
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

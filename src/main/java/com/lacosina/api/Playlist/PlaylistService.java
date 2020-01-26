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
     * @return - Playlist Entity
     */
    @Transactional
    public Playlist createPlaylist(Playlist playlist) {
        return this.playlistRepository.save(playlist);
    }

    /**
     * Update the playlist general information
     *
     * @param id - PK of the playlist
     * @param newPlaylist - The new updated playlist
     *
     * @return - The new Playlist Entity after save
     */
    @Transactional
    public Playlist updatePlaylist(final int id, Playlist newPlaylist) {
        Playlist playlist = this.playlistRepository.findById(id).orElseThrow();
        playlist.setName(newPlaylist.getName());
        playlist.setFavorite(newPlaylist.getFavorite());

        return this.playlistRepository.save(playlist);
    }

    /**
     * Deletes the playlist by the passed id
     * @param id - id of the playlist
     *
     * @return
     */
    @Transactional
    public Boolean deletePlaylist(final int id) {
        try {
            this.playlistRepository.deleteById(id);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

}

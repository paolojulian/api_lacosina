package com.lacosina.api.Playlist;

import com.lacosina.api.Recipe.Recipe;
import com.lacosina.api.Recipe.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final RecipeRepository recipeRepository;

    /**
     * Creates a playlist
     *
     * @return - Playlist Entity
     */
    @Transactional
    public Playlist createPlaylist(Playlist playlist) {
        return this.playlistRepository.save(playlist);
    }

    @Transactional(readOnly = true)
    public List<Playlist> fetchAllPlaylists() {
        return this.playlistRepository.findAll();
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

    @Transactional
    public void addRecipeToPlaylist(
            final int playlistId,
            final int recipeId
    ) {
        Playlist playlist = this.playlistRepository.findById(playlistId).orElseThrow();
        Recipe recipe = this.recipeRepository.findById(recipeId).orElseThrow();
        playlist.getRecipes().add(recipe);
        this.playlistRepository.save(playlist);
    }
}

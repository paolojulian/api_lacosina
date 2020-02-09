package com.lacosina.api.Playlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @PostMapping
    public Playlist createPlaylist(@Valid @RequestBody Playlist playlist) {
        return this.playlistService.createPlaylist(playlist);
    }

    @GetMapping
    public List<Playlist> fetchAllPlaylists() {
        return this.playlistService.fetchAllPlaylists();
    }

    @PutMapping("/{id}")
    public Playlist updatePlaylist(
        @RequestParam(name = "id") int id,
        @Valid @RequestBody Playlist playlist
    ) {
        return this.playlistService.updatePlaylist(id, playlist);
    }

    @DeleteMapping("/{id}")
    public Boolean deletePlaylist(@PathVariable(name = "id") int id) { return this.playlistService.deletePlaylist(id); }

    /**
     * Add an existing recipe to a playlist
     * @param playlistId - Pk playlist
     * @param recipeId - Pk Recipe
     */
    @PatchMapping("/{playlistId}/recipe/{recipeId}")
    public void addRecipeToPlaylist(
            @PathVariable int playlistId,
            @PathVariable int recipeId
    ) {

        this.playlistService.addRecipeToPlaylist(playlistId, recipeId);
    }
}

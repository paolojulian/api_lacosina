package com.lacosina.api.Playlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @PostMapping("/")
    public Playlist createPlaylist(@Valid @RequestBody Playlist playlist) {
        return this.playlistService.createPlaylist(playlist);
    }

    @PutMapping("/{id}")
    public Playlist updatePlaylist(
        @RequestParam(name = "id") int id,
        @Valid @RequestBody Playlist playlist
    ) {
        return this.playlistService.updatePlaylist(id, playlist);
    }

    @DeleteMapping("/{id}")
    public Boolean deletePlaylist(@RequestParam(name = "id") int id) { return this.playlistService.deletePlaylist(id); }
}

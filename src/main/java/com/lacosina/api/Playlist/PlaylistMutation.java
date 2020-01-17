package com.lacosina.api.Playlist;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlaylistMutation implements GraphQLMutationResolver {

    @Autowired
    private PlaylistService playlistService;

    public Playlist createPlaylist(String name) {
        return this.playlistService.createPlaylist(name);
    }

    public Boolean deletePlaylist(Integer id) { return this.playlistService.deletePlaylist(id); }
}

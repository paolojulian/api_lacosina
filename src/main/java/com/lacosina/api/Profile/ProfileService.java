package com.lacosina.api.Profile;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    @Transactional
    public Profile createProfile(String handle) {
        final Profile profile = new Profile();
        profile.setHandle(handle);

        return this.profileRepository.save(profile);
    }

    @Transactional
    public Profile updateProfile(final Integer id) {
        Profile profile = this.profileRepository.findById(id).orElseThrow();
        return this.profileRepository.save(profile);
    }
}

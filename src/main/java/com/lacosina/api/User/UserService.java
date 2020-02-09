package com.lacosina.api.User;

import com.lacosina.api.Profile.Profile;
import com.lacosina.api.Profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    private ProfileService profileService;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User createUser(
            final String email,
            final String username,
            final String password
    ) {
        final User user = new User(email, username, password);
        user.setProfile(profileService.createProfile(username));
        return this.userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> getUserList() {
        return this.getUserList(10);
    }

    @Transactional(readOnly = true)
    public List<User> getUserList(final int limitCount) {
        return this.userRepository
                .findAll()
                .stream()
                .limit(limitCount)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<User> getUser(final int id) {
        return this.userRepository.findById(id);
    }

    @Transactional
    public Boolean deleteUser(final Integer id) {
        this.userRepository.deleteById(id);

        return true;
    }

    @Transactional
    public Profile updateProfile(final Integer userId, Profile profile) {
        User user = this.userRepository.findById(userId).orElseThrow();
        user.setProfile(profile);
        this.userRepository.save(user);
        return user.getProfile();
    }

}

package org.example.chronovaccin.security;

import org.example.chronovaccin.entities.User;
import org.example.chronovaccin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChronoVaccinUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optUser = userRepository.findByEmail(username);
        if (optUser.isEmpty()){
            throw new UsernameNotFoundException("user not found");
        }
        return new UserDetail(optUser.get());
    }
}
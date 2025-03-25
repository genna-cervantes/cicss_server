package ust.com.cicss.security;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ust.com.cicss.dao.DepartmentChairRepository;
import ust.com.cicss.dao.TASRepository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import ust.com.cicss.models.DepartmentChairDetails;
import ust.com.cicss.models.TASDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private DepartmentChairRepository dcRepository;

    @Autowired
    private TASRepository tasRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<DepartmentChairDetails> dcOptional = Optional.ofNullable(dcRepository.getDepartmentChairByEmail(email));
        if (dcOptional.isPresent()) {
            return new org.springframework.security.core.userdetails.User(
                    dcOptional.get().getEmail(),
                    "",
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_Department_Chair"))
            );
        }

        Optional<TASDetails> tasOptional = Optional.ofNullable(tasRepository.getTasFromEmail(email));
        if (tasOptional.isPresent()) {
            return new org.springframework.security.core.userdetails.User(
                    tasOptional.get().getEmail(),
                    "",
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_TAS"))
            );
        }

        if (email.endsWith("cics@ust.edu.ph")) {
            return new org.springframework.security.core.userdetails.User(
                    email,
                    "", 
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_Student"))
            );
        }

        throw new UsernameNotFoundException("User with email " + email + " not found");
    }
}

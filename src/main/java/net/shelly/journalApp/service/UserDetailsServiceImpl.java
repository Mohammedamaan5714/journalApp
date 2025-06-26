package net.shelly.journalApp.service;

import net.shelly.journalApp.entity.User;
import net.shelly.journalApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    //to find user with this load by user
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUserName(username);
        if (user !=null){
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUserName())//to get and then set user name to user details for security
                    .username(user.getPassword())//same for the password we can do it simple way but this is small
                    .roles(user.getRoles().toArray(new String[0]))//getting roles as list convert it into array and then new string 0 resize it accordingly
                    .build();

        }
        throw new UsernameNotFoundException("user not forund with the username"+username);

    }
}

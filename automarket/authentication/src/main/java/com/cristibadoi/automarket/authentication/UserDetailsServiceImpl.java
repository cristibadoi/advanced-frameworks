package com.cristibadoi.automarket.authentication;

import com.cristibadoi.automarket.persistence.models.RoleModel;
import com.cristibadoi.automarket.persistence.models.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserService userService;

  @Override
  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    UserModel user = userService.findByUsername(username);
    List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
    for (RoleModel role : user.getRoles()) {
      grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
    }

    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                                                                  grantedAuthorities);

  }

}
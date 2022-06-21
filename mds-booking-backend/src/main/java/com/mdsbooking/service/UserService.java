package com.mdsbooking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdsbooking.dto.UserDTO;
import com.mdsbooking.dto.UserProfileDTO;
import com.mdsbooking.exception.UserNotFoundException;
import com.mdsbooking.model.User;
import com.mdsbooking.repository.IUserRepository;

@Service
@Transactional
public class UserService extends BaseService<IUserRepository> implements UserDetailsService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserDTO createUser(UserDTO userDto) {
		log.info("Creating new user");
		return save(modelMapper.map(userDto, User.class));
	}
	
	public UserDTO save(User userDto) {
		log.info("Saving new user");
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		User user = classRepository.save(userDto);
		log.info("User {} saved", user.getId());
		return modelMapper.map(user, UserDTO.class);
	}

	public User findById(Long userId) throws UserNotFoundException {
		log.info("Finding user {}", userId);
		Optional<User> optUser = classRepository.findById(userId);
		return optUser.orElseThrow(() -> new UserNotFoundException("User not found", "Id is not in database"));
	}

	public UserDTO findByEmail(String email) throws UserNotFoundException {
		log.info("Finding user by email {}", email);
		return modelMapper.map(classRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found", "Email is not in database")), UserDTO.class);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = classRepository.findByEmail(username);
		return (UserDetails) user.orElse(null);
	}

	public UserDTO updateProfile(UserProfileDTO profile) {
		Optional<User> optUuser = classRepository.findById(profile.getId());
		UserDTO response = null;
		if (optUuser.isPresent()) {
			User user = optUuser.get();
			user.setAddress(profile.getAddress());
			user.setCountry(profile.getCountry());
			user.setLastName(profile.getLastName());
			user.setName(profile.getName());
			user.setPhone(profile.getPhone());
			response = modelMapper.map(classRepository.save(user), UserDTO.class);
		} else {
			throw new UserNotFoundException("User not found", "Id is not in database"); 
		}
		return response;
	}

}

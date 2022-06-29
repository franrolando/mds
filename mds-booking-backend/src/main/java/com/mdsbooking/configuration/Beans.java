package com.mdsbooking.configuration;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.mdsbooking.dto.BookingDTO;
import com.mdsbooking.dto.ComodityDTO;
import com.mdsbooking.dto.HouseImageDTO;
import com.mdsbooking.dto.InquiryDTO;
import com.mdsbooking.model.Booking;
import com.mdsbooking.model.HouseComodity;
import com.mdsbooking.model.HouseImage;
import com.mdsbooking.model.Inquiry;
import com.mdsbooking.service.UserService;

@Configuration
public class Beans {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Inquiry, InquiryDTO>() {
			@Override
			protected void configure() {
				map().setHouseId(source.getId().getHouseFKId().getHouseId());
			}
		});
		modelMapper.addMappings(new PropertyMap<Booking, BookingDTO>() {
			@Override
			protected void configure() {
				map().setHouseId(source.getId().getHouseFKId().getHouseId());
			}
		});
		modelMapper.addMappings(new PropertyMap<HouseImage, HouseImageDTO>() {
			@Override
			protected void configure() {
				map().setHouseId(source.getId().getHouseFKId().getHouseId());
				map().setUrl(source.getId().getUrl());
			}
		});
		modelMapper.addMappings(new PropertyMap<HouseComodity, ComodityDTO>() {
			@Override
			protected void configure() {
				map().setId(source.getComodity().getId());
				map().setName(source.getComodity().getName());
			}
		});
		return modelMapper;
	}

	@Bean
	public DaoAuthenticationProvider daoProv(UserService userDetails) {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(userDetails);
		dao.setPasswordEncoder(passwordEncoder());
		return dao;
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(DaoAuthenticationProvider provider) {
		return new ProviderManager(provider);
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.addAllowedMethod(HttpMethod.GET);
		configuration.addAllowedMethod(HttpMethod.POST);
		configuration.addAllowedMethod(HttpMethod.PUT);
		configuration.addAllowedMethod(HttpMethod.OPTIONS);
		configuration.addAllowedHeader("content-type");
		configuration.addAllowedHeader("Authorization");
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

}

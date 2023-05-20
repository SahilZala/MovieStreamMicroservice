package com.pack.service.impl;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pack.dao.MovieDetails;
import com.pack.exceptions.MovieNotFoundException;
import com.pack.service.MovieDetailService;
import com.pack.util.AppUtility;

@Service
public class MovieDetailsServiceImpl implements MovieDetailService{
	@Override
	public List<String> getLandscapPoster(String id) {
		
		try {
			MovieDetails md = fetchFromJsonFile(id);
			return md.getLandscapPoster().stream().map(d->AppUtility.DIRECTORY_PATH+""+md.getId()+""+d).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ArrayList<>();
	}
	
	public MovieDetails fetchFromJsonFile(String id) throws IOException{
		StringBuilder val = new StringBuilder("");
		for(String i : id.split("-"))
			val.append(i);
		
		
		ObjectMapper obj = new ObjectMapper();
		MovieDetails md = obj.readValue(new File(AppUtility.DIRECTORY_PATH+""+val+"/metadata.json"), MovieDetails.class);
		md.setId(val.toString());
		return md;
	}

	@Override
	public String getMoviePath(String id) {
		try {
			StringBuilder val = new StringBuilder("");
			for(String i : id.split("-"))
				val.append(i);
			MovieDetails md = fetchFromJsonFile(id);
			return AppUtility.DIRECTORY_PATH+""+val+"/"+md.getMovieFileName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new MovieNotFoundException("movie not found");
	}

	@Override
	public List<String> getPortraitPoster(String id) {

		try {
			MovieDetails md = fetchFromJsonFile(id);
			return md.getPortraitPoster().stream().map(
					d->AppUtility.DIRECTORY_PATH+""+md.getId()+""+d).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ArrayList<>();
	}	
}

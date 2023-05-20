package com.pack.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.dto.MovieDetailsDTO;
import com.pack.util.ApiPaths;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("movie_stream")
@CrossOrigin
public class MovieDetailsController {
	
	@Autowired
	MovieDetailsDTO movieDetailDTO;
	
	@GetMapping(value=ApiPaths.READ_LANDSCAP_POSTER+"/{id}")
	public Flux<byte[]> getLandscapPosterStream(@PathVariable String id)
	{
		return movieDetailDTO.getLandscapPoster(id);
	}
	
	@GetMapping(value = ApiPaths.GET_MOVIE+"/{id}",produces = {"video/mkv" , "video/mp4"})
	public Mono<Resource> getMovieStream(@PathVariable String id) {
		return movieDetailDTO.getMovie(id);
	}
	
	
	@GetMapping(value = ApiPaths.READ_SINGLE_PORTRAIT_POSTER+"/{id}",produces = {"image/png"})
	public Mono<Resource> getMovieSinglePortraitPoster(@PathVariable String id) {
		return movieDetailDTO.getMovieSinglePortraitPoster(id);
	}
	
}

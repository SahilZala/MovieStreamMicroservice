package com.pack.dto.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.pack.dto.MovieDetailsDTO;
import com.pack.service.MovieDetailService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieDetailsDTOImpl implements MovieDetailsDTO {

	@Autowired
	MovieDetailService movieDetailService;
	
	
	@Autowired
	ResourceLoader resourceLoader;
	
	@Override
	public Flux<byte[]> getLandscapPoster(String id){
		return Flux.fromIterable(
				movieDetailService
				.getLandscapPoster(id)
				.stream()
				.map(d->{
						try {						
							return Files.readAllBytes(new File(d).toPath());
						} catch (IOException e) {
							e.printStackTrace();
						}
						return new byte[] {};
					}
				).collect(Collectors.toList()).stream().dropWhile(d->d.length == 0).collect(Collectors.toList())
			).log();
	}

	@Override
	public Mono<Resource> getSingleLandscapPoster(String id) {
		return Mono.fromSupplier(()->resourceLoader.getResource("file:"+movieDetailService.getLandscapPoster(id).get(0)));
	}

	@Override
	public Mono<Resource> getMovie(String id) {
		
		return Mono.fromSupplier(()->resourceLoader.getResource("file:"+movieDetailService.getMoviePath(id))).log();
	}

	@Override
	public Mono<Resource> getMovieSinglePortraitPoster(String id) {
		System.out.println(movieDetailService.getPortraitPoster(id));
		return Mono.fromSupplier(()->resourceLoader.getResource("file:"+movieDetailService.getPortraitPoster(id).get(0)));
	}
}



package com.pack.dto;

import org.springframework.core.io.Resource;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieDetailsDTO {
	Flux<byte[]> getLandscapPoster(String id);
	Mono<Resource> getSingleLandscapPoster(String id);
	Mono<Resource> getMovie(String id);
	Mono<Resource> getMovieSinglePortraitPoster(String id);
}

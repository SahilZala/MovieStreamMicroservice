package com.pack.service;

import java.util.List;

public interface MovieDetailService {
	List<String> getLandscapPoster(String id);
	String getMoviePath(String id);
	List<String> getPortraitPoster(String id);
}

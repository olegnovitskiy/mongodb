package com.fmdev.mongodb;

import java.util.Arrays;

import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Location {
	@GeoSpatialIndexed
	private final double[] coordinates;
	private final String type;
	
	@Override
	public String toString() {
		return " [" + Arrays.toString(coordinates) + "]";
	}
	
}

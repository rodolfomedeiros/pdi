package com.devroods.processamentodeimagem.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.devroods.processamentodeimagem.model.Pixel;

import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

public class AppUtils {
	
	public static int max(PixelReader pixels, int tamX, int tamY) {
		int max = 0;
		Color color = null;
		int f = 0;
		for(int readX = 0; readX < tamX; readX++){
	        for(int readY = 0; readY < tamY; readY++){
	        	color = pixels.getColor(readX, readY).grayscale();
	        	f = (int) (color.getRed() * 255);
	        	if(max < f) max = f;
	        }
	    }
		
		return max;
	}
	
	public static List<Integer> filterGetArrayOrdened(PixelReader pixels, int minX, int minY, int maxX, int maxY, int width, int height) {
		List<Integer> array = new ArrayList<>();
		Color color = null;
		int p = 0;
		for(int i = minX; i <= maxX; i++){
			if(i < 0 || i >= height) continue;
	        for(int j = minY; j <= maxY; j++){
	        	if(j < 0 || j >= width) continue;
	        	color = pixels.getColor(i, j).grayscale();
	        	p = (int) (color.getRed() * 255);
	        	
	        	array.add(p);
	        }
	    }
		
		Collections.sort(array);
		
		return array;
	}
	
	public static int intensidadeMedia(PixelReader pixels, int width, int height) {
		Color color = null;
		int p = 0, value = 0;
		for(int i = 0; i < height; i++){
	        for(int j = 0; j < width; j++){
	        	color = pixels.getColor(i, j).grayscale();
	        	p = (int) (color.getRed() * 255);
	        	
	        	value += p;
	        }
	    }
		
		return value/(width*height);
	}
	
	public static int intensidadeMedia(List<Pixel> pixels) {
		
		int value = 0;
		
		for(Pixel p : pixels) {
			value += p.getValueGray();
		}
		
		return value/pixels.size();
	}
	
	public static int intensidadeMedia(PixelReader pixels, int minX, int minY, int maxX, int maxY, int width, int height) {
		
		Color color = null;
		int p = 0, value = 0, count = 0;
		for(int i = minX; i <= maxX; i++){
			if(i < 0 || i >= height) continue;
	        for(int j = minY; j <= maxY; j++){
	        	if(j < 0 || j >= width) continue;
	        	color = pixels.getColor(i, j).grayscale();
	        	p = (int) (color.getRed() * 255);
	        	
	        	value += p;
	        	count++;
	        }
	    }
		
		return value/count;
	}
	
	public static List<Pixel> getPixels(PixelReader pixels, int width, int height) {
		List<Pixel> array = new ArrayList<>();
		Color color = null;
		int p = 0;
		for(int i = 0; i < height; i++){
	        for(int j = 0; j < width; j++){
	        	color = pixels.getColor(i, j).grayscale();
	        	p = (int) (color.getRed() * 255);
	        	
	        	array.add(new Pixel(p, i, j));
	        }
	    }
		
		return array;
	}
}

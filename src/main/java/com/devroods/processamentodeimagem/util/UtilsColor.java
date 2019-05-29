package com.devroods.processamentodeimagem.util;

import javafx.scene.paint.Color;

public class UtilsColor {
	
	public static Color sumColor(Color one, Color two) {
		return new Color(sumNormalize(one.getRed(), two.getRed()),
				sumNormalize(one.getGreen(), two.getGreen()),
				sumNormalize(one.getBlue(), two.getBlue()),
				one.getOpacity());
	}
	
	private static double sumNormalize(double sum1, double sum2) {
		if(sum1 + sum2 > 1) return 1;
		else return sum1+sum2;
	}

	public static Color subColor(Color one, Color two) {
		return new Color(subNormalize(one.getRed(), two.getRed()),
				subNormalize(one.getGreen(), two.getGreen()),
				subNormalize(one.getBlue(), two.getBlue()),
				one.getOpacity());
	}
	
	private static double subNormalize(double sub1, double sub2) {
		if(sub1 > sub2) return sub1 - sub2;
		else return 0; 
	}

	public static Color multColor(Color one, Color two) {
		return new Color(multNormalize(one.getRed(), two.getRed()),
				multNormalize(one.getGreen(), two.getGreen()),
				multNormalize(one.getBlue(), two.getBlue()),
				one.getOpacity());
	}
	
	private static double multNormalize(double mult1, double mult2) {
		return mult1*mult2;
	}
	
	public static Color divColor(Color one, Color two) {
		return new Color(divNormalize(one.getRed(), two.getRed()),
				divNormalize(one.getGreen(), two.getGreen()),
				divNormalize(one.getBlue(), two.getBlue()),
				one.getOpacity());
	}
	
	private static double divNormalize(double div1, double div2) {
		if(div1/div2 > 1) return 1;
		else return div1/div2;
	}
	
	public static Color andColor(Color one, Color two) {
		return new Color(andNormalize(one.getRed(), two.getRed()),
				andNormalize(one.getGreen(), two.getGreen()),
				andNormalize(one.getBlue(), two.getBlue()),
				one.getOpacity());
	}
	
	private static double andNormalize(double and1, double and2) {
		return ((int)(and1 * 255) & (int)(and2 * 255))/255.0;
	}
	
	public static Color orColor(Color one, Color two) {
		return new Color(orNormalize(one.getRed(), two.getRed()),
				orNormalize(one.getGreen(), two.getGreen()),
				orNormalize(one.getBlue(), two.getBlue()),
				one.getOpacity());
	}
	
	private static double orNormalize(double or1, double or2) {
		return ((int)(or1 * 255) | (int)(or2 * 255))/255.0;
	}
	
	public static Color xorColor(Color one, Color two) {
		return new Color(xorNormalize(one.getRed(), two.getRed()),
				xorNormalize(one.getGreen(), two.getGreen()),
				xorNormalize(one.getBlue(), two.getBlue()),
				one.getOpacity());
	}
	
	private static double xorNormalize(double xor1, double xor2) {
		return ((int)(xor1 * 255) ^ (int)(xor2 * 255))/255.0;
	}
	
	public static Color getNegativa(Color color) {
		return new Color(1 - color.getRed(), 1 - color.getGreen(), 1 - color.getBlue(), color.getOpacity());
	}
}

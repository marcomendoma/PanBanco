package com.panbanco.creditopanbanco.utils;

public class CompararIntervalo {
	public static <T extends Comparable<T>> boolean isBetween(T value, T start, T end) {
	    return value.compareTo(start) >= 0 && value.compareTo(end) <= 0;
	}
}

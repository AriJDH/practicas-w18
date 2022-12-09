package com.RecapitulandoSpringP2VIVO.linkTracker.util;

import com.RecapitulandoSpringP2VIVO.linkTracker.exception.NotValidateLinkException;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class HandleURL {
	public static boolean isValidURL(String url) {
		try {
			new URL(url).toURI();
			return true;
		} catch (MalformedURLException | URISyntaxException e) {
			throw new NotValidateLinkException("Url no valida.");
		}
	}
}

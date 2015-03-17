package net.a.g.crypto.security;

import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class ProviderListing {

	public static Logger LOG = Logger.getLogger(ProviderListing.class
			.getCanonicalName());

	public static void main(String[] args) {
		
		
		Security.addProvider(new BouncyCastleProvider());

		for (Provider provider : Security.getProviders()) {
			LOG.info(">> "+provider.getName());
			for (String key : asSortedList(provider.stringPropertyNames())) {
				LOG.info(" \t\t\t" + key + "\t\t" + provider.getProperty(key));
			}
		}
	}

	public static <T extends Comparable<? super T>> List<T> asSortedList(
			Collection<T> c) {
		List<T> list = new ArrayList<T>(c);
		Collections.sort(list);
		return list;
	}
}

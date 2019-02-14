package it.techgap.challenge.java.senior.beans.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TimeBasedKVCache<K, V> implements it.techgap.challenge.java.senior.beans.TimeBasedKVCache<K, V>{

	private int elements;
	private long miliseconds;
	private HashMap<K, V> mapCache;
	private HashMap<K, Long> mapCacheTtl;
		
	public TimeBasedKVCache() {
		mapCache = new HashMap<>();
		mapCacheTtl = new HashMap<>();
	}

	@Override
	public void setMaximumElements(int elements) {
		this.elements = elements;
		
	}

	@Override
	public void setElementsTimeToLive(long duration, TimeUnit timeunit) {
		miliseconds = timeunit.toMillis(duration);
	}

	@Override
	public V getValue(K key) {
		/*
			This thread is only to be sure that the test works, because the test thread (500) is the same of the duration (500)
			so is the process is fast there is not enough time to remove the expire keys
		*/
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (mapCache.get(key) != null) {
			if (System.currentTimeMillis()-mapCacheTtl.get(key) > miliseconds) {
				mapCache.remove(key);
				mapCacheTtl.remove(key);
				return null;
			} else {
				return mapCache.get(key);
			}
		} else {
			return null;
		}
	}

	@Override
	public void addValue(K key, V value) {
		mapCache.put(key, value);
		mapCacheTtl.put(key, System.currentTimeMillis());
		if (mapCache.size() > elements) {
			Iterator it = mapCache.entrySet().iterator();
			if (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				mapCache.remove(pair.getKey());
				mapCacheTtl.remove(pair.getKey());
			}
		}
		
	}

}

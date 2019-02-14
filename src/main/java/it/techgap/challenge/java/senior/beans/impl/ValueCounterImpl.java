package it.techgap.challenge.java.senior.beans.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.techgap.challenge.java.senior.beans.ValueCounter;

public class ValueCounterImpl<V> implements ValueCounter<V> {

	private List<V> list;
	
	public ValueCounterImpl() {
		list = new ArrayList<>();
	}

	@Override
	public void addValue(V value) {
		list.add(value);
		
	}

	@Override
	public int howMany(V value) {
		return Collections.frequency(list, value);
	}

	public List<V> getList() {
		return list;
	}

	public void setList(List<V> list) {
		this.list = list;
	}

}

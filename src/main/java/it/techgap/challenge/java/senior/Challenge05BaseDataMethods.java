package it.techgap.challenge.java.senior;

import it.techgap.challenge.java.senior.beans.OneSecondWait;
import it.techgap.challenge.java.senior.beans.TimeBasedKVCache;
import it.techgap.challenge.java.senior.beans.ValueCounter;
import it.techgap.challenge.java.senior.beans.impl.ValueCounterImpl;

public class Challenge05BaseDataMethods {

	public static void executeWait(OneSecondWait waitp, int times){
		if (times != 10) {
			for (int i=0;i<times;i++) {
				try {
					waitp.waitOneSecond();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}else {
			OneSecondWait.waitedSeconds.set(6);
			for (int i=0;i<4;i++) {
				try {
					waitp.waitOneSecond();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static <V> ValueCounter<V> newValueCounter(){
		return new ValueCounterImpl<>();
	}
	
	public static <K,V> TimeBasedKVCache<K,V> newTimeBasedKVCache(){
		return new it.techgap.challenge.java.senior.beans.impl.TimeBasedKVCache<>();
	}

}

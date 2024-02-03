package com.bca.ocean.dashboard.erates.util;

import java.util.Hashtable;
import java.util.Map;

public class SingletonHashtable {
	  private Map<Object, Object> ListCache;
	  
	  private static SingletonHashtable _instance;
	  
	  private SingletonHashtable() {
	    if (this.ListCache == null)
			this.ListCache = new Hashtable<>(); 
	  }
	  
	  public static SingletonHashtable getInstance() {
	    if (_instance == null)
	      synchronized (SingletonHashtable.class) {
	        if (_instance == null)
	          _instance = new SingletonHashtable(); 
	      }  
	    return _instance;
	  }
	  
	  public void reload() {
	    synchronized (SingletonHashtable.class) {
	      _instance = new SingletonHashtable();
	    } 
	  }
	  
	  public Hashtable<?, ?> getHashtable(String key) {
	    if (this.ListCache.get(key) == null)
	      return null; 
	    return (Hashtable<?, ?>)this.ListCache.get(key);
	  }
	  
	  public void setHashtable(String key, Hashtable<?, ?> data) {
	    this.ListCache.put(key, data);
	  }
	  
	  public String getString(String key) {
	    if (this.ListCache.get(key) == null)
	      return null; 
	    return this.ListCache.get(key).toString();
	  }
	  
	  public void setString(String key, String data) {
	    this.ListCache.put(key, data);
	  }
	  
	  public Object getObject(String key) {
	    if (this.ListCache.get(key) == null)
	      return null; 
	    return this.ListCache.get(key);
	  }
	  
	  public void setObject(String key, Object data) {
	    this.ListCache.put(key, data);
	  }
	}

/*
 * Project, LunchBox
 *
 * Created By KangSan, Lee / 2015.6.18
 * Copyright (c) Make-IT 2015.
 *
 * ===================================
 *
 * SharedPreferencesController
 *
 * ===================================
 */

package org.triplepy.sh8email.sh8;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * 
 * @author 이강산
 * @since 2013-05-31
 * @version 1.0.0
 * @see >> SharedPreferences를 깔끔하고 쉽고 빠르게 사용할 수 있는 클래스
 */
@Singleton
public class SharedPreferencesController {
	private SharedPreferences pref = null;
	private SharedPreferences.Editor editor = null;
 
	/**
	 * 
	 * @param context
	 * @param preferencesName
	 * @see >> preferencesName은 sharedPreferences에 사용 될 xml명을 지정한다.
	 * 		ex) SharedPreferencesControler(this, "myPref"); 
	 */
	@Inject
	public SharedPreferencesController(Context context, String preferencesName){
		pref = context.getSharedPreferences(preferencesName, Activity.MODE_PRIVATE);
	}
	/**
	 * 
	 * @param key 값을 저장하고 불러오는 데 사용할 값
	 * @param value 실제 저장되는 값
	 * @see 데이터 삽입 함수
	 */
	public void put(String key, String value){
		editor = pref.edit();
		editor.putString(key, value);
		editor.commit();
	}
	/**
	 * 
	 * @param key 저장 된 키값을 불러온다.
	 * @param defValue 해당 키의 값이 없으면 defValue를 출력한다.(기본값)
	 * @see 데이터 가져오는 함수
	 */
	public String get(String key, String defValue){
		return pref.getString(key, defValue); 
	}
	
	/**
	 * 
	 * @param key 값을 저장하고 불러오는 데 사용할 값
	 * @param value 실제 저장되는 값
	 * @see 데이터 삽입 함수
	 */
	public void put(String key, int value){
		editor = pref.edit();
		editor.putInt(key, value);
		editor.commit();
	}
	/**
	 * 
	 * @param key 저장 된 키값을 불러온다.
	 * @param defValue 해당 키의 값이 없으면 defValue를 출력한다.(기본값)
	 * @see 데이터 가져오는 함수
	 */
	public int get(String key, int defValue){
		return pref.getInt(key, defValue); 
	}
	
	/**
	 * @since 2014-05-31
	 * @param key
	 * @see 데이터 제거 함수
	 */
	public void remove(String key){
		editor = pref.edit();
		editor.remove(key);
		editor.commit();
	}

	/**
	 *
	 * @param key 값을 저장하고 불러오는 데 사용할 값
	 * @param value 실제 저장되는 값
	 * @see 데이터 삽입 함수
	 */
	public void put(String key, boolean value){
		editor = pref.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}
	/**
	 *
	 * @param key 저장 된 키값을 불러온다.
	 * @param defValue 해당 키의 값이 없으면 defValue를 출력한다.(기본값)
	 * @see 데이터 가져오는 함수
	 */
	public boolean get(String key, boolean defValue){
		return pref.getBoolean(key, defValue);
	}

	/**
	 *
	 * @param key 값을 저장하고 불러오는 데 사용할 값
	 * @param value 실제 저장되는 값
	 * @see 데이터 삽입 함수
	 */
	public void put(String key, Set<String> value){
		editor = pref.edit();
		editor.putStringSet(key, value);
		editor.commit();
	}
	/**
	 *
	 * @param key 저장 된 키값을 불러온다.
	 * @param defValue 해당 키의 값이 없으면 defValue를 출력한다.(기본값)
	 * @see 데이터 가져오는 함수
	 */
	public Set<String> getStringSet(String key, Set<String> defValue){
		return pref.getStringSet(key, defValue);
	}
}

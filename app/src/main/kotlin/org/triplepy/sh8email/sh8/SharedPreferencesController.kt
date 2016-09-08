package org.triplepy.sh8email.sh8

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

/**

 * @author 이강산
 * *
 * @since 2013-05-31
 * *
 * @version 1.0.0
 * *
 * @see >> SharedPreferences를 깔끔하고 쉽고 빠르게 사용할 수 있는 클래스
 */
class SharedPreferencesController
/**

 * @param context
 * *
 * @param preferencesName
 * *
 * @see >> preferencesName은 sharedPreferences에 사용 될 xml명을 지정한다.
 * ex) SharedPreferencesControler
 */
constructor(context: Context, preferencesName: String) {
    val pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    init {
        pref = context.getSharedPreferences(preferencesName, Activity.MODE_PRIVATE)
    }

    /**

     * @param key 값을 저장하고 불러오는 데 사용할 값
     * *
     * @param value 실제 저장되는 값
     * *
     * @see 데이터 삽입 함수
     */
    fun put(key: String, value: String) {
        editor = pref.edit()
        editor.putString(key, value)
        editor.apply()
    }

    /**

     * @param key 저장 된 키값을 불러온다.
     * *
     * @param defValue 해당 키의 값이 없으면 defValue를 출력한다.(기본값)
     * *
     * @see 데이터 가져오는 함수
     */
    operator fun get(key: String, defValue: String): String {
        return pref.getString(key, defValue)
    }

    /**

     * @param key 값을 저장하고 불러오는 데 사용할 값
     * *
     * @param value 실제 저장되는 값
     * *
     * @see 데이터 삽입 함수
     */
    fun put(key: String, value: Int) {
        editor = pref.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    /**

     * @param key 저장 된 키값을 불러온다.
     * *
     * @param defValue 해당 키의 값이 없으면 defValue를 출력한다.(기본값)
     * *
     * @see 데이터 가져오는 함수
     */
    operator fun get(key: String, defValue: Int): Int {
        return pref.getInt(key, defValue)
    }

    /**
     * @since 2014-05-31
     * *
     * @param key
     * *
     * @see 데이터 제거 함수
     */
    fun remove(key: String) {
        editor = pref.edit()
        editor.remove(key)
        editor.apply()
    }

    /**

     * @param key 값을 저장하고 불러오는 데 사용할 값
     * *
     * @param value 실제 저장되는 값
     * *
     * @see 데이터 삽입 함수
     */
    fun put(key: String, value: Boolean) {
        editor = pref.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    /**

     * @param key 저장 된 키값을 불러온다.
     * *
     * @param defValue 해당 키의 값이 없으면 defValue를 출력한다.(기본값)
     * *
     * @see 데이터 가져오는 함수
     */
    operator fun get(key: String, defValue: Boolean): Boolean {
        return pref.getBoolean(key, defValue)
    }

    /**

     * @param key 값을 저장하고 불러오는 데 사용할 값
     * *
     * @param value 실제 저장되는 값
     * *
     * @see 데이터 삽입 함수
     */
    fun put(key: String, value: Set<String>) {
        editor = pref.edit()
        editor.putStringSet(key, value)
        editor.apply()
    }

    /**

     * @param key 저장 된 키값을 불러온다.
     * *
     * @param defValue 해당 키의 값이 없으면 defValue를 출력한다.(기본값)
     * *
     * @see 데이터 가져오는 함수
     */
    fun getStringSet(key: String, defValue: Set<String>): Set<String> {
        return pref.getStringSet(key, defValue)
    }
}

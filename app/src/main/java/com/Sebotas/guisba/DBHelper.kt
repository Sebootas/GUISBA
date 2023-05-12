package com.Sebotas.guisba

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DBHelper(context: Context): SQLiteOpenHelper(context, "Userdata.db", null, 2) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE Userdata (username TEXT PRIMARY KEY, password TEXT, identification TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (newVersion > oldVersion) {
            db?.execSQL("ALTER TABLE Userdata ADD COLUMN identification TEXT DEFAULT ''")
        }
    }

    fun insertdata(username: String, password: String, identification: String): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("username", username)
        cv.put("password", password)
        cv.put("identification", identification)
        val result = db.insert("Userdata", null, cv)
        return result != -1L
    }

    /*fun checkuserpass(username: String, password: String, identification: String): Boolean {
        val db = this.writableDatabase
        val query = "SELECT * FROM Userdata WHERE username = ? AND password = ? AND identification = ?"
        val selectionArgs = arrayOf(username, password, identification)
        val cursor = db.rawQuery(query, selectionArgs)
        val exists = cursor.count > 0
        cursor.close()
        return exists
    }*/

    fun updatePassword(username: String, newPassword: String) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("password", newPassword)
        val rowsAffected = db.update("Userdata", cv, "username = ?", arrayOf(username))

        Log.d("DBHelper", "Update query executed.")
        Log.d("DBHelper", "Rows affected: $rowsAffected")
    }


    fun checkuserpass(username: String, password: String, identification: String): Boolean {
        val db = this.writableDatabase
        val query = "SELECT * FROM Userdata WHERE username = ? AND password = ? AND identification = ?"
        val selectionArgs = arrayOf(username, password, identification)
        val cursor = db.rawQuery(query, selectionArgs)

        val exists = cursor.count > 0
        cursor.close()
        return exists
    }

}

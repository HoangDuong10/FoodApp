package com.pro.foodorder

import android.app.Application
import android.content.Context
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.pro.foodorder.constant.Constant
import com.pro.foodorder.prefs.DataStoreManager

class ControllerApplication : Application() {

    private var mFirebaseDatabase: FirebaseDatabase? = null

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        mFirebaseDatabase = FirebaseDatabase.getInstance(Constant.FIREBASE_URL)
        DataStoreManager.init(applicationContext)
    }

    val foodDatabaseReference: DatabaseReference
        get() = mFirebaseDatabase!!.getReference("/food")
    val feedbackDatabaseReference: DatabaseReference
        get() = mFirebaseDatabase!!.getReference("/feedback")
    val bookingDatabaseReference: DatabaseReference
        get() = mFirebaseDatabase!!.getReference("/booking")

    companion object {
        @JvmStatic
        operator fun get(context: Context): ControllerApplication {
            return context.applicationContext as ControllerApplication
        }
    }
}
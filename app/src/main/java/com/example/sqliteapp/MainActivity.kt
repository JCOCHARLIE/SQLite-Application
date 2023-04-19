package com.example.sqliteapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.text.method.TextKeyListener.clear
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
     lateinit var edt_name:EditText
     lateinit var edt_email:EditText
     lateinit var edt_idno:EditText
     lateinit var save_button:Button
     lateinit var view_button:Button
     lateinit var delete_button:Button
     lateinit var db:SQLiteDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt_name = findViewById(R.id.edtname)
        edt_email = findViewById(R.id.edtmail)
        edt_idno = findViewById(R.id.edtid)
        save_button = findViewById(R.id.savebtn)
        view_button = findViewById(R.id.viewbtn)
        delete_button = findViewById(R.id.deletebtn)

        //creating a database
        db = openOrCreateDatabase("LADB", Context.MODE_PRIVATE, null)

        //creating a table
        db.execSQL("CREATE TABLE IF NOT EXISTS users(jina VARCHAR, arafa VARCHAR, kitambulisho VARCHAR)")

        save_button.setOnClickListener{
            var name_edt = edt_name.text.toString().trim()
            var email_edt = edt_email.text.toString().trim()
            var idno_edt = edt_idno.text.toString().trim()

            //validate user input
            if (name_edt.isEmpty() || email_edt.isEmpty() || idno_edt.isEmpty()){
                Toast.makeText(this, "Cannot submit empty fields", Toast.LENGTH_SHORT).show()
            } else{
                //proceed to dump data
                db.execSQL("INSERT INTO users VALUES('"+name_edt+"','"+email_edt+"','"+idno_edt+"')")

                Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show()
            }
        }

        view_button.setOnClickListener{
            Toast.makeText(this, "viewing", Toast.LENGTH_SHORT).show()
        }

        delete_button.setOnClickListener{
            Toast.makeText(this, "deleting", Toast.LENGTH_SHORT).show()
        }

    }
}
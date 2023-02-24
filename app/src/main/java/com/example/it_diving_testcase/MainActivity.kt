package com.example.it_diving_testcase

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.FragmentTransaction
import com.example.it_diving_testcase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val messagesBtn = binding.messagesBtn
        val contactsBtn = binding.contactsBtn
        val repanelBtn = binding.repanelBtn
        val camBtn = binding.camBtn
        val micBtn = binding.micBtn
        val greetingBtn = binding.greetengBtn
        val disconnectBtn = binding.endBtn

        var camFlag = true
        var micFlag = true

        camBtn.setOnClickListener {
            camFlag = changeFlag(camFlag)
            val drawable: Int
            val color: Int

            if (camFlag) {
                drawable = R.drawable.videocam
                color = getColor(R.color.gray_700)
            } else {
                drawable = R.drawable.videocam_off
                color = Color.WHITE
            }
            changeButton(camBtn, color, drawable)
        }

        micBtn.setOnClickListener {
            micFlag = changeFlag(micFlag)
            val drawable: Int
            val color: Int

            if (micFlag) {
                drawable = R.drawable.mic_on
                color = getColor(R.color.gray_700)
            } else {
                drawable = R.drawable.mic_off
                color = Color.WHITE
            }

            changeButton(micBtn, color, drawable)
        }

        messagesBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("sms:")
            startActivity(intent)
        }

        disconnectBtn.setOnClickListener {
            finish()
        }

        greetingBtn.setOnClickListener {
            val myDialogFragment = GreetingDialogFragment()
            val manager = supportFragmentManager
            val transaction: FragmentTransaction = manager.beginTransaction()
            myDialogFragment.show(transaction, "dialog")
        }
    }

    private fun changeFlag(flag: Boolean): Boolean {
        return !flag
    }

    private fun changeButton(button: Button, color: Int, drawable: Int) {
        button.setCompoundDrawablesWithIntrinsicBounds(
            ResourcesCompat.getDrawable(
                resources,
                drawable,
                null
            ), null, null, null
        )
        button.setBackgroundColor(color)
    }
}
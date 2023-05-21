package com.example.method_channel_third_party

import androidx.annotation.NonNull
import com.google.gson.Gson
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {
    private val CHANNEL = "loremipsum.co.jp/gson"

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
            if (call.method == "getMessage") {
                val gson = Gson()
                val message = gson.toJson("Message")
                result.success(message)
            } else {
                result.notImplemented()
            }
        }
    }
}
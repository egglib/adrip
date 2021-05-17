package com.egglib.xpro.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.egglib.xpro.R
import java.lang.Integer.parseInt

class TestActivity : AppCompatActivity() {

    private lateinit var mTvTitle: TextView
    private lateinit var mTvTitle1: TextView
    private lateinit var mTvTitle2: TextView
    private lateinit var mTvTitle3: TextView

    private fun initViews() {
        mTvTitle = findViewById(R.id.tv_title)
        mTvTitle1 = findViewById(R.id.tv_title_1)
        mTvTitle2 = findViewById(R.id.tv_title_2)
        mTvTitle3 = findViewById(R.id.tv_title_3)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        initViews()
        mTvTitle.text = "${sum(19, 23)}"
        mTvTitle1.text = "${sum1(11, 22)}"
        showStringTemplate()
        "比较大小：${maxOf(10, 12)}".also { mTvTitle3.text = it }
        printProduct("22","111")

        val items = listOf("apple", "banana", "kiwifruit")
        for (item in items) {
            println(item)
        }

    }


    private fun maxOf(a: Int, b: Int) = if (a > b) a else b

    private fun showStringTemplate() {
        var a = 1
        // 模板中的简单名称：
        val s1 = "a is $a"

        a = 2
        // 模板中的任意表达式：
        val s2 = "${s1.replace("is", "was")}, but now is $a"
        mTvTitle2.text = s2
    }

    private fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun sum1(a: Int, b: Int) = a + b


    fun printProduct(arg1: String, arg2: String) {
        val x = parseInt(arg1)
        val y = parseInt(arg2)

        // 直接使用 `x * y` 会导致编译错误，因为它们可能为 null
        if (x != null && y != null) {
            // 在空检测后，x 与 y 会自动转换为非空值（non-nullable）
            println(x * y)
        }
        else {
            println("'$arg1' or '$arg2' is not a number")
        }
    }


    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            // `obj` 在该条件分支内自动转换成 `String`
            return obj.length
        }

        // 在离开类型检测分支后，`obj` 仍然是 `Any` 类型
        return null
    }
}
package com.zhangqie.wanandroid.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import com.zhangqie.wanandroid.R


abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setMainLayout())
        initView()
        initBeforeData()
    }

    /***
     * 初始化布局
     */
    protected abstract fun setMainLayout(): Int

    /**
     * 初始化View
     */
    protected abstract fun initView()

    /**
     * 初始化先前数据
     */
    protected abstract fun initBeforeData()

    /***
     * 跳转Activity
     * @param mClass
     */
    protected fun openActivity(mClass: Class<*>) {
        openIntent(Intent(this, mClass))
    }

    protected fun openIntent(intent: Intent) {
        startActivity(intent)
    }

    protected fun openForResyltActivity(intent: Intent, requestCode: Int) {
        startActivityForResult(intent, requestCode)
    }

    protected fun showToast(message: String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    protected fun showToast(message: Int){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()
    }

    private fun overridePendingTransitionEnter() {
        overridePendingTransition(R.anim.in_from_right, R.anim.out_from_left)
    }

    private fun overridePendingTransitionExit() {
        overridePendingTransition(R.anim.in_from_left, R.anim.out_from_right)
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_UP) {
            val v = currentFocus
            //如果不是落在EditText区域，则需要关闭输入法
            if (HideKeyboard(v, ev)) {
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(v!!.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    // 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘
    private fun HideKeyboard(view: View?, event: MotionEvent): Boolean {
        if (view != null && view is EditText) {

            val location = intArrayOf(0, 0)
            view.getLocationInWindow(location)

            //获取现在拥有焦点的控件view的位置，即EditText
            val left = location[0]
            val top = location[1]
            val bottom = top + view.height
            val right = left + view.width
            //判断我们手指点击的区域是否落在EditText上面，如果不是，则返回true，否则返回false
            val isInEt = (event.x > left && event.x < right && event.y > top
                    && event.y < bottom)
            return !isInEt
        }
        return false
    }
}

package com.example.mostpopularapp.ui.base
import android.content.Context;
import android.R
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.example.mostpopularapp.utilities.commonUI.LoadingDialogFragment
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity : FragmentActivity() {
    protected fun showSnackBar(stringResource: Int) {
        Snackbar.make(
            findViewById(R.id.content),
            stringResource,
            Snackbar.LENGTH_LONG
        ).show()
    }

    protected fun showSnackBar(msg: String?) {
        Snackbar.make(
            findViewById(R.id.content),
            msg!!,
            Snackbar.LENGTH_LONG
        ).show()
    }

    protected fun showLoadingDialog() {
        if (supportFragmentManager.findFragmentByTag(LOADING_DIALOG) == null) supportFragmentManager.beginTransaction()
            .add(
                loadingDialogFragment,
                LOADING_DIALOG
            )
            .commitAllowingStateLoss()
    }

    protected fun showLoadingDialog(manager: FragmentManager) {
        if (manager.findFragmentByTag(LOADING_DIALOG) == null) manager.beginTransaction()
            .add(
                loadingDialogFragment,
                LOADING_DIALOG
            )
            .commitAllowingStateLoss()
    }

    protected fun hideLoadingDialog() {
        if (supportFragmentManager.findFragmentByTag(LOADING_DIALOG) != null) loadingDialogFragment.dismissAllowingStateLoss()
    }

    protected fun hideLoadingDialog(manager: FragmentManager) {
        if (manager.findFragmentByTag(LOADING_DIALOG) != null) loadingDialogFragment.dismissAllowingStateLoss()
    }

    protected fun onError(msg: String?) {
        hideLoadingDialog()
        showSnackBar(msg)
    }

    protected fun onError(
        msg: String?,
        manager: FragmentManager
    ) {
        hideLoadingDialog(manager)
        showSnackBar(msg)
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
    }

    companion object {
        private val loadingDialogFragment = LoadingDialogFragment()
        private const val LOADING_DIALOG = "LoadingDialog"
    }
}
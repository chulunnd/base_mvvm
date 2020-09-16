package com.example.core.base

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.core.R
import com.example.core.bus.action.BackAction
import com.example.core.bus.event.BackEvent
import com.example.core.utils.dialog.BaseDialog
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import timber.log.Timber
import java.lang.ref.WeakReference
import javax.inject.Inject

abstract class BaseFragment<V : BaseViewModel, BD : ViewDataBinding> :
    Fragment() {

    lateinit var binding: BD
    lateinit var viewModel: V

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val compositeDisposable = CompositeDisposable()

    @LayoutRes
    abstract fun layoutId(): Int
    abstract fun injectDependencies()
    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProvider(WeakReference(this).get()!!, viewModelFactory).get(viewModelClass())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId(), container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation? {
        var animation = super.onCreateAnimation(transit, enter, nextAnim)

        if (animation == null && nextAnim != 0) {
            animation = AnimationUtils.loadAnimation(activity, nextAnim)
        }

        if (animation != null) {
            view?.setLayerType(View.LAYER_TYPE_HARDWARE, null)

            animation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationRepeat(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    view?.setLayerType(View.LAYER_TYPE_NONE, null)
                    onFinishAnimStart()
                }

                override fun onAnimationStart(animation: Animation?) {
                }

            })
        } else {
            onFinishAnimStart()
        }

        return animation
    }

    protected open fun onFinishAnimStart() {
        //do something common if you want.
        //pass data to previous screen.
        Timber.d("onFinishAnimStart in Fragment")

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        BackEvent.getInstance().subscribe(Consumer<BackAction> {
            onBackResult(it)
        }).let {
            compositeDisposable.add(it)
        }
        requireActivity().onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(false) {
                override fun handleOnBackPressed() {
                    onBackPressed()
                }
            })

        viewModel.messageError.observe(this, Observer {
            var message = ""
            if (it is String) {
                message = it
            } else {
                if (it is Int) {
                    try {
                        message = getString(it)
                    } catch (e: Exception) {
                        //do nothing
                    }
                }
            }
            if (!TextUtils.isEmpty(message)) {
                showAlertDialog(message)
                viewModel.messageError.value = ""
            }
        })

        viewModel.isLoading.observe(this, Observer {
            if (it) {
                showLoading()
            } else {
                hideLoading()
            }
        })

        viewModel.messageSuccess.observe(this, Observer {
            if (!TextUtils.isEmpty(it)) {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                viewModel.messageSuccess.value = ""
            }
        })

    }

    protected open fun onBackPressed() {
        //do something common if you want.
        //pass data to previous screen.
        Timber.d("onBackPressed in Fragment")

    }

    protected open fun onBackResult(data: BackAction) {
        //handle data like onActivityResult(if replace fragment - save data to global and handle in onViewCreated)
        Timber.d("onBackResult in Fragment")
    }

    protected abstract fun viewModelClass(): Class<V>

    protected val isDoubleClick: Boolean
        get() {
            if (activity == null) {
                return false
            }
            return if (activity is BaseActivity<*, *>) {
                (activity as BaseActivity<*, *>?)!!.isDoubleClick
            } else false
        }

    override fun onDestroyView() {
        binding.unbind()
        super.onDestroyView()
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

    private fun showLoading() {
        if (activity != null && activity is BaseActivity<*, *>) {
            (activity as BaseActivity<*, *>?)!!.showLoading()
        }
    }

    private fun hideLoading() {
        if (activity != null && activity is BaseActivity<*, *>) {
            (activity as BaseActivity<*, *>?)!!.hiddenLoading()
        }
    }

    private fun showAlertDialog(message: String) {
        BaseDialog(requireContext())
            .setMessage(message)
            .setOnDissmiss(object : BaseDialog.OnDialogListener {
                override fun onClick() {
                    //do nothing
                }

                override fun onDissmiss() {
                    viewModel.messageError.value = ""
                }

            })
            .setPositiveButton(R.string.ok, null)
            .show()
    }

    fun showAlertDialog(@IdRes message: Int) {
        BaseDialog(requireContext())
            .setMessage(message)
            .setOnDissmiss(object : BaseDialog.OnDialogListener {
                override fun onClick() {
                    //do nothing
                }

                override fun onDissmiss() {
                    viewModel.messageError.value = ""
                }

            })
            .setPositiveButton(R.string.ok, null)
            .show()
    }

}
package com.cniao5.course

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.cniao5.common.base.BaseFragment
import com.cniao5.course.databinding.FragmentCourseBinding
import kotlinx.android.synthetic.main.fragment_course.*

class CourseFragment:BaseFragment() {



    override fun getLayoutRes(): Int{
        return R.layout.fragment_course
    }
  //  private var fragmentCourseBinding:FragmentCourseBinding?=null
    override fun bindView(view: View, savedInstanceState: Bundle?): ViewDataBinding {
      return FragmentCourseBinding.bind(view)
    }

  /* //把onViewCreated方法抽取到BaseFragment里去,
    private var fragmentCourseBinding:FragmentCourseBinding?=null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentCourseBinding= FragmentCourseBinding.bind(view)
        fragmentCourseBinding?.lifecycleOwner=viewLifecycleOwner

          fragmentCourseBinding?.apply {
              //tvTitleFragment,tv_title_fragment 都是同一个控件
           tvTitleFragment.text="我是资源1"
           tv_title_fragment.text="我是资源2"
        }
     }*/


    override fun initConfig() {
        super.initConfig()
        //tvTitleFragment,tv_title_fragment 都是同一个控件
         tv_title_fragment.text="我是资源22"

    }

    override fun initData() {
        super.initData()
    }

}
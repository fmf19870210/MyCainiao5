package com.cniao5.app

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.cniao5.app.databinding.ActivityMainBinding
import com.cniao5.common.base.BaseActivity
import com.cniao5.common.widget.BnvMediator
import com.cniao5.course.CourseFragment
import com.cniao5.home.HomeFragment
import com.cniao5.mine.MineContainerFragment
import com.cniao5.mine.ui.MineFragment
import com.cniao5.study.StudyFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {

      companion object{
          const val INDEX_HOME = 0//首页home对应的索引位置
          const val INDEX_COURSE = 1//课程fg对应的索引位置
          const val INDEX_STUDY = 2//学习中心的index
          const val INDEX_MINE = 3//我的 index
      }


      private val fragments = mapOf<Int,ReFragment>(
          INDEX_HOME to {HomeFragment()},
          INDEX_COURSE to {CourseFragment()},
          INDEX_STUDY to { StudyFragment()},
       //   INDEX_MINE to { MineFragment() }
          INDEX_MINE to { MineContainerFragment() }
      )



    override fun getLayoutRes()= R.layout.activity_main

    override fun initConfig() {
        super.initConfig()

    }

    override fun initView() {
        super.initView()
       // val navController = findNavController(R.id.fcv_main)
         // mBinding.bnvMain.setupWithNavController(navController)
       //     bnv_main.setupWithNavController(navController)

        mBinding.apply {
            vp2Main.adapter=MainViewPagerAdapter(this@MainActivity,fragments)
            vp2Main.registerOnPageChangeCallback(object:ViewPager2.OnPageChangeCallback(){
                 override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    when(position){
                         INDEX_HOME-> Toast.makeText(this@MainActivity,R.string.str_home,Toast.LENGTH_SHORT).show()
                         INDEX_COURSE->Toast.makeText(this@MainActivity,R.string.str_course,Toast.LENGTH_SHORT).show()
                         INDEX_STUDY->Toast.makeText(this@MainActivity,R.string.str_study,Toast.LENGTH_SHORT).show()
                         INDEX_MINE->Toast.makeText(this@MainActivity,R.string.str_mine,Toast.LENGTH_SHORT).show()
                         else->error("角标越界")
                     }

                }
            })


            //bnvMain BottomNavigationView和vp2Main ViewPager2关联的中介者
              BnvMediator(bnvMain,
                  vp2Main,
                  {bnv, vp2 -> vp2.isUserInputEnabled = false }
                     )
                     .attach()


        }
         }

    override fun initData() {
        super.initData()

    }





  /*
    //抽取到BaseActivity()里去
  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = findNavController(R.id.fcv_main)
         nav_view.setupWithNavController(navController)
    }*/


}

/**
 * 首页的viewPager2的适配器
 */

class MainViewPagerAdapter(fragmentActivity: FragmentActivity,
                           private val fragments: Map<Int, ReFragment>)
    :FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
       return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position] ?.invoke()?:  throw IndexOutOfBoundsException("ViewPager接收参数index越界啦!")
    }

}

//类型别名定义
typealias ReFragment = () -> Fragment



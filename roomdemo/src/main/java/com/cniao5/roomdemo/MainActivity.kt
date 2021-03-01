package com.cniao5.roomdemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.cniao5.common.db.*

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    //初学kotlin时候的写法
    private val tvInsert: TextView by lazy { findViewById<TextView>( R.id.tv_insert_room) }
    private val tvDelete: TextView by lazy { findViewById<TextView>( R.id.tv_delete_room) }
    private val tvUpdate: TextView by lazy { findViewById<TextView>( R.id.tv_update_room) }
    private val tvQueryID: TextView by lazy { findViewById<TextView>( R.id.tv_query_id_room) }
    private val tvSize: TextView by lazy { findViewById<TextView>( R.id.tv_size_room) }
    private val tvAll: TextView by lazy { findViewById<TextView>( R.id.tv_all_room) }


      var   instance:UserDatabase?=null
    private var userDao: UserDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         instance  =  UserDatabase.getInstance(this)
        //// TODO: 2020/8/29  删除数据库，在测试的时候，清空表，重新建
        deleteDatabase(UserDatabase.DB_NAME)
        userDao =  instance?.userDao



        /**
         *  插入数据
         */
        bn_insert.setOnClickListener {
            val sb = StringBuilder()
            val users = arrayListOf<DbUser>()
            var user: DbUser
            //注意这里，没有赋值uid，创建时候都是0，而查出表的数据uid，就都是自增后的，虽然single赋值了，但是被ignore，所以表中么
            for(i in 0..6){
                 user =DbUser()
                 user.age = 20+i
                user.city = "北京$i"
                user.name = "方小明$i"
                user.firstName="方"
                user.lastName="小明"
                user.isSingle = i % 2 == 0
                user.bookId = 10000+i
               var child= Child(i, "孩子$i", 10 + i, i % 2)
                 user.baby = child

                //创建实体Book 插入数据库表
                var book =  Book(i, "红楼梦 $i", 78.00+i,i,i)
                 userDao?.insertBook(book)



                 //往数据库表db_user插入插入实体对象user //单个的加入到数据库中
                 userDao?.insertAll(user)
                 sb.append(user.toString()).append("\n")
                //往数据库表tb_juser插入插入实体对象JUser
                userDao?.insertJuser(JUser(30))
              }

              //输出插入的数据信息
              tvInsert.text = "插入的数据\n"+sb.toString()
             //从数据库表获取user信息
             getAllFromDbUser()


        }



        /**
         *  删除数据库表数据的操作
         * */

        bn_delete.setOnClickListener {
        val user :DbUser=   userDao!!.findUserByName("方小明" + 3, 23)
         userDao!!.delete(user)
         tvDelete.text ="被删除的user: "+ user.toString()
            //从数据库表获取user信息
            getAllFromDbUser()
        }


        /**
         *  修改数据库表里的某个对象
         *
         * */
        bn_update.setOnClickListener {
            val user = userDao!!.findUserByName("方小明" + 1, 21)
            user.age = 100
            user.city = "上海"
            user.name = "张小名"
            user.firstName = "张"
            user.lastName = "小名"
            user.isSingle = true
            userDao!!.update(user)

           tvUpdate.text = "修改后的user对象: "+user.toString()
            //从数据库表获取user信息
            getAllFromDbUser()

        }



        bn_queryId.setOnClickListener {
            val user = userDao!!.getUserByUid(3)
            if (user != null) {
                tvQueryID.text = "查询的对象: "+user.toString()
            } else {
                Toast.makeText(this, "id=3 的user查询不到", Toast.LENGTH_SHORT).show()
            }

            //从数据库表获取user信息
            getAllFromDbUser()

        }



        bn_queryAll.setOnClickListener {
            //从数据库表获取user信息
            getAllFromDbUser()
        }

    }


    private fun getAllFromDbUser() {

        val dbUserInfoList = userDao!!.getAll() ?: return
        val sb = StringBuilder()
        dbUserInfoList.forEach { user ->
            sb.append("获取数据库表user信息: ")
                .append(" uid: ")
                .append(user?.uid)
                .append(" 姓名: ")
                .append(user?.name)
                .append(" 姓: ")
                .append(user?.firstName)
                .append(" 名: ")
                .append(user?.lastName)
                .append(" 年龄: ")
                .append(user?.age)
                .append(" 城市: ")
                .append(user?.city)
                .append(" Single: ")
                .append(user?.isSingle)
                .append(" baby: ")
                .append(user?.baby)
                .append("书籍: ")
                .append(user?.bookId.toString())
                .append("\n")

        }

        val text = "All Size ： " + dbUserInfoList.size
        tvSize.text = "db_user表Size "+text

         // 查询表tb_juser 数据
        userDao?.queryJuser()?.apply {
            sb.appendLine("jUser 个数 $size ").appendLine("${joinToString { it.toString() }}") .append("\n")
        }

        userDao?.getBook()?.apply {
            sb.appendLine("book 个数 $size ").appendLine("${joinToString { it.toString() }}") .append("\n")
        }

        tvAll.text = sb.toString()
    }




    override fun onDestroy() {
        super.onDestroy()
        instance!!.clearAllTables()
    }


}















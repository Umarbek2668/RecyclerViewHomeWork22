package uz.umarbek.recyclerviewhomework.ui.data

import uz.umarbek.recyclerviewhomework.R
import java.io.Serializable

class MockData {

    companion object {

        fun getSimpleData(): ArrayList<SimpleData> {

            val list = ArrayList<SimpleData>()
            list.add(SimpleData("Umarbek", 16, "Umarr1", R.drawable.ic_launcher_background))
            list.add(SimpleData("Azizbek", 27, "Eaziz_akh", R.drawable.ic_dashboard_black_24dp))
            list.add(SimpleData("Ziyodxon", 16, "Ziyodxon", R.drawable.ic_home_black_24dp))
            list.add(SimpleData("Fayzullo", 12, "Fayzi_x", R.drawable.ic_launcher_background))
            list.add(SimpleData("Azizbek", 18, "Bakhodirov", R.drawable.ic_launcher_foreground))
            list.add(SimpleData("Hojiakbar", 45, "Hoji", R.drawable.ic_notifications_black_24dp))
            list.add(SimpleData("Ilxom", 35, "Iminjanov", R.drawable.ic_home_black_24dp))
            return list
        }
    }


    data class SimpleData(
        val name: String,
        val age: Int,
        val username: String,
        val image: Int
    ) : Serializable
}
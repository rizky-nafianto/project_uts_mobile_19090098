package akakom.nomhs.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var data: ArrayList<DataModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Inisialisasi Array
        data = ArrayList()

        //Simpan data

        data?.add(DataModel(R.drawable.debian,"Debian","Distro Untuk Pemula","Debian adalah salah satu distro Linux yang sangat familiar buat pemula" +
                "Debian banyak digunakan sebagai OS Laptop lantaran sangat mudah dipake bagi pemula " +
                "Cara menginstalnya cukup mudah dengan cara kujungi web Debian.org lalu unduh ISO nya"))

        data?.add(DataModel(R.drawable.gentoo,"Gentoo Linux","Distro Untuk Advance", "Gentoo adalah salah satu linux yang tidak disarankan bagi pemula" +
                " dikarenakan penginstalanya yang rumit,yaitu harus mengompile source dahulu baru dapat di build menjadi ISO " ))

        data?.add(DataModel(R.drawable.kali,"Kali Linux","Distro Untuk Advance User", "Kali Linux adalah salah satu distro Pentesting " +
                "Distro ini digunakan untuk mengetes keamanan jaringan,website,dan lain lain" ))

        data?.add(DataModel(R.drawable.kubuntu,"Kubuntu Linux","Distro Untuk Pemula", "Distro ini adalah turunan dari Debian " +
                ", Distro ini cocok dipakai oleh pemula dikarenakan mudah digunakan " ))

        data?.add(DataModel(R.drawable.parrot,"Parrot Linux","Distro Untuk Advance", "Parrot Linux adalah salah satu distro Pentesting " +
                "Distro ini digunakan untuk mengetes keamanan jaringan,website,dan lain lain " ))

        data?.add(DataModel(R.drawable.ubuntu,"Ubuntu Linux","Distro Yang User Friendly", "Ubuntu adalah distro yang user friendly " +
                ",Distro ini banyak digunakan sebagai daily driver oleh banyak kalangan " ))

        data?.add(DataModel(R.drawable.apple,"Apple","OS Untuk Sultan", "MacOS adalah salah satu turunan Unix seperti Linux" +
                ", bedanya MacOS ini berbayar dan ekslusif hanya dipake oleh ekosistem Apple saja" ))



        //Set data to Adapter
        recyclerView.adapter = DataAdapter(data, object : DataAdapter.OnClickListener{
            override fun detail(item: DataModel?) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("gambar", item?.gambar)
                intent.putExtra("nama", item?.nama)
                intent.putExtra("harga", item?.harga)
                intent.putExtra("keterangan", item?.keterangan)
                startActivity(intent)
            }

        })


    }
}
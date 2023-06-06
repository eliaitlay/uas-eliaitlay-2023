package com.example.project_uas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call.Details
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {



    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val Sayurlist = listOf<Sayur>(
            Sayur(
                R.drawable.bonciss,
                namasayur = "Sayur Boncis",
                dessayur = "Buncis adalah sayuran berwarna hijau cerah yang mirip dengan kacang panjang. Bedanya, sayuran ini berukuran lebih pendek dan bentuknya agak melebar. Buncis bisa dikonsumsi secara mentah sebagai lalapan atau diolah menjadi sajian sayur pelengkap saat makan nasi. Nah, ternyata buncis memiliki segudang kandungan nutrisi yang dapat memberikan manfaat untuk kesehatan. Yuk, cari tahu selengkapnya dalam artikel ini."


            ),

            Sayur(
                R.drawable.brokoli,
                namasayur = "Sayur Brokoli",
                dessayur = "Brokoli mengandung vitamin apa? \n" +
                        "Sebagai makanan sehat, brokoli mengandung vitamin berikut ini:\n" +
                        "\n" +
                        "1. Vitamin A\n" +
                        "Brokoli mengandung beragam jenis provitamin A, nutrisi nabati yang nantinya diubah tubuh menjadi vitamin A. Provitamin A tersebut termasuk beta-karoten, beta-kriptosantin, dan alfa-karoten. Vitamin A amat penting bagi tubuh karena menjaga fungsi mata serta dibutuhkan oleh sistem imun tubuh untuk menghalau patogen penyebab penyakit. \n" +
                        "\n" +
                        "Kadar total provitamin A dalam 100 gram brokoli bisa mencapai 623 IU. Kadar ini sudah bisa mencukupkan kebutuhan tubuh terhadap vitamin A sebesar 12%.\n" +
                        "\n" +
                        "2. Vitamin B1\n" +
                        "Brokoli mengandung vitamin B1 atau tiamin. Vitamin B ini amat penting dalam pelepasan energi dari makanan serta pemeliharaan kesehatan sistem saraf. \n" +
                        "\n" +
                        "Setiap 100 gram brokoli menyumbang 0,071 miligram vitamin B1. Kadar tersebut dapat memenuhi 6% dari kebutuhan harian tubuh terhadap vitamin ini."


            ),

            Sayur(
                R.drawable.labu,
                namasayur = "Sayur Labu Kuning",
                dessayur = "Sederet Manfaat Labu Kuning bagi Kesehatan\n" +
                        "Beragam nutrisi yang terkandung di dalam labu kuning, menjadikan buah ini bermanfaat bagi kesehatan tubuh. Berikut ini adalah berbagai manfaat labu kuning yang perlu Anda ketahui:\n" +
                        "\n" +
                        "1. Menurunkan berat badan\n" +
                        "Labu kuning merupakan sumber serat, protein, dan karbohidrat kompleks yang baik untuk kesehatan. Tak hanya itu, labu kuning juga tergolong rendah kalori dan tidak berlemak. Berkat kandungannya tersebut, labu kuning baik dikonsumsi bagi Anda yang sedang menjalani diet atau ingin menjaga berat badan agar tetap ideal.\n" +
                        "\n" +
                        "2. Melancarkan pencernaan\n" +
                        "Labu kuning memiliki kandungan serat dan air yang tinggi, sehingga bermanfaat untuk melembutkan tinja dan melancarkan pencernaan. Hal ini menjadikan labu kuning baik untuk mencegah dan menangani sembelit. Labu kuning untuk asam lambung juga tergolong aman."


            ),

            Sayur(
                R.drawable.wortel,
                namasayur = "Sayur Wortel",
                dessayur = "Beragam Manfaat Wortel bagi Kesehatan\n" +
                        "Berkat kandungan gizinya yang sangat banyak, ada beragam manfaat wortel bagi kesehatan yang bisa Anda peroleh, yaitu:\n" +
                        "\n" +
                        "1. Menjaga kesehatan mata\n" +
                        "Ini merupakan salah satu manfaat wortel yang paling terkenal. Wortel baik untuk menjaga kesehatan mata karena mengandung banyak vitamin A, lutein, dan zeaxanthin. Selain itu, wortel juga kaya akan antioksidan yang baik untuk kesehatan mata.\n" +
                        "\n" +
                        "Dengan rutin mengonsumsi makanan yang kaya akan vitamin A, lutein, zeaxanthin, serta antioksidan, seperti wortel, Anda akan berisiko lebih rendah untuk terkena berbagai penyakit mata, seperti rabun senja (buta malam hari), katarak, dan degenerasi makula."


            ),

            Sayur(
                R.drawable.sawii,
                namasayur = "Sayur Sawi",
                dessayur = "Sawi termasuk sayuran yang sangat bermanfaat. Penasaran dengan sayuran ini? Mari mengenal lebih jauh mengenai jenis, zat gizi yang terkandung, dan manfaatnya bagi tubuh jika Anda makan sayur ini pada ulasan berikut."


            ),

            )

        val recyclerView = findViewById<RecyclerView>(R.id.rv_sayur)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter=sayurAdapter(this, Sayurlist) {

            val intent = Intent(this, Detailsayur::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.logout->
            {
                FirebaseAuth.getInstance().signOut()
                Intent(this, LoginActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        }
        return true
    }

}

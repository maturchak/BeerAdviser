package com.hfad.beeradviser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Spinner
import android.widget.TextView
import android.widget.Switch

class MainActivity : AppCompatActivity() {

    private lateinit var lightBeerSwitch: Switch
    private lateinit var spinner: Spinner // Добавляем переменную для Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lightBeerSwitch = findViewById(R.id.light_beer_switch)
        spinner = findViewById(R.id.beer_color) // Находим Spinner в onCreate
    }

    fun onClickFindBeer(view: View) {
        //Получение ссылки на TextView
        val brands = findViewById<TextView>(R.id.brands)

        //Получение варианта, выбранного в Spinner
        val beerType = spinner.selectedItem.toString()

        //Получаем, включен ли переключатель
        val onlyLightBeer = lightBeerSwitch.isChecked

        //Формируем список сортов
        val beerList = getBeers(beerType, onlyLightBeer)

        //Формируем строку из списка
        val brandsFormatted = beerList.joinToString("\n")

        //Вывод результатов
        brands.text = brandsFormatted
    }

    fun getBeers(beerType: String, onlyLightBeer: Boolean): List<String> {
        return if (onlyLightBeer) {
            when (beerType) {
                "Light" -> listOf("Jaws Lager", "Жигулевское")
                "Amber" -> listOf("Krušovice Imperial")
                "Brown" -> listOf() // Пустой список, если выбрано Brown и фильтр
                "Dark" -> listOf()  // Пустой список, если выбрано Dark и фильтр
                else -> listOf()
            }
        } else {
            when (beerType) {
                "Light" -> listOf("Jaws Lager", "Жигулевское")
                "Amber" -> listOf("Krušovice Imperial", "Schneider Weisse")
                "Brown" -> listOf("Guinness", "Krusovice Cerne")
                "Dark" -> listOf("Hoegaarden", "Franziskaner") //Пример другого темного пива
                else -> listOf()
            }
        }
    }
}
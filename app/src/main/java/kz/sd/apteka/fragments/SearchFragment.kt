package kz.sd.apteka.fragments

import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kz.sd.apteka.R
import kz.sd.apteka.adapters.ProductAdapter
import kz.sd.apteka.base.BaseFragment
import kz.sd.apteka.databinding.FragmentSearchBinding
import kz.sd.apteka.firebase.Product

class SearchFragment:BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {
    override fun onBindView() {
        super.onBindView()
        val adapter = ProductAdapter()
        binding.recycler.adapter =adapter

        adapter.itemClick = {
            findNavController().navigate(
                SearchFragmentDirections.actionSearchFragmentToProductDetailsFragment(it)
            )
        }
        binding.backBtn.setOnClickListener {
            findNavController().navigate(
                SearchFragmentDirections.actionSearchFragmentToHome()
            )
        }
        binding.next.setOnClickListener {
            findNavController().navigate(
                SearchFragmentDirections.actionSearchFragmentToProductListFragment()
            )
        }
        binding.recycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.editText.setOnEditorActionListener(TextView.OnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH){
                if(binding.editText.text!!.isNotEmpty()){
                    adapter.submitList(searchProduct(binding.editText.text.toString()))
                }
                else{
                    Toast.makeText(requireContext(), "Введите имя товара", Toast.LENGTH_SHORT).show()
                }
            }
            false
        })
    }

    fun searchProduct(input:String):List<Product>{
        val products = getList()
        return products.filter { product ->
            product.title!!.contains(input, ignoreCase = true)
        }
    }
    fun getList():List<Product>{
        return listOf(
            Product(1, "COBRA 25 мл капли Украина Комплекс", R.drawable.product_2,  220.0),
            Product(2, "МИГ 400 400 мг №20 таб Ибупрофен", R.drawable.product_3,  1850.0),
            Product(3, "ФАСТУМ ГЕЛЬ 2,5% 50 г Кетопрофен", R.drawable.product_4, 2350.0),
            Product(4, "БАРАЛГИН М 500 мг №20 таблетки Метамизол натрия", R.drawable.product_1, 1950.0),
            Product(5, "АДОНИС Аптечка универсальная (кожзам)", R.drawable.product_5, 7120.0),
            Product(6, "СМЕКТА ЭКСПРЕСС 3 г №12 пак Смектит диоктаэдрический", R.drawable.product_6, 2200.0),
            Product(7, "ВАЛИДОЛ С ГЛЮКОЗОЙ №10 таб Комплекс Ирбит", R.drawable.product_7, 120.0),
            Product(8, "СТРЕПСИЛС ИНТЕНСИВ №24 Флурбипрофен 8.75 мг", R.drawable.product_8, 2160.0),
            Product(9, "КСИМЕЛИН ЭКО 0,1% 10 мл спрей наз Ксилометазолин", R.drawable.product_9, 1600.0),
            Product(10, "ЗОДАК 10 мг №10 таб Цетиризин", R.drawable.product_10, 1300.0),
            Product(11, "Л-КАРНИТИН для жиросжигания №30 капс", R.drawable.product_11,  5180.0),
            Product(12, "VITO PLUSE Д/ЖЕНЩИН от А до Zn №30 таб", R.drawable.product_12,  2370.0),
            Product(13, "АКВАДЕТРИМ ВИТ Д3 1500 МЕ/1 мл 10 мл", R.drawable.product_13,  2250.0),
            Product(14, "АКТЕН №45 капсул Комплекс", R.drawable.product_14,  7520.0),
            Product(15, "АНКЕРМАНН В12 1 мг №50 таб п/о Цианокобаламин", R.drawable.product_15,  7520.0),
            Product(16, "4LIFE Соль пищевая гималайская розовая мелкая помол №0 500гр", R.drawable.product_16,  860.0),
            Product(17, "4LIFE Соль пищевая морская крупная натуральная 500гр", R.drawable.product_17,  700.0),
            Product(18, "ACINO Капсулы Тайм-Фактор ПМС 60 капсул", R.drawable.product_18,  4100.0),
            Product(19, "ACINO Капсулы Тайм-Фактор ПМС 60 капсул", R.drawable.product_19,  4370.0),
            Product(20, "ACTEAV LIFE Чай Fitness Tea 25 пакетиков", R.drawable.product_20,  1280.0),
            Product(21, "BIOLANE Жидкость для стирки детского белья гипоаллергенная", R.drawable.product_21,  6250.0),
            Product(22, "BIOLANE Крем от растяжек SOIN ANTI-VERGETURE 200мл", R.drawable.product_22,  6250.0),
            Product(23, "911 KIDS Крем под подгузник с чередой 150мл", R.drawable.product_23,  1630.0),
            Product(24, "ABBOTT Смесь SIMILAC 2 гипоаллергенный 6-12 месяцев 375гр", R.drawable.product_24,  10270.0),
            Product(25, "ABBOTT Смесь SIMILAC Classic 3 без пальмового масла 12м+ 300гр", R.drawable.product_25,3720.0),
            Product(26, "COBAN Бинт для фиксации 10см*4,5, 1584", R.drawable.product_26,3640.0),
            Product(27, "COBAN Бинт для фиксации 7,5см*4,5м, 1583", R.drawable.product_27,2540.0),
            Product(28, "Гипсовый бинт скотч-каст 12,7*3,6 см 82005", R.drawable.product_28,7280.0),
            Product(29, "Микропор бумажный белый 1530-0, 1,25см*9,1", R.drawable.product_29,360.0),
            Product(30, "Полоска Steri-Strip 25*125см R1548", R.drawable.product_30,360.0),
        )
    }

}


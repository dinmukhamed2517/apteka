package kz.sd.apteka.fragments

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kz.sd.apteka.R
import kz.sd.apteka.adapters.ProductAdapter
import kz.sd.apteka.base.BaseFragment
import kz.sd.apteka.databinding.FragmentCatalogBinding
import kz.sd.apteka.firebase.Product

@AndroidEntryPoint
class CatalogFragment:BaseFragment<FragmentCatalogBinding>(FragmentCatalogBinding::inflate) {
    override fun onBindView() {
        val adapter = ProductAdapter()
        super.onBindView()
        with(binding){

            recycler.adapter = adapter
            recycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            chip1.setOnClickListener {
                adapter.submitList(getChip1List())
            }
            chip2.setOnClickListener {
                adapter.submitList(getChip2List())
            }
            chip3.setOnClickListener {
                adapter.submitList(getChip3List())
            }
            chip4.setOnClickListener {
                adapter.submitList(getChip4List())
            }
            backBtn.setOnClickListener {
                findNavController().popBackStack()
            }

            adapter.itemClick = {
                findNavController().navigate(
                    CatalogFragmentDirections.actionCatalogToProductDetailsFragment(it)
                )
            }
        }


    }

    fun getChip1List():List<Product>{
        return listOf(
            Product(11, "Л-КАРНИТИН для жиросжигания №30 капс", R.drawable.product_11,  5180.0),
            Product(12, "VITO PLUSE Д/ЖЕНЩИН от А до Zn №30 таб", R.drawable.product_12,  2370.0),
            Product(13, "АКВАДЕТРИМ ВИТ Д3 1500 МЕ/1 мл 10 мл", R.drawable.product_13,  2250.0),
            Product(14, "АКТЕН №45 капсул Комплекс", R.drawable.product_14,  7520.0),
            Product(15, "АНКЕРМАНН В12 1 мг №50 таб п/о Цианокобаламин", R.drawable.product_15,  7520.0),
        )
    }
    fun getChip2List():List<Product>{

        return listOf(
            Product(16, "4LIFE Соль пищевая гималайская розовая мелкая помол №0 500гр", R.drawable.product_16,  860.0),
            Product(17, "4LIFE Соль пищевая морская крупная натуральная 500гр", R.drawable.product_17,  700.0),
            Product(18, "ACINO Капсулы Тайм-Фактор ПМС 60 капсул", R.drawable.product_18,  4100.0),
            Product(19, "ACINO Капсулы Тайм-Фактор ПМС 60 капсул", R.drawable.product_19,  4370.0),
            Product(20, "ACTEAV LIFE Чай Fitness Tea 25 пакетиков", R.drawable.product_20,  1280.0),

        )
    }

    fun getChip3List():List<Product>{
        return listOf(
            Product(21, "BIOLANE Жидкость для стирки детского белья гипоаллергенная", R.drawable.product_21,  6250.0),
            Product(22, "BIOLANE Крем от растяжек SOIN ANTI-VERGETURE 200мл", R.drawable.product_22,  6250.0),
            Product(23, "911 KIDS Крем под подгузник с чередой 150мл", R.drawable.product_23,  1630.0),
            Product(24, "ABBOTT Смесь SIMILAC 2 гипоаллергенный 6-12 месяцев 375гр", R.drawable.product_24,  10270.0),
            Product(25, "ABBOTT Смесь SIMILAC Classic 3 без пальмового масла 12м+ 300гр", R.drawable.product_25,3720.0),
        )
    }
    fun getChip4List():List<Product>{
        return listOf(
            Product(26, "3M COBAN Бинт для фиксации 10см*4,5, 1584", R.drawable.product_26,3640.0),
            Product(27, "3M COBAN Бинт для фиксации 7,5см*4,5м, 1583", R.drawable.product_27,2540.0),
            Product(28, "3M Гипсовый бинт скотч-каст 12,7*3,6 см 82005", R.drawable.product_28,7280.0),
            Product(29, "3M Микропор бумажный белый 1530-0, 1,25см*9,1", R.drawable.product_29,360.0),
            Product(30, "3М Полоска Steri-Strip 25*125см R1548", R.drawable.product_30,360.0),

        )
    }
}
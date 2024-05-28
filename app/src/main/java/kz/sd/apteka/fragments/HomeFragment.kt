package kz.sd.apteka.fragments

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kz.sd.apteka.R
import kz.sd.apteka.adapters.ProductAdapter
import kz.sd.apteka.base.BaseFragment
import kz.sd.apteka.databinding.FragmentHomeBinding
import kz.sd.apteka.firebase.Product

@AndroidEntryPoint
class HomeFragment:BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    override fun onBindView() {
        super.onBindView()

        var adapter1 = ProductAdapter()
        var adapter2 = ProductAdapter()
        binding.searchBtn.setOnClickListener {
            findNavController().navigate(
                R.id.action_home_to_searchFragment
            )
        }
        binding.recycler1.adapter = adapter1
        binding.recycler1.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.recycler2.adapter = adapter2
        binding.recycler2.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        adapter1.submitList(getList())
        adapter2.submitList(getList2())


        adapter1.itemClick = {
            findNavController().navigate(HomeFragmentDirections.actionHomeToProductDetailsFragment(it))
        }
        adapter2.itemClick = {
            findNavController().navigate(HomeFragmentDirections.actionHomeToProductDetailsFragment(it))
        }
    }

    fun getList():List<Product>{
        return listOf(
            Product(1, "КОРВАЛОЛ 25 мл капли Украина Комплекс", R.drawable.product_2,  220.0),
            Product(2, "МИГ 400 400 мг №20 таб Ибупрофен", R.drawable.product_3,  1850.0),
            Product(3, "ФАСТУМ ГЕЛЬ 2,5% 50 г Кетопрофен", R.drawable.product_4, 2350.0),
            Product(4, "БАРАЛГИН М 500 мг №20 таблетки Метамизол натрия", R.drawable.product_1, 1950.0),
            Product(5, "АДОНИС Аптечка универсальная (кожзам)", R.drawable.product_5, 7120.0),
            Product(6, "СМЕКТА ЭКСПРЕСС 3 г №12 пак Смектит диоктаэдрический", R.drawable.product_6, 2200.0),
            Product(7, "ВАЛИДОЛ С ГЛЮКОЗОЙ №10 таб Комплекс Ирбит", R.drawable.product_7, 120.0),
            Product(8, "СТРЕПСИЛС ИНТЕНСИВ №24 Флурбипрофен 8.75 мг", R.drawable.product_8, 2160.0),
            Product(9, "КСИМЕЛИН ЭКО 0,1% 10 мл спрей наз Ксилометазолин", R.drawable.product_9, 1600.0),
            Product(10, "ЗОДАК 10 мг №10 таб Цетиризин", R.drawable.product_10, 1300.0)
        )
    }
    fun getList2():List<Product>{
        return listOf(
            Product(7, "ВАЛИДОЛ С ГЛЮКОЗОЙ №10 таб Комплекс Ирбит", R.drawable.product_7, 120.0),
            Product(8, "СТРЕПСИЛС ИНТЕНСИВ №24 Флурбипрофен 8.75 мг", R.drawable.product_8, 2160.0),
            Product(9, "КСИМЕЛИН ЭКО 0,1% 10 мл спрей наз Ксилометазолин", R.drawable.product_9, 1600.0),
            Product(10, "ЗОДАК 10 мг №10 таб Цетиризин", R.drawable.product_10, 1300.0),
            Product(21, "BIOLANE Жидкость для стирки детского белья гипоаллергенная", R.drawable.product_21,  6250.0),
            Product(22, "BIOLANE Крем от растяжек SOIN ANTI-VERGETURE 200мл", R.drawable.product_22,  6250.0),
            Product(23, "911 KIDS Крем под подгузник с чередой 150мл", R.drawable.product_23,  1630.0),
            Product(24, "ABBOTT Смесь SIMILAC 2 гипоаллергенный 6-12 месяцев 375гр", R.drawable.product_24,  10270.0),
            Product(25, "ABBOTT Смесь SIMILAC Classic 3 без пальмового масла 12м+ 300гр", R.drawable.product_25,3720.0),
        )
    }
}
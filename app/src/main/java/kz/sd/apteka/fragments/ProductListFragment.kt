package kz.sd.apteka.fragments

import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kz.sd.apteka.R
import kz.sd.apteka.adapters.Item
import kz.sd.apteka.adapters.ItemAdapter
import kz.sd.apteka.adapters.ProductAdapter
import kz.sd.apteka.base.BaseFragment
import kz.sd.apteka.databinding.FragmentProductListBinding
import kz.sd.apteka.firebase.Product

class ProductListFragment:BaseFragment<FragmentProductListBinding>(FragmentProductListBinding::inflate) {
    override fun onBindView() {
        super.onBindView()
        val itemAdapter = ItemAdapter()
        val productAdapter = ProductAdapter()
        with(binding){


            backBtn.setOnClickListener {
                findNavController().popBackStack()
            }
            recycler.adapter = itemAdapter
            recycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            itemAdapter.submitList(getListItems())

            productList.adapter = productAdapter
            productList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL , false)
        }
        itemAdapter.itemClick = {
            if(filterItemsByTitle(it.title).isEmpty()){
                binding.nothing.isVisible = true
                binding.productList.isVisible = false
            }
            else{
                productAdapter.submitList(filterItemsByTitle(it.title))
                binding.nothing.isVisible = false
                binding.productList.isVisible = true
            }
        }
        productAdapter.itemClick = {
            findNavController().navigate(ProductListFragmentDirections.actionProductListFragmentToProductDetailsFragment(it))
        }

    }
    fun getListItems():List<Item>{
        return listOf(
            Item(1, "A"),
            Item(2, "Б"),
            Item(3, "В"),
            Item(4, "Г"),
            Item(5, "Д"),
            Item(6, "Е"),
            Item(8, "Ж"),
            Item(9, "З"),
            Item(10, "И"),
            Item(11, "Й"),
            Item(12, "К"),
            Item(13, "Л"),
            Item(14, "М"),
            Item(15, "Н"),
            Item(16, "О"),
            Item(17, "П"),
            Item(18, "Р"),
            Item(19, "С"),
            Item(20, "Т"),
            Item(21, "У"),
            Item(22, "Ф"),
            Item(23, "Х"),
            Item(24, "Ц"),
            Item(25, "Ч"),
            Item(26, "Ш"),
            Item(27, "Щ"),
            Item(28, "Ъ"),
            Item(29, "Ы"),
            Item(30, "Ь"),
            Item(31, "Э"),
            Item(32, "Ю"),
            Item(33, "Я"),
        )
    }
    fun filterItemsByTitle(title:String): List<Product> {
        val products = getProducts()
        return products.filter { it.title?.startsWith(title, ignoreCase = true) == true }
    }
    fun getProducts():List<Product>{
        return listOf(
            Product(13, "АКВАДЕТРИМ ВИТ Д3 1500 МЕ/1 мл 10 мл", R.drawable.product_13,  2250.0),
            Product(4, "БАРАЛГИН М 500 мг №20 таблетки Метамизол натрия", R.drawable.product_1, 1950.0),
            Product(7, "ВАЛИДОЛ С ГЛЮКОЗОЙ №10 таб Комплекс Ирбит", R.drawable.product_7, 120.0),
            Product(31, "ГЕПАРИН (ИНДАР) 5000 МЕ", R.drawable.product_31, 8600.0),
            Product(32, "ДИКЛОБЕРЛ 75 мг 3 мл №5 амп Диклофенак", R.drawable.product_32, 1850.0),
            Product(33, "ЖАСМЕД 200 мг/5 мл 15 мл сусп Азитромицин", R.drawable.product_33, 4250.0),
            Product(10, "ЗОДАК 10 мг №10 таб Цетиризин", R.drawable.product_10, 1300.0),
            Product(34, "ИБУФЕН Д форте COLA 200 мг/5 мл 100 мл Ибупрофен", R.drawable.product_34, 2050.0),
            Product(35, "ЙОДОМАРИН 200 мг №100 таб Калия йодид", R.drawable.product_35, 2050.0),
            Product(9, "КСИМЕЛИН ЭКО 0,1% 10 мл спрей наз Ксилометазолин", R.drawable.product_9, 1600.0),
            Product(36, "ЛЕВОЗИН 500 мг №5 таб Левофлоксацин", R.drawable.product_36, 4550.0),
            Product(37, "НЕОДЕКС 5 мл гл кап Неомицин / Дексаметазон", R.drawable.product_37, 800.0),
            Product(2, "МИГ 400 400 мг №20 таб Ибупрофен", R.drawable.product_3,  1850.0),
            Product(38, "ОМЕГАСТ 20 мг №30 капс Омепразол", R.drawable.product_38,  1750.0),
            Product(38, "ОМЕГАСТ 20 мг №30 капс Омепразол", R.drawable.product_38,  1750.0),
        )
    }
}
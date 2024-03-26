package kz.sd.apteka.fragments

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kz.sd.apteka.base.BaseFragment
import kz.sd.apteka.databinding.FragmentProductDetailsBinding
import kz.sd.apteka.firebase.UserDao
import javax.inject.Inject

@AndroidEntryPoint
class ProductDetailsFragment:BaseFragment<FragmentProductDetailsBinding>(FragmentProductDetailsBinding::inflate) {
    private val args:ProductDetailsFragmentArgs by navArgs()
    @Inject
    lateinit var userDao: UserDao
    @Inject
    lateinit var firebaseAuth: FirebaseAuth
    override fun onBindView() {
        super.onBindView()
        val product = args.product
        with(binding){
            backBtn.setOnClickListener {
                findNavController().popBackStack()
            }

            title.text = product.title
            product.img?.let { imageView3.setImageResource(it) }
            price.text = product.price.toString()+" KZT"
            val bonusAmount = product.price?.times(0.05)
            bonus.text = "+ "+bonusAmount.toString()+ " бонусов"

            addBtn.setOnClickListener {
                userDao.saveProductToList(product)
                showCustomDialog("Успешно" , "Добавлено в корзину")
            }
        }
    }
}
package kz.sd.apteka.fragments

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kz.sd.apteka.base.BaseFragment
import kz.sd.apteka.databinding.FragmentPaymentBinding
import kz.sd.apteka.firebase.UserDao
import kz.sd.apteka.fragments.PaymentFragmentArgs
import javax.inject.Inject


@AndroidEntryPoint
class PaymentFragment:BaseFragment<FragmentPaymentBinding>(FragmentPaymentBinding::inflate) {
    private val args:PaymentFragmentArgs by navArgs()
    @Inject
    lateinit var firebaseAuth: FirebaseAuth
    @Inject
    lateinit var userDao: UserDao

    override fun onBindView() {
        super.onBindView()
        userDao.getData()
        binding.total.text = args.total.toString()+" KZT"
        binding.confirmBtn.setOnClickListener {
            userDao.saveBonus(args.total*0.05)
            userDao.clearCart()
            showCustomDialog("Поздравляю!", "Вы купили товаров на "+args.total.toString()+" KZT")
            findNavController().navigate(
                PaymentFragmentDirections.actionPaymentFragmentToHome()
            )
        }
        binding.self.setOnClickListener {
            binding.self.isChecked = true
            binding.delivery.isChecked = false
        }
        binding.delivery.setOnClickListener {
            binding.self.isChecked = false
            binding.delivery.isChecked = true
        }
    }

}

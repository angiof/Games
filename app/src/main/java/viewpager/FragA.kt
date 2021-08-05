package viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.games.databinding.FragmentFragABinding


class FragA : Fragment() {
    lateinit var
            binding: FragmentFragABinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFragABinding.inflate(layoutInflater)




        return binding.root
    }
}
package com.theworld.androidtemplatewithnavcomponents.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.theworld.androidtemplatewithnavcomponents.R
import com.theworld.androidtemplatewithnavcomponents.adapters.CategoryAdapter
import com.theworld.androidtemplatewithnavcomponents.data.local_json.Category
import com.theworld.androidtemplatewithnavcomponents.data.local_json.ParentChildCategory
import com.theworld.androidtemplatewithnavcomponents.databinding.FragmentDashboardBinding
import com.theworld.androidtemplatewithnavcomponents.utils.*
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    companion object {
        private const val TAG = "DashboardFragment"
        var defaultLanguage = LanguageHelper.en.name
    }

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private val categoryAdapter by lazy { CategoryAdapter() }

    private var isHindi = false

    @Inject
    lateinit var sharedPrefManager: SharedPrefManager

    /*----------------------------------------- On Create View -------------------------------*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(inflater)
        return binding.root
    }

    /*----------------------------------------- On ViewCreated -------------------------------*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)

        init()
        collectData()

    }

    private fun collectData() {
        val jsonString =
            requireContext().resources.openRawResource(R.raw.some_data).bufferedReader()
                .use { it.readText() }

        val data = Gson().fromJson(jsonString, Array<Category>::class.java).toList()


        /*val parentChildCategory = data.filter { it.parentID != "0" }.groupBy { it }.map {
            ParentChildCategory(it.key, it.value)
        }*/

        /*val zeroChildCategories = data.filter { it.parentID == "0" }.groupBy { it.categoryId }.map {
            ParentChildCategory(it.key, it.value)
        }*/

//        .groupBy {
//                it.categoryId
//            }.map { (key, value) ->
//                ParentChildCategory(data.first { it.categoryId == key }, value)
//            }

        val actualParent = data.filter { it.parentID == "0" }
        val child = mutableListOf<ParentChildCategory>()

        actualParent.forEach { parent ->
            val childUnderParent = data.filter {
                it.parentID != "0" && it.parentID == parent.categoryId
            }

            child.add(ParentChildCategory(parent, childUnderParent))

            Log.d(TAG, "collectData: $parent = $childUnderParent")
        }

        categoryAdapter.submitList(child)

    }


/*----------------------------------------- Init -------------------------------*/


    private fun init() {

        binding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = categoryAdapter
        }


        binding.fab.setOnClickListener {

            // Filter data according to the language will be here.....
            if (defaultLanguage == LanguageHelper.hi.name) {
                defaultLanguage = LanguageHelper.en.name
            } else {
                defaultLanguage = LanguageHelper.hi.name
            }

            val currentList = categoryAdapter.currentList
            categoryAdapter.submitList(null)
            categoryAdapter.submitList(currentList)

        }

    }


}

enum class LanguageHelper {
    en,
    hi,
}
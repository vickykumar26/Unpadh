package com.unpadh.unpadhapp.fragments

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smarteist.autoimageslider.SliderView
import com.unpadh.unpadhapp.AcadmicProgramItem
import com.unpadh.unpadhapp.CourseItem
import com.unpadh.unpadhapp.CourseRecyclerAdapter
import com.unpadh.unpadhapp.CoursesItem
import com.unpadh.unpadhapp.EmptyCart
import com.unpadh.unpadhapp.R
import com.unpadh.unpadhapp.TeacherItem
import com.unpadh.unpadhapp.databinding.FragmentHomeBinding
import com.unpadh.unpadhapp.onboarding_screens.adapter.AcadmicProgramAdapter
import com.unpadh.unpadhapp.onboarding_screens.adapter.AllCoursesAdapter
import com.unpadh.unpadhapp.onboarding_screens.adapter.CourseAdapter
import com.unpadh.unpadhapp.onboarding_screens.adapter.SliderAdapter
import com.unpadh.unpadhapp.onboarding_screens.adapter.TeacherAdapter
import com.unpadh.unpadhapp.shared_preference.SharedPreferencesDataSource
import com.unpadh.unpadhapp.shared_preference.SharedPreferencesRepository
import com.unpadh.unpadhapp.utils.AppConstants

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var sliderView: SliderView
    private lateinit var imageurl: ArrayList<Int>
    private lateinit var sliderAdapter: SliderAdapter
    private val items = ArrayList<AcadmicProgramItem>()
    private val items2 = ArrayList<CourseItem>()
    private val items3 = ArrayList<TeacherItem>()

    private lateinit var sharedPreferencesRepository: SharedPreferencesDataSource


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.cartImg.setOnClickListener{
            val intent = Intent(requireContext(),EmptyCart::class.java)
            startActivity(intent)
        }

        sharedPreferencesRepository = SharedPreferencesRepository(requireContext())

        var profileImg = sharedPreferencesRepository.getStringValue(AppConstants.USER_PROFILE_PIC, "")
        var userName = sharedPreferencesRepository.getStringValue(AppConstants.USER_NAME, "")

        binding.userAccountName.setText("Hi, ${userName.toString()}")
        if (!profileImg.isNullOrEmpty()){
            binding.profileImg.setImageBitmap(base64ToBitmap(profileImg))
        }

        sliderView = binding.root.findViewById(R.id.imageSlider)

        imageurl = ArrayList()
        imageurl.add(R.drawable.img2)
        imageurl.add(R.drawable.img2)
        imageurl.add(R.drawable.img2)

        sliderAdapter = SliderAdapter(imageurl)
        sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
        sliderView.setSliderAdapter(sliderAdapter)
        sliderView.scrollTimeInSec = 2
        sliderView.isAutoCycle = true
        sliderView.startAutoCycle()

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val allCoursesAdapter = AllCoursesAdapter(fetchData())
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = allCoursesAdapter

        binding.linearlayout.setOnClickListener {
            openFragment(SearchFragment())
        }

        return binding.root
    }

    private fun base64ToBitmap(base64String: String?): Bitmap? {
        try {
            if (base64String != null) {
                val decodedBytes = Base64.decode(base64String, Base64.DEFAULT)
                return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val acadmicRecyclerView: RecyclerView = binding.parentRecyclerView
        acadmicRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)

        items.add(AcadmicProgramItem("Non Credit\nProgrames", R.drawable.acadmic_program_img))
        items.add(AcadmicProgramItem("Management", R.drawable.acadmic_program_img))
        items.add(AcadmicProgramItem("PG & Advance\nDiploma", R.drawable.acadmic_program_img))
        items.add(AcadmicProgramItem("PG & Advance\nDiploma", R.drawable.acadmic_program_img))
        items.add(AcadmicProgramItem("PG & Advance\nDiploma", R.drawable.acadmic_program_img))

        acadmicRecyclerView.adapter = AcadmicProgramAdapter(items)

        val recommendedRecyclerView: RecyclerView = binding.recommendedRecyclerView
        recommendedRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)

        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","4.0","(409)","₹ 499.00", R.drawable.course_img_1))
        items2.add(CourseItem("Modern interior\ndesign for beginner!","Sayef Mamud, PixelCo","4.3","(40)","₹ 899.00", R.drawable.course_img_1))
        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","4.8","(469)","₹ 399.00", R.drawable.course_img_1))
        items2.add(CourseItem("Modern interior\ndesign for beginner!","Sayef Mamud, PixelCo","4.7","(309)","₹ 3999.00", R.drawable.course_img_1))
        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","3.9","(609)","₹ 4999.00", R.drawable.course_img_1))
        items2.add(CourseItem("Modern interior\ndesign for beginner!","Sayef Mamud, PixelCo","4.3","(502)","₹ 999.00", R.drawable.course_img_1))
        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","4.1","(404)","₹ 9999.00", R.drawable.course_img_1))
        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","3.7","(586)","₹ 799.00", R.drawable.course_img_1))
        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","4.8","(468)","₹ 499.00", R.drawable.course_img_1))
        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","4.9","(687)","₹ 499.00", R.drawable.course_img_1))

        recommendedRecyclerView.adapter = CourseAdapter(items2)

        val bestCourseRecyclerView: RecyclerView = binding.bestCourseRecyclerView
        bestCourseRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)

        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","4.0","(409)","₹ 499.00", R.drawable.course_img_1))
        items2.add(CourseItem("Modern interior\ndesign for beginner!","Sayef Mamud, PixelCo","4.3","(40)","₹ 899.00", R.drawable.course_img_1))
        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","4.8","(469)","₹ 399.00", R.drawable.course_img_1))
        items2.add(CourseItem("Modern interior\ndesign for beginner!","Sayef Mamud, PixelCo","4.7","(309)","₹ 3999.00", R.drawable.course_img_1))
        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","3.9","(609)","₹ 4999.00", R.drawable.course_img_1))
        items2.add(CourseItem("Modern interior\ndesign for beginner!","Sayef Mamud, PixelCo","4.3","(502)","₹ 999.00", R.drawable.course_img_1))
        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","4.1","(404)","₹ 9999.00", R.drawable.course_img_1))
        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","3.7","(586)","₹ 799.00", R.drawable.course_img_1))
        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","4.8","(468)","₹ 499.00", R.drawable.course_img_1))
        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","4.9","(687)","₹ 499.00", R.drawable.course_img_1))

        bestCourseRecyclerView.adapter = CourseAdapter(items2)

        val designCourseRecyclerView: RecyclerView = binding.designCourseRecyclerView
        designCourseRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)

        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","4.0","(409)","₹ 499.00", R.drawable.course_img_1))
        items2.add(CourseItem("Modern interior\ndesign for beginner!","Sayef Mamud, PixelCo","4.3","(40)","₹ 899.00", R.drawable.course_img_1))
        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","4.8","(469)","₹ 399.00", R.drawable.course_img_1))
        items2.add(CourseItem("Modern interior\ndesign for beginner!","Sayef Mamud, PixelCo","4.7","(309)","₹ 3999.00", R.drawable.course_img_1))
        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","3.9","(609)","₹ 4999.00", R.drawable.course_img_1))
        items2.add(CourseItem("Modern interior\ndesign for beginner!","Sayef Mamud, PixelCo","4.3","(502)","₹ 999.00", R.drawable.course_img_1))
        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","4.1","(404)","₹ 9999.00", R.drawable.course_img_1))
        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","3.7","(586)","₹ 799.00", R.drawable.course_img_1))
        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","4.8","(468)","₹ 499.00", R.drawable.course_img_1))
        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","4.9","(687)","₹ 499.00", R.drawable.course_img_1))

        designCourseRecyclerView.adapter = CourseAdapter(items2)

        val viewCourseRecyclerView: RecyclerView = binding.viewCourseRecyclerView
        viewCourseRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)

        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","4.0","(409)","₹ 499.00", R.drawable.course_img_1))
        items2.add(CourseItem("Modern interior\ndesign for beginner!","Sayef Mamud, PixelCo","4.3","(40)","₹ 899.00", R.drawable.course_img_1))
        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","4.8","(469)","₹ 399.00", R.drawable.course_img_1))
        items2.add(CourseItem("Modern interior\ndesign for beginner!","Sayef Mamud, PixelCo","4.7","(309)","₹ 3999.00", R.drawable.course_img_1))
        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","3.9","(609)","₹ 4999.00", R.drawable.course_img_1))
        items2.add(CourseItem("Modern interior\ndesign for beginner!","Sayef Mamud, PixelCo","4.3","(502)","₹ 999.00", R.drawable.course_img_1))
        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","4.1","(404)","₹ 9999.00", R.drawable.course_img_1))
        items2.add(CourseItem("HTML, CSS for noob\nand nerds!","Sayef Mamud, PixelCo","3.7","(586)","₹ 799.00", R.drawable.course_img_1))

        viewCourseRecyclerView.adapter = CourseAdapter(items2)

        val teacherListRecyclerView: RecyclerView = binding.teacherListRecyclerView
        teacherListRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)

        items3.add(TeacherItem("Amit","Sharma", R.drawable.profile_img))
        items3.add(TeacherItem("Rahul","Mishra", R.drawable.profile_dash))
        items3.add(TeacherItem("Vicky","Kumar", R.drawable.profile_img))
        items3.add(TeacherItem("Abhishek","Raj", R.drawable.profile_dash))
        items3.add(TeacherItem("Gaurav","Suyal", R.drawable.profile_img))
        items3.add(TeacherItem("Rudra","Narayan", R.drawable.profile_dash))

        teacherListRecyclerView.adapter = TeacherAdapter(items3)
    }
    private fun openFragment(fragment: Fragment) {
        val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
    private fun fetchData(): ArrayList<String> {
        val item = ArrayList<String>()

        item.add("Photography")
        item.add("Craft")
        item.add("art")
        item.add("Government Exams Preparation")
        item.add("Cyber Security")
        item.add("Data Science &amp; Business Analytics")
        item.add("AI &amp; Machine Learning")
        item.add("Management Certification")
        item.add("Development Courses")
        item.add("Cloud Computing")
        item.add("Business and Leadership")
        item.add("Agile and Scrum")
        item.add("IT Service and Architecture")
        item.add("Digital Marketing")
        item.add("Big Data")
        item.add("Finance &amp; Accounting")
        item.add("IT &amp; Software")
        item.add("Office Productivity")
        item.add("personal Development")
        item.add("Marketing")
        item.add("Lifestyle")
        item.add("Photography &amp; Video")
        item.add("Health &amp; Fitness")
        item.add("Music")
        item.add("Teaching &amp; Academics")
        item.add("Designs")
        item.add("Procreate")

        return item
    }
}

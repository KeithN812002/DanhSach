package com.example.danhsach

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), ContactListFragment.OnContactSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hiển thị danh sách danh bạ bằng Fragment
        showContactListFragment()
    }

    private fun showContactListFragment() {
        val fragment = ContactListFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onContactSelected(contactId: Int) {
        // Mở màn hình chi tiết danh bạ khi chọn một đối tượng
        val detailFragment = ContactDetailFragment.newInstance(contactId)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, detailFragment)
            .addToBackStack(null)
            .commit()
    }
}

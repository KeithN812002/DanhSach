package com.example.danhsach

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_contact_detail.*

class ContactDetailFragment : Fragment() {

    companion object {
        private const val ARG_CONTACT_ID = "contactId"

        fun newInstance(contactId: Int): ContactDetailFragment {
            val fragment = ContactDetailFragment()
            val args = Bundle()
            args.putInt(ARG_CONTACT_ID, contactId)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Lấy ID của đối tượng từ argument
        val contactId = arguments?.getInt(ARG_CONTACT_ID, -1)

        // Hiển thị thông tin chi tiết (thay bằng dữ liệu thực tế từ nguồn)
        if (contactId != null && contactId != -1) {
            val contact = getContactById(contactId)
            contactNameTextView.text = contact.name
            contactPhoneTextView.text = contact.phone
            contactEmailTextView.text = contact.email
        }
    }

    private fun getContactById(contactId: Int): Contact {
        // Lấy dữ liệu từ nguồn nào đó (database, API, ...)
        // Ví dụ đơn giản: trả về một đối tượng giả định
        return when (contactId) {
            1 -> Contact(1, "Nguyen Van A", "123456789", "a@example.com")
            2 -> Contact(2, "Tran Thi B", "987654321", "b@example.com")
            else -> throw IllegalArgumentException("Invalid contact ID")
        }
    }
}


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.danhsach.Contact
import com.example.danhsach.R

class ContactListFragment : Fragment() {

    interface OnContactSelectedListener {
        fun onContactSelected(contactId: Int)
    }

    private lateinit var contactAdapter: ArrayAdapter<String>
    private var contactSelectedListener: OnContactSelectedListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contacts = getContacts()
        val contactNames = contacts.map { it.name }.toTypedArray()

        val contactListView: ListView = view.findViewById(R.id.contactListView)
        contactAdapter = ArrayAdapter(requireContext(), R.layout.item_contact, R.id.contactName, contactNames)

        contactListView.adapter = contactAdapter

        contactListView.setOnItemClickListener { _, _, position, _ ->
            contactSelectedListener?.onContactSelected(contacts[position].id)
        }
    }

    fun setOnContactSelectedListener(listener: OnContactSelectedListener) {
        contactSelectedListener = listener
    }

    private fun getContacts(): List<Contact> {
        // Return your list of contacts here
        return TODO("Provide the return value")
    }
}

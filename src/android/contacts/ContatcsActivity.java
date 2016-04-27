package android.contacts;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContatcsActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contatcs);
	}

	//onClick Method 
	public void findAllContacts(View view) {

		// Text field where we write the results.
		EditText names = (EditText)findViewById(R.id.contactsET);

		// Get contentResolver and request for contacts
		ContentResolver cr = getContentResolver();
		Cursor cur = cr.query(
				ContactsContract.Contacts.CONTENT_URI,null, null, null, null);

		// Go over all contacts
		while (cur.moveToNext()) {
			// Get contact name
			int nameIndex = cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
			String name = cur.getString(nameIndex);

			// Add name to text field, plus a newline
			names.append(name+"\n");

			// Get contact person id
			int idIndex = 	cur.getColumnIndex(ContactsContract.Contacts._ID);
			String id = cur.getString(idIndex);

			// Get list of phone numbers for this contact
			Cursor phoneCur = cr.query(
					ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
					ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = " + id,
					null, null);

			while ( phoneCur.moveToNext() ) {
				int phoneId = phoneCur.getColumnIndex(
						ContactsContract.CommonDataKinds.Phone.NUMBER);
				String phone = phoneCur.getString(phoneId);

				names.append(phone+"\n"); 	

			}

		}
	}
}

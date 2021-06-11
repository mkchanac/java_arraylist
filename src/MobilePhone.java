import java.util.ArrayList;

public class MobilePhone {
	private String myNumber;
	private ArrayList<Contact> myContacts;

	public MobilePhone(String myNumber) {
		this.myNumber = myNumber;
		this.myContacts = new ArrayList<Contact>();
	}

	public boolean addNewContact(Contact contact) {

		if (findContact(contact.getName()) >= 0) {
			System.out.println("Contact is already on file");
			return false;
		}

		myContacts.add(contact);
		return true;
	}

	public boolean updateContact(Contact oldContact, Contact newContact) {
		int position = findContact(oldContact);
		if (position < 0) {
			System.out.println("The contact doesn't exists");
			return false;
		} else {
			myContacts.set(position, newContact);
			System.out.println("Contact updated successfully");
			return true;
		}
	}

	public boolean removeContact(Contact contact) {
		int position = findContact(contact);

		if (position < 0) {
			System.out.println("The contact doesn't exists");
			return false;
		} else {
			myContacts.remove(position);
			System.out.println("Contact removed successfully");
			return true;
		}
	}

	private int findContact(Contact contact) {
		return this.myContacts.indexOf(contact);
	}

	private int findContact(String name) {
		for (int i = 0; i < this.myContacts.size(); i++) {
			Contact contact = this.myContacts.get(i);
			if (contact.getName() == name) {
				return i;
			}
		}
		return -1;
	}

//	public String queryContact(Contact contact) {
//		int position = findContact(contact);
//		if (position >= 0) {
//			return contact.getName();
//		} else {
//			return null;
//		}
//	}

	public Contact queryContact(String name) {
		int position = findContact(name);
		if (position >= 0) {
			return this.myContacts.get(position);
		} else {
			return null;
		}
	}

	public void printContacts() {
		System.out.println("Contact List:");

		for (int i = 0; i < myContacts.size(); i++) {
			System.out.println(
					(i + 1) + ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
		}

	}

}

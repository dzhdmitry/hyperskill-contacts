package contacts;

import contacts.entity.Contact;

import java.io.*;
import java.util.ArrayList;

public class ContactsStorage {
    String fileName;

    public ContactsStorage(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<Contact> getContacts() {
        ArrayList<Contact> contacts = new ArrayList<>();

        if (fileName == null) {
            return contacts;
        }

        try {
            contacts = (ArrayList<Contact>) deserialize();
        } catch (IOException | ClassCastException | ClassNotFoundException e) {
            contacts = new ArrayList<>();
        }

        return contacts;
    }

    public void putContacts(ArrayList<Contact> contacts) {
        if (fileName == null) {
            return;
        }

        try {
            ensureFile();
            serialize(contacts);
        } catch (IOException e) {
            //
        }
    }

    private void serialize(Object object) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(object);
        oos.close();
    }

    private Object deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object object = ois.readObject();

        ois.close();

        return object;
    }

    private void ensureFile() throws IOException {
        File file = new File(fileName);

        if (file.exists()) {
            return;
        }

        FileWriter writer = new FileWriter(file);

        writer.write("");
        writer.close();
    }
}

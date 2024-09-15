public class ContactList {
    private Node head;

    public ContactList() {
        this.head = null;
    }

    // Adicionar contato
    public void addContact(Contact contact) {
        Node newNode = new Node(contact);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    // Buscar contato pelo nome ou número de telefone
    public Contact searchContact(String identifier) {
        Node current = head;
        while (current != null) {
            Contact contact = current.getContact();
            if (contact.getName().equalsIgnoreCase(identifier) || contact.getPhoneNumber().equals(identifier)) {
                return contact;
            }
            current = current.getNext();
        }
        return null;
    }

    // Remover contato pelo nome ou número de telefone
    public boolean removeContact(String identifier) {
        if (head == null) return false;
        if (head.getContact().getName().equalsIgnoreCase(identifier) || head.getContact().getPhoneNumber().equals(identifier)) {
            head = head.getNext();
            return true;
        }
        Node current = head;
        while (current.getNext() != null) {
            if (current.getNext().getContact().getName().equalsIgnoreCase(identifier) ||
                    current.getNext().getContact().getPhoneNumber().equals(identifier)) {
                current.setNext(current.getNext().getNext());
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // Listar todos os contatos
    public void listContacts() {
        Node current = head;
        if (current == null) {
            System.out.println("No contacts found.");
            return;
        }
        while (current != null) {
            System.out.println(current.getContact());
            current = current.getNext();
        }
    }
}

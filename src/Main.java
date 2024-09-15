import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactList contactList = new ContactList();  // Cria a lista de contatos
        Scanner scanner = new Scanner(System.in);  // Para capturar entradas do usuário
        int option;

        do {
            System.out.println("\n--- Gerenciador de Contatos ---");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Buscar Contato");
            System.out.println("3. Remover Contato");
            System.out.println("4. Listar Contatos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();  // Consome a quebra de linha

            switch (option) {
                case 1:
                    System.out.print("Digite o Nome: ");
                    String name = scanner.nextLine();
                    System.out.print("Digite o Número de Telefone: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Digite o Email: ");
                    String email = scanner.nextLine();
                    contactList.addContact(new Contact(name, phoneNumber, email));
                    System.out.println("Contato adicionado com sucesso.");
                    break;
                case 2:
                    System.out.print("Digite o Nome ou Número de Telefone para buscar: ");
                    String searchQuery = scanner.nextLine();
                    Contact foundContact = contactList.searchContact(searchQuery);
                    if (foundContact != null) {
                        System.out.println("Contato Encontrado: " + foundContact);
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o Nome ou Número de Telefone para remover: ");
                    String removeQuery = scanner.nextLine();
                    if (contactList.removeContact(removeQuery)) {
                        System.out.println("Contato removido com sucesso.");
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Listando todos os contatos:");
                    contactList.listContacts();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        } while (option != 0);

        scanner.close();
    }
}

interface ClientRepository {
    String findClientById(String id);
}

class ClientRepositoryImpl implements ClientRepository {
    public String findClientById(String id) {
        if (id.equals("1")) {
            return "Sirisha";
        } else {
            return "Client not found";
        }
    }
}

class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public String getClientDetails(String id) {
        return clientRepository.findClientById(id);
    }
}

public class DependencyInjectionDemo {
    public static void main(String[] args) {
        ClientRepository clientRepository = new ClientRepositoryImpl();
        ClientService clientService = new ClientService(clientRepository);
        String clientDetails = clientService.getClientDetails("1");
        System.out.println("Client Details: " + clientDetails);
    }
}

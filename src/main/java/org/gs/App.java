package org.gs;

import org.gs.entity.Client;
import org.gs.entity.Planet;
import org.gs.services.ClientCrudService;
import org.gs.services.PlanetCrudService;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();


        // Create a new client
        Client client = new Client();
        client.setName("Cruz Conley");
        clientCrudService.createClient(client);

        // Get the client by ID
        Client clientById = clientCrudService.getClientById(8L);
        System.out.println("clientById = " + clientById);

        // Update the client
        clientById.setName("Sofia Hobbs");
        clientCrudService.updateClient(clientById);

        // Delete the client
        clientCrudService.deleteClient(4L);

        // Get all clients
        List<Client> allClients = clientCrudService.getAllClients();
        for (Client item : allClients) {
            System.out.println(item);
        }

        // Create a planet
        Planet planet = new Planet();
        planet.setId("NEP");
        planet.setName("Neptune");
        planetCrudService.createPlanet(planet);

        // Get the planet by ID
        Planet planetById = planetCrudService.getPlanetById("MAR");
        System.out.println("planetById = " + planetById);

        // Update the planet
        planetById.setName("Mars23");
        planetCrudService.updatePlanet(planetById);

        // Delete the planet
        planetCrudService.deletePlanet("VEN");

        // Get all planets
        List<Planet> allPlanets = planetCrudService.getAllPlanets();
        for (Planet item : allPlanets) {
            System.out.println(item);
        }
    }
}
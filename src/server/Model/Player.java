package server.Model;

import java.util.Random;




public class Player {

    private String Name;

    public Player()
    {
        this.Name = GenerateRandomName();
    }

    public Player(String name)
    {
        this.Name = name;
    }

    public String getName()
    {
        return this.Name;
    }

    //Ces deux fonctions privées servent à généré un nom drôle pour les joueurs qui n'en fournissent pas
    private String GenerateRandomName() {
        Random random = new Random();
        int max = 11;
        int min = 1;
        int randomNumber = random.nextInt(max - min) + min;
        return "aw yeah!";
    }
    private String getNameOfCreature(int ID) {
        String randomName;
        switch (ID) {
            case 1:
                randomName = "Kraken";
                break;
            case 2:
                randomName = "Unicorn";
                break;
            case 3:
                randomName = "Harpy";
                break;
            case 4:
                randomName = "Angel";
                break;
            case 5:
                randomName = "Griffin";
                break;
            case 6:
                randomName = "Kelpie";
                break;
            case 7:
                randomName = "Phoenix";
                break;
            case 8:
                randomName = "Leprechaun";
                break;
            case 9:
                randomName = "Dragon";
                break;
            case 10:
                randomName = "Wizard";
                break;
            default:
                randomName = "Cheater";
                break;
        }
        return randomName;
    }
}

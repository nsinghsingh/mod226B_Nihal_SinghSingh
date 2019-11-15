package Arcade;

import AdventureZone.AdventureZoneController;

public class ArcadeboxAdventureZone extends Arcadebox{

    AdventureZoneController adventureZone;

    @Override
    public void start(){
        adventureZone = new AdventureZoneController();
        run();
    }

    @Override
    public void run() {
        adventureZone.loadChoice();
        stop();
    }

    @Override
    public void stop() {
        adventureZone = null;
    }
}

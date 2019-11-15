package Arcade;

import AdventureZone.AdventureZoneController;

public class ArcadeboxAdventureZone implements Arcadebox{

    private AdventureZoneController adventureZone;

    @Override
    public void start(){
        adventureZone = new AdventureZoneController();
        run();
    }

    @Override
    public void run() {
        adventureZone.load();
        stop();
    }

    @Override
    public void stop() {
        adventureZone = null;
    }
}

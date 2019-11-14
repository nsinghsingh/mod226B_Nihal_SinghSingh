package Arcade;

import AdventureZone.AdventureZoneMain;

public class ArcadeboxAdventureZone extends Arcadebox{

    private AdventureZoneMain adventureZone;

    @Override
    public void start() {
        adventureZone = new AdventureZoneMain();
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

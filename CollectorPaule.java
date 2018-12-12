import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.Hamster;
import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Location;
import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.Territory;
import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Direction;
import java.io.IOException;

/**
 * Paule collects grains.
 *
 * @author  Sarah Breckner
 *          3425446
 *          st163632@stud.uni-stuttgart.de

 * @author  Kim Lingemann
 *          3380756
 *          st160814@stud.uni-stuttgart.de

 * @version 1
 */
public class CollectorPaule extends SimpleHamsterGame
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class PainterPaule
     */
    public CollectorPaule()
    {
        game.displayInNewGameWindow();
        try {
            game.initialize("/territories/territory-collector.ter");
        } catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }
    
    /**
     * Paule moves
     * 
     * Paule makes a certain number of steps.
     * @param       numberOfSteps, number of steps Paule should do
     * @requires    frontIsClear for each of Paule's steps
     * @requires    paule.isInitialized
     * @ensures     Paule is numberOfSteps tiles away from his old location
     */
    void multiMove (int numberOfSteps) {
           
        for (int i = 0; i<numberOfSteps; i++) {
            paule.move();
        }
    }
    
    /**
     * Paule collects ten grains
     * 
     * Paule picks up ten grains from his current tile
     * 
     * @requires    at least 10 grains on Paule's tile
     * @ensures     \old.paule.getGrainCount() = paule.getGrainCount() - 10
     */
    void collectAll () {
        
        for (int i = 0; i<10; i++) {
            paule.pickGrain();
        }
    }
    
    /**
     * Paule collects all grains
     * 
     * Paule picks up all grains from his current tile
     * 
     * @requires    paule.isInitialised()
     * @ensures     \old.paule.getGrainCount() = paule.getGrainCount() - paule.getLocation.getGrainCount()
     */
    void collectAllGrains() {
           
        while (paule.grainAvailable()) {
            paule.pickGrain();
        }
    }
    
    /**
     * collectAll fails
     * 
     * test of collectAll with a runtime exeption thrown because of too few grains
     */
    void testFail() {
        multiMove(3);
        collectAll();
        multiMove(3);
        collectAll();
        collectAll();
    }

    /**
     * collectAll is only partly successful
     * 
     * test of collectAll, no exeptions thrown but paule only partially picks the grains
     * 
     * @requires    paule.isInitialised()
     * @ensures     \old.paule.getGrainCount() = paule.getGrainCount() - 10
     */
    void testNotAllGrains() {
        multiMove(3);
        collectAll();
        multiMove(3);
        collectAll();
    }
    
    /**
     * collectAll succeeds
     * 
     * test of collectAll, no exeptions thrown and paule picks all the grains on his tile
     * 
     * @requires    paule.isInitialised()
     * @requires    if there are grains on a tile, the number of grains is a multiple of 10
     * @ensures     \old.paule.getGrainCount() = paule.getGrainCount() - 10
     */
    void testSuccess () {
        multiMove(3);
        collectAll();
    }
    
    /**
     * test of collectAllGrains
     * 
     * Paule picks all the grains in the territory
     * 
     * @requires    paule.isInitialised()
     * @ensures     \old.paule.getGrainCount() = paule.getGrainCount() - territory.getTotalGrainCount()
     */
    void testCollectAllGrains() {
        for (int i = 0; i < 2; i ++) {    
            multiMove(3);
            collectAllGrains();
        }
    }

}
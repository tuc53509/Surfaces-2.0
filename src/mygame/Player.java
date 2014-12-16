/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;

/**
 * Wraps up the player into a Node.
 *
 * @author Zack Hunter
 * @version %I% %G%
 * @see Node
 * @since 2.0
 */
public class Player extends Node {

    /**
     * copy of current Game object
     */
    private Game game;
    /**
     * BetterCharacterControl object to control the player
     */
    private BetterCharacterControl playerControl;
    /**
     * start position of player for the level
     */
    private Vector3f startPos;

    /**
     * Constructor. Copies game, sets name of node, and sets starting position.
     *
     * @param game instance of current game
     */
    public Player(Game game) {
        this.game = game;
        this.setName("Player");
        initControl();
    }

    /**
     * Initialize BetterCharacterControl for the player.
     */
    private void initControl() {
        playerControl = new BetterCharacterControl(1.5f, 6f, 1f);
        this.addControl(playerControl);
        playerControl.setJumpForce(new Vector3f(0, 10, 0));
        playerControl.setGravity(new Vector3f(0, 100, 0));
        game.getBulletAppState().getPhysicsSpace().add(playerControl);
    }

    /**
     * Set the starting position of the player. Reset the player.
     *
     * @param startPos Vector3f for the starting position of the player in the
     * level.
     */
    public void setStart(Vector3f startPos) {
        this.startPos = startPos;
        reset();
    }

    /**
     * Reset the player to the start position.
     */
    public void reset() {
        this.removeControl(playerControl);
        this.setLocalTranslation(startPos);
        this.addControl(playerControl);
    }

    /**
     * Return the BetterCharacterControl for the player.
     *
     * @return BetterCharacterControl for the player.
     */
    public BetterCharacterControl getControl() {
        return playerControl;
    }
}

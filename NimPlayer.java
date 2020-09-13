/** Student Name: Xixi Lyu
 * Student id: 1120263
 * User Name: XIXLYU
 *
 */

package Nim;
import java.lang.*;


public class NimPlayer {
    private String playerName;
    private int numOfWin;

    public int getNumOfWin() {
        return numOfWin;
    }
    public NimPlayer(String playerName){
        this.playerName = playerName;
        this.numOfWin = 0;
    }
    public String getPlayerName() {
        return playerName;
    }
    public int removeStone(int stoneRemove){
        return stoneRemove;
    }
    public void gameWin(){
        this.numOfWin+=1;
        System.out.println(this.playerName + " wins!\n");
    }
}

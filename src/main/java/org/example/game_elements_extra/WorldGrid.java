package org.example.game_elements_extra;

import org.example.game_elements_extra.types.WorldObjectType;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The type World grid.
 */
public class WorldGrid {

    private WorldObjectType[][] worldGrid;
    private final int gridDimension;
    private int floorNumber;

    /**
     * Instantiates a new World grid.
     *
     * @param dimension the dimension
     */
    public WorldGrid(int dimension){
        this.gridDimension = dimension;
        this.worldGrid = new WorldObjectType[dimension][dimension];
        this.floorNumber = 0;
    }

    /**
     * Get world grid world object type [ ] [ ].
     *
     * @return the world object type [ ] [ ]
     */
    public WorldObjectType[][] getWorldGrid(){
        return this.worldGrid;
    }

    /**
     * Gets grid dimension.
     *
     * @return the grid dimension
     */
    public int getGridDimension() {
        return this.gridDimension;
    }

    /**
     * Get floor number int.
     *
     * @return the int
     */
    public int getFloorNumber(){
        return this.floorNumber;
    }

    /**
     * Get content of position world object type.
     *
     * @param posX the pos x
     * @param posY the pos y
     * @return the world object type
     */
    public WorldObjectType getContentOfPosition(int posX, int posY){
        return this.worldGrid[posX][posY];
    }

    /**
     * Set individual world grid tile.
     *
     * @param type     the type
     * @param position the position
     */
    public void setIndividualWorldGridTile(WorldObjectType type, int[] position){
        this.worldGrid[position[0]][position[1]] = type;
    }

    private void spawnItems(WorldObjectType type, int numOfItems){
        int coordinateX;
        int coordinateY;

        int i = 0;
        while(i < numOfItems){
            coordinateX = ThreadLocalRandom.current().nextInt(0, gridDimension);
            coordinateY = ThreadLocalRandom.current().nextInt(0, gridDimension);
            if(this.worldGrid[coordinateX][coordinateY] == null && (coordinateX != 0 && coordinateY != 0)){
                this.worldGrid[coordinateX][coordinateY] = type;
                i += 1;
            }
        }
    }

    private void populateWorld(){
        spawnItems(WorldObjectType.ENEMY, 4);
        spawnItems(WorldObjectType.CHEST, 2);
        spawnItems(WorldObjectType.EXIT, 1);
    }

    private void refreshWorld(){
        for(int i = 0; i < gridDimension; i++){
            for(int j = 0; j < gridDimension; j++){
                this.worldGrid[i][j] = null;
            }
        }
    }

    /**
     * Generate new floor.
     */
    public void generateNewFloor(){
        refreshWorld();
        populateWorld();
        this.floorNumber += 1;
        System.out.println("You are at floor: " + this.floorNumber);
    }

}

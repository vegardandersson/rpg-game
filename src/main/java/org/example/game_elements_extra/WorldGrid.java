package org.example.game_elements_extra;

import org.example.game_elements_extra.types.WorldObjectType;

import java.util.concurrent.ThreadLocalRandom;

public class WorldGrid {

    private WorldObjectType[][] worldGrid;
    private final int gridDimension;
    private int floorNumber;

    public WorldGrid(int dimension){
        this.gridDimension = dimension;
        this.worldGrid = new WorldObjectType[dimension][dimension];
        this.floorNumber = 0;
    }

    public int getFloorNumber(){
        return this.floorNumber;
    }

    public WorldObjectType getContentOfPosition(int posX, int posY){
        return this.worldGrid[posX][posY];
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

    public void generateNewFloor(){
        refreshWorld();
        populateWorld();
        this.floorNumber += 1;
        printFloor();
    }

    public void printFloor(){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < this.gridDimension; i++){
            for(int j = 0; j < this.gridDimension; j++){
                if(this.worldGrid[i][j] == null){
                    builder.append("NULL ");
                }else {
                    builder.append(this.worldGrid[i][j].name());
                }
            }
            System.out.println(builder);
            builder = new StringBuilder();
        }
    }

}

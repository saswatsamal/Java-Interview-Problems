package com.saswatsamal;
import java.util.Random;

public class SongRandomizer {
    //Array is used to store the songs
    private String[] playlist;
    //This variable is used to keep track of pending songs
    private int pendingLotEndPoint;
    //Creating an object of Random to generate random numbers
    private Random random = new Random();

    //Constructor to initialize the playlist and pending lot
    public SongRandomizer(String[] playlist){
        this.playlist = playlist;
        // intially all the songs are unplayed so the pendingLotEnd will be outside the array
        this.pendingLotEndPoint = playlist.length;
    }

    public String playRandomSong()
    {
        //index of the song to return
        int songToReturnIdx;
        //What is the actual song that has to be return
        String songToReturn;

        //This will return an index from 0 to (pendingLotEnd - 1)
        //(0 to pendingLotEnd - 1 --> it will show the pending lot and it will keep shrinking
        //(pendingLotEnd to playlist.length) this will show/return the played songs == it will keep growing
        songToReturnIdx = random.nextInt(pendingLotEndPoint);
        songToReturn = playlist[songToReturnIdx];

        //Since the song has been chosen, then it will be swapped with the last point in the array
        // so that it can be removed from future considerations
        swap(songToReturnIdx, pendingLotEndPoint-1);

        //Shrinking the pendingLot, i.e the index pool from where we want to run our random generator
        pendingLotEndPoint--;

        //all the songs have been played so we have to reset the pending lot
        if(pendingLotEndPoint == 0){
            pendingLotEndPoint = playlist.length;
        }

        //return the song ID which is to be played next
        return songToReturn;

    }

    private void swap(int i, int j){
        if(i==j)
            return;
        String temp = playlist[i];
        playlist[i] = playlist[j];
        playlist[j] = temp;
    }

    public static void main(String[] args) {
        String[] songs = {"BaBa","Sugar","Runaway","Disco","Beautiful"};
        SongRandomizer songRandomizer = new SongRandomizer(songs);

        System.out.println("Iteration1");
        System.out.println("Next Song: "+songRandomizer.playRandomSong());
        System.out.println("Next Song: "+songRandomizer.playRandomSong());
        System.out.println("Next Song: "+songRandomizer.playRandomSong());
        System.out.println("Next Song: "+songRandomizer.playRandomSong());

        System.out.println("Iteration2");
        System.out.println("Next Song: "+songRandomizer.playRandomSong());
        System.out.println("Next Song: "+songRandomizer.playRandomSong());
        System.out.println("Next Song: "+songRandomizer.playRandomSong());
        System.out.println("Next Song: "+songRandomizer.playRandomSong());
    }

}

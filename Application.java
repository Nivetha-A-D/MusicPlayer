package com.te.casestudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) throws InterruptedException {

		ArrayList<SongDetails> arraylist = new ArrayList<SongDetails>();
		int id = 5;
		arraylist.add(
				new SongDetails(1, "Mundhinam parthaenaee", "Surya", "Vaaranam Ayiram", "l1", " Language:Tamil Song"));
		arraylist.add(new SongDetails(2, "Valayapatti", "Vijay", "Azhagiya Tamil Magan", "l2", " Language:Tamil Song"));
		arraylist.add(new SongDetails(3, "Poo ne poo", "Dhanush", "3", "l3", " Language:Telugu Song"));
		arraylist.add(new SongDetails(4, "Adiye ni", "G.V.Prakash", "Bachelor", "l4", " Language:Tamil  Song"));
		arraylist.add(new SongDetails(5, "Sirikadhey", "SivaKarthikeyan", "Remo", "l4", " Language:Tamil Song"));
		Collections.sort(arraylist);
		Scanner sc = new Scanner(System.in);
		do {
		System.out.println("---------------------Welcome to MUSIC PLAYER---------------------!!");
		// System.out.println(arraylist);
		System.out.println(
				"Press 1 to Play a Song\nPress 2 to Search a Song\nPress 3 to Show all Songs\nPress 4 to Operate on Songs Database");
		System.out.println("Enter your Choice:");
		int choice = sc.nextInt();
		switch (choice) {
		case 1: {
			System.out.println(
					"Press A to Play all songs\nPress B to Play Songs Randomly\nPress C to Play a Particular Song");
			System.out.println("Enter how to play the songs : ");
			sc.nextLine();
			String playBy = sc.nextLine();

			if (playBy.equals("A")) {
				System.out.println("you choose to : play all the songs sequentially order by song title");
				Collections.sort(arraylist);
				for (SongDetails songDetails : arraylist) {
					System.out.println("playing  " + songDetails.getSongTitle() + ".........");
					Thread.sleep(1000);
					System.out.println("Song ended");

				}
			} else if (playBy.equals("B")) {
				Collections.shuffle(arraylist);
				System.out.println("you choose to : play all the songs randomly");
				for (SongDetails songDetails : arraylist) {
					System.out.println("playing  " + songDetails.getSongTitle() + ".........");
					Thread.sleep(1000);
					System.out.println("Song ended");
				}
			} else {
				System.out.println("you choose to : to provide “song title” & play that particular song");
				System.out.println("Enter the song you want to search:");
				String search = sc.nextLine();
				for (SongDetails songDetails : arraylist) {
					if (songDetails.getSongTitle().contains(search)) {
						System.out.println("playing " + songDetails.getSongTitle() + "............");
						Thread.sleep(1000);
						System.out.println("Song ended");
					}

				}
			}
			break;
		}
		case 2:
			System.out.println("You want to search the song by songname!");
			System.out.println("Enter the song_name");
			String songName = sc.nextLine();
			for (SongDetails songDetails : arraylist) {
				if (songDetails.getSongTitle().contains(songName))
					System.out.println("playing " + songDetails.getSongTitle() + "....................");

			}
			break;

		case 3:
			System.out.println("Displaying all the songs:");
			for (SongDetails songDetails : arraylist) {
				System.out.println(songDetails);
			}
			break;
		case 4:
			System.out.println(
					"Press A to “Add Song” to Songs Repository\nPress B to “Edit an existing Song” info\nPress C to “Delete an existing Song” info");
			System.out.println("Enter which operation do you want to perform : ");
			sc.nextLine();
			String operation = sc.nextLine();

			if (operation.equals("A")) {
				System.out.println("you choose to : “Add Song” to Songs Repository");
				System.out.println("Enter the song details-------");
//					System.out.println("Enter the songId:");
//					int sid =sc.nextInt();
				System.out.println("Enter the songName: ");
				String sname = sc.nextLine();
				System.out.println("Enter the actorName:");
				String aname = sc.nextLine();
				System.out.println("Enter the movieName:");
				String mname = sc.nextLine();
				System.out.println("Enter the location:");
				String loc = sc.nextLine();
				System.out.println("Enter the description:");
				String des = sc.nextLine();
				arraylist.add(new SongDetails(++id, sname, aname, mname, loc, des));
				arrangeId( arraylist);
				System.out.println("Current music list after adding the song");
				
					for (SongDetails songDetails : arraylist) {
						System.out.println(songDetails);
					}

			} else if (operation.equals("B")) {
				System.out.println("you choose to :“Edit an existing Song” info ");
				System.out.println("Enter the song-id which you want to edit?");
				int songid = sc.nextInt();
				for (SongDetails songDetails : arraylist) {
					if (songDetails.songId == songid) {

						System.out.println("Do you want to edit the song title?:\nEnter name to edit or null");
						String st = sc.next();
						if (st != null) {
							songDetails.setSongTitle(st);
						}
						System.out.println("Do you want to edit the artist name?:\nEnter name to edit or null");
						String an = sc.next();
						if (an != null) {
							songDetails.setArtistName(an);
						}
						System.out.println("Do you want to edit the album name?:\nEnter name to edit or null");
						String abn = sc.next();
						if (abn != null) {
							songDetails.setAlbumName(abn);
						}
						System.out.println("Do you want to edit the song location?:\nEnter name to edit or null");
						String sl = sc.next();
						if (sl != null) {
							songDetails.setSongLocation(sl);
						}
						System.out.println("Do you want to edit the dscription?:\nEnter name to edit or null");
						String d = sc.next();
						if (d != null) {
							songDetails.setDescription(d);

						}
						
					}

//					else {
//						System.out.println("Enter the correct song_id");
//					}

				}
				System.out.println("Successfully edited!!Current music list after edited");
				arrangeId( arraylist);
				for (SongDetails songDetails : arraylist) {
					System.out.println(songDetails);
				}
			} else {
				System.out.println("you choose to : “Delete an existing Song” info");
				int delId = sc.nextInt();
				Iterator<SongDetails> it = arraylist.iterator();
				while (it.hasNext()) {
					if (it.next().getSongId() == delId) {

						it.remove();
						break;
					}
					
					
				}
				System.out.println("Current music list after Deleted");
				for (SongDetails songDetails : arraylist) {
					System.out.println(songDetails);
				}

			}
		}
		}while(true);

	}
	 static void arrangeId(ArrayList<SongDetails> arraylist) {
		int id=1;
		for( SongDetails songdetails : arraylist) {
			songdetails.setSongId(id++);
			
			
		}
	}
}
package com.radomirribic;


public class Codenavirus {

	int[] codenavirus(char[][] world, int[] firstInfected) {
		Slot[][] myWorld = new Slot[world.length][world[0].length];

		for (int i = 0; i < world.length; i++) {
			for (int c = 0; c < world[0].length; c++) {
				if (world[i][c] == '#') {
					myWorld[i][c] = new Slot(i, c, "healthyPerson");
				} else {
					myWorld[i][c] = new Slot(i, c, "empty");
				}
			}
		}

		boolean virusIsSpreading = true;
		int days = 1;

		while (virusIsSpreading) {

			if (days == 1) {
				myWorld[firstInfected[0]][firstInfected[1]].getInfected(days);
				days++;
			} else {
				int infectedToday = 0;

				for (int row = 0; row < world.length; row++) {
					for (int column = 0; column < world[0].length; column++) {
						myWorld[row][column].tryToRecover(days);

						if (myWorld[row][column].infectNext(myWorld, days)) {
							infectedToday++;
						}
					}
				}

				if (infectedToday == 0) {
					virusIsSpreading = false;
					break;
				}
				days++;
			}
		}
		

		int[] rez = new int[4];
		for (Slot[] s : myWorld) {
			for (Slot slot : s) {
				if (slot.getStatus().equalsIgnoreCase("recovered")) {
					rez[2]++;
				} else if (slot.getStatus().equalsIgnoreCase("healthyPerson")) {
					rez[3]++;
				} else if (slot.getStatus().equalsIgnoreCase("infected")) {
					rez[1]++;
				}
			}
		}
		rez[0] = days;

		return rez;

	}



}

class Slot {

	private String status;
	private int row;
	private int column;
	private int dayInfected;

	 Slot(int row, int column, String status) {
		super();
		this.status = status;
		this.row = row;
		this.column = column;
		this.dayInfected = -1;

	}

	 boolean infectNext(Slot[][] myWorld, int days) {
		if (status.equalsIgnoreCase("infected") && dayInfected != days && days - dayInfected < 4) {

			if (column + 1 < myWorld[0].length
					&& myWorld[row][column + 1].getStatus().equalsIgnoreCase("healthyPerson")) {
				myWorld[row][column + 1].getInfected(days);
				return true;
			} else if (row - 1 > -1 && myWorld[row - 1][column].getStatus().equalsIgnoreCase("healthyPerson")) {
				myWorld[row - 1][column].getInfected(days);
				return true;
			} else if (column - 1 > -1 && myWorld[row][column - 1].getStatus().equalsIgnoreCase("healthyPerson")) {
				myWorld[row][column - 1].getInfected(days);
				return true;
			} else if (row + 1 < myWorld.length
					&& myWorld[row + 1][column].getStatus().equalsIgnoreCase("healthyPerson")) {
				myWorld[row + 1][column].getInfected(days);
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

	 boolean tryToRecover(int days) {
		if (status.equalsIgnoreCase("infected") && days - dayInfected == 3) {
			this.status = "recovered";
			return true;
		} else {
			return false;
		}
	}

	 void getInfected(int days) {
		this.status = "infected";
		this.dayInfected = days;
	}

	 String getStatus() {
		return status;
	}

}

public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        int currRow = 0;
        int currCol = size/2;
        int currValue = 1;
        
        square.placeValue(currRow, currCol, currValue++);
        for (int i = 0; i < (size * size) - 1; i++) {
            int nextRow = (currRow - 1) % square.getHeight();
            int nextCol = (currCol + 1) % square.getWidth();

            if (nextRow == -1) nextRow = square.getHeight() - 1;
            
            if (square.readValue(nextRow, nextCol) == 0) {
                currRow = nextRow;
                currCol = nextCol;
                square.placeValue(currRow, currCol, currValue++);
            } else {
                currRow = (currRow + 1) % square.getHeight();                
                square.placeValue(currRow, currCol, currValue++);
            }
        }
        
        return square;
    }

}

import java.io.*;

class Main {
  
  private static final String FILE_NAME = "savegames//save.txt";

  public static void main(String[] args) {
    
    GameProgress gameProgress1 = new GameProgress(100, 1, 5, 0);
    GameProgress gameProgress2 = new GameProgress(90, 1, 6, 50);
    GameProgress gameProgress3 = new GameProgress(80, 1, 7, 100);

    saveGame(gameProgress1, gameProgress2, gameProgress3);
  }  
    
  public static void saveGame(GameProgress...gameProgresss) {
    try (FileOutputStream fos = new FileOutputStream(FILE_NAME); 
      ObjectOutputStream oos = new ObjectOutputStream(fos)) {
      for (GameProgress gameProgress : gameProgresss) { 
        oos.writeObject(gameProgress);
      }
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }  
  }
}
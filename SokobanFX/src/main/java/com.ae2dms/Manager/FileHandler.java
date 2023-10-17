package com.ae2dms.Manager;

import com.ae2dms.Controllers.SlotController;
import com.ae2dms.GameState.GameEngine;

import java.io.*;

/**
 * <p> The interface FileHandler defines some methods related to file operations.
 * The interface FileHandler defines some methods related to file operations.
 *
 * @author Yixin SHEN
 * @version 1.0
 * @date 2020/11/20-15:15
 * @since 1.0
 */
public interface FileHandler {

    /**
     * Clear all the file content.
     * <p> Clear all the file content
     *
     * @param fileName The name of the file to be cleared.
     * @author Yixin SHEN
     * @date 2020/11/20-15:56
     */
    static void clearInfoForFile(String fileName) {
        File file = new File(fileName);
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Erase the archive file.
     * <p> erase the Archive, make the Archive to be the default map.
     *
     * @param index The index of archive file to erase.
     * @author Yixin SHEN
     * @date 2020/11/20-15:56
     */
    default void eraseArchive(int index) {
        String source = "src/main/resources/level/SampleGame.skb";
        String des = "src/main/resources/Archives/Archive" + index + ".skb";

        FileHandler.clearInfoForFile(des);

        File fin = new File(source);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fin);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assert fis != null;
        BufferedReader in = new BufferedReader(new InputStreamReader(fis));

        FileWriter fstream = null;
        try {
            fstream = new FileWriter(des);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert fstream != null;
        BufferedWriter out = new BufferedWriter(fstream);

        String aLine = null;
        while (true) {
            try {
                if ((aLine = in.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            // add every line to des file
            try {
                assert aLine != null;
                out.write(aLine);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //close in BufferedWriter
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //close out BufferedWriter
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the mapSetName and levelIndex in the archive file.
     * <p> Get the mapSetName and levelIndex in the archive file.
     *
     * @param index The index value of selected archive
     * @return java.lang.String The mapSetName and levelIndex in a string format.
     * @throws IOException IOException
     * @author Yixin SHEN
     * @date 2020/11/20-18:03
     */
    static String mapSetName(int index) throws IOException {
        File file = new File("src/main/resources/Archives/Archive" + index + ".skb");
        InputStream input = new FileInputStream(file);
        String mapSetName = "";
        String LevelIndex = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            String line1 = reader.readLine();
            mapSetName = line1.replace("MapSetName: ", "");
            reader.readLine();
            String line2 = reader.readLine();
            LevelIndex = line2.replace("LevelIndex: ", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (mapSetName.equals("New Game!")) {
            return mapSetName;
        } else {
            return mapSetName + "     " + LevelIndex + "/8 Level";
        }
    }

    /**
     * Change the mapSetName in the corresponding archive file.
     * <p> Change the mapSetName in the corresponding archive file.
     *
     * @param newName The name user have input in.
     * @author Yixin SHEN
     * @date 2020/11/20-18:24
     */
    static void changeMapName(String newName) {
        String source = "src/main/resources/level/SampleGame.skb";
        String des = "src/main/resources/Archives/Archive" + SlotController.archive + ".skb";

        FileHandler.clearInfoForFile(des);

        File fin = new File(source);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fin);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assert fis != null;
        BufferedReader in = new BufferedReader(new InputStreamReader(fis));

        FileWriter fstream = null;
        try {
            fstream = new FileWriter(des);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert fstream != null;
        BufferedWriter out = new BufferedWriter(fstream);

        String aLine = null;
        while (true) {
            try {
                aLine = in.readLine();
                if (aLine == null) {
                    break;
                } else if (aLine.contains("New Game!")) {
                    aLine = aLine.replaceAll("New Game!", newName);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            // add every line to des file
            try {
                assert aLine != null;
                out.write(aLine);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //close in BufferedWriter
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //close out BufferedWriter
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Save the score to the ranking.txt file.
     * <p> When the game is completed, save the user nickname and scores to the ranking.txt file
     *
     * @param gameEngine The current gameEngine.
     * @throws FileNotFoundException FileNotFoundException
     * @author Yixin SHEN
     * @date 2020/11/22-16:21
     */
    default void saveScore(GameEngine gameEngine) throws FileNotFoundException {
        File sourceFile = new File("src/main/resources/Archives/Archive" + SlotController.archive + ".skb");
        InputStream input = new FileInputStream(sourceFile);

        File outFile = new File("src/main/resources/Ranking/ranking.txt");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            String line1 = reader.readLine();
            String line2 = reader.readLine();
            insertToRank(outFile, line1);
            insertToRank(outFile, line2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Save the score to the ranking.txt file.
     * <p> When the game is completed, insert the input string to the ranking.txt file
     *
     * @param file   The ranking.txt file.
     * @param conent The score used to be inserted.
     * @author Yixin SHEN
     * @date 2020/11/22-16:22
     */
    static void insertToRank(File file, String conent) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file, true)));
            out.write(conent + "\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert out != null;
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
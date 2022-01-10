
/*
 * Class: IST 261-001
 * Team 1
 * Assignment: TD04
 */

package Util;

import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;

public class Persistence {
  public static void saveState(PersistenceData persistenceData, String filePath) {

    Gson gson = new Gson();

    try (Writer writer = new FileWriter(filePath)) {
      gson.toJson(persistenceData, writer);
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  // TODO - Write the contents of this method
  public static PersistenceData loadState(String filePath) {
    Gson gson = new Gson();
    try (Reader reader = new FileReader(filePath)) {

      PersistenceData persistenceData = gson.fromJson(reader, PersistenceData.class);
      return persistenceData;
    } catch (Exception e) {
      System.out.println(e.toString());
      return null;

    }

  }
}
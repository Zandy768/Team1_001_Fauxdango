package View.ConsoleDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import Model.*;


public class AdvertisementDisplay
{
  private AdvertisementBank adBank;

  public AdvertisementDisplay(AdvertisementBank adBank) {
    this.adBank = adBank;
  }

  private void displayAd(Advertisement ad) {
    System.out.println();
    System.out.println("=== " + ad.getText() + " ===");
  }

  public void displayNextAd() {
    displayAd(adBank.getNextAd());
  }

  public void displayRandomAd() {
    displayAd(adBank.getRandomAd());
  }
}

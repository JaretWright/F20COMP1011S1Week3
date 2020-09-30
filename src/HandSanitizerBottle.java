import java.util.Arrays;
import java.util.List;

public class HandSanitizerBottle {
    private String brand;
    private int bottleVolume;
    private String bottleMaterial;
    private double alcoholContent;
    private int amountInBottle;

    public HandSanitizerBottle(String brand, int bottleVolume, String bottleMaterial, double alcoholContent) {
        setBottleVolume(bottleVolume);
        setBrand(brand);
        setBottleMaterial(bottleMaterial);
        setAlcoholContent(alcoholContent);
        setAmountInBottle(this.bottleVolume);
    }

    public String getBrand() {
        return brand;
    }

    /**
     * This method will validate if the brand is "Great Value" or "JDub's Elixer"
     * and will set the instance variable
     * @param newBrand - a String representing the brand name
     */
    public void setBrand(String newBrand) {


        if (newBrand.equalsIgnoreCase("Great Value") || newBrand.equalsIgnoreCase("JDub's Elixer"))
            this.brand = newBrand;
        else
            throw new IllegalArgumentException("brand must be Great Value or Jdub's Elixer");
    }

    public int getBottleVolume() {
        return bottleVolume;
    }

    public void setBottleVolume(int bottleVolume) {
        if (bottleVolume>=10 && bottleVolume<=1000)
            this.bottleVolume = bottleVolume;
        else
            throw new IllegalArgumentException("volume must be 10-1000");
    }

    public String getBottleMaterial() {
        return bottleMaterial;
    }

    public void setBottleMaterial(String bottleMaterial) {
        List<String> validTypes = Arrays.asList("plastic", "glass", "metal");

        if (validTypes.contains(bottleMaterial))
            this.bottleMaterial = bottleMaterial;
        else
            throw new IllegalArgumentException("valid bottle types are:" + validTypes);
    }

    public double getAlcoholContent() {
        return alcoholContent;
    }

    public void setAlcoholContent(double alcoholContent) {
        if (alcoholContent>=75 && alcoholContent<=100)
            this.alcoholContent = alcoholContent;
        else
            throw new IllegalArgumentException("alcohol content must be 0-100");
    }

    public int getAmountInBottle() {
        return amountInBottle;
    }

    public void setAmountInBottle(int amountInBottle) {
        if (amountInBottle>=0 && amountInBottle<=bottleVolume)
            this.amountInBottle = amountInBottle;
        else
            throw new IllegalArgumentException("amount in bottle must be 0-"+ bottleVolume);
    }

    public String toString()
    {
        return String.format("%13s holds %3d ml, alcohol %.1f%%", brand, bottleVolume, alcoholContent);
    }
}
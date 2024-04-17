
// maps to SQL Table
public class Saxophones implements DTO{
    private Integer id;
    private String manufacturer;
    private String model;
    private String voice;
    private Boolean unused;

    public Saxophones() {

    }

    public Saxophones(String manufacturer, String model, String voice, Boolean unused) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.voice = voice;
        this.unused = unused;
    }

    public Saxophones(Integer id, String manufacturer, String model, String voice, Boolean unused) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.voice = voice;
        this.unused = unused;
    }

    public int getId() {
        return 0;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public boolean isUnused() {
        return unused;
    }

    public void setUnused(boolean unused) {
        this.unused = unused;
    }
}




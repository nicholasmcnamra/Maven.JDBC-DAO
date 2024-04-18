import org.junit.Test;
import org.junit.Assert;

import java.sql.SQLException;
import java.util.List;

public class SaxophoneTests {

    @Test
    public void findByIdTest() throws SQLException {
        SaxophonesDAO saxophonesDAO = new SaxophonesDAO();
        Assert.assertEquals("Yanagisawa", saxophonesDAO.findById(1).getManufacturer());
    }

    @Test
    public void findAllTest() {
        SaxophonesDAO saxophonesDAO = new SaxophonesDAO();
        List<DTO> saxophones = saxophonesDAO.findAll();
        for (DTO saxophone : saxophones) {
            String stringRep = String.format("Id: %s\nManufacturer: %s\nModel: %s\nVoice: %s\nNew: %s\n", saxophone.getId(), saxophone.getManufacturer(), saxophone.getModel(), saxophone.getVoice(), saxophone.isUnused());
            System.out.println(stringRep);
        }
        Assert.assertEquals(5, saxophonesDAO.findAll().size());
    }

    @Test
    public void createTest() {
        SaxophonesDAO saxophonesDAO = new SaxophonesDAO();
        Saxophones saxophone = new Saxophones("Yanagisawa", "WO10", "Soprano", true);
        saxophonesDAO.create(saxophone);

        Assert.assertEquals(5, saxophonesDAO.findAll().size());
        }

        @Test
        public void updateTest() throws SQLException {
        SaxophonesDAO saxophonesDAO = new SaxophonesDAO();
        Saxophones saxophone = (Saxophones) saxophonesDAO.findById(1);

        saxophone.setModel("WO30");
        saxophone.setVoice("Alto");
        saxophone.setUnused(true);
        saxophonesDAO.update(saxophone);
        Assert.assertEquals(saxophone.getManufacturer(), saxophonesDAO.findById(1).getManufacturer());
        }

        @Test
        public void deleteTest() {
        SaxophonesDAO saxophonesDAO = new SaxophonesDAO();
        saxophonesDAO.delete(2);

        Assert.assertEquals(1, saxophonesDAO.findAll().size());
        }
}

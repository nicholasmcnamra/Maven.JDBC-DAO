import com.mysql.cj.PreparedQuery;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SaxophonesDAO implements DAO<DTO>{

    private int nextId;
    @Override
    public DTO findById(int id) throws SQLException {
        try {
            PreparedStatement statement = Connection.getConnection().prepareStatement("SELECT * FROM saxophones WHERE ID=" + id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return extractSaxophoneFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<DTO> findAll()  {
        try {
            PreparedStatement statement = Connection.getConnection().prepareStatement("SELECT * FROM saxophones");
            ResultSet rs = statement.executeQuery();

            List<DTO> saxophones = new ArrayList<>();

            while (rs.next()) {
                Saxophones saxophone = extractSaxophoneFromResultSet(rs);
                saxophones.add(saxophone);
            }
            return saxophones;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean create(DTO dto) {
        try {
            PreparedStatement statement = Connection.getConnection().prepareStatement("INSERT INTO saxophones (Manufacturer, Model, Voice, New) VALUES (?, ?, ?, ?)");
            statement.setString(1, dto.getManufacturer());
            statement.setString(2, dto.getModel());
            statement.setString(3, dto.getVoice());
            statement.setBoolean(4, dto.isUnused());

            int i = statement.executeUpdate();

            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(DTO dto) {
        try {
            PreparedStatement statement = Connection.getConnection().prepareStatement("UPDATE saxophones SET Manufacturer=?, Model=?, Voice=?, New=? WHERE id=" + dto.getId());
            statement.setString(1, dto.getManufacturer());
            statement.setString(2, dto.getModel());
            statement.setString(3, dto.getVoice());
            statement.setBoolean(4, dto.isUnused());

            int i = statement.executeUpdate();

            if (i == 1) {
                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Statement statement = Connection.getConnection().createStatement();
            int i = statement.executeUpdate("DELETE FROM saxophones WHERE id=" + id);

            if (i == 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Saxophones extractSaxophoneFromResultSet(ResultSet rs) throws SQLException {
        Saxophones saxophone = new Saxophones();

        saxophone.setId(rs.getInt("id"));
        saxophone.setManufacturer(rs.getString("Manufacturer"));
        saxophone.setModel(rs.getString("Model"));
        saxophone.setVoice(rs.getString("Voice"));
        saxophone.setUnused(rs.getBoolean("New"));

        return saxophone;
    }
}

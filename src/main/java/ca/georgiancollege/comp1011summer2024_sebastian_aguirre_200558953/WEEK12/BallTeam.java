package ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953.WEEK12;

public class BallTeam {

    public int id;
    public String conference, division, city, name, full_name, abbreviation;

    @Override
    public String toString() {
        return "Team Info\n" +
                "id=" + id +
                "\nconference='" + conference + '\'' +
                "\ndivision='" + division + '\'' +
                "\ncity='" + city + '\'' +
                "\nname='" + name + '\'' +
                "\nfull_name='" + full_name + '\'' +
                "\nabbreviation='" + abbreviation;
    }
}

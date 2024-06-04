package ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953;

public class Week4 {
    public static void main(String[] args) {
        //This is what we are doing sort of implicitly any time we have an action event (clcik or
        // change event)
        SampleInterface sampleInterface = new SampleInterface() {
            @Override
            public boolean isOddNumb(int number) {
                return number % 2 == 1;
            }
        };
    }
}

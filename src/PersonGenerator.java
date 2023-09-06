import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;
import java.util.ArrayList;
import java.util.Scanner;


public class PersonGenerator
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // Test data the lines of the file we will write
        Scanner scanner = new Scanner(System.in);

        // Collect user input for the number of records
        //Im sure there is a better way to do this with the SafeInput.getYNConfirm, but I went with this
        int numRecords = SafeInput.getInt(scanner , "Enter the number of records you would like to enter");

        ArrayList<String> persons = new ArrayList<>();

        // Collect data for each person record
        for (int i = 0; i < numRecords; i++) {
            System.out.println("Enter data for person " + (i + 1));

            String id = SafeInput.getNonZeroLenString(scanner , "ID");
            String firstName = SafeInput.getNonZeroLenString(scanner , "First Name");
            String lastName = SafeInput.getNonZeroLenString(scanner , "LastName");
            String title = SafeInput.getNonZeroLenString(scanner , "Title");
            int yearOfBirth = SafeInput.getInt(scanner , "YearOfBirth");

            String personRecord = id + ", " + firstName + ", " + lastName + ", " + title + ", " + yearOfBirth;
            persons.add(personRecord);
            //Adds the information in csv format to the array list again there is a way to use SafeInput.getYNConfirm, but I want to do it this way
        }
        // uses a fixed known path:
        //  Path file = Paths.get("c:\\My Documents\\data.txt");

        // use the toolkit to get the current working directory of the IDE
        // will create the file within the Netbeans project src folder
        // (may need to adjust for other IDE)
        // Not sure if the toolkit is thread safe...
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonTestData.txt");

        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(String rec : persons)
            {
                writer.write(rec, 0, rec.length());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}

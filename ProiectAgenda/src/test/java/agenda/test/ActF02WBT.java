package agenda.test;

import agenda.exceptions.InvalidFormatException;
import agenda.model.base.Contact;
import agenda.model.base.User;
import agenda.model.repository.classes.RepositoryActivityFile;
import agenda.model.repository.classes.RepositoryContactFile;
import agenda.model.repository.classes.RepositoryContactMock;
import agenda.model.repository.classes.RepositoryUserFile;
import agenda.model.repository.interfaces.RepositoryActivity;
import agenda.model.repository.interfaces.RepositoryContact;
import agenda.model.repository.interfaces.RepositoryUser;
import agenda.startApp.MainClass;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertTrue;

public class ActF02WBT
{
    RepositoryActivity ra;
    RepositoryContact rc;
    BufferedReader br;
    ByteArrayOutputStream baos;
    User user;
    public void buildBufferedReader()
    {
        if (baos!=null)
        {
            try
            {
                baos.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        baos = new ByteArrayOutputStream();
    }
    public void writeToBaos(String toWrite)
    {
        try
        {
            baos.write((toWrite+"\n").getBytes());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public BufferedReader getReader()
    {
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        return new BufferedReader(new InputStreamReader(bais));
    }
    @Before
    public void setUp() throws Exception
    {
        rc = new RepositoryContactFile();
        RepositoryUserFile ru = new RepositoryUserFile();
        ra = new RepositoryActivityFile(rc);
        user = ru.getByUsername("username1");
    }

    @Test
    public void testInstr()
    {
        buildBufferedReader();
        writeToBaos("test");
        writeToBaos("10/10/2019");
        writeToBaos("11:11");
        writeToBaos("10/10/2019");
        writeToBaos("11:12");
        writeToBaos("name2");
        MainClass.adaugActivitate(ra,rc,getReader(),user);
    }
    @Test
    public void testInstr2()//Invalid username
    {
        buildBufferedReader();
        writeToBaos("test");
        writeToBaos("10/10/2019");
        writeToBaos("11:11");
        writeToBaos("10/10/2019");
        writeToBaos("11:12");
        writeToBaos("nam34");
        MainClass.adaugActivitate(ra,rc,getReader(),user);
    }
    @Test
    public void testLoops()//Invalid user test
    {
        buildBufferedReader();
        writeToBaos("test");
        writeToBaos("10/10/2019");
        writeToBaos("11:11");
        writeToBaos("10/10/2019");
        writeToBaos("11:12");
        writeToBaos("nam34");
        writeToBaos("nam34");
        writeToBaos("nam34");
        writeToBaos("nam34");
        writeToBaos("name3");
        MainClass.adaugActivitate(ra,rc,getReader(),user);
    }
    @Test
    public void testDecisions() //Conflicts especially
    {
        buildBufferedReader();
        writeToBaos("test");
        writeToBaos("10/10/2019");
        writeToBaos("11:11");
        writeToBaos("10/10/2019");
        writeToBaos("11:12");
        writeToBaos("name3");

        MainClass.adaugActivitate(ra,rc,getReader(),user);
        MainClass.adaugActivitate(ra,rc,getReader(),user);
    }
}

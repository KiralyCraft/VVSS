package agenda.test;

import agenda.exceptions.InvalidFormatException;
import agenda.model.base.Contact;
import agenda.model.repository.classes.RepositoryContactMock;
import agenda.model.repository.interfaces.RepositoryContact;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ContactF01BBT
{
    private Contact con;
    private RepositoryContact rep;

    @Before
    public void setUp() throws Exception
    {
        rep = new RepositoryContactMock();
    }

    @Test
    public void testF01ECPV1()
    {
        Contact toAdd = new Contact();
        try
        {
            toAdd.setAddress("Luceafar");

        }
        catch (InvalidFormatException e)
        {
            assertTrue(false);
        }
        try
        {
            toAdd.setName("F");

        }
        catch (InvalidFormatException e)
        {
            assertTrue(false);
        }
        try
        {
            toAdd.setTelefon("ABCDEFGHIJLKMNO");
            assertTrue(false);

        }
        catch (InvalidFormatException e)
        {
            assertTrue(true);
        }
    }
    @Test
    public void testF01ECPV2()
    {
        Contact toAdd = new Contact();
        try
        {
            toAdd.setAddress("Luceafar");

        }
        catch (InvalidFormatException e)
        {
            assertTrue(false);
        }
        try
        {
            toAdd.setName("0");

        }
        catch (InvalidFormatException e)
        {
            assertTrue(false);
        }
        try
        {
            toAdd.setTelefon("44");
            assertTrue(false);

        }
        catch (InvalidFormatException e)
        {
            assertTrue(true);
        }
    }
    @Test
    public void testF01ECPV3()
    {
        Contact toAdd = new Contact();
        try
        {
            toAdd.setAddress("Luceafar");

        }
        catch (InvalidFormatException e)
        {
            assertTrue(false);
        }
        try
        {
            toAdd.setName("Eureka");
        }
        catch (InvalidFormatException e)
        {
            assertTrue(false);
        }
        try
        {
            toAdd.setTelefon("+40");
            assertTrue(true);

        }
        catch (InvalidFormatException e)
        {
            assertTrue(false);
        }
    }
    @Test
    public void testF01ECPV4()
    {
        Contact toAdd = new Contact();
        try
        {
            toAdd.setAddress("Luceafar");

        }
        catch (InvalidFormatException e)
        {
            assertTrue(false);
        }
        try
        {
            toAdd.setName("01234565");
        }
        catch (InvalidFormatException e)
        {
            assertTrue(false);
        }
        try
        {
            toAdd.setTelefon("0746309058");
            assertTrue(true);

        }
        catch (InvalidFormatException e)
        {
            assertTrue(false);
        }
    }
    @Test
    public void testF01BVA1()
    {
        Contact toAdd = new Contact();
        try
        {
            toAdd.setAddress("Luceafar");

        }
        catch (InvalidFormatException e)
        {
            assertTrue(false);
        }
        try
        {
            toAdd.setName("0123456");
            assertTrue(true);
        }
        catch (InvalidFormatException e)
        {
            assertTrue(false);
        }
        try
        {
            toAdd.setTelefon("0123456");
            assertTrue(true);

        }
        catch (InvalidFormatException e)
        {
            assertTrue(false);
        }
    }
    @Test
    public void testF01BVA2()
    {
        Contact toAdd = new Contact();
        try
        {
            toAdd.setAddress("Luceafar");

        }
        catch (InvalidFormatException e)
        {
            assertTrue(false);
        }
        try
        {
            toAdd.setName("0123456");
            assertTrue(true);
        }
        catch (InvalidFormatException e)
        {
            assertTrue(false);
        }
        try
        {
            toAdd.setTelefon("1234560");
            assertTrue(false);

        }
        catch (InvalidFormatException e)
        {
            assertTrue(true);
        }
    }
    @Test
    public void testF01BVA3()
    {
        Contact toAdd = new Contact();
        try
        {
            toAdd.setAddress("Luceafar");

        }
        catch (InvalidFormatException e)
        {
            assertTrue(false);
        }
        try
        {
            toAdd.setName("A.B.C");
            assertTrue(false);
        }
        catch (InvalidFormatException e)
        {
            assertTrue(true);
        }
        try
        {
            toAdd.setTelefon("1234560");
            assertTrue(false);

        }
        catch (InvalidFormatException e)
        {
            assertTrue(true);
        }
    }
    @Test
    public void testF01BVA4()
    {
        Contact toAdd = new Contact();
        try
        {
            toAdd.setAddress("Luceafar");

        }
        catch (InvalidFormatException e)
        {
            assertTrue(false);
        }
        try
        {
            toAdd.setName("1.2.3");
            assertTrue(false);
        }
        catch (InvalidFormatException e)
        {
            assertTrue(true);
        }
        try
        {
            toAdd.setTelefon("1234560");
            assertTrue(false);

        }
        catch (InvalidFormatException e)
        {
            assertTrue(true);
        }
    }
}

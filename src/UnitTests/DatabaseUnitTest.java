package UnitTests;

import model.SQLiteUtilities;
import model.Tip;

import org.junit.Before;
import org.junit.Test;
public class DatabaseUnitTest {

	
	@Before
	public void setUp() throws Exception {
		SQLiteUtilities.getSQLDatabaseInstance().createTable();
	}
	@Test
	public void testInsertAndSelect(){
		SQLiteUtilities.getSQLDatabaseInstance().insertTip(new Tip(20.0,0.15,0.15));
		SQLiteUtilities.getSQLDatabaseInstance().selectRows();
	}

}

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_CreatePlanetExplorer() {
		PlanetExplorer explorer = new PlanetExplorer(0, 0, "");
		
		assertNotNull(explorer);
	}
	
	@Test
	public void test_getExplorerPositionAtStart(){
		PlanetExplorer explorer = new PlanetExplorer(10,10,"");
		
		assertEquals("not getting position",explorer.getPosition(), "(0,0,N)");
	}
	
	@Test
	public void test_SetExplorerPosition(){
		PlanetExplorer explorer = new PlanetExplorer(10,10,"");
		
		explorer.setPosition("(2,2,W)");
		
		assertEquals("not setting position",explorer.getPosition(), "(2,2,W)");
	}
	
	@Test
	public void test_Moving1SpaceForwards(){
		PlanetExplorer explorer = new PlanetExplorer(10,10,"");
		
		assertEquals("not moving forwards","(0,1,N)", explorer.executeCommand("f"));
		
	}
	
	@Test
	public void test_changingDirection(){
		PlanetExplorer explorer = new PlanetExplorer(10,10,"");
		
		assertEquals("not changing direction","(0,0,E)", explorer.executeCommand("r"));
	}
	
	@Test
	public void test_executeffrf(){
		PlanetExplorer explorer = new PlanetExplorer(10,10,"");
		
		assertEquals("not going following direction","(1,2,E)", explorer.executeCommand("ffrf"));
	}
	
	@Test
	public void test_executeffbrf(){
		PlanetExplorer explorer = new PlanetExplorer(10,10,"");
		
		assertEquals("not going back properly","(1,1,E)", explorer.executeCommand("ffbrf"));
	}
	
	@Test
	public void test_executerfflf(){
		PlanetExplorer explorer = new PlanetExplorer(10,10,"");
		
		assertEquals("testing turning left","(2,1,N)", explorer.executeCommand("rfflf"));
	}
	
	@Test
	public void test_executefrfrfrfrfr(){
		PlanetExplorer explorer = new PlanetExplorer(10,10,"");
		
		assertEquals("going out of bounds of the direction array","(0,1,E)", explorer.executeCommand("frfrfrfrfr"));
	}
	
	@Test
	public void test_executelf(){
		PlanetExplorer explorer = new PlanetExplorer(3,3,"");
		
		assertEquals("appearing on the otherside of the grid not working", "(2,0,W)", explorer.executeCommand("lf"));
	}
}

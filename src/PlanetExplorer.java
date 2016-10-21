
// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID:
// Finish time:

public class PlanetExplorer {
	private String position = "(0,0,N)";
	private int maxOfX = 0;
	private int maxOfY = 0;
	
	public PlanetExplorer(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  
		 
	 */
		maxOfX = x - 1;
		maxOfY= y - 1;
		
	}
	
	public String executeCommand(String command){
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		char directions[] = "NESW".toCharArray();
		int direction = 0;
		
		for(int i=0; i < command.length(); i++){
		
			int x_coord = Character.getNumericValue(position.charAt(1));
			int y_coord = Character.getNumericValue(position.charAt(3));
			
			if( command.charAt(i) == 'f'){
				if(direction == 0){
					if(y_coord == maxOfY){
						y_coord = 0;
					}else{
					y_coord += 1;
					}
				}else if(direction == 1){
					if(x_coord == maxOfX){
						x_coord = 0;
					}else{
						x_coord +=1;
					}
				}else if(direction == 2){
					if(y_coord == 0){
						y_coord = maxOfY;
					}else{
						y_coord -=1;
					}
				}else{
					if(x_coord == 0){
						x_coord = maxOfX;
					}else{
						x_coord -=1;
					}
				}
				
				String newPosition = String.format("(%d,%d,%s)",x_coord,y_coord, Character.toString(directions[direction]));
				
				setPosition(newPosition);
			}else if(command.charAt(i) == 'b'){
				
				if(direction == 0){
					if(y_coord == 0){
						y_coord = maxOfY;
					}else{
					y_coord -= 1;
					}
				}else if(direction == 1){
					if(x_coord == 0){
						x_coord = maxOfX;
					}else{
						x_coord -=1;
					}
				}else if(direction == 2){
					if(y_coord == maxOfY){
						y_coord = 0;
					}else{
						y_coord +=1;
					}
				}else{
					if(x_coord == maxOfX){
						x_coord = 0;
					}else{
						x_coord +=1;
					}
				}
				
				String newPosition = String.format("(%d,%d,%s)",x_coord,y_coord, Character.toString(directions[direction]));
				
				setPosition(newPosition);
			}else if(command.charAt(i) == 'r'){
				direction += 1;
				if(direction == 4){
					direction = 0;
				}
				
				String newDir = Character.toString(directions[direction]);
				String newPosition = position.substring(0, 5) + newDir + position.substring(6, 7);
				
				setPosition(newPosition);	
			}else if(command.charAt(i) == 'l'){
				direction -= 1;
				if(direction == -1){
					direction = 3;
				}
				String newDir = Character.toString(directions[direction]);
				String newPosition = position.substring(0, 5) + newDir + position.substring(6, 7);
				
				setPosition(newPosition);
			}
		}
		return position;
	}
	
	public String getPosition(){
		return position;
	}
	
	public void setPosition(String newPos){
		position = newPos;
	}
}

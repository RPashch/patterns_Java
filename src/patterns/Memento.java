package patterns;

public class Memento {

	public static void main(String[] args) {
		Game game = new Game();
		game.setDataGame("First level", 100);
		System.out.println(game);
		
		System.out.println("—охран€емс€...и продолжаем играть дальше");
		File fileForSaving = new File();
		fileForSaving.setSave(game.save());
		game.setDataGame("Second level", 500);
		System.out.println(game);
		
		System.out.println("ѕроисходит сбой или нас убили и мы загружаемс€ с последнего сохранени€");
		game.load(fileForSaving.getSave());
		System.out.println(game);
	}

}

class Game{
	private String level;
	private int time;
	
	public void setDataGame(String level,int time){
		this.level = level;
		this.time = time;
	}
	
	public void load(Save save){
		this.level = save.getLevel();
		this.time = save.getTime();;
	}
	
	public Save save(){
		return new Save(level,time);
	}

	@Override
	public String toString() {
		return "Game [level=" + level + ", time=" + time + "]";
	}
	
	
	
}

class Save{
	private final String level;
	private final int time;
	public Save(String level, int time) {
		this.level = level;
		this.time = time;
	}
	public String getLevel() {
		return level;
	}
	public int getTime() {
		return time;
	}
	
	
}

class File{
	Save save;

	public Save getSave() {
		return save;
	}

	public void setSave(Save save) {
		this.save = save;
	}
	
	
}
package patterns;

public class Command {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comp c = new Comp();
		User user = new User(new CommandStart(c),new CommandStop(c),new CommandReset(c));
		user.startPC();
		user.stopPC();
		user.resetPC();
	}

}

interface CommandOperation {
	void execute();
}

class Comp {
	public void start() {
		System.out.println("start");
	}

	public void stop() {
		System.out.println("stop");
	}

	public void reset() {
		System.out.println("reset");
	}
}

class CommandStart implements CommandOperation {
	Comp copmuter;

	public CommandStart(Comp copmuter) {
		this.copmuter = copmuter;
	}

	@Override
	public void execute() {
		copmuter.start();

	}

}

class CommandStop implements CommandOperation {
	Comp copmuter;

	public CommandStop(Comp copmuter) {
		this.copmuter = copmuter;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		copmuter.stop();
	}

}

class CommandReset implements CommandOperation {
	Comp copmuter;

	public CommandReset(Comp copmuter) {
		this.copmuter = copmuter;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		copmuter.reset();
	}

}
//в этом классе можно было бы ещЄ создать коллекцию ComandOperation дл€ того, чтобы 
//можно было пользоватьс€ ею как в паттерне Composite, добавл€€ и удал€€ из коллекции 
//при помощи методов add and remove, а через foreach проходить все команды и вызывать их
class User{
	CommandOperation start;
	CommandOperation stop;
	CommandOperation reset;
	public User(CommandOperation start, CommandOperation stop, CommandOperation reset) {
		this.start = start;
		this.stop = stop;
		this.reset = reset;
	}
	
	public void startPC(){
		start.execute();
	}
	
	public void stopPC(){
		stop.execute();
	}
	public void resetPC(){
		reset.execute();
	}
}
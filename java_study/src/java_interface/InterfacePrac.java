package java_interface;

interface Playable{
	void play();
	void pause();
	void stop();
}

class MP3Player implements Playable{

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("mp3 play");
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		System.out.println("mp3 pause");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("mp3 stop");
	}
	
}

class DVDPlayer implements Playable{
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("dvd play");
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		System.out.println("dvd pause");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("dvd stop");
	}
}

public class InterfacePrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MP3Player mp = new MP3Player();
		DVDPlayer dvd = new DVDPlayer();
		
		mp.play();
		mp.pause();
		mp.stop();
		dvd.play();
		dvd.pause();
		dvd.stop();
	}

}

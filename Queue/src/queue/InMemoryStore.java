package queue;

import java.util.HashMap;

public class InMemoryStore {

	HashMap<String, Queue> map = new HashMap<>();
	void PrintAllSongsForUserPlaylist(String user) {
		Queue queue= map.get(user);
		queue.PrintQueue();
		
	}

	 
	void getRecentlyPlayedSongByUser(String user) {
		Queue queue= map.get(user);
		System.out.println("Recently played song by "+user+" is :"+queue.RearValue());
	}

	void addSongtoPlayListForUser(String user, String song) {
		if (!map.containsKey(user)) {
			map.put(user, new Queue());
		}

		Queue queue = map.get(user);
		if (queue.size == 3) {
			queue.Dequeue();
		}
		queue.Enqueue(song);

	}

	public static void main(String[] args) {
		InMemoryStore inMem = new InMemoryStore();
		String user="Pragya";
		inMem.addSongtoPlayListForUser(user,"s1");
		inMem.addSongtoPlayListForUser(user, "s2");
		inMem.addSongtoPlayListForUser(user, "s3");
		inMem.addSongtoPlayListForUser(user, "s4");
		inMem.addSongtoPlayListForUser(user, "s5");
		inMem.getRecentlyPlayedSongByUser(user);
		inMem.PrintAllSongsForUserPlaylist(user);
		String user2="baghel";
		inMem.addSongtoPlayListForUser(user2,"s10");
		inMem.addSongtoPlayListForUser(user2, "s20");
		inMem.addSongtoPlayListForUser(user2, "s30");
		inMem.addSongtoPlayListForUser(user2, "s40");
		inMem.addSongtoPlayListForUser(user2, "s50");
		inMem.getRecentlyPlayedSongByUser(user2);
		inMem.PrintAllSongsForUserPlaylist(user2);
		
		
	}

}

class QueueNode {
	String val;
	QueueNode next;

	QueueNode(String data) {
		val = data;
		next = null;
	}
}

class Queue {
	QueueNode Front = null, Rear = null;
	int size = 0;

	boolean Empty() {
		return Front == null;
	}
	String RearValue() {
		if(Rear == null) {
			return "";
		}
		return Rear.val;
	}

	String Peek() {
		if (Empty()) {
			System.out.println("Queue is Empty");
			return "";
		} else
			return Front.val;
	}

	void Enqueue(String value) {
		QueueNode Temp;
		Temp = new QueueNode(value);
		if (Temp == null) // When heap exhausted
			System.out.println("Queue is Full");
		else {
			if (Front == null) {
				Front = Temp;
				Rear = Temp;
			} else {
				Rear.next = Temp;
				Rear = Temp;
			}
			//System.out.println(value + " Inserted into Queue ");
			size++;
		}
	}

	void Dequeue() {
		if (Front == null)
			System.out.println("Queue is Empty");
		else {
			System.out.println(Front.val + " Removed From Queue");
			QueueNode Temp = Front;
			Front = Front.next;
			size--;
		}
	}
	void PrintQueue() {
		if (Front == null)
			System.out.println("Queue is Empty");
		else {
			QueueNode Temp = Front;
			while(Temp != null) {
				System.out.print(Temp.val+" ");
				Temp = Temp.next;
			}
			System.out.println();
		}
	}
}

import java.util.Random;

@SuppressWarnings("unchecked")
public class SkipList<T extends Comparable<? super T>>
{

	public int maxLevel;
	public SkipListNode<T>[] root;
	private int[] powers;
	private Random rd = new Random();

	SkipList(int i)
	{
		maxLevel = i;
		root = new SkipListNode[maxLevel];
		powers = new int[maxLevel];
		for (int j = 0; j < i; j++)
			root[j] = null;
		choosePowers();
		rd.setSeed(1230456789);
	}

	SkipList()
	{
		this(4);
	}

	public void choosePowers()
	{
		powers[maxLevel-1] = (2 << (maxLevel-1)) - 1;
		for (int i = maxLevel - 2, j = 0; i >= 0; i--, j++)
			powers[i] = powers[i+1] - (2 << j);
	}

	public int chooseLevel()
	{
		int i, r = Math.abs(rd.nextInt()) % powers[maxLevel-1] + 1;
		for (i = 1; i < maxLevel; i++)
		{
			if(r < powers[i])
				return i-1;
		}
		return i-1;
	}

	public boolean isEmpty()
	{
		return root[0] == null;
		//Your code goes here
	}

	public void insert(T key)
	{
		SkipListNode<T> node;
		SkipListNode<T>[] cur = new SkipListNode[maxLevel], prev = new SkipListNode[maxLevel];
		cur[maxLevel -1] = root[maxLevel -1];
		prev[maxLevel -1] = null;
		for(int level = maxLevel -1; level >= 0 ; level-- ){
			while( cur[level] != null && cur[level].key.compareTo(key) < 0){
				prev[level] = cur[level];
				cur[level] = cur[level].next[level];
			}
			if( cur[level] != null && cur[level].key.equals(key))
				return;
			if(level > 0){
				if(prev[level] == null){
					prev[level -1] = null;
					cur[level -1] = root[level -1];
				}else{
					cur[level -1] = prev[level].next[level -1];
					prev[level -1] =prev[level];
				}
			}
			level = chooseLevel();
			node = new SkipListNode<T>(key,level +1);
			for(int i =0; i <= level; i++){
				node.next[i] = cur[i];
				if(prev[i] == null)
					root[i] = node;
				else
					prev[i].next[i] = node;
			}
		}
		//Your code goes here
	}	

	public T first()
	{
		if(!isEmpty())
			return root[0].key;
		else
			return null;
		//Your code goes here
	}

	public T last()
	{
		SkipListNode<T> cur = root[0];
		if(!isEmpty()){
			while(cur.next[0] != null){
				cur = cur.next[0];
			}
			return cur.key;
		}
		else
			return null;
		//Your code goes here 
	}	

	public T search(T key)
	{
		if(!isEmpty()){
			int lvl;
			SkipListNode<T> prev, curr;
			for (lvl = maxLevel - 1; lvl >= 0 && root[lvl] == null; lvl--) ;
			prev = curr = root[lvl];
			while (true) {
				if (key == curr.key)
					return curr.key;
				else if (key.compareTo(curr.key) < 0) {
					if (lvl == 0)
						return null;
					else if (curr == root[lvl])
						curr = root[--lvl];
					else curr = prev.next[--lvl];
				}
				else {
					prev = curr;
					if (curr.next[lvl] != null)
						curr = curr.next[lvl];
					else {
						for (lvl--; lvl >= 0 && curr.next[lvl] == null; lvl--) ;
						if (lvl >= 0)
							curr = curr.next[lvl];
						else return null;
					}
				}
			}
		}else{
			return null;
		}

		//Your code goes here
	}
}
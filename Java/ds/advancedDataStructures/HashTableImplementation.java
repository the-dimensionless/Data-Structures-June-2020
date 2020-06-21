package advancedDataStructures;

/*
 * This hash table class uses a customized LinkedList class
 * Present in the same package
 */

public class HashTableImplementation {
	
	static class HashTable<K, V> {
		private class HTPair {
			K key;
			V value;
			
			public HTPair (K k, V v) {
				this.key = k;
				this.value = v;
			}
			
			@SuppressWarnings("unchecked")
			public boolean equals (Object other) {
				HTPair ob = (HTPair) other;
				return this.key.equals(ob.key);
			}
			
			public String toString () {
				return "{"+this.key+"-"+this.value+"}";
			}
		}
		
		LinkedList<HTPair>[] bucketArray;
		int size;
		
		public static final int DEFAULT_CAPACITY = 10;
		
		public HashTable () {
			this(DEFAULT_CAPACITY);
		}
		
		@SuppressWarnings("unchecked")
		public HashTable (int capacity) {
			this.bucketArray = (LinkedList<HTPair>[]) new LinkedList[capacity];
			this.size = 0;
		}
		
		private int hashFunction (K key) {
			int hc = key.hashCode();
			hc = Math.abs(hc);
			int bi = hc % this.bucketArray.length;
			return bi;
		}
		
		public void put (K key, V value) throws Exception {
			int bi = this.hashFunction(key);
			HTPair pair = new HTPair(key, value);
			LinkedList<HTPair> bucket = this.bucketArray[bi];
			if (bucket == null) {
				bucket = new LinkedList<>();
				bucket.addLast(pair);
				this.size++;
				this.bucketArray[bi] = bucket;
			} else {
				int existing = bucket.find(pair);
				if (existing == -1) {
					bucket.addLast(pair);
					this.size++;
				} else {
					HTPair rv = bucket.getAt(existing);
					rv.value = value;
				}
			}
			
			double lambda = (this.size * 1.0) / this.bucketArray.length;
			if (lambda > 0.75) {
				this.rehash();
			}
		}
		
		public V get(K key) throws Exception {
			int bi = this.hashFunction(key);
			HTPair pair = new HTPair(key, null);
			LinkedList<HTPair> bucket = this.bucketArray[bi];
			
			if (bucket == null) {
				return null;
			} else {
				int exists = bucket.find(pair);
				if (exists == -1) {
					return null;
				} else {
					HTPair rv = bucket.getAt(exists);
					return rv.value;
				}
			}
		}
		
		public V remove(K key) throws Exception {
			int bi = this.hashFunction(key);
			HTPair pair = new HTPair(key, null);
			LinkedList<HTPair> bucket = this.bucketArray[bi];
			if (bucket == null) {
				return null;
			} else {
				int findAt = bucket.find(pair);
				if (findAt == -1) {
					return null;
				} else {
					HTPair rv = bucket.getAt(findAt);
					bucket.removeAt(findAt);
					this.size--;
					return rv.value;
				}

			}
		}
		
		public void display () {
			for (LinkedList<HTPair> bucket: this.bucketArray) {
				if (bucket != null && !bucket.isEmpty()) {
					bucket.display();
				} else {
					System.out.println("NULL");
				}
				System.out.println("***********************************");
			}
			System.out.println("----------------------------------------");
		}
		
		// Rehash when size is increasing 
		@SuppressWarnings("unchecked")
		private void rehash () throws Exception {
			LinkedList<HTPair>[] oba = this.bucketArray;
			this.bucketArray = (LinkedList<HTPair>[]) new LinkedList[2 * oba.length];
			this.size = 0;
			
			for (LinkedList<HTPair> ob: oba) {
				while (ob != null && !ob.isEmpty()) {
					HTPair rp = ob.removeFirst();
					this.put(rp.key, rp.value);
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		HashTable<String, Integer> map=new HashTable<>(4);
        map.put("USA", 200);
		map.put("Russia", 250);
		map.put("India", 300);
		map.display();
		map.put("China", 320);
		map.display();
		map.put("Pak", 100);
		
		map.display();
		map.put("India", 315);
		map.display();
		System.out.println(map.get("India"));
		System.out.println(map.get("Finland"));
		
		map.remove("Pak");
		map.display();
	}

}

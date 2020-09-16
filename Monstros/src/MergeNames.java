public class MergeNames {
    
    public static String[] uniqueNames(String[] names1, String[] names2) {
        throw new UnsupportedOperationException("Waiting to be implemented.");
        int size1, size2;
        String[] name = new String[10];
        size1 = names1.length;
        size2 = names2.length;
        for(int i = 0; i < size1; i++) {
        	for(int j = 0; i < size2; i++) {
        		if(names1[i] != names2[j]) {
        			name[k] = names1[i];
        		}
        	}
        }
    }
    
    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}

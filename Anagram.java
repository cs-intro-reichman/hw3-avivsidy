/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2)
	{
		int [] charCounts = new int[26]; 

		for (int i = 0; i < str1.length(); i++)
			{
			char c = Character.toLowerCase(str1.charAt(i));
			if (c >= 'a' && c <= 'z')
			{
				charCounts[c - 'a']++;
			}
			}

		for (int i = 0; i < str2.length(); i++)
		{
			char c = Character.toLowerCase(str2.charAt(i));
			if (c >= 'a' && c <= 'z')
			{
				charCounts[c - 'a']--;
			}
		}
		for (int i=0; i < charCounts.length; i++)
			{
			if (charCounts[i] != 0)
				{
				return false;
				}
			}	
		return true;	
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
    for (int i = 0; i < str.length(); i++) {
        char c = Character.toLowerCase(str.charAt(i));

        if (c < 'a' || c > 'z')
		{
            str = str.substring(0, i) + str.substring(i + 1);
            i--;
        }
		else
		{
            if (str.charAt(i) != c)	
			{
                str = str.substring(0, i) + c + str.substring(i + 1);
            }
        }
    }
    return str;
}
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
    char[] chars = str.toCharArray();
    for (int i = 0; i < chars.length; i++)
	{
        int j = (int)(Math.random() * chars.length);
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    return new String(chars);
}
}

public static double jaccard_algorithm(String str1, String str2) {
    // Create sets of characters in both strings
    Set<Character> set1 = new HashSet<>();
    Set<Character> set2 = new HashSet<>();
    for (char c : str1.toCharArray()) {
      set1.add(c);
    }
    for (char c : str2.toCharArray()) {
      set2.add(c);
    }
    Set<Character> intersection = new HashSet<>(set1);
    intersection.retainAll(set2);
    Set<Character> union = new HashSet<>(set1);
    union.addAll(set2);
    double jaccard = (double) intersection.size() * 100 / union.size();

    return jaccard;
  }

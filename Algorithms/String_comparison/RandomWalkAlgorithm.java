/*
For this function I would suggest to install or add below library in order to use Cosine Similarity class
import org.apache.commons.text.similarity.*;

*/ 


public static double RandomWalkAlgorithm(String s1, String s2) {
    // Define set of possible all_substrings
    Set<String> all_substrings = new HashSet<>();
    for (int i = 0; i < s1.length(); i++) {
      for (int j = i + 1; j <= Math.min(i + 3, s1.length()); j++) {
        all_substrings.add(s1.substring(i, j));
      }
    }
    for (int i = 0; i < s2.length(); i++) {
      for (int j = i + 1; j <= Math.min(i + 3, s2.length()); j++) {
        all_substrings.add(s2.substring(i, j));
      }
    }
    // Represent all_substrings as vectors

    Map<String, Integer> substringIndex = new HashMap<>();
    int index = 0;
    for (String substring : all_substrings) {
      substringIndex.put(substring, index++);
    }
    int total_substring = all_substrings.size();
    Map<CharSequence, Integer>[] vectors = new Map[2];
    for (int i = 0; i < 2; i++) {
      Map<CharSequence, Integer> vector = new HashMap<>();
      for (int j = 0; j < total_substring; j++) {
        vector.put((CharSequence) substringIndex.keySet().toArray()[j], 0);
      }
      vectors[i] = vector;
    }
    for (int i = 0; i < s1.length(); i++) {
      for (int j = i + 1; j <= Math.min(i + 3, s1.length()); j++) {
        String substring = s1.substring(i, j);
        if (substringIndex.containsKey(substring)) {
          vectors[0].put(substring, vectors[0].get(substring) + 1);
        }
      }
    }
    for (int i = 0; i < s2.length(); i++) {
      for (int j = i + 1; j <= Math.min(i + 3, s2.length()); j++) {
        String substring = s2.substring(i, j);
        if (substringIndex.containsKey(substring)) {
          vectors[1].put(substring, vectors[1].get(substring) + 1);
        }
      }
    }
    // Compute similarity using cosine similarity
    CosineSimilarity cosineSimilarity = new CosineSimilarity();
    double similarity =
      (cosineSimilarity.cosineSimilarity(vectors[0], vectors[1])) * 100;
    return similarity;
  }

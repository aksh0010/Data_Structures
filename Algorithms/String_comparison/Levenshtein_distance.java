/*
Levenshtein Distance algorithm to calculate edit distance among strings.
*/

public static double Levenshtein(String s1, String s2) {
    String[] tokens1 = s1.split("\\s+");
    String[] tokens2 = s2.split("\\s+");
    int[][] dp = new int[tokens1.length + 1][tokens2.length + 1];
    for (int i = 0; i <= tokens1.length; i++) {
      for (int j = 0; j <= tokens2.length; j++) {
        if (i == 0) {
          dp[i][j] = j;
        } else if (j == 0) {
          dp[i][j] = i;
        } else {
          int cost = tokens1[i - 1].equals(tokens2[j - 1]) ? 0 : 1;
          dp[i][j] =
            Math.min(
              dp[i - 1][j - 1] + cost,
              Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1)
            );
        }
      }
    }

    double common_tokens = dp[tokens1.length][tokens2.length];
    double total_tokens = tokens1.length + tokens2.length;
    double similarity_score = 100 - ((common_tokens * 100) / total_tokens);

    return similarity_score;
  }

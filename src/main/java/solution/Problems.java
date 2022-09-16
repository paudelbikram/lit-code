package solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problems {

  public static void main(String... args) {

    // Two Sum
    System.out.println("TWO SUM");
    System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
    System.out.println(Arrays.toString(twoSum(new int[]{3,3}, 6)));

    // Contains Duplicate
    System.out.println("CONTAINS DUPLICATE");
    System.out.println(containsDuplicate(new int[]{1,2,3,1}));
    System.out.println(containsDuplicate(new int[]{1,2,3,4}));
    System.out.println(containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));

    // Max Profit
    System.out.println("MAX PROFIT");
    System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    System.out.println(maxProfit(new int[]{7,6,3,1,3,4,3,1,4,10, 2}));

    // Valid Anagram
    System.out.println("VALID ANAGRAM");
    System.out.println(isAnagram("anagram", "nagaram"));
    System.out.println(isAnagram("rat", "car"));

    // Valid Parenthesis
    System.out.println("VALID PARENTHESIS");
    System.out.println(validParenthesis("()"));
    System.out.println(validParenthesis("()[]{}"));
    System.out.println(validParenthesis("(]"));


    // Valid Parenthesis
    System.out.println("VALID PARENTHESIS");
    System.out.println(validParenthesis("()"));
    System.out.println(validParenthesis("()[]{}"));
    System.out.println(validParenthesis("(]"));


    // Valid Parenthesis
    System.out.println("SOLVING GURU'S DAI QUESTION");
    System.out.println(Arrays.toString(solve(new int[]{1,2,3,4,5}, 2))); //
    System.out.println(Arrays.toString(solve(new int[]{1,0,3,4,5}, 2)));
    System.out.println(Arrays.toString(solve(new int[]{1,2,3,4,5,6,7}, 3)));
  }



  private static double[] solve(int[] arr, int subgroup) {
    int finalArraySize = arr.length - subgroup + 1;
    double[] finalArray = new double[finalArraySize];

    for(int i = 0; i < arr.length - subgroup + 1; i++) {
      int[] subArray = Arrays.copyOfRange(arr, i, Math.abs(subgroup + i));
      finalArray[i] = Arrays.stream(subArray).sum() * 1.0/subArray.length;
    }
    return finalArray;
  }


  /**
   * You are given an array prices where prices[i] is the price of a given stock on the ith day.
   * You want to maximize your profit by choosing a single day to buy one stock and choosing a
   * different day in the future to sell that stock.
   * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
   * Example 1:
   * Input: prices = [7,1,5,3,6,4]
   * Output: 5
   * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
   * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
   * Example 2:
   * Input: prices = [7,6,4,3,1]
   * Output: 0
   * Explanation: In this case, no transactions are done and the max profit = 0.
   * @param prices an array of prices
   * @return solution
   */
  public static int maxProfit(int[] prices) {
    if(prices == null || prices.length == 0) return 0;
    int min = prices[0];
    int max = Integer.MIN_VALUE;

    for (int price : prices) {
      int money = price - min;
      if (money > max)
        max = money;
      if (price < min)
        min = price;
    }

    return max;
  }


  /**
   * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
   * You may assume that each input would have exactly one solution, and you may not use the same element twice.
   * You can return the answer in any order.
   * Example 1:
   * Input: nums = [2,7,11,15], target = 9
   * Output: [0,1]
   * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
   * Example 2:
   * Input: nums = [3,2,4], target = 6
   * Output: [1,2]
   * Example 3:
   * Input: nums = [3,3], target = 6
   * Output: [0,1]
   * @param nums an array with numbers
   * @param target a sum number
   * @return solution
   */
  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> valueAndIndex = new HashMap<>();
    for(int i = 0; i < nums.length; i++) {
      if (nums[i] <= target) {
        if (valueAndIndex.containsKey(nums[i])) {
          return new int[]{valueAndIndex.get(nums[i]), i};
        }
        valueAndIndex.put(target - nums[i], i);
      }
    }
    return new int[]{};
  }


  /**
   * Given an integer array nums, return true if any value appears at least twice in the array,
   * and return false if every element is distinct.
   * Example 1:
   * Input: nums = [1,2,3,1]
   * Output: true
   * Example 2:
   * Input: nums = [1,2,3,4]
   * Output: false
   * Example 3:
   * Input: nums = [1,1,1,3,3,4,3,2,4,2]
   * Output: true
   * @param nums an array with number
   * @return solution
   */
  public static boolean containsDuplicate(int[] nums) {
    // HashSet uses HashMap under the hood
    Set<Integer> visitedNumber = new HashSet<>();
    for (int num : nums) {
      if (visitedNumber.contains(num))
        return true;
      visitedNumber.add(num);
    }
    return false;
  }


  /**
   * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
   * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
   * typically using all the original letters exactly once.
   * Example 1:
   * Input: s = "anagram", t = "nagaram"
   * Output: true
   * Example 2:
   * Input: s = "rat", t = "car"
   * Output: false
   * @param s
   * @param t
   * @return
   */
  public static boolean isAnagram(String s, String t) {
    if ((s == null || t == null) || (s.length() != t.length())) {
      return false;
    }
    final Object Present = new Object();
    HashMap<Character, Object> mapOfCharacters = new HashMap<>();
    for (Character i : s.toCharArray()) {
      mapOfCharacters.put(i, Present);
    }

    for( Character j : t.toCharArray()) {
      if (!mapOfCharacters.containsKey(j)){
        return false;
      }
    }
    return true;
  }


  /**
   * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
   * determine if the input string is valid.
   *
   * An input string is valid if:
   * Open brackets must be closed by the same type of brackets.
   * Open brackets must be closed in the correct order.
   * Example 1:
   * Input: s = "()"
   * Output: true
   * Example 2:
   * Input: s = "()[]{}"
   * Output: true
   * Example 3:
   * Input: s = "(]"
   * Output: false
   * @param s
   * @return
   */
  public static boolean validParenthesis(String s) {
    if (s == null || s.trim().isEmpty()) {
      return false;
    }
    final char openSmallBracket = '(';
    final char closeSmallBracket = ')';
    final char openMediumBracket = '{';
    final char closeMediumBracket = '}';
    final char openBigBracket = '[';
    final char closeBigBracket = ']';

    boolean smallOpen = false;
    boolean mediumOpen = false;
    boolean bigOpen = false;
    for(Character i : s.toCharArray()) {
      if (i.equals(openSmallBracket)) {
        smallOpen = true;
      } else if (i.equals(closeSmallBracket)) {
        if (smallOpen) {
          smallOpen = false;
        } else {
          return false;
        }
      } else if (i.equals(openMediumBracket)) {
        mediumOpen = true;
      } else if (i.equals(closeMediumBracket)) {
        if (mediumOpen) {
          mediumOpen = false;
        } else {
          return false;
        }
      } else if (i.equals(openBigBracket)) {
        bigOpen = true;
      } else if (i.equals(closeBigBracket)) {
        if (bigOpen) {
          bigOpen = false;
        } else {
          return false;
        }
      }
    }
    return !(bigOpen || mediumOpen || smallOpen);
  }


  /**
   *
   * @param nums
   * @return
   */
  public static int maxSubArray(int[] nums) {
    return 0;
  }



}

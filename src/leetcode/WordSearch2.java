package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class WordSearch2 {

    public static void main(String[] args){
       char[][] board = {
                            {'o','a','a','n'},
                            {'e','t','a','e'},
                            {'i','h','k','r'},
                            {'i','f','l','v'}
                        };
       /*List<String> words = new ArrayList<>();
       words.add("oath"); words.add("pea"); words.add("eat"); words.add("rain");*/
       String[] words = {"oath","pea","eat","rain"}; /* output: oath, eat. */
       char[][] board2 = {
               {'b','a','a','b','a','b'},
               {'a','b','a','a','a','a'},
               {'a','b','a','a','a','b'},
               {'a','b','a','b','b','a'},
               {'a','a','b','b','b','a'},
               {'a','a','b','a','a','b'}
       };
       String[] words2 = {
               "bbaabaabaaaaabaababaaaaababb","aabbaaabaaabaabaaaaaabbaaaba","babaababbbbbbbaabaababaabaaa",
               "bbbaaabaabbaaababababbbbbaaa","babbabbbbaabbabaaaaaabbbaaab","bbbababbbbbbbababbabbbbbabaa",
               "babababbababaabbbbabbbbabbba","abbbbbbaabaaabaaababaabbabba","aabaabababbbbbbababbbababbaa",
               "aabbbbabbaababaaaabababbaaba","ababaababaaabbabbaabbaabbaba","abaabbbaaaaababbbaaaaabbbaab",
               "aabbabaabaabbabababaaabbbaab","baaabaaaabbabaaabaabababaaaa","aaabbabaaaababbabbaabbaabbaa",
               "aaabaaaaabaabbabaabbbbaabaaa","abbaabbaaaabbaababababbaabbb","baabaababbbbaaaabaaabbababbb",
               "aabaababbaababbaaabaabababab","abbaaabbaabaabaabbbbaabbbbbb","aaababaabbaaabbbaaabbabbabab",
               "bbababbbabbbbabbbbabbbbbabaa","abbbaabbbaaababbbababbababba","bbbbbbbabbbababbabaabababaab",
               "aaaababaabbbbabaaaaabaaaaabb","bbaaabbbbabbaaabbaabbabbaaba","aabaabbbbaabaabbabaabababaaa",
               "abbababbbaababaabbababababbb","aabbbabbaaaababbbbabbababbbb","babbbaabababbbbbbbbbaabbabaa"};
/* output:
* ["aabbbbabbaababaaaabababbaaba","abaabbbaaaaababbbaaaaabbbaab","ababaababaaabbabbaabbaabbaba"]*/
        System.out.println(" Following words are found in the board");
       for(String foundWord:findWords(board,words))
           System.out.println(foundWord);
    }

    /* T(n)=O(m*n*l)
    *   where (m,n) are #rows and #columns in a board and
    *   'l' is the count of words is a Words[]. */
    private static List<String> findWords(char[][] board, String[] words) {
        List<String> foundWords = new ArrayList<>();
        boolean[] found = new boolean[words.length];
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[row].length;col++){
                for(int c=0;c<words.length;c++){
                    String word = words[c];
                    char firstChar = word.charAt(0);
                    if(!found[c] && firstChar==board[row][col] && containsWord(board,row,col,word)){
                        foundWords.add(word); found[c] = true;
                        //foundWords.contains()
                    }

                }
            }
        }
        return foundWords;
    }

    /* returns true if board has the given word, false otherwise.*/
    private static boolean containsWord(char[][] board,int row, int col, String word){
        int maxRows = board.length; int maxCols = board[0].length;
        boolean[][] visited = new boolean[board.length][board[0].length];
        //Arrays.fill(visited,false);
        Stack<Grid> stack = new Stack<>();
        Grid g = new Grid(row,col,maxRows,maxCols);
        g.ch = board[g.row][g.col];
        stack.push(g);
        visited[g.row][g.col] = true;
        StringBuilder sb = new StringBuilder(); sb.append(g.ch);
        if(sb.toString().equals(word)) return true;
        while(!stack.isEmpty()){
            Grid top = stack.peek();
             /* right*/
            Grid right = top.right(); if(right!=null) right.ch = board[right.row][right.col];
            if(right!=null && !visited[right.row][right.col] && right.ch==word.charAt(sb.length())){
                stack.push(right); visited[right.row][right.col] = true;
                sb.append(right.ch);
                if(sb.toString().equals(word)) return true;
                continue;
            }

            /* left*/
            Grid left = top.left(); if(left!=null) left.ch = board[left.row][left.col];
            if(left!=null && !visited[left.row][left.col] && left.ch==word.charAt(sb.length())){
                stack.push(left); visited[left.row][left.col] = true;
                sb.append(left.ch);
                if(sb.toString().equals(word)) return true;
                continue;
            }

            /* top*/
            Grid _top = top.top(); if(_top!=null) _top.ch = board[_top.row][_top.col];
            if(_top!=null && !visited[_top.row][_top.col] && _top.ch==word.charAt(sb.length())){
                stack.push(_top); visited[_top.row][_top.col] = true;
                sb.append(_top.ch);
                if(sb.toString().equals(word)) return true;
                continue;
            }

            /* bottom*/
            Grid bottom = top.bottom(); if(bottom!=null) bottom.ch = board[bottom.row][bottom.col];
            if(bottom!=null && !visited[bottom.row][bottom.col] && bottom.ch==word.charAt(sb.length())){
                stack.push(bottom); visited[bottom.row][bottom.col] = true;
                sb.append(bottom.ch);
                if(sb.toString().equals(word)) return true;
                continue;
            }

            stack.pop();
            sb.deleteCharAt(sb.length()-1);

        } return false;
    }

    private static boolean isValid(int row, int col, int maxRows, int maxCols){
        return row>=0 && row<maxRows && col>=0 && col<maxCols;
    }

    private static class Grid{
        public char ch;
        int row;
        int col; int maxRows; int maxCols;

        public Grid (int row, int col,int maxRows, int maxCols){
            this.row = row; this.maxRows = maxRows;
            this.col = col; this.maxCols = maxCols;
        }

        public Grid right(){
            return isValid(row,col+1,maxRows,maxCols)?new Grid(row,col+1,maxRows,maxCols):null;
        }

        public Grid left(){
            return isValid(row,col-1,maxRows,maxCols)?new Grid(row,col-1,maxRows,maxCols):null;
        }

        public Grid bottom(){
            return isValid(row+1,col,maxRows,maxCols)?new Grid(row+1,col,maxRows,maxCols):null;
        }

        public Grid top(){
            return isValid(row-1,col,maxRows,maxCols)?new Grid(row-1,col,maxRows,maxCols):null;
        }

    }

}
